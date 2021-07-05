package com.example.test.controller.admin;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import com.example.test.entity.Paper;
import com.example.test.entity.Question;
import com.example.test.service.PaperService;
import com.example.test.service.QuestionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaperController {

	@Autowired
	PaperService paperService;
	@Autowired
	QuestionService questionService;
	/**
	 * 跳转到试卷管理页面
	 * //@param course
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toPaperPage.action")
	public PageInfo<Paper> toPaperPage(@RequestParam(value="page", defaultValue="1") int page,
			Model model, HttpSession session){
		PageInfo<Paper> pageInfo = paperService.findByPage(page, 5);
		List<Paper> dataList = pageInfo.getList();
//		List<Paper> dataList = paperService.find(paper);
		/*for(Paper g : dataList){
			String courseName= "";
			String id = g.getCourseId();
			if(id != null){
				String ids[] = id.split(",");
			}
			//判断最后一个字符是否为逗号，若是截取
			String str = courseName.substring(courseName.length() -1, courseName.length());
			if(",".equals(str)){
				str = courseName.substring(0, courseName.length()-1);
			}else{
				str = courseName;
			}
			g.setCourseId(str);
		}*/
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return pageInfo;
	}
	
/*
	*//**
	 * 跳转到试卷管理页面
	 * //@param course
	 * @param model
	 * @param session
	 * @return
	 *//*
	@RequestMapping("/qryAllPaper.action")
	@ResponseBody
	public List<Paper> qryAllPaper(@RequestParam(value="page", defaultValue="1") int page,
			Paper paper,Model model, HttpSession session){
		PageInfo<Paper> pageInfo = paperService.findByPage(page, 5);
		List<Paper> dataList = pageInfo.getList();
//		List<Paper> dataList = paperService.find(paper);
		*//*for(Paper g : dataList){
			String courseName= "";
			String id = g.getCourseId();
			if(id != null){
				String ids[] = id.split(",");
			}
			//判断最后一个字符是否为逗号，若是截取
			String str = courseName.substring(courseName.length() -1, courseName.length());
			if(",".equals(str)){
				str = courseName.substring(0, courseName.length()-1);
			}else{
				str = courseName;
			}
			g.setCourseId(str);
		}*//*
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return dataList;			
	}*/
	
/*	*//**
	 * 跳转到新增试卷页面
	 * @param paper
	 * @param model
	 * @param session
	 * @return
	 *//*
	@RequestMapping("/toAddPaperPage.action")
	@ResponseBody
	public String toAddPaperPage(Paper paper,Model model, HttpSession session){
//		model.addAttribute("type", typeService.find(new Type()));
		return "/admin/paper-reg.jsp";
	}*/
	
	/**
	 * 新增试卷
	 * @param paper
	 * @param model
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addPaper.action")
	@ResponseBody
	public String addPaper(@RequestParam List<String> ch_no,
						   @RequestParam List<String> type,
						   @RequestParam int dif,
						   Paper paper,Model model, HttpSession session,
						   HttpServletResponse response) throws IOException {
		Map map = new HashMap();
		List<Question> paperList = new ArrayList<Question>();
//		map.put("gradeId", paper.getGradeId());
//		map.put("courseId", paper.getCourseId());
		paper.setPaperDif(dif);
		paper.setPaperType(String.join(",", type));
		paperList = questionService.createPaper(ch_no,type,dif);

		String quesId = "";
		for(Question ques : paperList){
			quesId+=ques.getQuestionId()+",";
		}
		if(!quesId.isEmpty()){
			quesId = removeLast(quesId);
		}
		paper.setQuestionId(quesId);
		paperService.insert(paper);
		response.sendRedirect("/toPaperPage.action");
		return "redirect:/toPaperPage.action";
	}
	
	/**
	 * 删除试卷信息
	 * @param paperId	试卷编号，删除多个，id用逗号分隔开
	 * @param model
	 * @return
	 */
	@RequestMapping("/deletePaper.action")
	@ResponseBody
	public String deletePaper(String paperId, Model model,HttpServletResponse response) throws IOException {
		if(paperId != null){
			String ids[] = paperId.split(",");
			for(int i=0;i<ids.length;i++){
				paperService.delete(ids[i]);
			}
		}
		response.sendRedirect("/toPaperPage.action");
		return "redirect:/toPaperPage.action";
	} 
	/*
	@RequestMapping("/qryPaper.action")
	public String qryPaper(String paperId, Model model){
		Paper paper = paperService.get(paperId);
		String quesId = paper.getQuestionId();
		List<Question> quesList =new ArrayList<Question>();
		Question question = null;
		int selNum=0;
		int inpNum=0;
		int desNum=0;
		if(quesId != null){
			String ids[] = quesId.split(",");
			for(int i=0;i<ids.length;i++){
				question = questionService.get(Integer.parseInt(ids[i]));
				quesList.add(question);
				if("1".equals(question.getTypeId())){
					selNum+=1;
				}
				if("4".equals(question.getTypeId())){
					inpNum+=1;
				}
				if("5".equals(question.getTypeId())){
					desNum+=1;
				}
			}
		}
		paper.setScore(selNum+"");
		paper.setBeginTime(inpNum+"");
		paper.setEndTime(desNum+"");
		model.addAttribute("paper", paper);
		model.addAttribute("quesList", quesList);
		return "/admin/paper-qry.jsp";
	}
	*/
	
	/**
	 * 去掉最后一个逗号
	 * @param str
	 * @return
	 */
	public String removeLast(String str){
		//判断最后一个字符是否为逗号，若是截取
		String newStr = str.substring(str.length() -1, str.length());
		if(",".equals(newStr)){
			newStr = str.substring(0, str.length()-1);
		}else{
			newStr = str;
		}
		return newStr;
	}
	
}

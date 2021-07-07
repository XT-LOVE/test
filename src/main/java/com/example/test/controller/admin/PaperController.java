package com.example.test.controller.admin;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;

import com.example.test.entity.Paper;
import com.example.test.entity.Question;
import com.example.test.service.PaperService;
import com.example.test.service.QuestionService;

@RestController
public class PaperController {

	@Autowired
	PaperService paperService;
	@Autowired
	QuestionService questionService;
	/**
	 * 试卷管理页面，分页显示试卷
	 * //@param course
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toPaperPage")
	public List<Paper> toPaperPage(@RequestParam(value="page", defaultValue="1") int page,
								   @RequestParam(value = "teacherId") int teacherId,
								   Model model, HttpSession session){
		PageInfo<Paper> pageInfo = paperService.findByPage(page, 5,teacherId);
		List<Paper> dataList = pageInfo.getList();
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return dataList;
	}

	
	/**
	 * 新增试卷
	 * @param paper
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/addPaper")
	@ResponseBody
	public String addPaper(@RequestBody Paper paper, Model model, HttpSession session,
						   HttpServletResponse response) throws IOException {
		List<Question> questions = new ArrayList<Question>();
		List<String> chNoList = Arrays.asList(paper.getChNo().split(","));
		List<String> typeList = Arrays.asList(paper.getPaperType().split(","));
		questions = questionService.createPaper(chNoList,typeList,paper.getPaperDif(),paper.getProblemNum());
		if(questions.size()!=paper.getProblemNum())
			return "题库不足！";
		String quesId = "";
		int score = 0;
		for(Question ques : questions){
			quesId+=ques.getQuestionId()+",";
			if(ques.getQuestionType().equals("多项选择题"))
				score+=5;
			else if(ques.getQuestionType().equals("填空题"))
				score+=2;
			else if(ques.getQuestionType().equals("自由作答题"))
				score+=10;
		}
		if(!quesId.isEmpty()){
			quesId = removeLast(quesId);
		}
		paper.setQuestionId(quesId);
		paper.setScore(score);
//		System.out.println(paper);
		paperService.insert(paper);
//		System.out.println(paper);
		return String.valueOf(paper.getPaperId());
	}
	
	/**
	 * 删除试卷信息
	 * @param paperId	试卷编号，删除多个，id用逗号分隔开
	 * @param model
	 * @return
	 */
	@RequestMapping("/deletePaper")
	@ResponseBody
	public String deletePaper(String paperId, Model model,HttpServletResponse response) throws IOException {
		if(paperId != null){
			String ids[] = paperId.split(",");
			for(int i=0;i<ids.length;i++){
				paperService.delete(ids[i]);
			}
		}
		response.sendRedirect("/toPaperPage");
		return "redirect:/toPaperPage";
	} 
	/*
	@RequestMapping("/qryPaper")
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

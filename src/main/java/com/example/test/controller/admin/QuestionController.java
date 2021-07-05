package com.example.test.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;

import com.example.test.controller.BaseController;
import com.example.test.entity.Question;
import com.example.test.service.QuestionService;

/**
 * 题库管理
 *
 */
//@Controller
//@Repository
	@RestController
public class QuestionController extends BaseController {

	@Autowired
	QuestionService questionService;
	/**
	 * 跳转到题库管理页面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toQuestionPage.action")
	public PageInfo<Question> toQuestionPage(@RequestParam(value="page", defaultValue="1") int page,
			Model model, HttpSession session){
//		List<Question> dataList = questionService.find();
		PageInfo<Question> pageInfo = questionService.findByPage(page, 5);
//		PageInfo<Video> pageInfo = new PageInfo<>(list);
		List<Question> dataList = pageInfo.getList();
//		Type type=null;
//		String type;
//		for(Question que : dataList){
//			String courseName= "";
//			String typeName="";
////			type = typeService.get(Integer.parseInt(que.getTypeId()));
//			type = que.getQuestionType();
//			typeName=type.getTypeName();
//			que.setCourseId(courseName);
//			que.setTypeId(typeName);
//		}
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return pageInfo;
	}

	
	/**
	 * 删除问题信息
	 * @param questionId	问题编号，删除多个是，id用逗号分隔开
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteQuestion.action")
	public String deleteQuestion(String questionId, Model model){
		if(questionId != null){
			String ids[] = questionId.split(",");
			for(int i=0;i<ids.length;i++){
				questionService.delete(Integer.parseInt(ids[i]));
			}
		}
		return "redirect:/toQuestionPage.action";
	} 
	/**
	 * 跳转到添加试题信息页面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toAddQuestion.action")
	public List<Question> toAddQuestion(Question question,Model model, HttpSession session){
		//获取问题信息
		List<Question> dataList = questionService.find();
//		model.addAttribute("type", typeService.find(new Type()));
		model.addAttribute("dataList", dataList);
		return dataList;
	}
	
	/**
	 * 添加试题信息
	 * @param question
	 * @param model
	 * @return
	 */
	@RequestMapping("/addQuesInfo.action")
	public String addQuesInfo(Question question, Model model, HttpServletResponse response) throws IOException {
		//TODO 首先插入答案

		Question que = new Question();
		// = questionService.get(que.getQuestionId())
		if(que!=null) {
			response.sendRedirect("/toQuestionPage.action");
			return "成功";
		}
		questionService.insert(question);
		return "失败";
	}
	
	/**
	 * 查看问题信息
	 * @param questionId 问题编号
	 * @param model	model
	 * @param session session
	 * @return return
	 */
	@RequestMapping(value = "/toQryQuestion/{id}", method = RequestMethod.GET)
	public Question toQryQuestion(@PathVariable("id") int questionId, Model model, HttpSession session){
		Question questionInfo = questionService.get(questionId);
//		Type type = typeService.get(Integer.parseInt(questionInfo.getTypeId()));
//		questionInfo.setTypeId(type.getTypeName());
		model.addAttribute("question", questionInfo);
		System.out.println(questionInfo);
		return questionInfo;
	}
	
	/**
	 * 跳转到更新题目信息页面
	 * //@param type
	 * @param model model
	 * @param session session
	 * @return
	 */
	@RequestMapping("/toUpdQuestion.action")
	public String toUpdQuestion(int questionId, Model model, HttpSession session){
		Question questionInfo = questionService.get(questionId);
		model.addAttribute("question", questionInfo);
//		List<Type> typeList = typeService.find(new Type());
//		model.addAttribute("typeList", typeList);
		return "/admin/question-upd.jsp";			
	}
	
	/**
	 * 更新题目信息
	 * //@param type
	 * @param model model
	 * @param session session
	 * @return
	 */
	@RequestMapping("/updQuestion.action")
	public String updQuestion(Question question, Model model, HttpSession session){
		questionService.update(question);
		return "redirect:/toQuestionPage.action";			
	}
	
	/**
	 * 删除问题信息
	 * //@param type
	 * @param model model
	 * @param session session
	 * @return
	 */
	@RequestMapping("/delQuestion.action")
	public String delQuestion(int questionId, Model model, HttpSession session){
		questionService.delete(questionId);
		return "redirect:/todelQuestionPage.action";			
	}
}

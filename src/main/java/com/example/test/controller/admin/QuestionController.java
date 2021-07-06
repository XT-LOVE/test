package com.example.test.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.test.entity.Answer;
import com.example.test.service.AnswerService;
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
	@Autowired
	AnswerService answerService;
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
	public void deleteQuestion(String questionId, Model model){
		if(questionId != null){
			String ids[] = questionId.split(",");
			for(int i=0;i<ids.length;i++){
				questionService.delete(Integer.parseInt(ids[i]));
			}
		}
		return;
	} 
	/**
	 * 跳转到添加试题信息页面
	 * @param model
	 * @param session
	 * @return
	 *//*
	@RequestMapping("/toAddQuestion.action")
	public List<Question> toAddQuestion(Model model, HttpSession session){
		//获取问题信息
		List<Question> dataList = questionService.find();
//		model.addAttribute("type", typeService.find(new Type()));
		model.addAttribute("dataList", dataList);
		return dataList;
	}*/
	
	/**
	 * 添加试题信息
	 * @param qandA 包装类：Question和Answer
	 * @param model
	 * @return
	 */
	@RequestMapping("/addQuesInfo.action")
	public Integer addQuesInfo(@RequestBody QandA qandA, Model model) throws IOException {
//		System.out.println(qandA.answer+"\n"+qandA.question);
		//插入答案
		answerService.insert(qandA.answer);
		qandA.question.setAnswerId(qandA.answer.getAnswerId());
		System.out.println(qandA.question);
		questionService.insert(qandA.question);
		model.addAttribute("question", qandA.question);
		model.addAttribute("answer", qandA.answer);
		return qandA.question.getQuestionId();
	}
	
	/**
	 * 查看问题信息
	 * @param questionId 问题编号
	 * @param model	model
	 * @param session session
	 * @return return
	 */
	@RequestMapping(value = "/toQryQuestion", method = RequestMethod.GET)
	public Question toQryQuestion(int questionId, Model model, HttpSession session){
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
class QandA{
	public Question question;
	public Answer answer;
}

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
	 * @param model  model
	 * @param session session
	 * @return PageInfo<Question>
	 */
	@RequestMapping("/toQuestionPage")
	public PageInfo<Question> toQuestionPage(@RequestParam(value="page", defaultValue="1") int page,
			Model model, HttpSession session){
		PageInfo<Question> pageInfo = questionService.findByPage(page, 5);
		List<Question> dataList = pageInfo.getList();
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return pageInfo;
	}

	
	/**
	 * 删除问题信息
	 * @param questionId	问题编号，删除多个，id用逗号分隔开
	 * @param model model
	 * @return 提示
	 */
	@RequestMapping("/deleteQuestion")
	public String deleteQuestion(String questionId, Model model){
		if(questionId != null){
			int rowsDel = 0;
			String[] ids = questionId.split(",");
			for (String id : ids) {
				rowsDel += questionService.delete(Integer.parseInt(id));
			}
			if(rowsDel != ids.length)
				return "删除不完全";
			else
				return "删除成功";
		}
		return "选择questionId";
	} 

	
	/**
	 * 添加试题信息
	 * @param qandA 包装类：Question和Answer
	 * @param model model
	 * @return questionId
	 */
	@RequestMapping("/addQuesInfo")
	public Integer addQuesInfo(@RequestBody QandA qandA, Model model){
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
	 * 更新题目信息
	 * @Param qandA
	 * @param model model
	 * @param session session
	 * @return String
	 */
	@RequestMapping("/updQuestion")
	public String updQuestion(@RequestBody QandA qandA, Model model, HttpSession session){
		Question question = questionService.get(qandA.question.getQuestionId());
		qandA.answer.setAnswerId(question.getAnswerId());
		int arowInSet = answerService.update(qandA.answer);
		int qrowInSet = questionService.update(qandA.question);
		if(qrowInSet != 1 && arowInSet != 1){
			return "更新失败";
		}
		return "更新成功";
	}
	
	/**
	 * 删除问题信息
	 * @param model model
	 * @param session session
	 * @return String
	 */
	@RequestMapping("/delQuestion")
	public String delQuestion(int questionId, Model model, HttpSession session){
		int rowDel = questionService.delete(questionId);
		if(rowDel != 1)
			return "删除失败";
		return "删除成功";
	}
}
class QandA{
	public Question question;
	public Answer answer;
}

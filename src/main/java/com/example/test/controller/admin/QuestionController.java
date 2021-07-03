package com.example.test.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import com.example.test.controller.BaseController;
import com.example.test.entity.Question;
import com.example.test.entity.Type;
import com.example.test.service.QuestionService;
import com.example.test.service.TypeService;
/**
 * 题库管理
 *
 */
@Controller
public class QuestionController extends BaseController {

	@Autowired
	QuestionService questionService;
	@Autowired
	TypeService typeService;
	/**
	 * 跳转到题库管理页面
	 * @param question
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toQuestionPage.action")
	public String toQuestionPage(@RequestParam(value="page", defaultValue="1") int page,
			Question question,Model model, HttpSession session){
//		List<Question> dataList = questionService.find(question);
		PageInfo<Question> pageInfo = questionService.findByPage(question, page, 5);
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
		return "/admin/question-mgt.jsp";			
	}
	
	/**
	 * 跳转到题库管理页面
	 * @param question
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/quesPage.action")
	@ResponseBody
	public List<Question> quesPage(@RequestParam(value="page", defaultValue="1") int page,
			Question question,Model model, HttpSession session){
//		List<Question> dataList = questionService.find(question);
		PageInfo<Question> pageInfo = questionService.findByPage(question, page, 5);
		List<Question> dataList = pageInfo.getList();
//		Type type=null;
//		for(Question que : dataList){
//			String typeName="";
//			type = typeService.get(Integer.parseInt(que.getTypeId()));
//			typeName=type.getTypeName();
//			que.setTypeId(typeName);
//		}
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return dataList;			
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
	 * @param question
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toAddQuestion.action")
	public String toAddQuestion(Question question, Model model, HttpSession session){
		//获取问题信息
		List<Question> dataList = questionService.find(question);
		//获取题型信息
		model.addAttribute("type", typeService.find(new Type()));
		model.addAttribute("dataList", dataList);
		return "/admin/question-reg.jsp";			
	}
	
	/**
	 * 添加试题信息
	 * @param question
	 * @param model
	 * @return
	 */
	@RequestMapping("/addQuesInfo.action")
	public String addQuesInfo(Question question, Model model){
		questionService.insert(question);
		return "redirect:/toQuestionPage.action";			
	}
	
	/**
	 * 查看问题信息
	 * @param questionId 问题编号
	 * @param model	model
	 * @param session session
	 * @return return
	 */
	@RequestMapping("/toQryQuestion.action")
	public String toQryQuestion(int questionId, Model model, HttpSession session){
		Question questionInfo = questionService.get(questionId);
//		Type type = typeService.get(Integer.parseInt(questionInfo.getTypeId()));
//		questionInfo.setTypeId(type.getTypeName());
		model.addAttribute("question", questionInfo);
		return "/admin/question-qry.jsp";			
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

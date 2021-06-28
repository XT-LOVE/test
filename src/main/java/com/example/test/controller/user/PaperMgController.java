package com.example.test.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test.domain.Paper;
import com.example.test.domain.Question;
import com.example.test.service.PaperService;
import com.example.test.service.QuestionService;
import com.example.test.service.UserService;

/**
 * 试卷综合管理
 * @author hspcadmin
 *
 */
@Controller
public class PaperMgController {

	@Autowired
	UserService userService;
	@Autowired
	PaperService paperService;
	@Autowired
	QuestionService questionService;

	
	/**
	 * 查看试卷详情
	 * @param paperId
	 * @param userId
	 * @param model
	 * @param session
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/qrypaper.action")
	public String qrypaper(String paperId,String userId,Model model, HttpSession session){
		Map map = new HashMap();
		map.put("paperId", paperId);
		map.put("userId", userId);
		Paper paper = paperService.getPaperDetail(map);
		Question question = null;
		String []ids = paper.getQuestionId().split(",");
		List<Question> selList = new ArrayList<Question>();
		List<Question> inpList = new ArrayList<Question>();
		List<Question> desList = new ArrayList<Question>();
		for(int i = 0;i<ids.length;i++){
			question = questionService.get(Integer.parseInt(ids[i]));
			if("1".equals(question.getTypeId())){//单选
				selList.add(question);
			}
			if("4".equals(question.getTypeId())){//填空
				inpList.add(question);
			}
			if("5".equals(question.getTypeId())){//简答题
				desList.add(question);
			}
		}
		
		if(selList.size()>0){
			model.addAttribute("selectQ", "单项选择题（每题5分）");
			model.addAttribute("selList", selList);
		}
		
		if(inpList.size()>0){
			model.addAttribute("inpQ", "填空题（每题5分）");
			model.addAttribute("inpList", inpList);
		}
		
		if(desList.size()>0){
			model.addAttribute("desQ", "简答题（每题5分）");
			model.addAttribute("desList", desList);
		}
		
		model.addAttribute("paper", paper);
		return "/user/qrypaper.jsp";			
	}
}

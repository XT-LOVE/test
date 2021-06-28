package com.example.test.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.test.domain.MsgItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.domain.Student;
import com.example.test.service.UserService;

@Controller
public class StuController {
	@Autowired
	UserService userService;
	//跳转到前台登录页面
	@RequestMapping("/toLogin.action")
	public String toUserLogin(Student user, Model model, HttpSession session){
		if(session.getAttribute("userName")!= null){
			return "/user/index.jsp";
		}
		if(session.getAttribute("user")== null){
			session.setAttribute("user", userService.get(user.getUserId()));
		}
		List<Student> dataList = userService.find(user);
		model.addAttribute("dataList", dataList);
		return "/user/login.jsp";			
	}
		
	/**
	 * 前台用户登录
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/user/toIndex.action")
	public String toIndex(Student user, Model model, HttpSession session){
		if(session.getAttribute("userName")!= null){
			return "/user/index.jsp";
		}else{
			return "forward:/toLogin.action";
		}
	}
	
	/**
	 * 用户账号密码检查
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/checkPwd.action")
	@ResponseBody
	public MsgItem checkPwd(Student user, Model model, HttpSession session){
		MsgItem item = new MsgItem();
		Student loginUser = userService.login(user);
		if(loginUser!=null && loginUser.getUserType() ==0){
			if(loginUser.getUserState()==0 ){
				item.setErrorNo("1");
				item.setErrorInfo("该账号尚未通过审核!");
			}else{
				item.setErrorNo("0");
				item.setErrorInfo("登录成功!");
				session.setAttribute("userName", loginUser.getUserName());
				session.setAttribute("user", loginUser);
			}
		}else{
			item.setErrorNo("1");
			item.setErrorInfo("账号不存在或用户名密码错误!");
		}
		return item;
	}
	
	@RequestMapping("/toRegistPage.action")
	public String toRegistPage(Model model, HttpSession session){
		return "/user/regist.jsp";
	}
	
	/**
	 * 添加用户信息
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/addUserInfo.action")
	public String addUserInfo(Student user, Model model, HttpSession session){
		userService.insert(user);
		return "redirect:/toLogin.action";			
	}
	
	//跳转到前台登录页面
	@RequestMapping("/toUserInfo.action")
	public String toUserInfo(Student user, Model model, HttpSession session){
		Student loginUser = (Student) session.getAttribute("user");
		user = userService.getStu(loginUser);
		model.addAttribute("user", user);
		return "/user/userinfo.jsp";			
	}
	
	/**
	 * 更新学生信息
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateUserInfo.action")
	public String updateUserInfo(String newPwd, Student user, Model model, HttpSession session){
		if(newPwd!= null && newPwd.trim().length()>0){
			user.setUserPwd(newPwd);
		}
		userService.update(user);
		user = userService.get(user.getUserId());
		if(session.getAttribute("user")== null){
			session.setAttribute("user", userService.getStu(user));
		}
		return "redirect:/user/toIndex.action";			
	}
	
	//跳转到登录页面
	@RequestMapping("/user/exitSys.action")
	public String exitSystem(Student user, Model model, HttpSession session){
		if(session.getAttribute("userName")!= null){
			session.removeAttribute("userName");
			return "/user/login.jsp";
		}
		return "/user/login.jsp";			
	}
	
	//跳转到前台登录页面
	@RequestMapping("/toAbout.action")
	public String toAbout(Student user, Model model, HttpSession session){
		Student loginUser = (Student) session.getAttribute("user");
		model.addAttribute("user", loginUser);
		return "/user/about.jsp";			
	}
}

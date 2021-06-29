package com.example.test.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

//import org.apache.poi.hssf.record.UserSViewEnd;
import com.example.test.entity.MsgItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import com.example.test.controller.BaseController;
import com.example.test.entity.Student;
import com.example.test.service.UserService;
/**
 * 用户管理
 * @author hspcadmin
 *
 */
@Controller
public class UserController extends BaseController{

	@Autowired
	UserService userService;
	//跳转到登录页面
	@RequestMapping("/admin/login.action")
	public String toLoin(Student user, Model model, HttpSession session){
		if(session.getAttribute("userName")!= null){
			return "/admin/index.jsp";
		}
		List<Student> dataList = userService.find(user);
		model.addAttribute("dataList", dataList);
		return "/admin/login.jsp";			
	}
	
	@RequestMapping("/admin/userLogin.action")
	public String checkUser(Student user, Model model, HttpSession session){
		Student loginUser = userService.login(user);
		
		if(session.getAttribute("userName")!= null){
			return "/admin/index.jsp";
		}
		
		if(loginUser!=null && loginUser.getUserType() == 2){
			session.setAttribute("userName", loginUser.getStu_name());
			return "/admin/index.jsp";
		}else{
			model.addAttribute("message", "用户名或密码输入错误！！！");
			return "/admin/login.jsp";
		}
	}
	
	/**
	 * 判断账户信息是否存在
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/checkAccount.action")
	public String checkAccount(String userId, Model model){
		Student userInfo = userService.get(userId);
		if(userInfo!= null){
			model.addAttribute("message", "该账号已经存在");
		}else{
			model.addAttribute("message", "<font color='green'>验证通过</font>");
		}
		model.addAttribute("userId", userId);
		return "/admin/info-reg.jsp";
	}
	
	/**
	 * ajax验证用户账号是否存在
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/userRegist.action")
	@ResponseBody
	public  MsgItem userRegist(String userId, Model model, HttpSession session){
		MsgItem msgItem = new MsgItem();
		Student user = userService.get(userId);
		if(user!=null){
			msgItem.setErrorNo("1");
			msgItem.setErrorInfo("账号已经存在");
		}else{
			msgItem.setErrorNo("0");
			msgItem.setErrorInfo("<font color='green'>验证通过</font>");
		}
		return msgItem;
	} 
	
	//跳转到登录页面
	@RequestMapping("/admin/exitSys.action")
	public String exitSys(Student user, Model model, HttpSession session){
		if(session.getAttribute("userName")!= null){
			session.removeAttribute("userName");
			return "forward:/admin/login.action";
		}
		return "/admin/login.jsp";			
	}
	
	//跳转到题库录入页面
	@RequestMapping(value="/admin/toQueDep.action",method=RequestMethod.POST)
	public String toQueDep(Model model, HttpSession session){
		return "/admin/info-reg.jsp";			
	}
	
	//获取所有的用户信息
	@RequestMapping("/admin/getAllUser.action")
	public String getAllUserInfo(@RequestParam(value="page", defaultValue="1") int page,
								 Student user, Model model, HttpSession session){
//		List<User> dataList = userService.find(user);
		PageInfo<Student> pageInfo = userService.findByPage(user, page, 5);
		List<Student> dataList = pageInfo.getList();
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return "/admin/info-mgt.jsp";			
	}
	
	//获取所有的用户信息
	@RequestMapping("/admin/qryAllUser.action")
	@ResponseBody
	public List<Student> qryAllUser(@RequestParam(value="page", defaultValue="1") int page,
									Student user, Model model, HttpSession session){
//			List<User> dataList = userService.find(user);
		PageInfo<Student> pageInfo = userService.findByPage(user, page, 5);
		List<Student> dataList = pageInfo.getList();
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return dataList;			
	}
	
	/**
	 * 跳转到添加用户信息页面
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin/toAddUser.action")
	public String toAddUserInfo(Student user, Model model, HttpSession session){
		List<Student> dataList = userService.find(user);
		model.addAttribute("dataList", dataList);
		return "/admin/info-reg.jsp";			
	}
	
	/**
	 * 添加用户信息
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/addUser.action")
	public String addUser(Student user, Model model){
		userService.insert(user);
		return "redirect:/admin/getAllUser.action";			
	}
	
	/**
	 * 删除用户信息
	 * @param userId	用户账号，删除多个是，id用逗号分隔开
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/deleteUser.action")
	public String deleteUser(String userId, Model model){
		if(userId != null){
			String ids[] = userId.split(",");
			for(int i=0;i<ids.length;i++){
				userService.delete(ids[i]);
			}
		}
		return "redirect:/admin/getAllUser.action";
	} 
	
	/**
	 * 获取所有待审核信息
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/getFindPending.action")
	public String findPending(@RequestParam(value="page", defaultValue="1") int page, Student user, Model model){
		PageInfo<Student> pageInfo = userService.findPendingByPage(user, page, 5);
		List<Student> dataList = pageInfo.getList();
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return "/admin/info-deal.jsp";
	}
	
	//获取所有的用户信息
	@RequestMapping("/admin/qryFindPending.action")
	@ResponseBody
	public List<Student> qryFindPending(@RequestParam(value="page", defaultValue="1") int page,
										Student user, Model model, HttpSession session){
//				List<User> dataList = userService.find(user);
		PageInfo<Student> pageInfo = userService.findPendingByPage(user, page, 5);
		List<Student> dataList = pageInfo.getList();
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return dataList;			
	}
	
	/**
	 * 用户身份信息审核(通过)
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/passinfo.action")
	public String passUserInfo(Student user, Model model){
		Student us = new Student();
		if(user != null){
			String ids[] = user.getUserId().split(",");
			for(int i=0;i<ids.length;i++){
				us.setUserId(ids[i]);
				us.setUserState(1);
				userService.update(us);
			}
		}
		return "redirect:/admin/getFindPending.action";
	}
	
	/**
	 * 用户身份信息审核(不通过)
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/failinfo.action")
	public String failUserInfo(Student user, Model model){
		Student us = new Student();
		if(user != null){
			String ids[] = user.getUserId().split(",");
			for(int i=0;i<ids.length;i++){
				us.setUserId(ids[i]);
				us.setUserState(2);
				userService.update(us);
			}
		}
		return "redirect:/admin/getFindPending.action";
	}
	
	/**
	 * 跳转到添加用户信息页面
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin/toUpdateUser.action")
	public String toUpdateUser(Student user, Model model, HttpSession session){
		String userId = user.getUserId().trim();
		Student userInfo = userService.get(userId);
		model.addAttribute("user", userInfo);
		return "/admin/info-upd.jsp";			
	}
	
	/**
	 * 用户个人信息查询(信息审核)
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin/toQryUser.action")
	public String toQryUser(Student user, Model model, HttpSession session){
		String userId = user.getUserId().trim();
		Student userInfo = userService.get(userId);
		model.addAttribute("user", userInfo);
		return "/admin/info-det.jsp";			
	}
	
	/**
	 * 用户个人信息查询(信息审核)
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin/toQryUserInfo.action")
	public String toQryUserInfo(Student user, Model model, HttpSession session){
		String userId = user.getUserId().trim();
		Student userInfo = userService.get(userId);
		model.addAttribute("user", userInfo);
		return "/admin/info-qry.jsp";			
	}
	
	/**
	 * 用户个人信息查询(信息管理)
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin/toQryMgUser.action")
	public String toQryMgUser(Student user, Model model, HttpSession session){
		String userId = user.getUserId().trim();
		Student userInfo = userService.get(userId);
		model.addAttribute("user", userInfo);
		return "/admin/info-qry.jsp";			
	}
	
	@RequestMapping("/admin/updateUser.action")
	public String updateUser(Student user, Model model){
		userService.update(user);
		return "redirect:/admin/getAllUser.action";			
	}
	
}

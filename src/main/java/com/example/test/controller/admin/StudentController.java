package com.example.test.controller.admin;

import com.example.test.controller.BaseController;
import com.example.test.entity.ApiResult;
import com.example.test.entity.Login;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import com.example.test.util.ApiResultHandler;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * 学生管理
 */


@Controller
public class StudentController extends BaseController{

	//验证学生账号是否存在
	@RequestMapping("/student?method=checkAccount")
	@ResponseBody
	public ApiResult userRegist(String stu_no){
		Student student = StudentService.get(stu_no);
		if(stu_no!=null){
			return ApiResultHandler.buildApiResult(200, "账号存在", student);
		}else{
			return ApiResultHandler.buildApiResult(404, "账号不存在", null);
		}
	}

	//账号的密码检查
	@RequestMapping("/student?method=checkPwd")
	@ResponseBody
	public ApiResult checkPwd(Login login){
		Student student = StudentService.get(login.getUsername());
		if(student!=null){
			return ApiResultHandler.buildApiResult(200, "账号存在", student);
			}
		else{
			return ApiResultHandler.buildApiResult(404, "账号不存在", null);
		}
	}

	//获取单个学生信息
	@RequestMapping("/student/{stu_no}")
	@ResponseBody
	public ApiResult findById(@PathVariable("stu_no") int stu_no) {
		Student student = StudentService.get(stu_no);
		if (student != null) {
			return ApiResultHandler.buildApiResult(200,"请求成功",student);
		} else {
			return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
		}
	}

	//获取所有的学生信息
	@RequestMapping("/student/{page}/{size}")
	@ResponseBody
	public ApiResult findAll(@PathVariable int page, @PathVariable int size) {
		List<Student> studentPage = new List<>(page,size);
		List<Student> res = StudentService.findAll(studentPage);
		return  ApiResultHandler.buildApiResult(200,"分页查询所有学生",res);
	}

	//添加学生信息
	@RequestMapping("/student?method=addStu")
	public void addStu(Student user){
		StudentService.insert(user);
	}
	
	//删除学生信息
	@RequestMapping("student?method=deleteStu")
	public void deleteStu(String stu_no){
		if(stu_no != null){
			String ids[] = stu_no.split(",");
			for(int i=0;i<ids.length;i++){
				StudentService.delete(ids[i]);
			}
		}
	}

	//修改学生信息
	@RequestMapping("student?method=updateStu")
	public void updateUser(Student user, Model model){
		StudentService.update(user);
	}
	
}

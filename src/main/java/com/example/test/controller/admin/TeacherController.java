package com.example.test.controller.admin;

import com.example.test.controller.BaseController;
import com.example.test.entity.ApiResult;
import com.example.test.entity.Login;
import com.example.test.entity.Teacher;
import com.example.test.service.TeacherService;
import com.example.test.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师管理
 */


@RestController
public class TeacherController extends BaseController{

	//验证教师账号是否存在
	@PostMapping("/teacher?method=checkAccount")
	@ResponseBody
	public ApiResult checkAccount(String tea_no){
		Teacher teacher = TeacherService.get(tea_no);
		if(teacher!=null){
			return ApiResultHandler.buildApiResult(200, "账号存在", teacher);
		}else{
			return ApiResultHandler.buildApiResult(404, "账号不存在", null);
		}
	}

	//账号密码检查
	@PostMapping("/teacher?method=checkPwd")
	@ResponseBody
	public ApiResult checkPwd(Login login){
		Teacher teacher = TeacherService.get(login.getUsername());
		if(teacher!=null){
			return ApiResultHandler.buildApiResult(200, "密码正确", teacher);
		} else{
			return ApiResultHandler.buildApiResult(404, "密码错误", null);
		}
	}

	//获取单个教师信息
	@GetMapping("/teacher?method=getTeaInfo")
	@ResponseBody
	public ApiResult findById(int tea_no) {
		Teacher teacher = TeacherService.get(tea_no);
		if (teacher != null) {
			return ApiResultHandler.buildApiResult(200,"请求成功",teacher);
		} else {
			return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
		}
	}

	//获取所有的教师信息
	@GetMapping("/teacher?method=getAllTeaInfo")
	@ResponseBody
	public ApiResult findAll() {
		List<Teacher> teacherList = TeacherService.find();
		return  ApiResultHandler.buildApiResult(200,"查询所有教师",teacherList);
	}

	//添加教师信息
	@PostMapping("/teacher?method=addTea")
	@ResponseBody
	public ApiResult addTea(Teacher teacher){
		TeacherService.insert(teacher);
		return ApiResultHandler.buildApiResult(200,"添加成功",null);
	}

	//删除教师信息
	@DeleteMapping("teacher?method=deleteTea")
	@ResponseBody
	public ApiResult deleteTea(String tea_no){
		if(tea_no != null){
			String ids[] = tea_no.split(",");
			for(int i=0;i<ids.length;i++){
				TeacherService.delete(ids[i]);
			}
		}
		return ApiResultHandler.buildApiResult(200,"删除成功",null);
	}

	//修改教师信息
	@PutMapping("teacher?method=updateTea")
	@ResponseBody
	public ApiResult updateTea(Teacher teacher){
		TeacherService.update(teacher);
		return ApiResultHandler.buildApiResult(200,"更新成功",null);
	}
	
}

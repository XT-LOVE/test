package com.example.test.controller.admin;

import com.example.test.controller.BaseController;
import com.example.test.entity.ApiResult;
import com.example.test.entity.Login;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import com.example.test.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 学生管理
 */


@RestController
public class StudentController extends BaseController{

	private StudentService studentService;
	//验证学生账号是否存在
	@PostMapping("/student?method=checkAccount")
	@ResponseBody
	public ApiResult checkAccount(int stu_no){
		Student student = studentService.get(stu_no);
		if(student!=null){
			return ApiResultHandler.buildApiResult(200, "账号存在", student);
		}else{
			return ApiResultHandler.buildApiResult(404, "账号不存在", null);
		}
	}

	//账号密码检查
	@PostMapping("/student?method=checkPwd")
	@ResponseBody
	public ApiResult checkPwd(Login login){
		Student student = studentService.get(login.getUsername());
		if(student!=null){
			return ApiResultHandler.buildApiResult(200, "密码正确", student);
		} else{
			return ApiResultHandler.buildApiResult(404, "密码错误", null);
		}
	}

	//获取单个学生信息
	@GetMapping("/student?method=getStuInfo")
	@ResponseBody
	public ApiResult findById(int stu_no) {
		Student student = studentService.get(stu_no);
		if (student != null) {
			return ApiResultHandler.buildApiResult(200,"请求成功",student);
		} else {
			return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
		}
	}

	//获取所有的学生信息
	@GetMapping("/student?method=getAllStuInfo")
	@ResponseBody
	public ApiResult findAll() {
		List<Student> studentList = studentService.find();
		return  ApiResultHandler.buildApiResult(200,"查询所有学生",studentList);
	}

	//添加学生信息
	@PostMapping("/student?method=addStu")
	@ResponseBody
	public ApiResult addStu(Student student){
		studentService.insert(student);
		return ApiResultHandler.buildApiResult(200,"添加成功",null);
	}

	//删除学生信息
	@DeleteMapping("student?method=deleteStu")
	@ResponseBody
	public ApiResult deleteStu(String stu_no){
		if(stu_no != null){
			String ids[] = stu_no.split(",");
			for(int i=0;i<ids.length;i++){
				studentService.delete(ids[i]);
			}
		}
		return ApiResultHandler.buildApiResult(200,"删除成功",null);
	}

	//修改学生信息
	@PutMapping("student?method=updateStu")
	@ResponseBody
	public ApiResult updateStu(Student student){
		studentService.update(student);
		return ApiResultHandler.buildApiResult(200,"更新成功",null);
	}

}
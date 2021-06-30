package com.example.test.controller.admin;

import com.example.test.controller.BaseController;
import com.example.test.entity.ApiResult;
import com.example.test.entity.Login;
import com.example.test.entity.Manager;
import com.example.test.service.ManagerService;
import com.example.test.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生管理
 */


@RestController
public class ManagerController extends BaseController{

	//验证管理员账号是否存在
	@PostMapping("/manager?method=checkAccount")
	@ResponseBody
	public ApiResult checkAccount(String mana_no){
		Manager manager = ManagerService.get(mana_no);
		if(manager!=null){
			return ApiResultHandler.buildApiResult(200, "账号存在", manager);
		}else{
			return ApiResultHandler.buildApiResult(404, "账号不存在", null);
		}
	}

	//账号密码检查
	@PostMapping("/manager?method=checkPwd")
	@ResponseBody
	public ApiResult checkPwd(Login login){
		Manager manager = ManagerService.get(login.getUsername());
		if(manager!=null){
			return ApiResultHandler.buildApiResult(200, "密码正确", manager);
		} else{
			return ApiResultHandler.buildApiResult(404, "密码错误", null);
		}
	}

	//获取单个管理员信息
	@GetMapping("/manager?method=getManInfo")
	@ResponseBody
	public ApiResult findById(int mana_no) {
		Manager manager = ManagerService.get(mana_no);
		if (manager != null) {
			return ApiResultHandler.buildApiResult(200,"请求成功",manager);
		} else {
			return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
		}
	}

	//获取所有的管理员信息
	@GetMapping("/manager?method=getAllManInfo")
	@ResponseBody
	public ApiResult findAll() {
		List<Manager> managerList = ManagerService.find();
		return  ApiResultHandler.buildApiResult(200,"查询所有管理员",managerList);
	}

	//添加管理员信息
	@PostMapping("/manager?method=addMan")
	@ResponseBody
	public ApiResult addMan(Manager manager){
		ManagerService.insert(manager);
		return ApiResultHandler.buildApiResult(200,"添加成功",null);
	}

	//删除管理员信息
	@DeleteMapping("manager?method=deleteMan")
	@ResponseBody
	public ApiResult deleteMan(String mana_no){
		if(mana_no != null){
			String ids[] = mana_no.split(",");
			for(int i=0;i<ids.length;i++){
				ManagerService.delete(ids[i]);
			}
		}
		return ApiResultHandler.buildApiResult(200,"删除成功",null);
	}

	//修改管理员信息
	@PutMapping("manager?method=updateMan")
	@ResponseBody
	public ApiResult updateMan(Manager manager){
		ManagerService.update(manager);
		return ApiResultHandler.buildApiResult(200,"更新成功",null);
	}
	
}

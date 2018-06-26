package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@ApiOperation(value="查询用户")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		 try {
			List<User> list=userService.findAll();
			return MsgResponse.success("success", list);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="保存用户")
	@PostMapping("saveUser")
	public MsgResponse saveUser(User user){
		 try {
			 userService.save(user);
			return MsgResponse.success("success", user);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="关键字查询用户")
	@GetMapping("queryUser")
	public MsgResponse queryUser(String keywords){
		try {
			List<User> list=userService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {		
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	@ApiOperation(value="修改用户信息")
	@PostMapping("updateUser")
	public MsgResponse updateUser(User user){
		 try {
			 userService.update(user);
			return MsgResponse.success("success", user);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="删除用户")
	@PostMapping("deleteUserById")
	public MsgResponse deleteUserById(long id){
		 try {
			 userService.deleteById(id);
			return MsgResponse.success("success", null);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="批量删除用户")
	@PostMapping("batchDeleteUser")
	public MsgResponse batchDeleteUser(long[]ids){
		 try {
			 List<Long> idList=new ArrayList<>();
		 for(long id:ids){
			 idList.add(id);
		 }
		 userService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	}



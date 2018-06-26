package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
@Autowired
private IClazzService clazzService;
@ApiOperation(value="查询所有班级信息")
@GetMapping("findAllClazz")
public MsgResponse findAllClazz(){
	try {
		List<Clazz> list=clazzService.findAll();
		return MsgResponse.success("success", list);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="查询班级信息")
@GetMapping("findAllClazzVM")
public MsgResponse findAllClazzVM(){
	try {
		List<ClazzVM> list=clazzService.findAllVM();
		return MsgResponse.success("success", list);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="保存班级信息")
@PostMapping("saveClazz")
public MsgResponse saveClazz(Clazz clazz){
	 try {
		 clazzService.save(clazz);
		return MsgResponse.success("success", clazz);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="通过关键字查询班级信息")
@GetMapping("queryClazz")
public MsgResponse queryClazz(String keywords){
	try {
		List<Clazz> list=clazzService.query(keywords);
		return MsgResponse.success("success", list);
	} catch (Exception e) {		
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}	
}
@ApiOperation(value="修改班级信息")
@PostMapping("updateClazz")
public MsgResponse updateClazz(Clazz clazz){
	 try {
		 clazzService.update(clazz);
		return MsgResponse.success("success", clazz);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="删除班级")
@PostMapping("deleteClazzById")
public MsgResponse deleteClazzById(long id){
	 try {
		clazzService.deleteById(id);
		return MsgResponse.success("success", null);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="批量删除班级")
@PostMapping("batchDeleteClazz")
public MsgResponse batchDeleteClazz(long[]ids){
	 try {
		 List<Long> idList=new ArrayList<>();
	 for(long id:ids){
		 idList.add(id);
	 }
	 clazzService.batchDelete(idList);
		return MsgResponse.success("批量删除成功", null);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
}


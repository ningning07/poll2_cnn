package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("options")
@Api(description="选项模块相关接口")
public class OptionsController {
@Autowired
private IOptionsService optionsService;
@ApiOperation(value="查询选项信息")
@GetMapping("findAllOptions")
public MsgResponse findAllOptions(){
	 try {
		List<Options> list=optionsService.selectAll();
		return MsgResponse.success("success", list);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="插入选项")
@PostMapping("saveOptions")
public MsgResponse saveCourse(Options options){
	 try {
		 optionsService.save(options);
		return MsgResponse.success("success", options);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="通过关键字查询选项")
@GetMapping("queryOptions")
public MsgResponse queryCourse(String keywords){
	try {
		List<Options> list=optionsService.query(keywords);
		return MsgResponse.success("success", list);
	} catch (Exception e) {		
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}	
}
@ApiOperation(value="修改选项")
@PostMapping("updateOptions")
public MsgResponse updateOptions(Options options){
	 try {
		 optionsService.update(options);
		return MsgResponse.success("success", options);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="删除选项")
@PostMapping("deleteOptionsById")
public MsgResponse deleteOptionsById(long id){
	 try {
		 optionsService.deleteOptionsById(id);
		return MsgResponse.success("success", null);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="批量删除选项")
@PostMapping("batchDeleteOptions")
public MsgResponse batchDeleteOptions(long[]ids){
	 try {
		 List<Long> idList=new ArrayList<>();
	 for(long id:ids){
		 idList.add(id);
	 }
	 optionsService.batchDelete(idList);
		return MsgResponse.success("批量删除成功", null);
	 } catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}

}
}

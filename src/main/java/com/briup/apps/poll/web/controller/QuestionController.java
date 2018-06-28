package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="题库模块相关接口")
@RequestMapping("/question")
public class QuestionController {
@Autowired
private IQuestionService questionService;

@ApiOperation(value="查询所有的题目所有信息",notes="每个题目信息中所包含的题目及选项")
@GetMapping("findAllQuestionVM")
public MsgResponse findAllQuestionVM(){
	try {
List<QuestionVM> list= questionService.findAllQuestionVM();
		
	return MsgResponse.success("success", list);
	} catch (Exception e) {
	e.printStackTrace();
	return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="查询所有的题目信息")
@GetMapping("findAllQuestion")
public MsgResponse findAllQuestion(){
	try {
List<Question> list=questionService.findAll();
		
	return MsgResponse.success("success", list);
	} catch (Exception e) {
	e.printStackTrace();
	return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="保存或修改题目信息")
@GetMapping("saveOrUpdateQuestion")
public MsgResponse saveOrUpdateQuestion(QuestionVM question){
	try {
			return MsgResponse.success("success", question);
			} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			}
}
@ApiOperation(value="通过问题id删除题目信息",notes="删除问题的同时删除选项")
@GetMapping("deleteQuestionById")
public MsgResponse deleteQuestionById(long id){
	try {
		questionService.deleteById(id);
		return MsgResponse.success("success", null);
			} catch (Exception e) { 
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			}
}
}

package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程接口")
@RestController
@RequestMapping("/course")
public class CourseController {
@Autowired
private ICourseService  courseService;
@ApiOperation(value="查询课程")
@GetMapping("findAllCourse")
public MsgResponse findAllCourse(){
	 try {
		List<Course> list=courseService.findAll();
		return MsgResponse.success("success", list);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="插入课程")
@PostMapping("saveCourse")
public MsgResponse saveCourse(Course course){
	 try {
		 courseService.save(course);
		return MsgResponse.success("success", course);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="查询课程")
@GetMapping("queryCourse")
public MsgResponse queryCourse(String keywords){
	try {
		List<Course> list=courseService.query(keywords);
		return MsgResponse.success("success", list);
	} catch (Exception e) {		
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}	
}
@ApiOperation(value="修改课程")
@PostMapping("updateCourse")
public MsgResponse updateCourse(Course course){
	 try {
		 courseService.update(course);
		return MsgResponse.success("success", course);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="删除课程")
@PostMapping("deleteCourseById")
public MsgResponse deleteCourseById(long id){
	 try {
		 courseService.deleteById(id);
		return MsgResponse.success("success", id);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="批量删除课程")
@PostMapping("batchDeleteCourse")
public MsgResponse batchDeleteCourse(List<Long>ids){
	 try {
		 courseService.batchDelete(ids);
		return MsgResponse.success("success", ids);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
}

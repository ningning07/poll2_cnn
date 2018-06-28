package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "答卷相关接口")
@RestController
@RequestMapping("/answers")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;

	@ApiOperation(value = "查询答卷", notes = "答卷对应的课调信息")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM() {
		try {
			List<AnswersVM> list = answersService.findAllAnswersVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "查询答卷")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers() {
		try {
			List<Answers> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("根据关键字查询答卷")
	@GetMapping("queryAnswers")
	public MsgResponse queryAnswers(String keywords) {
		try {
			List<Answers> list = answersService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("添加答卷")
	@GetMapping("saveAnswers")
	public MsgResponse saveAnswers(Answers answers) {
		try {
			answersService.save(answers);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("修改答卷")
	@GetMapping("updateAnswers")
	public MsgResponse updateAnswers(Answers answers) {
		try {
			answersService.update(answers);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("删除答卷")
	@GetMapping("deleteAnswers")
	public MsgResponse deleteAnswers(long id) {
		try {
			answersService.delete(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("批量删除答卷")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (Long id : ids) {
				idList.add(id);
				answersService.delete(id);
			}
			return MsgResponse.success("删除成功", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

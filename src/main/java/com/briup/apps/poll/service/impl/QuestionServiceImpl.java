package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;
@Service
public class QuestionServiceImpl implements IQuestionService {
@Autowired
private QuestionMapper questionMapper;
@Autowired
private QuestionVMMapper questionVMMapper;
@Autowired
private OptionsMapper optionsMapper;
	@Override
	public List<Question> findAll() throws Exception {
	QuestionExample example=new QuestionExample();
		return questionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		// TODO Auto-generated method stub
		return questionVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
		// 从questionvm中拆分出question和options
		Question question=new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType()); 
		List<Options> options=questionVM.getOptions();
		if(question.getId()!=null){
			//修改操作
		//1.修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.题目下选项信息(以删除代修改)
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//新接收到的options数据插入到数据库中
			//获得问题的主键
			long id=question.getId();
			//保存选项信息
			for(Options option: options){
				option.setQuestionId(id);
				optionsMapper.insert(option);
			}
		}else{
			//保存操作
if(question.getQuestiontype().equals("简答题")){
	questionMapper.insert(question);
}else{
	//1.保存问题信息
	questionMapper.insert(question);
	long id=question.getId();
	//2.保存选项信息
	for(Options option: options){
		option.setQuestionId(id);
		optionsMapper.insert(option);
	}
}
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.deleteByPrimaryKey(id);
	}

}

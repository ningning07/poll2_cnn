package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService {
	@Autowired
	private AnswersMapper answersMapper;
	@Autowired
	private AnswersVMMapper answersVMMapper;

	@Override
	public List<Answers> findAll() throws Exception {
		AnswersExample example = new AnswersExample();
		return answersMapper.selectByExample(example);
	}

	@Override
	public List<Answers> query(String keywords) throws Exception {
		AnswersExample example = new AnswersExample();
		example.createCriteria().andSelectionEqualTo(keywords);
		return answersMapper.selectByExample(example);
	}

	@Override
	public void save(Answers answers) throws Exception {
		answersMapper.insert(answers);

	}

	@Override
	public void update(Answers answers) throws Exception {
		answersMapper.updateByPrimaryKey(answers);

	}

	@Override
	public void delete(long id) throws Exception {
		answersMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void batchDelete(Long[] ids) throws Exception {
		for (Long id : ids) {
			answersMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public List<AnswersVM> findAllAnswersVM() throws Exception {
		return answersVMMapper.selectAll();
	}

}

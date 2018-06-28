package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
List<Options> selectAll() throws Exception;

List<Options> query(String keywords) throws Exception;

void save(Options options) throws Exception;

void update(Options options) throws Exception;

void deleteOptionsById(long id);

void batchDelete(List<Long>ids) throws Exception;



}

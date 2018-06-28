package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public class QuestionVM {
private Long id;
private String name;
private String questionType;

private List<Options> options;//一个题目下的所有选项

/**
 * @return the id
 */
public Long getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the questionType
 */
public String getQuestionType() {
	return questionType;
}

/**
 * @param questionType the questionType to set
 */
public void setQuestionType(String questionType) {
	this.questionType = questionType;
}

/**
 * @return the options
 */
public List<Options> getOptions() {
	return options;
}

/**
 * @param options the options to set
 */
public void setOptions(List<Options> options) {
	this.options = options;
}

}

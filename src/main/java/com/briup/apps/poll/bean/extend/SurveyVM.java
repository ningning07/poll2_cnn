package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.User;

public class SurveyVM {
private Long id;
private String status;

private Questionnaire questionnaire;
private Course course;
private User charge;
private Clazz clazz;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Questionnaire getQuestionnaire() {
	return questionnaire;
}
public void setQuestionnaire(Questionnaire questionnaire) {
	this.questionnaire = questionnaire;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public User getCharge() {
	return charge;
}
public void setCharge(User charge) {
	this.charge = charge;
}
public Clazz getClazz() {
	return clazz;
}
public void setClazz(Clazz clazz) {
	this.clazz = clazz;
}


}

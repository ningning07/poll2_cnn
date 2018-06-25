package com.briup.apps.poll.util;

public class MsgResponse {
private Integer stauts;//状态码200成功500代码异常
private String message;//错误，成功信息
private Object data;//返回数据 ，500返回为空

public  static MsgResponse success(String message,Object data){
	MsgResponse response=new MsgResponse();
	response.setStauts(200);
	response.setMessage(message);
	response.setData(data);
	return response;
}
public static MsgResponse error(String message){
	MsgResponse response=new MsgResponse();
	response.setStauts(500);
	response.setMessage(message);
	response.setData(null);
	return response;
}
public Integer getStauts() {
	return stauts;
}
public void setStauts(Integer stauts) {
	this.stauts = stauts;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
}
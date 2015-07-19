package com.pj.bean;

public class User {
private String id;
private String name;
private String sex;
private String age;
private String chinese;
private String math;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getChinese() {
	return chinese;
}
public void setChinese(String chinese) {
	this.chinese = chinese;
}
public String getMath() {
	return math;
}
public void setMath(String math) {
	this.math = math;
}
public String toString(){
	System.out.println("id:"+id+" name:"+name+" sex:"+sex+" 语文成绩:"+chinese+" 数学成绩:"+math);
	return "";
}

}

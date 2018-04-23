package com.javaex.vo;

public class UserVo {

	public UserVo() {

	}

	public UserVo(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserVo [age=" + age + ", name=" + name + "]";
	}

	
}

package com.user;

public class User {
	private int id ;
	private String name;
	private int age ;
	private String password;
//---get and  set method -----------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//----toString ----------------
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	
	

}

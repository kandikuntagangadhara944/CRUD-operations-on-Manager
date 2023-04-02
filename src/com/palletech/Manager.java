package com.palletech;

public class Manager 
{
	private int id;
	private String name;
	private String dept;
	private int exp;
	public Manager(int id, String name, String dept, int exp) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.exp = exp;
	}
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
}

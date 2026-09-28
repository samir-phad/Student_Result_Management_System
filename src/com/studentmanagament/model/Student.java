package com.studentmanagament.model;

public class Student {

	private int rollno;
	private String name;
	private String address;
	private Marks mark;

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMark(Marks mark) {
		this.mark = mark;
	}

	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Marks getMark() {
		return mark;
	}

	@Override
	public String toString() {
		return "Student Name = " + name + ", \nStudent address = " + address + ", \nStudent Roll no = " + rollno + ",\n"
				+ mark + "\n";
	}
}

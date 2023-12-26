package com.todolist.model;

public class MyNote {
	
	private String name;
	private String note;
	
	public MyNote (String name, String note) {
		this.name = name; 
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}

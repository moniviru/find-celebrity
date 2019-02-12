package com.globant.findcelebrity.dto;

public class Person {

	private String name;
	private int index;
	
	public Person(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndexFile() {
		return index + 1;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", index=" + index + "]";
	}	
}

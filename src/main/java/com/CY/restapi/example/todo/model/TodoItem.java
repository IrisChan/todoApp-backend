package com.CY.restapi.example.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoItem {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String owner;
	private boolean isDone;
	
	public TodoItem() {
		super();
	}
	
	public TodoItem(Long id, String description, String owner, boolean isDone) {
		super();
		this.id = id;
		this.description = description;
		this.owner = owner;
		this.isDone = isDone;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}

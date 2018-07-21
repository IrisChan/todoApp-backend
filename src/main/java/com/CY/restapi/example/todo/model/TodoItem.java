package com.CY.restapi.example.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "todoitem")
public class TodoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name = "isdone")
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
	
	@Override
	public String toString() {
		return "Todo{" +
				", owner='" + owner + '\'' + 
				", description= '" + description + 
				"'}";
	}
}

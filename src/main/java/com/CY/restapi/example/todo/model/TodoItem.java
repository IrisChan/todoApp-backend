package com.CY.restapi.example.todo.model;

import java.util.Date;

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
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "isdone")
	private boolean done;
	
	@Column(name = "targetdate")
	private Date targetDate;
	
	public TodoItem() {
		super();
	}
	
	public TodoItem(Long id, String title, String description, Date targetDate, boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.done = done;
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public Date getTargetDate() {
		return this.targetDate;
	}
	
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		TodoItem other = (TodoItem) obj;
		if (id != other.id) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Todo{" +
				", title='" + title + '\'' + 
				", description= '" + description + 
				", targetDate= '" + targetDate.toString() + 
				"'}";
	}
}

package com.CY.restapi.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CY.restapi.example.todo.model.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{

}

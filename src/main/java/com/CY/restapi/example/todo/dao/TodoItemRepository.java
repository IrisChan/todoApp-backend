package com.CY.restapi.example.todo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CY.restapi.example.todo.model.TodoItem;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long>{
//	@Query
//	Optional<TodoItem> findById(Long id);
	
	
}

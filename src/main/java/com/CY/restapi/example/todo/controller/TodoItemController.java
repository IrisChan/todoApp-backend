package com.CY.restapi.example.todo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CY.restapi.example.todo.dao.TodoItemRepository;
import com.CY.restapi.example.todo.model.TodoItem;

@RestController
public class TodoItemController {

	@Autowired
	private TodoItemRepository repository;
	
	@GetMapping(value = "/todoitems", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TodoItem> getAllTodoItems() {
		return repository.findAll();
	}
	
	@GetMapping(value = "/todoitems/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TodoItem getTodoItem(@PathVariable long id) throws Exception {
		Optional<TodoItem> item = repository.findById(id);
		
		if (!item.isPresent())
			throw new Exception("Item not found");
		
		return item.get();
	}
	
	@DeleteMapping(value = "/todoitems/{id}")
	public void deleteTodoItem(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	@PostMapping(value = "/todoitems", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createTodoItem(@RequestBody TodoItem item) {
		TodoItem toAddeditem = repository.save(item);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(toAddeditem.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/todoitems/{id}", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> updateTodoItem(@RequestBody TodoItem item, @PathVariable long id) {

		Optional<TodoItem> itemOptional = repository.findById(id);

		if (!itemOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setId(id);
		
		repository.save(item);

		return ResponseEntity.noContent().build();
	}
}

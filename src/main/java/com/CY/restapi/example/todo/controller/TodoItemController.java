package com.CY.restapi.example.todo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CY.restapi.example.todo.dao.TodoItemRepository;
import com.CY.restapi.example.todo.exception.TodoItemNotFoundException;
import com.CY.restapi.example.todo.model.TodoItem;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoItemController {

	@Autowired
	private TodoItemRepository repository;
	
	@GetMapping(value = "/todoitems", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TodoItem> getAllTodoItems() {
		return (List<TodoItem>) repository.findAll();
	}
	
	@GetMapping(value = "/todoitems/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public TodoItem getTodoItem(@PathVariable Long id) {
		Optional<TodoItem> item = repository.findById(id);
		
		if (!item.isPresent())
			throw new TodoItemNotFoundException(TodoItem.class, "id", id.toString());
		
		return item.get();
	}
	
	@DeleteMapping(value = "/todoitems/{id}")
	public ResponseEntity<Object> deleteTodoItem(@PathVariable Long id) {
		
		Optional<TodoItem> item = repository.findById(id);
		
		if (!item.isPresent())
			throw new TodoItemNotFoundException(TodoItem.class, "id", id.toString());
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/todoitems", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createTodoItem(@RequestBody TodoItem item) {
		TodoItem toAddeditem = repository.save(item);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(toAddeditem.getId()).toUri();	
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<>(toAddeditem, headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/todoitems/{id}", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> updateTodoItem(@RequestBody TodoItem item, @PathVariable Long id) {

		Optional<TodoItem> itemOptional = repository.findById(id);

		if (!itemOptional.isPresent())
			throw new TodoItemNotFoundException(TodoItem.class, "id", id.toString());

		item.setId(id);
		
		repository.save(item);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(item.getId()).toUri();		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<>(item, headers, HttpStatus.OK);
	}
}

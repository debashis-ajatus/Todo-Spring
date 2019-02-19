package com.example.tododemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tododemo.model.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
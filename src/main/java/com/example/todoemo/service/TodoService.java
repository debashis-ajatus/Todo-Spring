package com.example.todoemo.service;

import java.util.ArrayList;

import com.example.tododemo.model.TodoItem;

public interface TodoService {

	/**
	 * fetch all entries
	 * @return
	 */
	public ArrayList<TodoItem> findAll();

	/**
	 * insert item
	 * @param todoItem
	 * @return
	 */
	public TodoItem addItem(TodoItem todoItem);

	/**
	 * update item
	 * @param todoItem
	 * @return
	 */
	public TodoItem updateItem(TodoItem todoItem);
	/**
	 * delete item
	 * @param userid
	 * @return
	 */
	public boolean delete(Long userid);
}

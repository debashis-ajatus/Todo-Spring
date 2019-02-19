package com.example.tododemo.service.impl;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tododemo.logger.LogFactory;
import com.example.tododemo.model.DumpModel;
import com.example.tododemo.model.TodoItem;
import com.example.tododemo.repository.TodoItemRepository;
import com.example.todoemo.service.TodoService;
import com.google.gson.Gson;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoItemRepository todoItemReposiitory;

	private static final Logger LOGGER = LogFactory.getLogger("logs");
	private static final Gson GSON = new Gson();
	

	@Override
	public ArrayList<TodoItem> findAll() {
		LOGGER.info("find-all request--------------------------------------------------");
		DumpModel dumpData = new DumpModel();
		String reqString = "find-all";
		dumpData.setRequest(reqString);
		ArrayList<TodoItem> todoItems = (ArrayList<TodoItem>) todoItemReposiitory.findAll();
		dumpData.setResponse(GSON.toJson(todoItems));
		LOGGER.info(GSON.toJson(dumpData));
		LOGGER.info("------------------------REQUEST SUCCESSFULLY COMPLETED-------------------------------------");
		return todoItems;
		
	}

	@Override
	public TodoItem addItem(TodoItem todoItem) {
		LOGGER.info("add-item request--------------------------------------------------");
		DumpModel dumpData = new DumpModel();
		dumpData.setRequest(GSON.toJson(todoItem));
		todoItemReposiitory.save(todoItem);
		dumpData.setResponse(GSON.toJson(todoItem));
		LOGGER.info(GSON.toJson(dumpData));
		LOGGER.info("------------------------REQUEST SUCCESSFULLY COMPLETED-------------------------------------");
		return todoItem;
	}

	@Override
	public TodoItem updateItem(TodoItem todoItem) {
		LOGGER.info("update-item request--------------------------------------------------");
		DumpModel dumpData = new DumpModel();
		dumpData.setRequest(GSON.toJson(todoItem));
		todoItemReposiitory.save(todoItem);
		dumpData.setResponse(GSON.toJson(todoItem));
		LOGGER.info(GSON.toJson(dumpData));
		LOGGER.info("------------------------REQUEST SUCCESSFULLY COMPLETED-------------------------------------");
		return todoItem;
	}

	@Override
	public boolean delete(Long userid) {
		LOGGER.info("delete request--------------------------------------------------");
		DumpModel dumpData = new DumpModel();
		String reqString =  Long.toString(userid);
		dumpData.setRequest(reqString);
		try {
			todoItemReposiitory.delete(userid);
			dumpData.setResponse(GSON.toJson(true));
			return true;
		} catch (Exception e) {
			dumpData.setResponse(GSON.toJson(false));
			return false;
		} finally {
			LOGGER.info(GSON.toJson(dumpData));
			LOGGER.info("------------------------REQUEST SUCCESSFULLY COMPLETED-------------------------------------");
		}
	}

}

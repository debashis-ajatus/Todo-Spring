package com.example.tododemo.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tododemo.model.TodoItem;
import com.example.todoemo.service.TodoService;
import com.example.tododemo.logger.LogFactory;

@RestController
public class TodoDemoController {

    @Autowired
    private TodoService todoService;

    private static final Logger LOGGER = LogFactory.getLogger(TodoDemoController.class.getName());

    @RequestMapping("/")
    public ArrayList<TodoItem> index(Model model) {
        LOGGER.info("Here in fetching list of todos");
        return todoService.findAll();
    }

    @RequestMapping("/addTodo")
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        return todoService.addItem(todoItem);
    }

    @RequestMapping(value = "/updateTodo")
    public TodoItem updateTodo(@RequestBody TodoItem todoItem) {
        return todoService.updateItem(todoItem);
    }

    @DeleteMapping(value = "/deleteTodo")
    public boolean deleteTodo(@RequestParam("todoid") Long userid) {
        return todoService.delete(userid);
    }
}

package com.example.tododemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.tododemo.model.TodoItem;
import com.example.tododemo.repository.TodoItemRepository;
import com.example.todoemo.service.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TodoDemoServiceImplTest {

	@InjectMocks
	private TodoService todoDemoService = new TodoServiceImpl();

	@Mock
	private TodoItemRepository todoItemRepository;

	@Before
	public void doSetup() {
		MockitoAnnotations.initMocks(this);
		// todoDemoService = new TodoServiceImpl();
	}

	@Test
	public void testFindAll() {
		Mockito.when(todoItemRepository.findAll()).thenReturn(getIterableTodoItem());

		ArrayList<TodoItem> todoItems = todoDemoService.findAll();

		Assert.assertTrue(todoItems.get(0) instanceof TodoItem);
		Assert.assertEquals(1, todoItems.size());
		Assert.assertEquals("testCategory", todoItems.get(0).getCategory());
		Assert.assertEquals("testName", todoItems.get(0).getName());
		Assert.assertTrue(todoItems.get(0).isComplete());
	}

	private Iterable<TodoItem> getIterableTodoItem() {
		List<TodoItem> items = new ArrayList<>();
		TodoItem todoItem1 = new TodoItem();
		todoItem1.setId(1234L);
		todoItem1.setCategory("testCategory");
		todoItem1.setComplete(true);
		todoItem1.setName("testName");
		items.add(todoItem1);
		return items;
	}

	@Test
	public void testAddItem() {
		TodoItem todoItem = ((ArrayList<TodoItem>) getIterableTodoItem()).get(0);

		Mockito.when(todoItemRepository.save(Mockito.any(TodoItem.class)))
				.thenReturn(((ArrayList<TodoItem>) getIterableTodoItem()).get(0));

		TodoItem todoItemRes = todoDemoService.addItem(todoItem);
		Assert.assertTrue(todoItemRes instanceof TodoItem);
		Assert.assertEquals("testCategory", todoItemRes.getCategory());
		Assert.assertEquals("testName", todoItemRes.getName());
		Assert.assertTrue(todoItemRes.isComplete());
	}

	@Test
	public void testUpdateItem() {
		TodoItem todoItem = ((ArrayList<TodoItem>) getIterableTodoItem()).get(0);

		Mockito.when(todoItemRepository.save(Mockito.any(TodoItem.class))).thenReturn(todoItem);

		TodoItem todoItemRes = todoDemoService.updateItem(todoItem);
		Assert.assertTrue(todoItemRes instanceof TodoItem);
		Assert.assertEquals("testCategory", todoItemRes.getCategory());
		Assert.assertEquals("testName", todoItemRes.getName());
		Assert.assertTrue(todoItemRes.isComplete());
	}

	@Test
	public void testDelete() {
		Mockito.doNothing().when(todoItemRepository).delete(Mockito.anyLong());

		boolean res = todoDemoService.delete(1234L);
		Assert.assertTrue(res);
	}

	@Test
	public void testDeleteFalse() {
		Mockito.doThrow(Exception.class).when(todoItemRepository).delete(Mockito.anyLong());

		boolean res = todoDemoService.delete(1234L);
		Assert.assertFalse(res);
	}
}

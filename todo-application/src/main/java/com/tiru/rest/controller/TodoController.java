package com.tiru.rest.controller;

import com.tiru.rest.bean.model.Todo;
import com.tiru.rest.dao.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by oustlabs on 05/10/18.
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoDAO todoDAO;



    @GetMapping("/list")
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todosList = todoDAO.getAllList();
        if(todosList.size()>0) {
            return new ResponseEntity<List<Todo>>(todosList, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/pendingList")
    public ResponseEntity<List<Todo>> getAllPendingList(){
        List<Todo> todosList = todoDAO.getAllPendingList();
        if(todosList.size()>0) {
            return new ResponseEntity<List<Todo>>(todosList, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/completedList")
    public ResponseEntity<List<Todo>> getAllCompletedList(){
        List<Todo> todosList = todoDAO.getAllCompletedList();
        if(todosList.size()>0) {
            return new ResponseEntity<List<Todo>>(todosList, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getAllTodos(@PathVariable int todoId){
        Todo todoData = todoDAO.getTodoData(todoId);
        if(todoData != null) {
            return new ResponseEntity<Todo>(todoData, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity saveTodoData(@RequestBody Todo todo){
        int generatedId = todoDAO.saveTodoData(todo);
        if(generatedId>0){
            return new ResponseEntity<Todo>(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{todoId}")
    public ResponseEntity updateTodoData(@PathVariable int  todoId,@RequestBody Todo todo){
        int id = todoDAO.update(todo,todoId);
        System.out.println(id);
        if(id>0){
            return new ResponseEntity<Todo>(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/markTodoCompleted/{todoId}")
    public ResponseEntity markTodoCompleted(@PathVariable int  todoId,@RequestBody Todo todo){
        System.out.println(todo.toString());
        int id = todoDAO.markTodoCompleted(todo,todoId);
        System.out.println(id);
        if(id>0){
            return new ResponseEntity<Todo>(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable int todoId){
        int id = todoDAO.deleteTodo(todoId);
        if(id>0){
            return new ResponseEntity<Todo>(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }





}

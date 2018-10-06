package com.tiru.rest.dao;

import com.tiru.rest.bean.model.Todo;
import com.tiru.rest.dao.mapper.TodoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oustlabs on 06/10/18.
 */
@Repository
public class TodoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Todo> getAllList(){
        String sql = "Select * from Todo where isdeleted=?";
        return jdbcTemplate.query(
                sql,
                new Object[] {false},
                new TodoRowMapper()
                );
    }

    public List<Todo> getAllPendingList(){
        String sql = "Select * from Todo where isdeleted=? and isCompleted=?";
        return jdbcTemplate.query(
                sql,
                new Object[] {false,false},
                new TodoRowMapper()
        );
    }

    public List<Todo> getAllCompletedList(){
        String sql = "Select * from Todo where isdeleted=? and isCompleted=?";
        return jdbcTemplate.query(
                sql,
                new Object[] {false,true},
                new TodoRowMapper()
        );
    }

    public Todo getTodoData(int todoId){
        String sql = "Select * from Todo where todoId=?";
        return jdbcTemplate.queryForObject(sql,new Object[] {todoId}, new BeanPropertyRowMapper<Todo>(Todo.class));
    }

    public int saveTodoData(Todo todo){
        String sql = "insert into Todo (title, description, scheduledAt) values(?,  ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[] {
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.getScheduledAt()
                });
    }

    public int update(Todo todo,int todoId) {
        return jdbcTemplate.update("update Todo set title = ?, description = ?, scheduledAt = ? " +
                        "  where todoId = ?",
                new Object[] {
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.getScheduledAt(),
                        todoId
                });
    }

    public int deleteTodo(long todoId) {
        return jdbcTemplate.update("update  Todo set isdeleted=? where todoId=?", new Object[] {
                true,
                todoId
        });
    }

    public int markTodoCompleted(Todo todo,int todoId) {
        return jdbcTemplate.update("update Todo set isCompleted = ?, completedOn = NOW() " +
                        "  where todoId = ?",
                new Object[] {
                        todo.isCompleted(),
                        todoId
                });
    }

}

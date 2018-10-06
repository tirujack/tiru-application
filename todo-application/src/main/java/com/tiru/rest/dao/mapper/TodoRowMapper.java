package com.tiru.rest.dao.mapper;

import com.tiru.rest.bean.model.Todo;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by oustlabs on 06/10/18.
 */
public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet resultSet,int rowNum) throws SQLException{
        Todo todo = new Todo();
        todo.setTodoId(resultSet.getInt("todoId"));
        todo.setTitle(resultSet.getString("title"));
        todo.setDescription(resultSet.getString("description"));
        todo.setCompleted(resultSet.getBoolean("isCompleted"));
        todo.setScheduledAt(resultSet.getString("scheduledAt"));
        todo.setCompletedOn(resultSet.getString("completedOn"));
        todo.setCreatedDateTime(resultSet.getString("createdDateTime"));
        todo.setIsdeleted(resultSet.getBoolean("isdeleted"));

        return todo;
    }
}

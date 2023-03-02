package ru.alexey.example.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alexey.example.Mappers.EventMapper;
import ru.alexey.example.Models.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDAO {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public EventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> index(){
        return jdbcTemplate.query("SELECT * FROM events", new EventMapper());
    }
    public void create(Event event){

    }



}

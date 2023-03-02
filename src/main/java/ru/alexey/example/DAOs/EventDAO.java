package ru.alexey.example.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alexey.example.Models.Event;

import java.util.List;

@Component
public class EventDAO {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public EventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> index(){
        return jdbcTemplate.query("SELECT * FROM events", new BeanPropertyRowMapper<>(Event.class));
    }
    public void create(Event event){
        jdbcTemplate.update("INSERT INTO events VALUES (1, ?, ?, ?, ?)",
                event.getTitle(),
                event.getDescription(),
                event.getStartDate(),
                event.getPeriodicity());
    }
    public void update(Event event){
        jdbcTemplate.update("UPDATE events SET title = ?, description = ?, startDate = ?, periodicity = ? WHERE id = ?",
                event.getTitle(),
                event.getDescription(),
                event.getStartDate(),
                event.getPeriodicity(),
                event.getId());
    }



}

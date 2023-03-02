package ru.alexey.example.Mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.alexey.example.Models.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

        Event event = new Event();
        event.setId(rs.getInt("id"));
        event.setTitle(rs.getString("title"));
        event.setDescription(rs.getString("description"));
        event.setStartDate(rs.getDate("startDate"));
        event.setPeriodicity(rs.getInt("periodicity"));
        return event;
    }
}

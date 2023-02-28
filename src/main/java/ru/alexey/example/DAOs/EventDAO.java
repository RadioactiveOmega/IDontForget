package ru.alexey.example.DAOs;

import org.springframework.stereotype.Component;
import ru.alexey.example.Models.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/idontforget";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "020219618";
    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Event> index(){
        List<Event> events = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from Events";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Event event =new Event();
                event.setId(resultSet.getInt("id"));
                event.setTitle(resultSet.getString("title"));
                event.setStartDate(resultSet.getDate("startdate"));
                event.setPeriodicity(resultSet.getInt("periodicity"));

                events.add(event);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return events;
    }
    public void create(Event event){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO events Values(1,?,?,?,?)");
            preparedStatement.setString(1, event.getTitle());
            preparedStatement.setString(2, event.getDescription());
            preparedStatement.setDate(3, event.getStartDate());
            preparedStatement.setInt(4, event.getPeriodicity());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}

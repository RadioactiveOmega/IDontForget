package ru.alexey.example.Models;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Event {
    int id;

    @NotEmpty(message = "title must not be empty")
    String title;
    String description;

    @NotEmpty
    Date startDate;
    @NotEmpty
    Date periodicity;

}

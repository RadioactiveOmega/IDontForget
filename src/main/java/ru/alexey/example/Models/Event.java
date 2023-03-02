package ru.alexey.example.Models;

import jakarta.validation.constraints.Min;
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
    @Min(value = 0, message = "periodicity must be greater then 0")
    Integer periodicity;

}

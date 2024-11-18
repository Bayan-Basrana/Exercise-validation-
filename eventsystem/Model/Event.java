package com.example.eventsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
    @NotEmpty(message = "your ID is empty")
    @Size(min = 2,message = "The ID must be more than 2")
    private String id;
    @NotEmpty(message = "The description is empty")
    @Size(min = 15,message = "The description must be more than 15")
    private String description;
    @NotNull(message = "capacity is empty")
    @Min(value = 25,message = "capacity must be more than 25")
    private Integer capacity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}

package com.example.trackersystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
@NotEmpty(message = "ID is empty")
@Size(min=2,message = "your ID must be more than 2")
    private String id;
@NotEmpty(message = "the title is empty ")
@Size(min=8,message = "the title must be more than 8")
    private String title;
    @NotEmpty(message = "the description is empty ")
    @Size(min=15,message = "the description must be more than 8")
    private String description;
    @NotEmpty(message = "status is empty")
    @Pattern(regexp = "not started|in progress|completed")
    private String status;
    @NotEmpty(message = "company Name is empty")
    @Size(min=6,message = "company Name must be more than 6")
    private String companyName;

}

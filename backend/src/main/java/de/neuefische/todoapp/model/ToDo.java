package de.neuefische.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Core File
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private String id;
    private String description;
    private de.neuefische.todoapp.Enums.status status;
}

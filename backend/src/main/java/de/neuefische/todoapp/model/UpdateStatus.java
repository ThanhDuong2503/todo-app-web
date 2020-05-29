package de.neuefische.todoapp.model;

import de.neuefische.todoapp.Enums.status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateStatus {
    private status status;
}

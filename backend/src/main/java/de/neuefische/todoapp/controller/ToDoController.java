package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.Enums.status;
import de.neuefische.todoapp.model.Description;
import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.UpdateStatus;
import de.neuefische.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @PutMapping
    public ToDo addToDo(@RequestBody Description description) {
        return toDoService.addToDo(description);
    }

    @GetMapping("{id}/status")
    public ToDo getAllToDos(@PathVariable String id) {

        return toDoService.getToDoById(id);
    }

    @DeleteMapping("{id}")
    public void removeToDo(@PathVariable String id) {
        toDoService.removeToDo(id);
    }

    @PutMapping("{id}/status")
    public ToDo updateStatus(@PathVariable String id, @RequestBody UpdateStatus status) {
        return toDoService.setStatus(id, status);
    }
}

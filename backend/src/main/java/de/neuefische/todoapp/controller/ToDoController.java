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

    // ruft alle ToDos auf http://localhost:8080/ auf
    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    // added neue ToDos
    @PutMapping
    public ToDo addToDo(@RequestBody Description description) {
        return toDoService.addToDo(description);
    }

    // ruft einzelnes ToDo mit id=1 auf http://localhost:8080/1/status auf
    @GetMapping("{id}/status")
    public ToDo getAllToDos(@PathVariable String id) {

        return toDoService.getToDoById(id);
    }

    @DeleteMapping("{id}")
    public void removeToDo(@PathVariable String id) {
        toDoService.removeToDo(id);
    }

    // verschiebt ToDos je nach Status
    @PutMapping("{id}/status")
    public ToDo updateStatus(@PathVariable String id, @RequestBody UpdateStatus status) {
        return toDoService.setStatus(id, status);
    }
}

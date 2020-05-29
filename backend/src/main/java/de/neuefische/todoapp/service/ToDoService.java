package de.neuefische.todoapp.service;

import de.neuefische.todoapp.DB.ToDoDB;
import de.neuefische.todoapp.Enums.status;
import de.neuefische.todoapp.model.Description;
import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.UpdateStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ToDoService {

    private final ToDoDB toDoDB;

    @Autowired
    public ToDoService(ToDoDB toDoDB) {

        this.toDoDB = toDoDB;
    }

    // Listet alle Todos auf
    public List<ToDo> getAllToDos() {

        return toDoDB.getAllToDos();
    }

    // added neue ToDo mit random ID zu status OPEN
    public ToDo addToDo(Description description) {
        String uuid = UUID.randomUUID().toString();
        String message= description.getDescription();
        ToDo newToDo = new ToDo(uuid, message, status.OPEN);
        return toDoDB.addToDo(newToDo);
    }

    // löscht ToDo
    public List<ToDo> removeToDo(String id) {
        for (ToDo toDoToBeRemoved: toDoDB.getAllToDos()){
            if(toDoToBeRemoved.getId().equals(id)) {
                toDoDB.removeToDo(toDoToBeRemoved);
                return toDoDB.getAllToDos();
            }
        } throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ToDo ID not found");
    }


    public ToDo getToDoById(String id) {
        return toDoDB.getToDoById(id);
    }

    // setzt neuen Status zum Verschieben der ToDo
    public ToDo setStatus(String id, UpdateStatus status) {
        status newStatus = status.getStatus();
        for (ToDo todo: toDoDB.getAllToDos()) {
            if (todo.getId().equals(id)) {
                todo.setStatus(newStatus);
                return todo;
            }
        } throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status not found");

    }
}

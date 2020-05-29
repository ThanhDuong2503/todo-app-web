package de.neuefische.todoapp.DB;

import de.neuefische.todoapp.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static de.neuefische.todoapp.Enums.status.*;

@Service
public class ToDoDB {

    private List<ToDo> todos = new ArrayList<>(List.of(
            new ToDo("1", "Kaufe ein Steak", OPEN),
            new ToDo("2", "esse das Steak", IN_PROGRESS),
            new ToDo("3", "verdaue das Steak", DONE)));

    public List<ToDo> getAllToDos(){

        return todos;
    }

    public ToDo addToDo(ToDo newToDo) {

        this.todos.add(newToDo);
        return newToDo;
    }

    public List<ToDo> getToDos() {
        return todos;
    }

    public ToDo getToDoById(String id) {
        for (ToDo toDo : todos) {
            if (toDo.getId().equals(id)) {
                return toDo;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student ID not found");
    }


    public List<ToDo> removeToDo(ToDo toDoToBeRemoved) {
        todos.remove(toDoToBeRemoved);
        return todos;
    }

    public void clearDb(){
        todos.clear();
    }
}

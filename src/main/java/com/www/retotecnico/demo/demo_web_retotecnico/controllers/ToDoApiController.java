package com.www.retotecnico.demo.demo_web_retotecnico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.www.retotecnico.demo.demo_web_retotecnico.models.ToDo;
import com.www.retotecnico.demo.demo_web_retotecnico.services.ToDoApiService;

@RestController
@RequestMapping("/api/todos")
public class ToDoApiController {

    @Autowired
    private ToDoApiService toDoService;

    @PostMapping
    public ToDo crearToDo(@RequestBody ToDo toDo) {
        return toDoService.crear(toDo);
    }

    @GetMapping
    public List<ToDo> obtenerTodos() {
        return toDoService.obtenerTodos();
    }

    @PutMapping("/{id}")
    public ToDo actualizarToDo(@PathVariable Long id, @RequestBody ToDo datosActualizados) {
        return toDoService.actualizar(id, datosActualizados);
    }

    @PatchMapping("/{id}/estatus")
    public ToDo cambiarEstatus(@PathVariable Long id, @RequestBody String completado) {
        return toDoService.cambiarEstatus(id, completado);
    }

    @DeleteMapping("/{id}")
    public void eliminarToDo(@PathVariable Long id) {
        toDoService.eliminar(id);
    }
}

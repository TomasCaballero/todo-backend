package net.todolist.todo_app_backend.controlador;

import lombok.AllArgsConstructor;
import net.todolist.todo_app_backend.dto.TareaDto;
import net.todolist.todo_app_backend.servidor.implementacion.TareaServidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tareas")
public class TareaControlador {

    @Autowired
    private TareaServidor tareaServidor;

    @PostMapping
    public ResponseEntity<TareaDto> crear(@RequestBody TareaDto tareaDto){
        TareaDto tareaGuardada = tareaServidor.crear(tareaDto);
        return new ResponseEntity<>(tareaGuardada, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TareaDto> obtenerTareaPorId(@PathVariable("id")Long id){
        TareaDto tareaEncontrada = tareaServidor.obtenerPorId(id);
        return ResponseEntity.ok(tareaEncontrada);
    }

    @GetMapping
    public ResponseEntity<List<TareaDto>> obtenerTodasLasTareas(){
        List<TareaDto> tareas = tareaServidor.obtenerTodos();
        return ResponseEntity.ok(tareas);
    }

    @PutMapping("{id}")
    public ResponseEntity<TareaDto> modificarTarea(@PathVariable("id") Long id,@RequestBody TareaDto tareaNueva){
        TareaDto tarea = tareaServidor.modificarTareaPorId(id,tareaNueva);
        return ResponseEntity.ok(tarea);
    }
}

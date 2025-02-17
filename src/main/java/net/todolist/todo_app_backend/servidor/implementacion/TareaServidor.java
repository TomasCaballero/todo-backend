package net.todolist.todo_app_backend.servidor.implementacion;

import lombok.AllArgsConstructor;
import net.todolist.todo_app_backend.dto.TareaDto;
import net.todolist.todo_app_backend.entity.Tarea;
import net.todolist.todo_app_backend.exception.ResourceNotFoundException;
import net.todolist.todo_app_backend.mapper.TareaMapper;
import net.todolist.todo_app_backend.repositorio.TareaRepositorio;
import net.todolist.todo_app_backend.servidor.EntityServidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TareaServidor implements EntityServidor<TareaDto> {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Override
    public TareaDto crear(TareaDto entityDto) {
        Tarea tarea = TareaMapper.toTarea(entityDto);
        Tarea tareaGuardada = tareaRepositorio.save(tarea);
        return TareaMapper.toTareaDto(tareaGuardada);
    }

    @Override
    public TareaDto obtenerPorId(Long id) {
        Tarea tareaEncontrada = tareaRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe tarea con id: "+id));
        return TareaMapper.toTareaDto(tareaEncontrada);
    }

    @Override
    public List<TareaDto> obtenerTodos() {
        List<Tarea> tareas = tareaRepositorio.findAll();
        return tareas.stream().map((tarea -> TareaMapper.toTareaDto(tarea)))
                .collect(Collectors.toList());
    }
}

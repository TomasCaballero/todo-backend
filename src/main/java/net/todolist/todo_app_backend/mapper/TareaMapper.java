package net.todolist.todo_app_backend.mapper;

import net.todolist.todo_app_backend.dto.TareaDto;
import net.todolist.todo_app_backend.entity.Tarea;

public class TareaMapper {
    public static TareaDto toTareaDto(Tarea tarea){
        return new TareaDto(
                tarea.getId(),
                tarea.getUsuario(),
                tarea.getTitulo(),
                tarea.getContenido()
        );
    }

    public static Tarea toTarea(TareaDto tareaDto){
        return new Tarea(
                tareaDto.getId(),
                tareaDto.getUsuario(),
                tareaDto.getTitulo(),
                tareaDto.getContenido()
        );
    }
}

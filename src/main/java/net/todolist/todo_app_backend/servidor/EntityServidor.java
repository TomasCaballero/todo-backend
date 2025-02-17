package net.todolist.todo_app_backend.servidor;

import net.todolist.todo_app_backend.dto.EntityDto;

public interface EntityServidor<T extends EntityDto> {
    T crear(T entityDto);
    T obtenerPorId(Long id);
}

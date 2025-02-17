package net.todolist.todo_app_backend.repositorio;

import net.todolist.todo_app_backend.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
}

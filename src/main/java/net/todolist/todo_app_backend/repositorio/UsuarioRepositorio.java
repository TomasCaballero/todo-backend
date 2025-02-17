package net.todolist.todo_app_backend.repositorio;

import net.todolist.todo_app_backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}

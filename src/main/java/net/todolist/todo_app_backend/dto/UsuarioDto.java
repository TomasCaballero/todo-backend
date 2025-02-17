package net.todolist.todo_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.todolist.todo_app_backend.entity.Tarea;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String password;
    private List<Tarea> tareas = new ArrayList<>();
}

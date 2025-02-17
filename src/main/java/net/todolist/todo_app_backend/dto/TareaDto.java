package net.todolist.todo_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.todolist.todo_app_backend.entity.Usuario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TareaDto extends EntityDto{
    private Long id;
    private Usuario usuario;
    private String titulo;
    private String contenido;
}

package net.todolist.todo_app_backend.mapper;

import net.todolist.todo_app_backend.dto.UsuarioDto;
import net.todolist.todo_app_backend.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDto toUsuarioDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getTareas()
        );
    }

    public static Usuario toUsuario(UsuarioDto usuarioDto){
        return new Usuario(
                usuarioDto.getId(),
                usuarioDto.getNombreUsuario(),
                usuarioDto.getEmail(),
                usuarioDto.getPassword(),
                usuarioDto.getTareas()
        );
    }
}

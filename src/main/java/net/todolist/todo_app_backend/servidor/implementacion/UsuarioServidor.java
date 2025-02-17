package net.todolist.todo_app_backend.servidor.implementacion;

import lombok.AllArgsConstructor;
import net.todolist.todo_app_backend.dto.EntityDto;
import net.todolist.todo_app_backend.dto.UsuarioDto;
import net.todolist.todo_app_backend.entity.Usuario;
import net.todolist.todo_app_backend.mapper.UsuarioMapper;
import net.todolist.todo_app_backend.repositorio.UsuarioRepositorio;
import net.todolist.todo_app_backend.servidor.EntityServidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServidor implements EntityServidor<UsuarioDto> {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioDto crear(UsuarioDto entityDto) {
        Usuario usuario = UsuarioMapper.toUsuario(entityDto);
        Usuario usuarioGuardado = usuarioRepositorio.save(usuario);
        return UsuarioMapper.toUsuarioDto(usuarioGuardado);
    }
}

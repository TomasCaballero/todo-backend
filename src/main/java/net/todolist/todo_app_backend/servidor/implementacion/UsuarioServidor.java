package net.todolist.todo_app_backend.servidor.implementacion;

import lombok.AllArgsConstructor;
import net.todolist.todo_app_backend.dto.EntityDto;
import net.todolist.todo_app_backend.dto.UsuarioDto;
import net.todolist.todo_app_backend.entity.Usuario;
import net.todolist.todo_app_backend.exception.ResourceNotFoundException;
import net.todolist.todo_app_backend.mapper.UsuarioMapper;
import net.todolist.todo_app_backend.repositorio.UsuarioRepositorio;
import net.todolist.todo_app_backend.servidor.EntityServidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public UsuarioDto obtenerPorId(Long id) {

        Usuario usuarioEncontrado = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe usuario con id: "+id));

        return UsuarioMapper.toUsuarioDto(usuarioEncontrado);
    }

    @Override
    public List<UsuarioDto> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarios.stream().map((usuario -> UsuarioMapper.toUsuarioDto(usuario)))
                .collect(Collectors.toList());
    }

}

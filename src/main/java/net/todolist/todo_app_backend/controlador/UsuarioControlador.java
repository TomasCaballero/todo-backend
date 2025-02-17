package net.todolist.todo_app_backend.controlador;

import lombok.AllArgsConstructor;
import net.todolist.todo_app_backend.dto.UsuarioDto;
import net.todolist.todo_app_backend.servidor.implementacion.UsuarioServidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServidor usuarioServidor;

    @PostMapping
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuarioGuardad = usuarioServidor.crear(usuarioDto);
        return new ResponseEntity<>(usuarioGuardad, HttpStatus.CREATED);
    }
}

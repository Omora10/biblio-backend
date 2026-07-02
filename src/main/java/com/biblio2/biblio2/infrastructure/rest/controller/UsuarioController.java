package com.biblio2.biblio2.infrastructure.rest.controller;

import com.biblio2.biblio2.application.dto.UsuarioRequest;
import com.biblio2.biblio2.application.dto.UsuarioResponse;
import com.biblio2.biblio2.application.service.UsuarioApplicationService;
import com.biblio2.biblio2.domain.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST: Usuario
 * Expone los endpoints para la gestión de usuarios
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioApplicationService usuarioService;

    /**
     * Constructor con inyección de dependencias
     */
    public UsuarioController(UsuarioApplicationService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * GET /api/usuarios
     * Obtiene todos los usuarios
     */
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> obtenerTodos() {

        List<UsuarioResponse> usuarios = usuarioService.ejecutar()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuarios);
    }

    /**
     * POST /api/usuarios/registrar
     * Registra un nuevo usuario en el sistema
     */
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRequest request) {

        Usuario usuario = usuarioService.registrarUsuario(
                request.getNombre(),
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(usuario));
    }

    /**
     * GET /api/usuarios/{id}
     * Obtiene un usuario por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id) {

        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);

        return ResponseEntity.ok(toResponse(usuario));
    }

    /**
     * PUT /api/usuarios/{id}
     * Actualiza un usuario existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioRequest request) {

        Usuario usuario = usuarioService.actualizarUsuario(
                id,
                request.getNombre(),
                request.getEmail()
        );

        return ResponseEntity.ok(toResponse(usuario));
    }

    /**
     * GET /api/usuarios/email/{email}
     * Obtiene un usuario por email
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponse> obtenerPorEmail(@PathVariable String email) {

        Usuario usuario = usuarioService.obtenerPorEmail(email);

        return ResponseEntity.ok(toResponse(usuario));
    }

    /**
     * Convierte una entidad de dominio Usuario a DTO UsuarioResponse
     */
    private UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
        );
    }
}
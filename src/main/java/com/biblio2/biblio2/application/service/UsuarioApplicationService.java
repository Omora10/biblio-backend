package com.biblio2.biblio2.application.service;

import com.biblio2.biblio2.domain.entity.Usuario;
import com.biblio2.biblio2.domain.exception.UsuarioNoEncontradoException;
import com.biblio2.biblio2.domain.port.UsuarioRepositoryPort;
import com.biblio2.biblio2.domain.usecase.usuario.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio de Aplicación: Usuario
 * Orquesta los casos de uso relacionados con usuarios
 * Implementa las interfaces de casos de uso y delega en los puertos
 */
@Service
public class UsuarioApplicationService implements
        RegistrarUsuarioUseCase,
        ObtenerUsuarioPorIdUseCase,
        ObtenerUsuariosUseCase,
        ActualizarUsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioApplicationService(UsuarioRepositoryPort usuarioRepository,
                                     PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * Se asignan valores por defecto para los nuevos campos
     * manteniendo compatibilidad con el frontend actual.
     */
    public Usuario registrarUsuario(String nombre, String email, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        Usuario nuevoUsuario = new Usuario(
                nombre,
                email,
                encodedPassword,
                null,                  // telefono
                null,                  // avatarUrl
                true,                  // activo
                LocalDate.now()        // fechaRegistro
        );

        return usuarioRepository.guardar(nuevoUsuario);
    }

    /**
     * Implementación del caso de uso RegistrarUsuarioUseCase
     */
    @Override
    public Usuario ejecutar(String nombre, String email, String password) {
        return registrarUsuario(nombre, email, password);
    }

    /**
     * Obtiene todos los usuarios
     */
    @Override
    public List<Usuario> ejecutar() {
        return usuarioRepository.obtenerTodos();
    }

    /**
     * Obtiene un usuario por su ID
     */
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.obtenerPorId(id)
                .orElseThrow(() ->
                        new UsuarioNoEncontradoException(
                                "Usuario con ID " + id + " no encontrado"));
    }

    /**
     * Implementación del caso de uso ObtenerUsuarioPorIdUseCase
     */
    @Override
    public Usuario ejecutar(Long id) {
        return obtenerUsuarioPorId(id);
    }

    /**
     * Actualiza un usuario existente.
     * Conserva los nuevos campos si no son modificados.
     */
    public Usuario actualizarUsuario(Long id, String nombre, String email) {

        Usuario usuario = obtenerUsuarioPorId(id);

        usuario.setNombre(nombre);
        usuario.setEmail(email);

        return usuarioRepository.actualizar(usuario);
    }

    /**
     * Implementación del caso de uso ActualizarUsuarioUseCase
     */
    @Override
    public Usuario ejecutar(Long id, String nombre, String email) {
        return actualizarUsuario(id, nombre, email);
    }

    /**
     * Obtiene un usuario por email
     */
    public Usuario obtenerPorEmail(String email) {

        return usuarioRepository.obtenerPorEmail(email)
                .orElseThrow(() ->
                        new UsuarioNoEncontradoException(
                                "Usuario con email " + email + " no encontrado"));
    }
}
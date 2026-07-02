package com.biblio2.biblio2.domain.usecase.usuario;

import com.biblio2.biblio2.domain.entity.Usuario;

import java.util.List;

/**
 * Caso de uso: Obtener todos los usuarios
 */
public interface ObtenerUsuariosUseCase {

    /**
     * Retorna la lista de usuarios registrados
     */
    List<Usuario> ejecutar();
}
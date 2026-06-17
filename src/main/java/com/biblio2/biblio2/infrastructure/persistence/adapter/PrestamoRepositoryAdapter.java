package com.biblio2.biblio2.infrastructure.persistence.adapter;

import com.biblio2.biblio2.domain.entity.Prestamo;
import com.biblio2.biblio2.domain.entity.Usuario;
import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.port.PrestamoRepositoryPort;
import com.biblio2.biblio2.infrastructure.persistence.entity.PrestamoEntity;
import com.biblio2.biblio2.infrastructure.persistence.entity.UsuarioEntity;
import com.biblio2.biblio2.infrastructure.persistence.entity.LibroEntity;
import com.biblio2.biblio2.infrastructure.persistence.repository.PrestamoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PrestamoRepositoryAdapter implements PrestamoRepositoryPort {

    private final PrestamoJpaRepository jpaRepository;

    public PrestamoRepositoryAdapter(PrestamoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        PrestamoEntity entity = mapToEntity(prestamo);
        entity = jpaRepository.save(entity);
        return mapToDomain(entity);
    }

    @Override
    public Optional<Prestamo> obtenerPorId(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<Prestamo> obtenerPorUsuario(Long usuarioId) {
        return jpaRepository.findByUsuarioId(usuarioId).stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Prestamo actualizar(Prestamo prestamo) {
        return guardar(prestamo);
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }

    private PrestamoEntity mapToEntity(Prestamo prestamo) {
        PrestamoEntity entity = new PrestamoEntity();

        if (prestamo.getId() != null) {
            entity.setId(prestamo.getId());
        }

        if (prestamo.getUsuario() != null) {
            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setId(prestamo.getUsuario().getId());
            usuarioEntity.setNombre(prestamo.getUsuario().getNombre());
            usuarioEntity.setEmail(prestamo.getUsuario().getEmail());
            usuarioEntity.setPassword(prestamo.getUsuario().getPassword());
            entity.setUsuario(usuarioEntity);
        }

        if (prestamo.getLibro() != null) {
            LibroEntity libroEntity = new LibroEntity();
            libroEntity.setId(prestamo.getLibro().getId());
            libroEntity.setTitulo(prestamo.getLibro().getTitulo());
            libroEntity.setAutor(prestamo.getLibro().getAutor());
            libroEntity.setIsbn(prestamo.getLibro().getIsbn());
            libroEntity.setImagenUrl(prestamo.getLibro().getImagenUrl());
            libroEntity.setPrestado(prestamo.getLibro().isPrestado());
            entity.setLibro(libroEntity);
        }

        entity.setFechaPrestamo(prestamo.getFechaPrestamo());
        entity.setFechaDevolucion(prestamo.getFechaDevolucion());
        entity.setDevuelto(prestamo.isDevuelto());

        return entity;
    }

    private Prestamo mapToDomain(PrestamoEntity entity) {
        Usuario usuario = null;

        if (entity.getUsuario() != null) {
            usuario = new Usuario(
                    entity.getUsuario().getId(),
                    entity.getUsuario().getNombre(),
                    entity.getUsuario().getEmail(),
                    entity.getUsuario().getPassword()
            );
        }

        Libro libro = null;

        if (entity.getLibro() != null) {
            libro = new Libro(
                    entity.getLibro().getId(),
                    entity.getLibro().getTitulo(),
                    entity.getLibro().getAutor(),
                    entity.getLibro().getIsbn(),
                    entity.getLibro().getImagenUrl()
            );

            libro.setPrestado(entity.getLibro().isPrestado());
        }

        Prestamo prestamo = new Prestamo(usuario, libro, entity.getFechaPrestamo());
        prestamo.setId(entity.getId());
        prestamo.setFechaDevolucion(entity.getFechaDevolucion());
        prestamo.setDevuelto(entity.isDevuelto());

        return prestamo;
    }
}
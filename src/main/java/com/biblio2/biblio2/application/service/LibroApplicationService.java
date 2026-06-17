package com.biblio2.biblio2.application.service;

import com.biblio2.biblio2.domain.entity.Libro;
import com.biblio2.biblio2.domain.exception.LibroNoEncontradoException;
import com.biblio2.biblio2.domain.port.LibroRepositoryPort;
import com.biblio2.biblio2.domain.usecase.libro.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroApplicationService implements
        CrearLibroUseCase,
        ObtenerLibrosUseCase,
        ObtenerLibroPorIdUseCase,
        EliminarLibroUseCase,
        ActualizarLibroUseCase {

    private final LibroRepositoryPort libroRepository;

    public LibroApplicationService(LibroRepositoryPort libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro ejecutar(String titulo, String autor, String isbn, String imagenUrl) {
        Libro nuevoLibro = new Libro(titulo, autor, isbn, imagenUrl);
        return libroRepository.guardar(nuevoLibro);
    }

    @Override
    public List<Libro> ejecutar() {
        return libroRepository.obtenerTodos();
    }

    @Override
    public Libro ejecutar(Long id) {
        return libroRepository.obtenerPorId(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + id + " no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        if (!libroRepository.existe(id)) {
            throw new LibroNoEncontradoException("Libro con ID " + id + " no encontrado");
        }

        libroRepository.eliminar(id);
    }

    @Override
    public Libro ejecutar(Long id, String titulo, String autor, String isbn, String imagenUrl) {
        Libro libroExistente = libroRepository.obtenerPorId(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con ID " + id + " no encontrado"));

        libroExistente.setTitulo(titulo);
        libroExistente.setAutor(autor);
        libroExistente.setIsbn(isbn);
        libroExistente.setImagenUrl(imagenUrl);

        return libroRepository.actualizar(libroExistente);
    }
}
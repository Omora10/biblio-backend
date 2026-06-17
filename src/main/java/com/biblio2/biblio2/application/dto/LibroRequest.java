package com.biblio2.biblio2.application.dto;

public class LibroRequest {

    private String titulo;
    private String autor;
    private String isbn;
    private String imagenUrl;

    public LibroRequest() {
    }

    public LibroRequest(String titulo, String autor, String isbn, String imagenUrl) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.imagenUrl = imagenUrl;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
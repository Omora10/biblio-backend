package com.biblio2.biblio2.application.dto;

public class LibroResponse {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String imagenUrl;
    private boolean prestado;

    public LibroResponse() {
    }

    public LibroResponse(Long id,
                         String titulo,
                         String autor,
                         String isbn,
                         String imagenUrl,
                         boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.imagenUrl = imagenUrl;
        this.prestado = prestado;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
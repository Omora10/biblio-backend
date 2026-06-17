package com.biblio2.biblio2.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String autor;

    @Column(nullable = false, length = 20, unique = true)
    private String isbn;

    @Column(length = 500)
    private String imagenUrl;

    @Column(nullable = false)
    private boolean prestado = false;

    public LibroEntity() {
    }

    public LibroEntity(String titulo, String autor, String isbn, String imagenUrl) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.imagenUrl = imagenUrl;
    }

    public LibroEntity(Long id, String titulo, String autor, String isbn, String imagenUrl) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.imagenUrl = imagenUrl;
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

    @Override
    public String toString() {
        return "LibroEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
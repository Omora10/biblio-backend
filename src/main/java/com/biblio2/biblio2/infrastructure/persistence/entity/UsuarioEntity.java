package com.biblio2.biblio2.infrastructure.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entidad JPA: Usuario
 * Mapea la entidad de dominio Usuario a la tabla usuarios en la base de datos
 */
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String telefono;

    @Column(length = 500)
    private String avatarUrl;

    @Column(nullable = false)
    private boolean activo = true;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    /**
     * Constructor sin argumentos
     */
    public UsuarioEntity() {
    }

    /**
     * Constructor para registrar un nuevo usuario
     */
    public UsuarioEntity(String nombre,
                         String email,
                         String password,
                         String telefono,
                         String avatarUrl,
                         boolean activo,
                         LocalDate fechaRegistro) {

        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.avatarUrl = avatarUrl;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor completo
     */
    public UsuarioEntity(Long id,
                         String nombre,
                         String email,
                         String password,
                         String telefono,
                         String avatarUrl,
                         boolean activo,
                         LocalDate fechaRegistro) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.avatarUrl = avatarUrl;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public boolean isActivo() {
        return activo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", activo=" + activo +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
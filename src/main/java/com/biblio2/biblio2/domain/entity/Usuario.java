package com.biblio2.biblio2.domain.entity;

import java.time.LocalDate;

/**
 * Entidad de dominio: Usuario
 * Representa un usuario del sistema sin dependencias de Spring ni infraestructura.
 */
public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String telefono;
    private String avatarUrl;
    private boolean activo = true;
    private LocalDate fechaRegistro;

    /**
     * Constructor vacío
     */
    public Usuario() {
    }

    /**
     * Constructor antiguo (compatibilidad)
     */
    public Usuario(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.activo = true;
    }

    /**
     * Constructor antiguo (compatibilidad)
     */
    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.activo = true;
    }

    /**
     * Constructor completo
     */
    public Usuario(Long id,
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

    /**
     * Constructor para crear un nuevo usuario
     */
    public Usuario(String nombre,
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
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
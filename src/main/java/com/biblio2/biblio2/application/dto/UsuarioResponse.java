package com.biblio2.biblio2.application.dto;

import java.time.LocalDate;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String avatarUrl;
    private boolean activo;
    private LocalDate fechaRegistro;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id,
                           String nombre,
                           String email,
                           String telefono,
                           String avatarUrl,
                           boolean activo,
                           LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
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
}
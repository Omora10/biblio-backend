package com.biblio2.biblio2.application.dto;

import java.time.LocalDate;

public class UsuarioRequest {

    private String nombre;
    private String email;
    private String password;
    private String telefono;
    private String avatarUrl;
    private boolean activo;
    private LocalDate fechaRegistro;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String nombre,
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
}
package org.proundmega.protocolos.app.domain;

import lombok.Data;

@Data
public class Usuario {
    private String usuario;
    private String password;

    public Usuario(String nombre, String password) {
        this.usuario = nombre;
        this.password = password;
    }

    public Usuario() {
    }

}

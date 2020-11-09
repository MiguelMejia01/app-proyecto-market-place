package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceAccessDeniedException extends Exception {

    public static final String DESCRIPCION = "No tiene acceso al recurso solicitado";

    public MasterResourceAccessDeniedException() {
        super(DESCRIPCION);
    }

    public MasterResourceAccessDeniedException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

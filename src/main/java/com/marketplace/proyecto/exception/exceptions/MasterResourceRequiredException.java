package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceRequiredException extends Exception {

    public static final String DESCRIPCION = "El campo es requerido";

    public MasterResourceRequiredException() {
        super(DESCRIPCION);
    }

    public MasterResourceRequiredException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

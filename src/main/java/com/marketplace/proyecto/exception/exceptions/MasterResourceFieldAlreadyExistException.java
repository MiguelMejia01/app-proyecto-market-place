package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceFieldAlreadyExistException extends Exception {

    public static final String DESCRIPCION = "El recurso se encuentra registrado";

    public MasterResourceFieldAlreadyExistException() {
        super(DESCRIPCION);
    }

    public MasterResourceFieldAlreadyExistException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceOlderException extends Exception {

    public static final String DESCRIPCION = "Persona menor de edad";

    public MasterResourceOlderException() {
        super(DESCRIPCION);
    }

    public MasterResourceOlderException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

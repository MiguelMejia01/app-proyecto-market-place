package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceFieldInvalidException extends Exception {


    public static final String DESCRIPCION = "Campo o tipo de dato inválido";

    public MasterResourceFieldInvalidException() {
        super(DESCRIPCION);
    }

    public MasterResourceFieldInvalidException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

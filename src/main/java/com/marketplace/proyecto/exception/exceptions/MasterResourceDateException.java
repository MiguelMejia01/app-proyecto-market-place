package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceDateException extends Exception {


    public static final String DESCRIPCION = "Violación de asignación en la fecha";

    public MasterResourceDateException() {
        super(DESCRIPCION);
    }

    public MasterResourceDateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

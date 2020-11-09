package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceNotAssociateException extends Exception {

    public static final String DESCRIPCION = "No hay recursos disponibles";

    public MasterResourceNotAssociateException() {
        super(DESCRIPCION);
    }

    public MasterResourceNotAssociateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

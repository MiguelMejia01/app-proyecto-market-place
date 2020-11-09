package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceDeletedException extends Exception {

    public static final String DESCRIPCION = "No ha sido posible eliminar el registro";

    public MasterResourceDeletedException() {
        super(DESCRIPCION);
    }

    public MasterResourceDeletedException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

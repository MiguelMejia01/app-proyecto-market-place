package com.marketplace.proyecto.exception.exceptions;

public class MasterResourceContratoActivoException extends Exception {


    public static final String DESCRIPCION = "El empleado posee un contrato activo.";

    public MasterResourceContratoActivoException() {
        super(DESCRIPCION);
    }

    public MasterResourceContratoActivoException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}

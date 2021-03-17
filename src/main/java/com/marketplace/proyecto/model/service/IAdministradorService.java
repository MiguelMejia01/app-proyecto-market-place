package com.marketplace.proyecto.model.service;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Administrador;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAdministradorService {




    // BUSCAR  POR ID
    @Transactional(readOnly = true)
    Administrador findById(Long id) throws MasterResourceNotFoundException;

    // SERVICIO DE CREAR
    @Transactional(propagation = Propagation.NEVER)
    Administrador create(Administrador administrador) throws Exception;

    // SERVICIO DE EDITAR
    @Transactional(propagation = Propagation.NEVER)
    Administrador edit(Long id, Administrador administrador) throws Exception;

    // SERVICIO DE ELIMINAR
    @Transactional(propagation = Propagation.NEVER)
    void delete(Long id) throws MasterResourceDeletedException;
}

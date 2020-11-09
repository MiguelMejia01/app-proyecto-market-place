package com.marketplace.proyecto.model.service;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Proveedor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProveedorService {
    // BUSQUEDA POR TODAS
    List<Proveedor> findByAll();

    // BUSCAR  POR ID
    @Transactional(readOnly = true)
    Proveedor findById(Long id) throws MasterResourceNotFoundException;

    // SERVICIO DE CREAR
    @Transactional(propagation = Propagation.NEVER)
    Proveedor create(Proveedor proveedor) throws Exception;

    // SERVICIO DE EDITAR
    @Transactional(propagation = Propagation.NEVER)
    Proveedor edit(Long id, Proveedor proveedor) throws Exception;

    // SERVICIO DE ELIMINAR
    @Transactional(propagation = Propagation.NEVER)
    void delete(Long id) throws MasterResourceDeletedException;
}

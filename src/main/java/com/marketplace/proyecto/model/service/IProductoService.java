package com.marketplace.proyecto.model.service;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Producto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductoService {
    // BUSQUEDA POR TODAS
    List<Producto> findByAll();

    // BUSCAR  POR ID
    @Transactional(readOnly = true)
    Producto findById(Long id) throws MasterResourceNotFoundException;

    // SERVICIO DE CREAR
    @Transactional(propagation = Propagation.NEVER)
    Producto create(Producto producto) throws Exception;

    // SERVICIO DE EDITAR
    @Transactional(propagation = Propagation.NEVER)
    Producto edit(Long id, Producto producto) throws Exception;

    // SERVICIO DE ELIMINAR
    @Transactional(propagation = Propagation.NEVER)
    void delete(Long id) throws MasterResourceDeletedException;
}

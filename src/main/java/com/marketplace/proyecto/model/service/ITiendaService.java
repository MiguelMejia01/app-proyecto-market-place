package com.marketplace.proyecto.model.service;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Tienda;

import java.util.List;

public interface ITiendaService {


    Tienda findById(Long id) throws MasterResourceNotFoundException;

    Tienda create(Tienda tienda) throws Exception;

    Tienda edit(Long id, Tienda tienda) throws Exception;

    void delete(Long id) throws MasterResourceDeletedException;
}

package com.marketplace.proyecto.model.service;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Cliente;

import java.util.List;

public interface IClienteService {


    Cliente findById(Long id) throws MasterResourceNotFoundException;

    Cliente create(Cliente cliente) throws Exception;

    Cliente edit(Long id, Cliente cliente) throws Exception;

    void delete(Long id) throws MasterResourceDeletedException;
}

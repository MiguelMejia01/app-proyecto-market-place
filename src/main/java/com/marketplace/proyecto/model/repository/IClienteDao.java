package com.marketplace.proyecto.model.repository;

import com.marketplace.proyecto.model.entity.Cliente;
import com.marketplace.proyecto.model.entity.Tienda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteDao  extends CrudRepository<Cliente,Long> {
}

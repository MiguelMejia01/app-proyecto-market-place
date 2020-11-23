package com.marketplace.proyecto.model.repository;

import com.marketplace.proyecto.model.entity.Administrador;
import com.marketplace.proyecto.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdministradorDao  extends CrudRepository<Administrador, Long> {

   // List<Administrador> findAllByOrderById();

}

package com.marketplace.proyecto.model.service.implement;

import com.marketplace.proyecto.exception.exceptions.ApiRequestException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceConstraintException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Cliente;
import com.marketplace.proyecto.model.repository.IClienteDao;
import com.marketplace.proyecto.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {


    @Autowired
    private IClienteDao clienteDao;

    private Cliente cliente;

    // BUSQUEDA POR TODAS
    @Override
    public List<Cliente> findByAll() {
        List<Cliente> clientes = clienteDao.findAllByOrderById();
        return clientes;
    }

    // BUSCAR  POR ID
    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) throws MasterResourceNotFoundException {
        cliente = clienteDao.findById(id).orElse(null);
        if(cliente == null){
            throw new MasterResourceNotFoundException();
        }
        return cliente;
    }

    // SERVICIO DE CREAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Cliente create(Cliente cliente) throws Exception {


        Cliente crear = null;
        try{

            crear = clienteDao.save(cliente);
        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> " El campo " + err.getPropertyPath() + " " + err.getMessage()).collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad cliente identificada con " + cliente.getId() + " ";
            throw new MasterResourceConstraintException(error);
        }
        return crear;
    }


    // SERVICIO DE EDITAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Cliente edit(Long id, Cliente cliente) throws Exception {

        this.cliente = clienteDao.findById(id).orElse(null);

        if(this.cliente == null){
            throw new MasterResourceNotFoundException();
        }
        try{
            this.cliente.setEmail(cliente.getEmail());
            this.cliente.setTarjeta(cliente.getTarjeta());
            this.cliente.setTelefono(cliente.getTelefono());
            this.cliente.setContraseña(cliente.getContraseña());
            this.cliente.setFacturas(cliente.getFacturas());


            return clienteDao.save(this.cliente);

        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> "El campo " + err.getPropertyPath() + " " + err.getMessage()).
                            collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad Cliente identificada con " + cliente.getId() + " ";
            throw new MasterResourceConstraintException(error);
        }
    }

    // SERVICIO DE ELIMINAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(Long id) throws MasterResourceDeletedException {
        try {
            clienteDao.deleteById(id);
        }catch (Exception e){
            throw new MasterResourceDeletedException(e.getLocalizedMessage());
        }
    }


}

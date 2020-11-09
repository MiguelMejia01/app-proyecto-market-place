package com.marketplace.proyecto.model.service.implement;

import com.marketplace.proyecto.exception.exceptions.ApiRequestException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceConstraintException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Administrador;
import com.marketplace.proyecto.model.entity.Cliente;
import com.marketplace.proyecto.model.repository.IAdministradorDao;
import com.marketplace.proyecto.model.service.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorService implements IAdministradorService {

    @Autowired
    private IAdministradorDao administradorDao;

    private Administrador administrador;

    // BUSQUEDA POR TODAS
    @Override
    public List<Administrador> findByAll() {
        List<Administrador> administrador = administradorDao.findAllByOrderById();
        return administrador;
    }

    // BUSCAR  POR ID
    @Override
    @Transactional(readOnly = true)
    public Administrador findById(Long id) throws MasterResourceNotFoundException {
        administrador = administradorDao.findById(id).orElse(null);
        if(administrador == null){
            throw new MasterResourceNotFoundException();
        }
        return administrador;
    }

    // SERVICIO DE CREAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Administrador create(Administrador administrador) throws Exception {


        Administrador crear = null;
        try{

            crear = administradorDao.save(administrador);
        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> " El campo " + err.getPropertyPath() + " " + err.getMessage()).collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad Administrador identificada con " + administrador.getIdadministrador() + " ";
            throw new MasterResourceConstraintException(error);
        }
        return crear;
    }


    // SERVICIO DE EDITAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Administrador edit(Long id, Administrador administrador) throws Exception {

        this.administrador = administradorDao.findById(id).orElse(null);

        if(this.administrador == null){
            throw new MasterResourceNotFoundException();
        }
        try{
            this.administrador.setCodigo(administrador.getCodigo());
            this.administrador.setNombre(administrador.getNombre());



            return administradorDao.save(this.administrador);

        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> "El campo " + err.getPropertyPath() + " " + err.getMessage()).
                            collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad Administrador identificada con " + administrador.getIdadministrador() + " ";
            throw new MasterResourceConstraintException(error);
        }
    }

    // SERVICIO DE ELIMINAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(Long id) throws MasterResourceDeletedException {
        try {
            administradorDao.deleteById(id);
        }catch (Exception e){
            throw new MasterResourceDeletedException(e.getLocalizedMessage());
        }
    }
}

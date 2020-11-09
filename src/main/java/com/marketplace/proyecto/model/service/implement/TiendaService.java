package com.marketplace.proyecto.model.service.implement;

import com.marketplace.proyecto.exception.exceptions.ApiRequestException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceConstraintException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Tienda;
import com.marketplace.proyecto.model.repository.ITiendaDao;
import com.marketplace.proyecto.model.service.ITiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaService implements ITiendaService {

    @Autowired
    private ITiendaDao tiendaDao;

    private Tienda tienda;

    // BUSQUEDA POR TODAS LAS TIENDAS
    @Override
    public List<Tienda> findByAll() {
        List<Tienda> tiendas = tiendaDao.findAllByOrderById();
        return tiendas;
    }

    // BUSCAR DIAS NO LABORABLES POR ID
    @Override
    @Transactional(readOnly = true)
    public Tienda findById(Long id) throws MasterResourceNotFoundException {
        tienda = tiendaDao.findById(id).orElse(null);
        if(tienda == null){
            throw new MasterResourceNotFoundException();
        }
        return tienda;
    }

    // SERVICIO DE CREAR DIAS NO LABORABLES
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Tienda create(Tienda tienda) throws Exception {


        Tienda crear = null;
        try{

            crear = tiendaDao.save(tienda);
        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> " El campo " + err.getPropertyPath() + " " + err.getMessage()).collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad dias no laborales identificada con " + tienda.getNombre() + " ";
            throw new MasterResourceConstraintException(error);
        }
        return crear;
    }


    // SERVICIO DE EDITAR DIAS NO LABORABLES
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Tienda edit(Long id, Tienda tienda) throws Exception {

        this.tienda = tiendaDao.findById(id).orElse(null);

        if(this.tienda == null){
            throw new MasterResourceNotFoundException();
        }
        try{
            this.tienda.setNombre(tienda.getNombre());
            this.tienda.setCorreo(tienda.getCorreo());


            return tiendaDao.save(this.tienda);

        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> "El campo " + err.getPropertyPath() + " " + err.getMessage()).
                            collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad Tienda identificada con " + tienda.getNombre() + " ";
            throw new MasterResourceConstraintException(error);
        }
    }

    // SERVICIO DE ELIMINAR DIAS NO LABORABLES
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(Long id) throws MasterResourceDeletedException {
        try {
            tiendaDao.deleteById(id);
        }catch (Exception e){
            throw new MasterResourceDeletedException(e.getLocalizedMessage());
        }
    }

}

package com.marketplace.proyecto.model.service.implement;

import com.marketplace.proyecto.exception.exceptions.ApiRequestException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceConstraintException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Cliente;
import com.marketplace.proyecto.model.entity.Producto;
import com.marketplace.proyecto.model.repository.IProductoDao;
import com.marketplace.proyecto.model.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {


    @Autowired
    private IProductoDao productoDao;

    private Producto producto;

    // BUSQUEDA POR TODAS
    @Override
    public List<Producto> findByAll() {
        List<Producto> productos = productoDao.findAllByOrderById();
        return productos;
    }

    // BUSCAR  POR ID
    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) throws MasterResourceNotFoundException {
        producto = productoDao.findById(id).orElse(null);
        if(producto == null){
            throw new MasterResourceNotFoundException();
        }
        return producto;
    }

    // SERVICIO DE CREAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Producto create(Producto producto) throws Exception {


        Producto crear = null;
        try{

            crear = productoDao.save(producto);
        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> " El campo " + err.getPropertyPath() + " " + err.getMessage()).collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad Producto identificada con " + producto.getId() + " ";
            throw new MasterResourceConstraintException(error);
        }
        return crear;
    }


    // SERVICIO DE EDITAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Producto edit(Long id, Producto producto) throws Exception {

        this.producto = productoDao.findById(id).orElse(null);

        if(this.producto == null){
            throw new MasterResourceNotFoundException();
        }
        try{
            this.producto.setNombre(producto.getNombre());
            this.producto.setDescripcion(producto.getDescripcion());
            this.producto.setPrecio(producto.getPrecio());


            return productoDao.save(this.producto);

        }catch (ConstraintViolationException ce){
            List<String> errores = ce.getConstraintViolations()
                    .stream().map(err -> "El campo " + err.getPropertyPath() + " " + err.getMessage()).
                            collect(Collectors.toList());
            throw new ApiRequestException(errores.toString(), ce.getCause());
        }catch (DataIntegrityViolationException di){
            String error = " La entidad Producto identificada con " + producto.getId() + " ";
            throw new MasterResourceConstraintException(error);
        }
    }

    // SERVICIO DE ELIMINAR
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(Long id) throws MasterResourceDeletedException {
        try {
            productoDao.deleteById(id);
        }catch (Exception e){
            throw new MasterResourceDeletedException(e.getLocalizedMessage());
        }
    }


}

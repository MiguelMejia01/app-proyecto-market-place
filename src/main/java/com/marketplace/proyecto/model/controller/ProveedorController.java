package com.marketplace.proyecto.model.controller;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Administrador;
import com.marketplace.proyecto.model.entity.Proveedor;
import com.marketplace.proyecto.model.repository.IAdministradorDao;
import com.marketplace.proyecto.model.repository.IProveedorDao;
import com.marketplace.proyecto.model.service.IAdministradorService;
import com.marketplace.proyecto.model.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Proveedor")
public class ProveedorController {


    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/listar")
    public List<Proveedor> listarAdmi() {
        return proveedorService.findByAll();
    }

    // Buscar Por Id
    @GetMapping("/ver/{id}")
    public Proveedor finByIdAdmi(
            @PathVariable Long id) throws MasterResourceNotFoundException {
        return proveedorService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear")
    public Proveedor crear(@RequestBody Proveedor proveedor) throws Exception {
        return proveedorService.create(proveedor);
    }

    // Editar Administrador
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/editar/{id}")
    public Proveedor editar(@PathVariable Long id, @RequestBody Proveedor proveedor) throws Exception {
        return proveedorService.edit(id, proveedor);
    }

    // Eliminar Admi
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable Long id) throws MasterResourceDeletedException {
        proveedorService.delete(id);
    }
}

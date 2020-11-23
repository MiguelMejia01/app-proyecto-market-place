package com.marketplace.proyecto.model.controller;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Tienda;
import com.marketplace.proyecto.model.repository.ITiendaDao;
import com.marketplace.proyecto.model.service.ITiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tiendas")
public class TiendaController {


    @Autowired
    private ITiendaService tiendaService;

    @GetMapping("/listar")
    public List<Tienda> listarTiendas() { return tiendaService.findByAll();}


    // Buscar Por Id
    @GetMapping("/ver/{id}")
    public Tienda finByIdTienda (
            @PathVariable Long id) throws MasterResourceNotFoundException {
        return tiendaService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear")
    public Tienda crear(@RequestBody Tienda tienda) throws Exception {
        return tiendaService.create(tienda);
    }

    // Editar Tienda
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/editar/{id}")
    public Tienda editar(@PathVariable Long id, @RequestBody Tienda tienda) throws Exception {
        return tiendaService.edit(id, tienda);
    }

    // Eliminar Tienda
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable Long id) throws MasterResourceDeletedException {
        tiendaService.delete(id);
    }

}

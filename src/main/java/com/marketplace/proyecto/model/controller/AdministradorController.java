package com.marketplace.proyecto.model.controller;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Administrador;
import com.marketplace.proyecto.model.entity.Tienda;
import com.marketplace.proyecto.model.repository.IAdministradorDao;
import com.marketplace.proyecto.model.repository.ITiendaDao;
import com.marketplace.proyecto.model.service.IAdministradorService;
import com.marketplace.proyecto.model.service.ITiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Administrador")
public class AdministradorController {


        @Autowired
        private IAdministradorDao administradorDao;

        @Autowired
        private IAdministradorService administradorService;

        @GetMapping("/listar")
        public List<Administrador> listarAdmi() {
            return administradorService.findByAll();
        }

        // Buscar Por Id
        @GetMapping("/ver/{id}")
        public Administrador finByIdAdmi(
                @PathVariable Long id) throws MasterResourceNotFoundException {
            return administradorService.findById(id);
        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/crear")
        public Administrador crear(@RequestBody Administrador administrador) throws Exception {
            return administradorService.create(administrador);
        }

        // Editar Administrador
        @ResponseStatus(HttpStatus.CREATED)
        @PutMapping("/editar/{id}")
        public Administrador editar(@PathVariable Long id, @RequestBody Administrador administrador) throws Exception {
            return administradorService.edit(id, administrador);
        }

        // Eliminar Admi
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/delete/{id}")
        public void delete(
                @PathVariable Long id) throws MasterResourceDeletedException {
            administradorService.delete(id);
        }
    }


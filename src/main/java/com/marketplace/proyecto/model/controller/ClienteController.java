package com.marketplace.proyecto.model.controller;

import com.marketplace.proyecto.exception.exceptions.MasterResourceDeletedException;
import com.marketplace.proyecto.exception.exceptions.MasterResourceNotFoundException;
import com.marketplace.proyecto.model.entity.Cliente;
import com.marketplace.proyecto.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Cliente")
public class ClienteController {


        @Autowired
        private IClienteService clienteService;

        @GetMapping("/listar")
        public List<Cliente> listarTiendas() {
            return clienteService.findByAll();
        }

        // Buscar Por Id
        @GetMapping("/ver/{id}")
        public Cliente finByIdTienda(
                @PathVariable Long id) throws MasterResourceNotFoundException {
            return clienteService.findById(id);
        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/crear")
        public Cliente crear(@RequestBody Cliente cliente) throws Exception {
            return clienteService.create(cliente);
        }

        // Editar Cliente
        @ResponseStatus(HttpStatus.CREATED)
        @PutMapping("/editar/{id}")
        public Cliente editar(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {
            return clienteService.edit(id, cliente);
        }

        // Eliminar Cliente
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/delete/{id}")
        public void delete(
                @PathVariable Long id) throws MasterResourceDeletedException {
            clienteService.delete(id);
        }
}


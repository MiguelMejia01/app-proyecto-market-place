package com.marketplace.proyecto.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String email;

    @Size(max = 15, message = "solo se permiten 15 caracteres")
    String contraseña;

    @Column(unique = true)
    @Size(max = 10, message = "solo se permiten 10 digitos")
    Integer telefono;

    @Size(max = 30, message = "solo se permiten 30 digitos")
    String tarjeta;

    @Size(max = 10, message = "solo se permiten 10 caracteres")
    Integer clave;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "proveedor"})
    private List<Factura> facturas;

}

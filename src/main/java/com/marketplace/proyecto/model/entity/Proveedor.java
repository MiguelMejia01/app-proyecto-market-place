package com.marketplace.proyecto.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;

    @Column(name = "nombre_tienda", unique = true)
    String nombretienda;

    String productos;

    @Size(max = 10, message = "solo se permiten 10 digitos")
    Integer contacto;





}

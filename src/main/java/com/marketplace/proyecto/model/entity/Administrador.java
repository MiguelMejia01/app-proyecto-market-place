package com.marketplace.proyecto.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "administradores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {


    @Id
    @Column(name = "id_administrador", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idadministrador;

    String nombre;

    @Column(unique = true)
    Integer codigo;

}

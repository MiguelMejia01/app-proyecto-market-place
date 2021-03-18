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

    //tercera prueba del slack 
    // ya funciona la herramiente slack y el despliegue continuo con git hub 
    // conecte git hub con la cuenta de heroku y escogi el repositorio cual desplegar 
    // tambien escogi que no desplegara hasta que ejecutara el CI que tenia en mi repositorio 
    String nombre;

    @Column(unique = true)
    Integer codigo;

}

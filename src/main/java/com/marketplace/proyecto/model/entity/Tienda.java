package com.marketplace.proyecto.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tiendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String direccion;

    private String redes;

    private Integer telefono;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "categoria", nullable = false)
    private Categoria categoria;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tienda"})
    private List<Producto> productos;


}

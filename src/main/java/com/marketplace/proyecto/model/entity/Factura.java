package com.marketplace.proyecto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "numero_factura", unique = true)
    @Size(max = 20, message = "solo se permiten 20 digitos")
    Integer numerofactura;

    @Column(name = "fecha_compra")
    LocalDateTime fechacompra;

}

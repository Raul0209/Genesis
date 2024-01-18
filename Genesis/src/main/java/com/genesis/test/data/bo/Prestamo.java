package com.genesis.test.data.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "codigo_de_prestamo")
    private String codigoDePrestamo;
    @Column(name = "codigo_de_cliente")
    private String codigoDeCliente;
    private double monto;
    @Column(name = "cantidad_de_cuotas")
    private Integer cantidadDeCuotas;
    @Column(name = "fecha_de_registro")
    private LocalDate fechaDeRegistro;


}

package com.genesis.test.data.bo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String dpi;
    private String nombreCompleto;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "fecha_de_registro")
    private Date fechaRegistro;
    private Boolean estado;
}

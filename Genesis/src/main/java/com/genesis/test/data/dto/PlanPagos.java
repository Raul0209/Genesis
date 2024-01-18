package com.genesis.test.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PlanPagos {
    private double cuota;
    private LocalDate fechaPago;
    private Integer numeroCuota;
}

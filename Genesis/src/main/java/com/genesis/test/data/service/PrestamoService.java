package com.genesis.test.data.service;

import com.genesis.test.data.bo.Prestamo;
import com.genesis.test.data.dto.PlanPagos;

import java.math.BigInteger;
import java.util.List;

public interface PrestamoService {
    List<Prestamo> findAllPrestamos();

    Prestamo findById(BigInteger id);

    Prestamo save(Prestamo prestamo);

    List<PlanPagos> generarPlanPagos(BigInteger idPrestamo);


}

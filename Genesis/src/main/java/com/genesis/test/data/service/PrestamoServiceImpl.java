package com.genesis.test.data.service;

import com.genesis.test.data.bo.Prestamo;
import com.genesis.test.data.dto.PlanPagos;
import com.genesis.test.data.repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> findAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo findById(BigInteger id) {
        return prestamoRepository.findById(id).get();
    }

    @Override
    public Prestamo save(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public List<PlanPagos> generarPlanPagos(BigInteger idPrestamo) {

        List<PlanPagos> planPagosList = new ArrayList<>();

        Prestamo prestamo = prestamoRepository.findById(idPrestamo).get();

        for (Integer x = 1; x <= prestamo.getCantidadDeCuotas(); x++) {
            PlanPagos planPagos = new PlanPagos();
            Double interes = (prestamo.getMonto() / prestamo.getCantidadDeCuotas()) * 1.03;
            planPagos.setNumeroCuota(x);
            planPagos.setFechaPago(prestamo.getFechaDeRegistro().plusMonths(x.longValue()));
            planPagos.setCuota(interes);
            planPagosList.add(planPagos);
        }

        return planPagosList;
    }
}

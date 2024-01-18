package com.genesis.test.data.web.controller;


import com.genesis.test.data.bo.Cliente;
import com.genesis.test.data.bo.Prestamo;
import com.genesis.test.data.dto.PlanPagos;
import com.genesis.test.data.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/service/v1/prestamo")
@CrossOrigin(origins = "*")
public class PrestamoController {

    private final PrestamoService prestamoService;

    @GetMapping("/all")
    ResponseEntity<List<Prestamo>> findAllPrestamos() {
        return new ResponseEntity<>(prestamoService.findAllPrestamos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Prestamo> findById(@PathVariable BigInteger id) {
        return new ResponseEntity<>(prestamoService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Prestamo> save(@RequestBody Prestamo prestamo) {
        return new ResponseEntity<>(prestamoService.save(prestamo), HttpStatus.OK);
    }

    @GetMapping("/generar-plan-pago/{idPrestamo}")
    ResponseEntity<List<PlanPagos>> generarPlanPago(@PathVariable BigInteger idPrestamo) {
        return new ResponseEntity<>(prestamoService.generarPlanPagos(idPrestamo), HttpStatus.OK);
    }

}

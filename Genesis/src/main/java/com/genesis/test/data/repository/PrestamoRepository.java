package com.genesis.test.data.repository;

import com.genesis.test.data.bo.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PrestamoRepository extends JpaRepository<Prestamo, BigInteger> {
}

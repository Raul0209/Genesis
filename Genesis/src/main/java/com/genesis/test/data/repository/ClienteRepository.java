package com.genesis.test.data.repository;

import com.genesis.test.data.bo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, BigInteger> {
    void deleteById(BigInteger id);

//    List<Cliente> find
}

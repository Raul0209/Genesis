package com.genesis.test.data.service;

import com.genesis.test.data.bo.Cliente;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAllClients();

    Optional<Cliente> findById(BigInteger id);

    Cliente save(Cliente cliente);

    Cliente changeClientStatus(BigInteger id, Boolean status);

    Cliente delete(BigInteger id);
}

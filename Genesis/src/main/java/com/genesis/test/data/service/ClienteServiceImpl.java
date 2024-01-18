package com.genesis.test.data.service;


import com.genesis.test.data.bo.Cliente;
import com.genesis.test.data.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAllClients() {
        System.out.println(new Date());

        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(BigInteger id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente changeClientStatus(BigInteger id, Boolean estado) {
        Cliente clienteToChangeStatus = clienteRepository.findById(id).get();
        clienteToChangeStatus.setEstado(estado);

        return clienteRepository.save(clienteToChangeStatus);
    }

    @Override
    public Cliente delete(BigInteger id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        clienteRepository.delete(cliente.get());
        return cliente.get();
    }
}

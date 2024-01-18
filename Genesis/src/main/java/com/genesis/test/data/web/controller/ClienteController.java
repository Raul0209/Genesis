package com.genesis.test.data.web.controller;

import com.genesis.test.data.bo.Cliente;
import com.genesis.test.data.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController()
@RequestMapping("/service/v1/cliente")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteController {
    private final ClienteService clienteService;


    @GetMapping("/all")
    ResponseEntity<List<Cliente>> findAllClients() {
        return new ResponseEntity<>(clienteService.findAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Cliente> findById(@PathVariable BigInteger id) {
        return new ResponseEntity<>(clienteService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
    }

    @PutMapping("/{id}/{estado}")
    ResponseEntity<Cliente> changeStatus(@PathVariable BigInteger id, @PathVariable Boolean estado) {
        return new ResponseEntity<>(clienteService.changeClientStatus(id, estado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable BigInteger id) {
        return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
    }

}

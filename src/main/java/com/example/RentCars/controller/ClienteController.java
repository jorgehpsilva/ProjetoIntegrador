package com.example.RentCars.controller;

import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping("/salvar")
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(clienteService.create(clienteDTO));
        } catch (Exception e) {
            throw new ProcessErrorException("Um cliente foi adicionado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(clienteService.getById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado" + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(clienteService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Clientes não encontrados");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(clienteService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado " + id);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO) throws ProcessErrorException {
        try {
            return ResponseEntity.ok(clienteService.update(clienteDTO));
        } catch (Exception e){
            throw new ProcessErrorException("Cliente não atualizado");
        }
    }

    @GetMapping("/getByNome")
    public ResponseEntity<ClienteDTO> getByNome(@RequestParam(value = "nome") String nome) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(clienteService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
    }
}

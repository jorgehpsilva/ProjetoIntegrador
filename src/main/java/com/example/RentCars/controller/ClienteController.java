package com.example.RentCars.controller;

import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.service.impl.ClienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) throws Exception {
        ClienteDTO cliente = clienteService.create(clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() throws Exception {
        List<ClienteDTO> clientes = clienteService.getAll();
        List<ClienteDTO> clientesResponseDTO = clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(clientesResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable int id) throws Exception {
        ClienteDTO clienteDTO = clienteService.getById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> update(@PathVariable int id, @RequestBody ClienteDTO clienteDTO) throws Exception {
        ClienteDTO updatedCliente = clienteService.updateById(id, clienteDTO);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.deleteById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado " + id);
        }
    }

    @GetMapping("/nome")
    public ResponseEntity<ClienteDTO> getByNome(@RequestParam String nome) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
    }
}

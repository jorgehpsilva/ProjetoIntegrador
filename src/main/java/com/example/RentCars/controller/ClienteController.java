package com.example.RentCars.controller;

import com.example.RentCars.exceptions.ProcessErrorException;
import com.example.RentCars.exceptions.ResourceNotFoundException;
import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.service.impl.ClienteServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO) throws Exception {
        ClienteDTO cliente = clienteService.create(clienteDTO);
        ClienteDTO clienteDTOMapped = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(clienteDTOMapped);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable int id) throws Exception {
        ClienteDTO clienteDTO = clienteService.getById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() throws Exception {
        try {
            return ResponseEntity.ok(clienteService.getAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Clientes não encontrados");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.delete(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado " + id);
        }
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.update(clienteDTO));
        } catch (Exception e){
            throw new ProcessErrorException("Cliente não atualizado");
        }
    }

    @GetMapping
    public ResponseEntity<ClienteDTO> getByNome(@RequestParam(value = "nome") String nome) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.getByNome(nome));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
    }
}

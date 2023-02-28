package com.example.RentCars.service.impl;

import com.example.RentCars.model.Categoria;
import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.CategoriasDTO;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.repository.IClienteRepository;
import com.example.RentCars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClienteServiceImpl implements IService<ClienteDTO> {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        CategoriasDTO categoriasDTO;
        int idCategorias = cliente.getCategorias().getId();
        if (categoriaService.ifCategoriasExists(idCategorias)) {
            categoriasDTO = categoriaService.getById(idCategorias);
            Categoria categoria = new Categoria(categoriasDTO);
            cliente.setCategorias(categoria);
            cliente = clienteRepository.save(cliente);
        }
        clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }

    @Override
    public ClienteDTO getById(int id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    public boolean ifClienteExists(int id) {
        return clienteRepository.existsById(id);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        //cliente = clienteRepository.saveAllAndFlush(cliente);
        clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> getAll(){
        List<Cliente> clienteList = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOS = new ArrayList<>();

        for (Cliente cliente: clienteList) {
            ClienteDTO clienteDTO = new ClienteDTO(cliente);
            clienteDTOS.add(clienteDTO);
        }
        return clienteDTOS;
    }

    public ClienteDTO getByNome(String nome) {
        Cliente cliente = clienteRepository.findByNome(nome);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }
}

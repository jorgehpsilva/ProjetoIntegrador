package com.example.RentCars.service.impl;

import com.example.RentCars.model.Cliente;
import com.example.RentCars.model.dto.ClienteDTO;
import com.example.RentCars.repository.IClienteRepository;
import com.example.RentCars.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements IService<ClienteDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente clienteMapped = modelMapper.map(clienteDTO, Cliente.class);
        Cliente cliente = clienteRepository.save(clienteMapped);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOS = new ArrayList<>();

        for (Cliente cliente : clienteList) {
            ClienteDTO clienteDTO = new ClienteDTO(cliente);
            clienteDTOS.add(clienteDTO);
        }
        return clienteDTOS;
    }

    @Override
    public ClienteDTO getById(int id) throws Exception {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (!clienteOptional.isPresent()) {
            throw new Exception("Cliente não encontrado!");
        }
        return modelMapper.map(clienteOptional.get(), ClienteDTO.class);
    }

    @Override
    public ClienteDTO updateById(int id, ClienteDTO clienteDTO) throws Exception {
        ClienteDTO categoriaFound = getById(id);
        Cliente categoria = clienteRepository.saveAndFlush(modelMapper.map(categoriaFound, Cliente.class));
        return modelMapper.map(categoria, ClienteDTO.class);
    }

    @Override
    public String deleteById(int id) {
        clienteRepository.deleteById(id);
        return "Cliente  deletado" + id;
    }

    public boolean ifClienteExists(int id) {
        return clienteRepository.existsById(id);
    }

    public ClienteDTO getByNome(String nome) {
        Cliente cliente = clienteRepository.findByNome(nome);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }
}

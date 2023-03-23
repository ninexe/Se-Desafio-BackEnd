package com.se.calc.services;

import com.se.calc.models.Cliente;
import com.se.calc.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    @Transactional
    public List<Cliente> salvarClientes(List<Cliente> clientes) {

        return clienteRepository.saveAll(clientes);
    }
}

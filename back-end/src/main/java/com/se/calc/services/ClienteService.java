package com.se.calc.services;

import com.se.calc.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> salvarClientes(List<Cliente> clientes);
}

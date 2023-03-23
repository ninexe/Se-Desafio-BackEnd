package com.se.calc.repositorys;

import com.se.calc.models.Cliente;
import com.se.calc.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

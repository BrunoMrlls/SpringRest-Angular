package com.meireles.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meireles.vendas.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}

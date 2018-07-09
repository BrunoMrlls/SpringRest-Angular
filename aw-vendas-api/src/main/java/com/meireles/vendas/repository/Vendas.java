package com.meireles.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meireles.vendas.model.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {

}

package com.meireles.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meireles.vendas.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {

}

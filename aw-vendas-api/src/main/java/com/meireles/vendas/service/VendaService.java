package com.meireles.vendas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meireles.vendas.model.Venda;
import com.meireles.vendas.repository.Vendas;
import com.meireles.vendas.repository.Produtos;

@Service
public class VendaService {
	
	@Autowired
	private Vendas vendas;

	@Autowired
	private Produtos produtos;
	
	public Venda adicionar(Venda venda) {
		venda.setCadastro(LocalDateTime.now());
		venda.getItems().forEach(i -> { 
			i.setVenda(venda);
			i.setProduto(produtos.findById(i.getProduto().getId()).get());
		});
		
		BigDecimal totalItens = venda.getItems().stream() //lambda p/ somar total items
				.map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		venda.setTotal(totalItens.add(venda.getFrete()));
		
		return vendas.save(venda);
	}
}

package com.igti.produto.vo;

import lombok.Data;

/**
 * classe de manipulacao de dado, para navegar de uma estrutura para outra
 * 
 * @author Thais
 *
 */
@Data
public class ProdutoRequest {

	private String nome;
	private String descricao;
	private int quantidade;
	private double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;

	}
}

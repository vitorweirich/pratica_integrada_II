package edu.com.unoesc.restaurante.form;

import javax.validation.constraints.NotNull;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Produto;

public class ProdutoAdicionarForm {

	@NotNull
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private Double preco;
	@NotNull
	private Integer quantidade;
	@NotNull
	private String unidadeMedida;
	@NotNull
	private boolean cozido;
	@NotNull
	private Integer estabelecimento;
	@NotNull
	private Integer categoria;

	public ProdutoAdicionarForm() {
		this.id = -1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public boolean isCozido() {
		return cozido;
	}

	public void setCozido(boolean cozido) {
		this.cozido = cozido;
	}

	public Integer getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Integer estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Produto getProduto(CategoriaDAO categoriaDAO, EstabelecimentoDAO estabelecimentoDAO) {
		Categoria categoriaById = categoriaDAO.getCategoriaById(this.categoria);
		Estabelecimento estabelecimentoById = estabelecimentoDAO.getEstabelecimentoById(estabelecimento);
		return new Produto(id, nome, preco, quantidade, unidadeMedida, cozido, estabelecimentoById, categoriaById);
	}

}

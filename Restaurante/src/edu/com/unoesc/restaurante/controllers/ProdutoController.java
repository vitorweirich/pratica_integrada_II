package edu.com.unoesc.restaurante.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.models.Produto;

@ManagedBean(name = "produtoMB")
@RequestScoped
public class ProdutoController implements Serializable {

	private Produto produto = new Produto();
	private List<Produto> listProdutos = null;
	
	@ManagedProperty(value = "#{ProdutoDAO}")
	private ProdutoDAO produtoDAO;
	
	public void save() {

		if (this.produto.getId() == -1) {
			this.produtoDAO.insertProduto(produto);
		} else {
			this.produtoDAO.updateProduto(produto);
		}
		this.listProdutos = null;

		this.produto = new Produto();

	}

	public void load(int id) {
		produto = produtoDAO.getProdutoById(id);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListProdutos() {
		if (this.listProdutos == null)
			this.listProdutos = this.produtoDAO.getProdutos();

		return this.listProdutos;
	}

	public void setListProdutos(List<Produto> listProdutos) {
		this.listProdutos = listProdutos;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
}

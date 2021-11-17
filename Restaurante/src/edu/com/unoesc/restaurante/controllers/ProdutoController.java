package edu.com.unoesc.restaurante.controllers;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.FuncionarioDAO;
import edu.com.unoesc.restaurante.dao.PedidoDAO;
import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.dto.EstabelecimentoDTO;
import edu.com.unoesc.restaurante.dto.FuncionarioDTO;
import edu.com.unoesc.restaurante.form.ProdutoAdicionarForm;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Comanda;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Funcionario;
import edu.com.unoesc.restaurante.models.Pedido;
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

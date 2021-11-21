package edu.com.unoesc.restaurante.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.dao.PedidoDAO;
import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.models.Comanda;
import edu.com.unoesc.restaurante.models.Pedido;

@ManagedBean(name = "pedidoMB")
@RequestScoped
public class PedidoController implements Serializable {

	private Pedido pedido = new Pedido();
	private List<Pedido> listPedidos = null;

	@ManagedProperty(value = "#{PedidoDAO}")
	private PedidoDAO pedidoDAO;
	
	@ManagedProperty(value = "#{ComandaDAO}")
	private ComandaDAO comandaDAO;
	
	public ComandaDAO getComandaDAO() {
		return comandaDAO;
	}

	public void setComandaDAO(ComandaDAO comandaDAO) {
		this.comandaDAO = comandaDAO;
	}

	public void save() {
		System.out.println("a porro do id da comanda é   " + this.pedido.getComanda().getId() + "  seu MERDA");
		if (this.pedido.getId() == -1) {
			this.pedidoDAO.insertPedido(pedido);
		} else {
			this.pedidoDAO.updatePedido(pedido);
		}
		this.listPedidos = null;

		this.pedido = new Pedido();

	}

	public void load(int id) {
		pedido = pedidoDAO.getPedidoById(id);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido produto) {
		this.pedido = produto;
	}

	public List<Pedido> getListPedidos() {
		if (this.listPedidos == null)
			this.listPedidos = this.pedidoDAO.getPedidos();

		return this.listPedidos;
	}

	public void setListPedidos(List<Pedido> listProdutos) {
		this.listPedidos = listProdutos;
	}

	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

}

package edu.com.unoesc.restaurante.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.dao.PedidoDAO;
import edu.com.unoesc.restaurante.models.Pedido;

@ManagedBean(name = "pedidoMB")
@RequestScoped
public class PedidoController implements Serializable {

	private Pedido pedido = new Pedido();
	private List<Pedido> listPedidosCozinha = null;
	private List<Pedido> listPedidosGarcom = null;

	@ManagedProperty(value = "#{PedidoDAO}")
	private PedidoDAO pedidoDAO;
	
	@ManagedProperty(value = "#{ComandaDAO}")
	private ComandaDAO comandaDAO;
	
	@ManagedProperty(value = "#{comandaMB}")
	private ComandaController comandaMB;
	
	public ComandaDAO getComandaDAO() {
		return comandaDAO;
	}

	public void setComandaDAO(ComandaDAO comandaDAO) {
		this.comandaDAO = comandaDAO;
	}

	public ComandaController getComandaMB() {
		return comandaMB;
	}

	public void setComandaMB(ComandaController comandaMB) {
		this.comandaMB = comandaMB;
	}

	public void save() throws IOException {
		this.pedido.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		if (this.pedido.getId() == -1) {
			this.pedidoDAO.insertPedido(pedido);
		} else {
			this.pedidoDAO.updatePedido(pedido);
		}
		this.listPedidosCozinha = null;
		this.listPedidosGarcom = null;
		comandaMB.detalheStr(pedido.getComanda().getId());
		this.pedido = new Pedido();
	}
	
	public void load(int id) {
		pedido = pedidoDAO.getPedidoById(id);
	}
	
	public void finalizar(Pedido pedido) {
		pedido.setDataFinalizacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		this.pedidoDAO.updatePedido(pedido);
		this.listPedidosCozinha = null;
	}
	
	public void entregar(Pedido pedido) {
		pedido.setDataEntrega(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		this.pedidoDAO.updatePedido(pedido);
		this.listPedidosGarcom = null;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido produto) {
		this.pedido = produto;
	}

	public List<Pedido> getListPedidosCozinha() {
		if (this.listPedidosCozinha == null) {
			this.listPedidosCozinha = this.pedidoDAO.getPedidosCozinha();
		}
		
		return this.listPedidosCozinha;
	}
	
	public List<Pedido> getListPedidosGarcom() {
		if (this.listPedidosGarcom == null) {
			this.listPedidosGarcom = this.pedidoDAO.getPedidosGarcom();
		}
		
		return this.listPedidosGarcom;
	}

	public void setLististPedidosGarcom(List<Pedido> listProdutos) {
		this.listPedidosGarcom = listProdutos;
	}
	
	public void setListPedidosCozinha(List<Pedido> listProdutos) {
		this.listPedidosCozinha = listProdutos;
	}

	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

}

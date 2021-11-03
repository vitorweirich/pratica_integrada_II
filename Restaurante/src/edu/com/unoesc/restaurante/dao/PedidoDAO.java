package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Pedido;

public interface PedidoDAO {

	Pedido getPedidoById (Integer id);
	List<Pedido> getPedidos();
	boolean deletePedido(int id);
	boolean insertPedido(Pedido p);
	boolean updatePedido(Pedido p);
}

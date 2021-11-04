package edu.com.unoesc.restaurante.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.com.unoesc.restaurante.dao.PedidoDAO;
import edu.com.unoesc.restaurante.models.Pedido;

public class PedidoConverter implements Converter<Object, Pedido>{
	@Autowired
	PedidoDAO contaDAO;

	@Override
	public Pedido convert(Object source) {
		Integer id = Integer.parseInt((String)source);
		Pedido pessoa= contaDAO.getPedidoById(id);
		
		return pessoa;
	}
}
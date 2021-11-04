package edu.com.unoesc.restaurante.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.models.Produto;

public class ProdutoConverter implements Converter<Object, Produto>{
	@Autowired
	ProdutoDAO produtoDAO;

	@Override
	public Produto convert(Object source) {
		Integer id = Integer.parseInt((String)source);
		Produto pessoa= produtoDAO.getProdutoById(id);
		
		return pessoa;
	}
}
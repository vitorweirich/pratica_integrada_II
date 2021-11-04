package edu.com.unoesc.restaurante.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.models.Comanda;

public class ComandaConverter implements Converter<Object, Comanda>{
	@Autowired
	ComandaDAO comandaDAO;

	@Override
	public Comanda convert(Object source) {
		Integer id = Integer.parseInt((String)source);
		Comanda pessoa= comandaDAO.getComandaById(id);
		
		return pessoa;
	}
}
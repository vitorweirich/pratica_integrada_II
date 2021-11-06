package edu.com.unoesc.restaurante.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.models.Endereco;

public class EnderecoConverter implements Converter<Object, Endereco>{
	@Autowired
	EnderecoDAO enderecoDAO;

	@Override
	public Endereco convert(Object source) {
		Integer id = Integer.parseInt((String)source);
		Endereco endereco = enderecoDAO.getEnderecoById(id);
		
		return endereco;
	}
}
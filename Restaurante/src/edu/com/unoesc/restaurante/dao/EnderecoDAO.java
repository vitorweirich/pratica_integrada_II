package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Endereco;

public interface EnderecoDAO {

	Endereco getEnderecoById (Integer id);
	List<Endereco> getEnderecos();
	boolean deleteEndereco(int id);
	boolean insertEndereco(Endereco e);
	boolean updateEndereco(Endereco e);
}

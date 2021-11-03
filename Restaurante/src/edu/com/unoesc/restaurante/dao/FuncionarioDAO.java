package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Funcionario;

public interface FuncionarioDAO {

	Funcionario getFuncionarioById (Integer id);
	List<Funcionario> getFuncionarios();
	boolean deleteFuncionario(int id);
	boolean insertFuncionario(Funcionario f);
	boolean updateFuncionario(Funcionario f);
}

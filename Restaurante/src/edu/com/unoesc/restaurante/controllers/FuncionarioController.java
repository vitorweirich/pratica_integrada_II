package edu.com.unoesc.restaurante.controllers;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.FuncionarioDAO;
import edu.com.unoesc.restaurante.form.FuncionarioAdicionarForm;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "funcionarioMB")
@RequestScoped
public class FuncionarioController {

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> listFuncionarios = null;

	@ManagedProperty(value = "#{FuncionarioDAO}")
	private FuncionarioDAO funcionarioDAO;

	public void save() {

		if (this.funcionario.getId() == -1) {
			this.funcionarioDAO.insertFuncionario(funcionario);
		} else {
			this.funcionarioDAO.updateFuncionario(funcionario);
		}
		this.listFuncionarios = null;

		this.funcionario = new Funcionario();

	}
	
	public void load(int id) {
		funcionario = funcionarioDAO.getFuncionarioById(id);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getListFuncionarios() {
		if (this.listFuncionarios == null)
			this.listFuncionarios = this.funcionarioDAO.getFuncionarios();

		return this.listFuncionarios;
	}

	public void setListFuncionarios(List<Funcionario> listFuncionarios) {
		this.listFuncionarios = listFuncionarios;
	}

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}
	
	
	
}

package edu.com.unoesc.restaurante.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.models.Endereco;

@ManagedBean(name = "enderecoMB")
@RequestScoped
public class EnderecoController implements Serializable {

	private Endereco endereco = new Endereco();
	private List<Endereco> listEnderecos = null;
	
	@ManagedProperty(value = "#{EnderecoDAO}")
	private EnderecoDAO enderecoDAO;

	public void save() {

		if (this.endereco.getId() == -1) {
			this.enderecoDAO.insertEndereco(endereco);
		} else {
			this.enderecoDAO.updateEndereco(endereco);
		}
		this.listEnderecos = null;

		this.endereco = new Endereco();

	}

	public void load(int id) {
		endereco = enderecoDAO.getEnderecoById(id);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getListEnderecos() {
		if (this.listEnderecos == null)
			this.listEnderecos = this.enderecoDAO.getEnderecos();

		return this.listEnderecos;
	}

	public void setListEnderecos(List<Endereco> listEnderecos) {
		this.listEnderecos = listEnderecos;
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
	
	
	
}

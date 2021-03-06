package edu.com.unoesc.restaurante.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.models.Estabelecimento;


@ManagedBean(name = "estabelecimentoMB")
@RequestScoped
public class EstabelecimentoController implements Serializable {
	
	private Estabelecimento estabelecimento = new Estabelecimento();
	private List<Estabelecimento> listEstabelecimentos = null;
	
	@ManagedProperty(value = "#{EstabelecimentoDAO}")
	private EstabelecimentoDAO estabelecimentoDAO;
	
	public void save() {

		if (this.estabelecimento.getId() == -1) {
			this.estabelecimentoDAO.insertEstabelecimento(estabelecimento);
		} else {
			this.estabelecimentoDAO.updateEstabelecimento(estabelecimento);
		}
		this.listEstabelecimentos = null;

		this.estabelecimento = new Estabelecimento();

	}

	public void load(int id) {
		estabelecimento = estabelecimentoDAO.getEstabelecimentoById(id);
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Estabelecimento> getListEstabelecimentos() {
		if (this.listEstabelecimentos == null)
			this.listEstabelecimentos = this.estabelecimentoDAO.getEstabelecimentos();

		return this.listEstabelecimentos;
	}

	public void setListEstabelecimentos(List<Estabelecimento> listEstabelecimentos) {
		this.listEstabelecimentos = listEstabelecimentos;
	}

	public EstabelecimentoDAO getEstabelecimentoDAO() {
		return estabelecimentoDAO;
	}

	public void setEstabelecimentoDAO(EstabelecimentoDAO estabelecimentoDAO) {
		this.estabelecimentoDAO = estabelecimentoDAO;
	}
	
	

}

package edu.com.unoesc.restaurante.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.models.Comanda;

@ManagedBean(name = "comandaMB")
@RequestScoped
public class ComandaController implements Serializable {

	private Comanda comanda = new Comanda();
	private List<Comanda> listComandas = null;

	private Double valor = null;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@ManagedProperty(value = "#{ComandaDAO}")
	private ComandaDAO comandaDAO;

	public void save() {

		if (this.comanda.getId() == -1) {
			this.comanda.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
			this.comandaDAO.insertComanda(comanda);
		} else {
			System.out.println(comanda);
			comanda.setDataCriacao(comandaDAO.getComandaById(comanda.getId()).getDataCriacao());
			this.comandaDAO.updateComanda(comanda);
		}
		this.listComandas = null;

		this.comanda = new Comanda();

	}

	public String detalheStr(int id) throws IOException {
		comanda = comandaDAO.getComandaById(id);
		return "comandaDetalhe.xhtml";
	}

	public void pagar() throws IOException {
		if (this.valor != null) {
			Comanda comandaById = comandaDAO.getComandaById(this.getComanda().getId());
			if (comandaById.getValorPago() == null) {
				comandaById.setValorPago(0d);
			}
			if (comandaById.getValorTotal() == null) {
				comandaById.setValorTotal(0d);
			}
			if ((this.valor + comandaById.getValorPago()) <= comandaById.getValorTotal()) {
				comandaById.setValorPago(comandaById.getValorPago() + valor);
				if (comandaById.getValorPago() >= comandaById.getValorTotal()) {
					comandaById.setDataFinalizacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
				}
				this.comandaDAO.updateComanda(comandaById);
				this.valor = null;
				this.detalheStr(comandaById.getId());
			} else {
				this.valor = comandaById.getValorTotal() - comandaById.getValorPago();
				System.out.println("Acontece alguma coisa " + valor);
				this.detalheStr(comandaById.getId());
			}
		} 
	}

	public void detalhe(int id) throws IOException {
		comanda = comandaDAO.getComandaById(id);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect("comandaDetalhe.xhtml");
	}

	public void load(int id) {
		comanda = comandaDAO.getComandaById(id);
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public List<Comanda> getListComandas() {
		if (this.listComandas == null)
			this.listComandas = this.comandaDAO.getComandas();

		return this.listComandas;
	}

	public void setListComandas(List<Comanda> listComandas) {
		this.listComandas = listComandas;
	}

	public ComandaDAO getComandaDAO() {
		return this.comandaDAO;
	}

	public void setComandaDAO(ComandaDAO comandaDAO) {
		this.comandaDAO = comandaDAO;
	}
}

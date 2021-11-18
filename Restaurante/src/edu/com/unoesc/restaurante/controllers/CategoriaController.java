package edu.com.unoesc.restaurante.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.models.Categoria;

@ManagedBean(name = "categoriaMB")
@RequestScoped
public class CategoriaController implements Serializable {

	private Categoria categoria = new Categoria();
	private List<Categoria> listCategorias = null;

	@ManagedProperty(value = "#{CategoriaDAO}")
	private CategoriaDAO categoriaDAO;

	public void save() {

		if (this.categoria.getId() == -1) {
			this.categoriaDAO.insertCategoria(categoria);
		} else {
			this.categoriaDAO.updateCategoria(categoria);
		}
		this.listCategorias = null;

		this.categoria = new Categoria();

	}

	public void load(int id) {
		categoria = categoriaDAO.getCategoriaById(id);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListCategorias() {
		if (this.listCategorias == null)
			this.listCategorias = this.categoriaDAO.getCategorias();

		return this.listCategorias;
	}

	public void setListCategorias(List<Categoria> listCategorias) {
		this.listCategorias = listCategorias;
	}

	public CategoriaDAO getCategoriaDAO() {
		return this.categoriaDAO;
	}

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
}

package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Categoria;

public interface CategoriaDAO {

	Categoria getCategoriaById (Integer id);
	List<Categoria> getCategorias();
	boolean deleteCategoria(int id);
	boolean insertCategoria(Categoria c);
	boolean updateCategoria(Categoria c);
}

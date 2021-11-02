package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Produto;

public interface ProdutoDAO {

	Produto getProdutoById (Integer id);
	List<Produto> getProdutos();
	boolean deleteProduto(int id);
	boolean insertProduto(Produto p);
	boolean updateProduto(Produto p);
}

package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Estabelecimento;

public interface EstabelecimentoDAO {

	Estabelecimento getEstabelecimentoById (Integer id);
	List<Estabelecimento> getEstabelecimentos();
	boolean deleteEstabelecimento(int id);
	boolean insertEstabelecimento(Estabelecimento e);
	boolean updateEstabelecimento(Estabelecimento e);
}

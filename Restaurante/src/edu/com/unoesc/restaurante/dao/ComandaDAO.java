package edu.com.unoesc.restaurante.dao;

import java.util.List;

import edu.com.unoesc.restaurante.models.Comanda;

public interface ComandaDAO {

	Comanda getComandaById (Integer id);
	List<Comanda> getComandas();
	boolean deleteComanda(int id);
	boolean insertComanda(Comanda c);
	boolean updateComanda(Comanda c);
}

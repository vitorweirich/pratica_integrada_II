package edu.com.unoesc.restaurante.controllers;

import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.models.Comanda;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "comandaMB")
@RequestScoped
public class ComandaController implements Serializable {

    private Comanda comanda = new Comanda();
    private List<Comanda> listComandas = null;

    @ManagedProperty(value = "#{ComandaDAO}")
    private ComandaDAO comandaDAO;

    @ManagedProperty(value = "#{EstabelecimentoDAO}")
    private EstabelecimentoDAO estabelecimentoDAO;

    public void save() {

        if (comanda.getId() == -1) {
            comandaDAO.insertComanda(comanda);
        } else {
            comandaDAO.updateComanda(comanda);
        }
        this.listComandas = null;

        this.comanda = new Comanda();

    }

    public void load(int id) {
        comanda = comandaDAO.getComandaById(id);
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setCategoria(Comanda comanda) {
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
        return comandaDAO;
    }

    public void setComandaDAO(ComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
    }
}

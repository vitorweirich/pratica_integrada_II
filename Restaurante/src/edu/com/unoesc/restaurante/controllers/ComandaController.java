package edu.com.unoesc.restaurante.controllers;

import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.models.Comanda;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ManagedBean(name = "comandaMB")
@RequestScoped
public class ComandaController implements Serializable {

    private Comanda comanda = new Comanda();
    private List<Comanda> listComandas = null;

    @ManagedProperty(value = "#{ComandaDAO}")
    private ComandaDAO comandaDAO;

    public void save() {

        if (this.comanda.getId() == -1) {
            this.comanda.setDataCriacao(LocalDateTime.now());
            this.comandaDAO.insertComanda(comanda);
        } else {
            System.out.println(comanda);
            this.comandaDAO.updateComanda(comanda);
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
        return this.comandaDAO;
    }

    public void setComandaDAO(ComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
    }
}

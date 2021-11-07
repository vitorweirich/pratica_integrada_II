package edu.com.unoesc.restaurante.form;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.models.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaAdicionarForm {
    @NotNull
    private Integer id;
    @NotBlank
    private String descricao;

    public CategoriaAdicionarForm() {
        this.id = -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
    	System.out.println("Set id " + id);
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria(CategoriaDAO categoriaDAO) {
        return new Categoria(id, descricao);
    }

}

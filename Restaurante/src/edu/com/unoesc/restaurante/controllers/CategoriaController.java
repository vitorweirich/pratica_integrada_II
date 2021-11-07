package edu.com.unoesc.restaurante.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.form.CategoriaAdicionarForm;
import edu.com.unoesc.restaurante.models.Categoria;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @GetMapping(value = "/categorias")
    public String categoriasList(Model m) {
        ArrayList<Categoria> categorias = new ArrayList<>(categoriaDAO.getCategorias());

        m.addAttribute("listCategorias", categorias);
        m.addAttribute("categoriaForm", new CategoriaAdicionarForm());

        return "categoria";
    }

    @PostMapping(value = "/categoriaSave")
    public String save(@Valid @ModelAttribute("categoriaForm") CategoriaAdicionarForm categoriaForm, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/categorias";
        }

        Categoria categoria = categoriaForm.getCategoria(categoriaDAO);
        if (categoria.getId() == -1) {
            categoriaDAO.insertCategoria(categoria);
        } else {
            categoriaDAO.updateCategoria(categoria);
        }

        return "redirect:/categorias";
    }

    @RequestMapping(value = "/categoria/{id}")
    public String produto(@PathVariable int id, Model model, HttpSession session) {

        model.addAttribute("listCategorias", new ArrayList<>(categoriaDAO.getCategorias()));
        model.addAttribute("categoria", categoriaDAO.getCategoriaById(id));

        return "categoria";
    }

    @GetMapping(value = "/categoria/{id}/deletar")
    public String deletar(@PathVariable int id, Model model, HttpSession session) {
        categoriaDAO.deleteCategoria(id);
        return "redirect:/categorias";
    }
}

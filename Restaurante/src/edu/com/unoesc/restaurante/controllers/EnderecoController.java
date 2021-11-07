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

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.form.EnderecoAdicionarForm;
import edu.com.unoesc.restaurante.models.Endereco;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoDAO enderecoDAO;

    @GetMapping(value = "/enderecos")
    public String categoriasList(Model m) {
        ArrayList<Endereco> categorias = new ArrayList<>(enderecoDAO.getEnderecos());

        m.addAttribute("listEnderecos", categorias);
        m.addAttribute("enderecoForm", new EnderecoAdicionarForm());

        return "endereco";
    }

    @PostMapping(value = "/enderecoSave")
    public String save(@Valid @ModelAttribute("enderecoForm") EnderecoAdicionarForm enderecoForm, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/enderecos";
        }

        Endereco endereco = enderecoForm.getEndereco();
        if (endereco.getId() == -1) {
        	enderecoDAO.insertEndereco(endereco);
        } else {
        	enderecoDAO.updateEndereco(endereco);
        }

        return "redirect:/enderecos";
    }

    @RequestMapping(value = "/endereco/{id}")
    public String produto(@PathVariable int id, Model model, HttpSession session) {

        model.addAttribute("listEnderecos", new ArrayList<>(enderecoDAO.getEnderecos()));
        model.addAttribute("endereco", enderecoDAO.getEnderecoById(id));

        return "endereco";
    }

    @GetMapping(value = "/enderecos/{id}/deletar")
    public String deletar(@PathVariable int id, Model model, HttpSession session) {
    	enderecoDAO.deleteEndereco(id);
        return "redirect:/enderecos";
    }
}

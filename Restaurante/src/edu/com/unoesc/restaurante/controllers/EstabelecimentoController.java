package edu.com.unoesc.restaurante.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.form.EstabelecimentoAdicionarForm;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;


@Controller
public class EstabelecimentoController {
	
	@Autowired
	EstabelecimentoDAO estabelecimentoDAO;
	
	@Autowired
	EnderecoDAO enderecoDAO;
	
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.GET)
	public String estabelecimentosList(Model m) {

		ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>(estabelecimentoDAO.getEstabelecimentos());
		
		ArrayList<Endereco> enderecos = new ArrayList<>(enderecoDAO.getEnderecos());

		m.addAttribute("listEnderecos", enderecos);
		m.addAttribute("listEstabelecimentos", estabelecimentos);
		m.addAttribute("estabelecimentoForm", new EstabelecimentoAdicionarForm());
		
		System.out.println(estabelecimentos.size());
		
		System.out.println(enderecos.size());

		return "estabelecimento";
	}
	
	@RequestMapping(value = "/estabelecimentoSave", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("estabelecimento") EstabelecimentoAdicionarForm estabelecimentoForm, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/estabelecimentos";
		}
		
		
		Estabelecimento estabelecimento = estabelecimentoForm.getEstabelecimento(enderecoDAO);
		if (estabelecimento.getId() == -1) {
			estabelecimentoDAO.insertEstabelecimento(estabelecimento);
		} else {
			estabelecimentoDAO.updateEstabelecimento(estabelecimento);
		}
		

		return "redirect:/estabelecimentos";
	}
	
	@RequestMapping(value = "/estabelecimento/{id}")
    public String produto(@PathVariable int id, Model model, HttpSession session) {

		ArrayList<Endereco> enderecos = new ArrayList<>(enderecoDAO.getEnderecos());

		model.addAttribute("listEnderecos", enderecos);
        model.addAttribute("listEstabelecimentos", estabelecimentoDAO.getEstabelecimentos());
        Estabelecimento estabelecimentoById = estabelecimentoDAO.getEstabelecimentoById(id);
        model.addAttribute("estabelecimento", new EstabelecimentoAdicionarForm(estabelecimentoById));

        return "estabelecimento";
    }

}

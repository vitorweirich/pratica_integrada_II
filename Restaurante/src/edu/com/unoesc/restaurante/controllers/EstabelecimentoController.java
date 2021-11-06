package edu.com.unoesc.restaurante.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.form.ProdutoAdicionarForm;
import edu.com.unoesc.restaurante.models.Comanda;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Produto;


@Controller
public class EstabelecimentoController {
	
	@Autowired
	EstabelecimentoDAO estabelecimentoDAO;
	
	@Autowired
	EnderecoDAO enderecoDAO;
	
	@RequestMapping(value = "/estabelecimentos", method = RequestMethod.GET)
	public String estabelecimentosList(Model m) {

		ArrayList<Estabelecimento> estabelecimentos = new ArrayList(estabelecimentoDAO.getEstabelecimentos());
		
		ArrayList<Endereco> enderecos = new ArrayList(enderecoDAO.getEnderecos());

		m.addAttribute("listEnderecos", enderecos);
		m.addAttribute("listEstabelecimentos", estabelecimentos);
		m.addAttribute("estabelecimento", new Estabelecimento());
		
		System.out.println(estabelecimentos.size());
		
		System.out.println(enderecos.size());

		return "estabelecimento";
	}
	
	@RequestMapping(value = "/estabelecimentoSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("estabelecimento") Estabelecimento estabelecimento, HttpSession session) {

		
		if (estabelecimento.getId() == 0) {
			estabelecimentoDAO.insertEstabelecimento(estabelecimento);
		} else {
			estabelecimentoDAO.updateEstabelecimento(estabelecimento);
		}
		

		return "redirect:/estabelecimentos";
	}

}

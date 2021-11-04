package edu.com.unoesc.restaurante.controllers;

import java.util.ArrayList;
import java.util.List;

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
import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.form.ProdutoAdicionarForm;
import edu.com.unoesc.restaurante.models.Comanda;
import edu.com.unoesc.restaurante.models.Produto;

@Controller
@RequestMapping("/")
public class ProdutoController {

	@Autowired
	ProdutoDAO produtoDAO;

	@Autowired
	private EstabelecimentoDAO estabelecimentoDAOImpl;
	
	@Autowired
	private ComandaDAO comandaDAOImpl;
	
	@Autowired
	private CategoriaDAO categoriaDAOImpl;

	@GetMapping(value = "/produtos")
	public String produtosList(Model m) {
		ArrayList<Produto> produtos = new ArrayList<Produto>(produtoDAO.getProdutos());

		m.addAttribute("listProdutos", produtos);
		m.addAttribute("produtoForm", new ProdutoAdicionarForm());

		m.addAttribute("estabelecimentos", estabelecimentoDAOImpl.getEstabelecimentos());
		List<Comanda> comandas = comandaDAOImpl.getComandas();
		comandas.forEach(c -> c.getProdutos().forEach(pe -> System.out.println(pe.getNome())));
		m.addAttribute("comandas", comandaDAOImpl.getComandas());
		return "produto";
	}

	@PostMapping(value = "/produtoSave")
	public String save(@Valid @ModelAttribute("produtoForm") ProdutoAdicionarForm produtoForm, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/produtos";
		}
		Produto produto = produtoForm.getProduto(categoriaDAOImpl, estabelecimentoDAOImpl);
		if (produto.getId() == -1) {
			produtoDAO.insertProduto(produto);
		} else {
			produtoDAO.updateProduto(produto);
		}

		return "redirect:/produtos";
	}

	@RequestMapping(value = "/produto/{id}")
	public String produto(@PathVariable int id, Model model, HttpSession session) {
		model.addAttribute("listProdutos", new ArrayList<Produto>(produtoDAO.getProdutos()));

		model.addAttribute("produto", produtoDAO.getProdutoById(id));

		return "produto";

	}

	@GetMapping(value = "/produto/{id}/deletar")
	public String deletar(@PathVariable int id, Model model, HttpSession session) {
		produtoDAO.deleteProduto(id);
		return "redirect:/produtos";
	}

}

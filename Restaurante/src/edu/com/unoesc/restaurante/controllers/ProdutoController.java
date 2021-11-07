package edu.com.unoesc.restaurante.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.FuncionarioDAO;
import edu.com.unoesc.restaurante.dao.PedidoDAO;
import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.dto.EstabelecimentoDTO;
import edu.com.unoesc.restaurante.dto.FuncionarioDTO;
import edu.com.unoesc.restaurante.form.ProdutoAdicionarForm;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Comanda;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Funcionario;
import edu.com.unoesc.restaurante.models.Pedido;
import edu.com.unoesc.restaurante.models.Produto;

@Controller
@RequestMapping("/")
public class ProdutoController {

	@Autowired
	private CategoriaDAO categoriaDAOImpl;

	@Autowired
	private ComandaDAO comandaDAOImpl;
	
	@Autowired
	private EnderecoDAO enderecoDAOImpl;

	@Autowired
	private EstabelecimentoDAO estabelecimentoDAOImpl;
	
	@Autowired
	private FuncionarioDAO funcionarioDAOImpl;
	
	@Autowired
	private PedidoDAO pedidoDAOImpl;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping("/comandas")
	public ResponseEntity<List<Comanda>> getComandas() {
		List<Comanda> comandas = comandaDAOImpl.getComandas();
		comandas.forEach(c -> c.getProdutos().forEach(p -> System.out.println(p.getNome())));
		return ResponseEntity.status(200).body(comandas);
	}
	
	@GetMapping("/estabelecimentosDTO")
	public ResponseEntity<List<EstabelecimentoDTO>> getEstabelecimentosDTO() {
		List<Estabelecimento> estabelecimentos = estabelecimentoDAOImpl.getEstabelecimentos();
		return ResponseEntity.status(200).body(EstabelecimentoDTO.converter(estabelecimentos));
	}
	@GetMapping("/estabelecimentosAPI")
	public ResponseEntity<List<Estabelecimento>> getEstabelecimentosAPI() {
		List<Estabelecimento> estabelecimentos = estabelecimentoDAOImpl.getEstabelecimentos();
		return ResponseEntity.status(200).body(estabelecimentos);
	}
	
	@GetMapping("/funcionario/{id}")
	public ResponseEntity<FuncionarioDTO> getFuncionario(@PathVariable("id") Integer id) {
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		FuncionarioDTO f = funcionarioDAOImpl.getFuncionarioWithEstabelecimentoById(id);
		return ResponseEntity.status(200).body(f);
	}
	
	@GetMapping("/funcionarios")
	public ResponseEntity<List<Funcionario>> getFuncionarios() {
		System.out.println("sasaa");
		System.out.println("sasaa");
		System.out.println("sasaa");
		System.out.println("sasaa");
		List<Funcionario> funcionarios = funcionarioDAOImpl.getFuncionarios();
		return ResponseEntity.status(200).body(funcionarios);
	}
	
	@GetMapping("/cadastrRowsTabelas")
	public String cadastraTeste() {
		Categoria c = new Categoria();
		c.setDescricao("Téste");
		categoriaDAOImpl.insertCategoria(c);
		
		// Insert Endereco 
		Endereco end = new Endereco();
		end.setBairro("Comércio");
		end.setCep("45330145");
		end.setCidade("Pachecó");
		end.setLogradouro("12, Avenida");
		enderecoDAOImpl.insertEndereco(end);
		
		// Insert Estabelecimento
		Estabelecimento est = new Estabelecimento();
		est.setCnpj("111111");
		est.setEndereco(end);
		est.setTelefone("89770000");
		est.setInscricaoEstadual("Naum sei");
		est.setNome("Frangaria");
		est.setRazaoSocial("também não sei");
		estabelecimentoDAOImpl.insertEstabelecimento(est);
		
		// Insert Funcionario
		Funcionario f = new Funcionario();
		f.setNome("Parry Horrer");
		f.setCpf("44112122");
		f.setEndereco(end);
		f.setFuncao("Migicionista");
		f.setNascimento(LocalDate.now());
		f.setEstabelecimento(est);
		funcionarioDAOImpl.insertFuncionario(f);
		
		// Insert Produto
		Produto produto = new Produto();
		produto.setCozido(false);
		produto.setNome("AA");
		produto.setPreco(15.5);
		produto.setQuantidade(23);
		produto.setUnidadeMedida("Grema");
		produto.setCategoria(c);
		produto.setEstabelecimento(est);
		produtoDAO.insertProduto(produto);
		Produto produtoById = produtoDAO.getProdutoById(produto.getId());
		System.out.println();
		System.out.println(produtoById.getNome());
		System.out.println(produtoById.getEstabelecimento().getNome());
		System.out.println(produtoById.getEstabelecimento().getEndereco().getCidade());
		System.out.println();
		
		// Insert Comanda
		Comanda co = new Comanda();
		co.setDataCriacao(LocalDateTime.now());
		co.setEstabelecimento(est);
		comandaDAOImpl.insertComanda(co);
		
		// Insert Pedido
		Pedido p = new Pedido();
		p.setComanda(co);
		p.setDataCriacao(LocalDateTime.now());
		p.setQuantidade(1);
		p.setProduto(produto);
		pedidoDAOImpl.insertPedido(p);
		return "redirect:/produtos";
	}

	@GetMapping(value = "/produtos")
	public String produtosList(Model m) {
		ArrayList<Produto> produtos = new ArrayList<>(produtoDAO.getProdutos());

		m.addAttribute("listProdutos", produtos);
		m.addAttribute("produtoForm", new ProdutoAdicionarForm());

		m.addAttribute("estabelecimentos", estabelecimentoDAOImpl.getEstabelecimentos());
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
		model.addAttribute("listProdutos", new ArrayList<>(produtoDAO.getProdutos()));

		model.addAttribute("produto", produtoDAO.getProdutoById(id));

		return "produto";

	}

	@GetMapping(value = "/produto/{id}/deletar")
	public String deletar(@PathVariable int id, Model model, HttpSession session) {
		produtoDAO.deleteProduto(id);
		return "redirect:/produtos";
	}

}

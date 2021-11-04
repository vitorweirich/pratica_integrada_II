package edu.com.unoesc.restaurante.test.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.dao.ComandaDAO;
import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.FuncionarioDAO;
import edu.com.unoesc.restaurante.dao.PedidoDAO;
import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Comanda;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Funcionario;
import edu.com.unoesc.restaurante.models.Pedido;
import edu.com.unoesc.restaurante.models.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath:test-spring-context.xml" }) 
@ContextConfiguration("test-spring-context.xml") 
public class ProdutoDaoTest {
	
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
	private ProdutoDAO produtoDAOImpl;
	
	@Test
	public void test(){
		// Insert Categoria
		Categoria c = new Categoria();
		c.setDescricao("BBBBBB");
		categoriaDAOImpl.insertCategoria(c);
		assertEquals(c.getId(), categoriaDAOImpl.getCategoriaById(c.getId()).getId());
		
		// Insert Endereco 
		Endereco end = new Endereco();
		end.setBairro("Comércio");
		end.setCep("45330145");
		end.setCidade("Pachecó");
		end.setLogradouro("12, Avenida");
		enderecoDAOImpl.insertEndereco(end);
		assertEquals(end.getId(), enderecoDAOImpl.getEnderecoById(end.getId()).getId());
		
		// Insert Estabelecimento
		Estabelecimento est = new Estabelecimento();
		est.setCnpj("111111");
		est.setEndereco(end);
		est.setTelefone("89770000");
		est.setInscricaoEstadual("Naum sei");
		est.setNome("Frangaria");
		est.setRezaoSocial("também não sei");
		estabelecimentoDAOImpl.insertEstabelecimento(est);
		assertEquals(est.getId(), estabelecimentoDAOImpl.getEstabelecimentoById(est.getId()).getId());
		
		// Insert Funcionario
		Funcionario f = new Funcionario();
		f.setNome("Parry Horrer");
		f.setCpf("44112122");
		f.setEndereco(end);
		f.setFuncao("Migicionista");
		f.setNascimento(LocalDate.now());
		f.setEstabelecimento(est);
		funcionarioDAOImpl.insertFuncionario(f);
		assertEquals(f.getId(), funcionarioDAOImpl.getFuncionarioById(f.getId()).getId());
		
		// Insert Produto
		Produto produto = new Produto();
		produto.setCozido(false);
		produto.setNome("AA");
		produto.setPreco(15.5);
		produto.setQuantidade(23);
		produto.setUnidadeMedida("Grema");
		produto.setCategoria(c);
		produto.setEstabelecimento(est);
		produtoDAOImpl.insertProduto(produto);
		Produto produtoById = produtoDAOImpl.getProdutoById(produto.getId());
		System.out.println();
		System.out.println(produtoById.getNome());
		System.out.println(produtoById.getEstabelecimento().getNome());
		System.out.println(produtoById.getEstabelecimento().getEndereco().getCidade());
		System.out.println();
		assertEquals(produto.getId(), produtoById.getId());
		
		// Insert Comanda
		Comanda co = new Comanda();
		co.setDataCriacao(LocalDateTime.now());
		co.setEstabelecimento(est);
		comandaDAOImpl.insertComanda(co);
		assertEquals(co.getId(), comandaDAOImpl.getComandaById(co.getId()).getId());
		
		// Insert Pedido
		Pedido p = new Pedido();
		p.setComanda(co);
		p.setDataCriacao(LocalDateTime.now());
		p.setQuantidade(1);
		p.setProduto(produto);
		pedidoDAOImpl.insertPedido(p);
		assertEquals(p.getId(), pedidoDAOImpl.getPedidoById(p.getId()).getId());
		
		
//		List<Pedido> pedidos = comandaDAOImpl.getComandaById(8).getPedidos();
//		System.out.println(pedidos);
		
//		Estabelecimento estabelecimentoById = estabelecimentoDAOImpl.getEstabelecimentoById(35);
//		estabelecimentoById.getFuncionarios().forEach(fun -> System.out.println(fun.getNome()));
	}
}

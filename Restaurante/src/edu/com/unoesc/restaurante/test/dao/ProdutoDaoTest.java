package edu.com.unoesc.restaurante.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.dao.ProdutoDAO;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath:test-spring-context.xml" }) 
@ContextConfiguration("test-spring-context.xml") 
public class ProdutoDaoTest {
	
	@Autowired
	private CategoriaDAO categoriaDAOImpl;
	
	@Autowired
	private ProdutoDAO produtoDAOImpl;
	
	@Autowired
	private EstabelecimentoDAO estabelecimentoDAOImpl;
	
	@Autowired
	private EnderecoDAO enderecoDAOImpl;
	
//	@Autowired
//    private ApplicationContext applicationContext;

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
		
		Produto produto = new Produto();
		produto.setCozido(false);
		produto.setNome("AA");
		produto.setPreco(15.5);
		produto.setQuantidade(23);
		produto.setUnidadeMedida("Grema");
		produto.setCategoria(c);
		produto.setEstabelecimento(estabelecimentoDAOImpl.getEstabelecimentoById(est.getId()));
		
		produtoDAOImpl.insertProduto(produto);
		Produto produtoById = produtoDAOImpl.getProdutoById(produto.getId());
		System.out.println();
		System.out.println(produtoById.getNome());
		System.out.println(produtoById.getEstabelecimento().getNome());
		System.out.println(produtoById.getEstabelecimento().getEndereco().getCidade());
		System.out.println();
		assertEquals(produto.getId(), produtoById.getId());
	}
}

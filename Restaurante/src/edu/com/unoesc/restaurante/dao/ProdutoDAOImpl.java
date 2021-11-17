package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.models.Produto;

@Service(value="ProdutoDAO")
public class ProdutoDAOImpl implements ProdutoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Produto getProdutoById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = (Produto) session.get(Produto.class, id);

		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Produto> getProdutos() {
		return (List<Produto>) this.sessionFactory.getCurrentSession().createQuery("from Produto").list();
	}

	@Override
	@Transactional
	public boolean deleteProduto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = (Produto) session.load(Produto.class, id);
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertProduto(Produto p) {
		this.sessionFactory.getCurrentSession().save(p);

		return false;
	}

	@Override
	@Transactional
	public boolean updateProduto(Produto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}

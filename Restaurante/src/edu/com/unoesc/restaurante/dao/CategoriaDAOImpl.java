package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.models.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Categoria getCategoriaById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria c = (Categoria) session.get(Categoria.class, id);

		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Categoria> getCategorias() {
		return (List<Categoria>) this.sessionFactory.getCurrentSession().createQuery("from Categoria").list();
	}

	@Override
	@Transactional
	public boolean deleteCategoria(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria c = (Categoria) session.load(Categoria.class, id);
		if (c!=null) {
			session.delete(c);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertCategoria(Categoria c) {
		this.sessionFactory.getCurrentSession().save(c);

		return false;
	}

	@Override
	@Transactional
	public boolean updateCategoria(Categoria c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		return true;
	}

}

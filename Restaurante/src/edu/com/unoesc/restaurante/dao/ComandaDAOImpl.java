package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.models.Comanda;

@Service(value="ComandaDAO")
public class ComandaDAOImpl implements ComandaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Comanda getComandaById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();

		return session.get(Comanda.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comanda> getComandas() {
		NativeQuery<Comanda> createNativeQuery = this.sessionFactory.getCurrentSession().createNativeQuery("select * from comandas c where c.data_hora_finalizacao is null", Comanda.class);
		return createNativeQuery.getResultList();
	}

	@Override
	@Transactional
	public boolean deleteComanda(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comanda c = session.load(Comanda.class, id);
		if (c!=null) {
			session.delete(c);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertComanda(Comanda c) {
		this.sessionFactory.getCurrentSession().save(c);

		return false;
	}

	@Override
	@Transactional
	public boolean updateComanda(Comanda c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		return true;
	}

}

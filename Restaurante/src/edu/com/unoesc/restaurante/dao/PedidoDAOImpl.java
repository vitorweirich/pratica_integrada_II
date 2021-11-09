package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.models.Pedido;

@Repository
public class PedidoDAOImpl implements PedidoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Pedido getPedidoById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pedido p = (Pedido) session.get(Pedido.class, id);

		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Pedido> getPedidos() {
		return (List<Pedido>) this.sessionFactory.getCurrentSession().createQuery("from Pedido").list();
	}

	@Override
	@Transactional
	public boolean deletePedido(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pedido p = (Pedido) session.load(Pedido.class, id);
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertPedido(Pedido p) {
		this.sessionFactory.getCurrentSession().save(p);

		return false;
	}

	@Override
	@Transactional
	public boolean updatePedido(Pedido p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		return true;
	}

}
package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.models.Endereco;

@Service(value="EnderecoDAO")
public class EnderecoDAOImpl implements EnderecoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Endereco getEnderecoById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Endereco e = (Endereco) session.get(Endereco.class, id);

		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Endereco> getEnderecos() {
		return (List<Endereco>) this.sessionFactory.getCurrentSession().createQuery("from Endereco").list();
	}

	@Override
	@Transactional
	public boolean deleteEndereco(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Endereco e = (Endereco) session.load(Endereco.class, id);
		if (e!=null) {
			session.delete(e);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertEndereco(Endereco e) {
		this.sessionFactory.getCurrentSession().save(e);

		return false;
	}

	@Override
	@Transactional
	public boolean updateEndereco(Endereco e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		return true;
	}

}

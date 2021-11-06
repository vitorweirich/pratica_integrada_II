package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Funcionario;

@Repository
public class EstabelecimentoDAOImpl implements EstabelecimentoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Estabelecimento getEstabelecimentoById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Estabelecimento e = (Estabelecimento) session.get(Estabelecimento.class, id);

		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Estabelecimento> getEstabelecimentos() {
		NativeQuery<Estabelecimento> createNativeQuery = this.sessionFactory.getCurrentSession()
				.createNativeQuery("select * from estabelecimento", Estabelecimento.class);
//		List<Estabelecimento> resultList = createNativeQuery.getResultList();
		List<Integer> ids = this.sessionFactory.getCurrentSession()
		.createNativeQuery("select estabelecimento.id from estabelecimento").getResultList();
		List<Estabelecimento> resultList = createNativeQuery.getResultList();
		int x = 0;
		for (Integer id: ids) {
			NativeQuery<Funcionario> query = this.sessionFactory.getCurrentSession()
					.createNativeQuery("select * from funcionarios where id_estabelecimento = " + id, Funcionario.class);
			List<Funcionario> list = query.getResultList();
			resultList.get(x).setFuncionarios(list);
			x++;
		}
//		return resultList;
		return (List<Estabelecimento>) this.sessionFactory.getCurrentSession().createQuery("from Estabelecimento").list();
	}

	@Override
	@Transactional
	public boolean deleteEstabelecimento(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Estabelecimento e = (Estabelecimento) session.load(Estabelecimento.class, id);
		if (e != null) {
			session.delete(e);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertEstabelecimento(Estabelecimento e) {
		this.sessionFactory.getCurrentSession().save(e);

		return false;
	}

	@Override
	@Transactional
	public boolean updateEstabelecimento(Estabelecimento e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		return true;
	}

}

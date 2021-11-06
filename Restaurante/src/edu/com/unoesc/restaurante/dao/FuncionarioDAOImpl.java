package edu.com.unoesc.restaurante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.com.unoesc.restaurante.dto.FuncionarioDTO;
import edu.com.unoesc.restaurante.models.Funcionario;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Funcionario getFuncionarioById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Funcionario f = (Funcionario) session.get(Funcionario.class, id);

		return f;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Funcionario> getFuncionarios() {
		return (List<Funcionario>) this.sessionFactory.getCurrentSession().createQuery("from Funcionario").list();
	}
	
	@Override
	@Transactional
	public FuncionarioDTO getFuncionarioWithEstabelecimentoById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Funcionario f = (Funcionario) session.get(Funcionario.class, id);
		System.out.println(f.getNome());
		System.out.println(f.getNome());
		System.out.println(f.getNome());
		System.out.println(f.getEstabelecimento().getCnpj());
		System.out.println(f.getNome());
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO(f);
		return funcionarioDTO;
	}

	@Override
	@Transactional
	public boolean deleteFuncionario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Funcionario f = (Funcionario) session.load(Funcionario.class, id);
		if (f!=null) {
			session.delete(f);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean insertFuncionario(Funcionario f) {
		this.sessionFactory.getCurrentSession().save(f);

		return false;
	}

	@Override
	@Transactional
	public boolean updateFuncionario(Funcionario f) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(f);
		return true;
	}

}

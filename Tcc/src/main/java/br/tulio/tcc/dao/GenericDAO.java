package br.tulio.tcc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.tulio.tcc.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	private Class classe;
	private Session sessao;
	private Transaction transacao;
	
	// Construtor para buscar o tipo de classe de Entidade
	@SuppressWarnings("unchecked")
	public GenericDAO() {
	this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			}
	
	
	public void salvar(Entidade entidade) { 
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		transacao = null;
		
		try {
			
		transacao = sessao.beginTransaction();
		sessao.save(entidade);
		transacao.commit();
			
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			
			throw erro;
			
		}finally {
			sessao.close();
		}
		
	}
	
	public void excluir(Entidade entidade) { 
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		transacao = null;
		
		try {
			
		transacao = sessao.beginTransaction();
		sessao.delete(entidade);
		transacao.commit();
			
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			
			throw erro;
			
		}finally {
			sessao.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){	
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		transacao = null;
		
		try {
			
			
		// Create CriteriaBuilder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			
			
			// Create CriteriaQuery
			CriteriaQuery<Entidade> consulta = builder.createQuery(classe);
			
			
			// Specify criteria root
			consulta.from(classe);
			
			// Execute query
			List<Entidade> resultado = sessao.createQuery(consulta).getResultList();

			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
			
		}finally {
			sessao.close();
		}
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(int codigo){	
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Entidade resultado = null;
		
		try {
			
			resultado = (Entidade) sessao.find(classe, codigo);
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
			
		}finally {
			sessao.close();
		}
		
		
	}

}

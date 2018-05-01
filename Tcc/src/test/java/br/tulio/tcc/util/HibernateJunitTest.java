package br.tulio.tcc.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateJunitTest {
	
	@Test
	public void conectar( ) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

}

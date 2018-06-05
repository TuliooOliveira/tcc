package br.tulio.tcc.util;

import org.junit.Test;

import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Estado;

public class TesteDAO {
	
	@Test
	public void salvar( ) {
		Estado estado = new Estado();
		estado.setNome("Pernambuco");
		estado.setSigla("PE");
		
		EstadoDAO estadoDao = new EstadoDAO();
		estadoDao.salvar(estado);
	}

}

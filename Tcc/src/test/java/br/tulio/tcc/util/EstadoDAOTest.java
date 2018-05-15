package br.tulio.tcc.util;

import org.junit.Test;

import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.modelo.Estado;

public class EstadoDAOTest {
	
	@Test
	public void salvar() {
		
		Estado estado = new Estado();
		estado.setNome("Pernambuco");
		estado.setSigla("PE");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		
	}

}

package br.tulio.tcc.util;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Estado;

public class EstadoDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		Estado estado = new Estado();
		estado.setNome("Pernambuco");
		estado.setSigla("PE");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		
	} 
	
	@Test
	public void listar() {
		EstadoDAO estadoDao = new EstadoDAO();
		List<Estado> resultado = estadoDao.listar();
		
		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + "-" + estado.getNome());
		}
			
		}
		
}

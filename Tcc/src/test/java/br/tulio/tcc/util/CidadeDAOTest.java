package br.tulio.tcc.util;

import org.junit.Test;

import br.tulio.tcc.dao.CidadeDAO;
import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Cidade;
import br.tulio.tcc.entidade.Estado;

public class CidadeDAOTest {
	
	@Test
	public void salvar() {

		EstadoDAO estadoDAO = new EstadoDAO();		
		
		Estado estado = estadoDAO.buscar(1);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Jaboatão dos Guararapes");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);

	}

}

package br.tulio.tcc.util;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.tulio.tcc.dao.CidadeDAO;
import br.tulio.tcc.dao.EstadoDAO;
import br.tulio.tcc.entidade.Cidade;
import br.tulio.tcc.entidade.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(3);

		Cidade cidade = new Cidade();
		cidade.setNome("Jaboatão dos Guararapes");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);

	}
	
	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for (Cidade cidade : resultado) {
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Nome da cidade: " + cidade.getNome());
			System.out.println("Código do estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
		}
	}

}

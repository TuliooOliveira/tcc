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
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);

	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDao = new EstadoDAO();
		List<Estado> resultado = estadoDao.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + "-" + estado.getNome());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		int codigo = 4;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigo);

		System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());

	}

	
	@Test
	@Ignore
	public void excluir() {
		int codigo = 5;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigo);

		estadoDao.excluir(estado);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			
			System.out.println("Registro removido!");
		System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		int codigo = 4;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigo);
		
		estado.setNome("Pernam");
		estado.setSigla("Pe");
		estadoDao.excluir(estado);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			
			System.out.println("Registro removido!");
		System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		
		}
	}

}

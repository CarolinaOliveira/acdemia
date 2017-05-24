package br.com.locadorachandon.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.locadorachandon.dao.AtendenteDAO;
import br.com.locadorachandon.domain.Atendente;

public class AtendenteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Atendente a = new Atendente();

		a.setCpfAt("09026443597");
		a.setNomeAt("Meyce");
		a.setSenha(12345678);

		AtendenteDAO dao = new AtendenteDAO();

		dao.salvar(a);

	}

	@Test
	public void listar() {
		AtendenteDAO dao = new AtendenteDAO();
		List<Atendente> atendentes = dao.listar();

		for (Atendente atendente : atendentes) {
			System.out.println(atendente);

		}

	}
	@Test
	@Ignore
	public void buscarPorId(){
		AtendenteDAO dao = new AtendenteDAO();
		
		Atendente a1 = dao.buscarPorId(2L);
		Atendente a2 = dao.buscarPorId(1L);
		
		System.out.println(a1);
		System.out.println(a2);
	}
}

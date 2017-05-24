package br.com.locadorachandon.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.locadorachandon.dao.MarcaDAO;
import br.com.locadorachandon.domain.Marca;

public class MarcaDAOTeste {
	@Test
	@Ignore
	public void salvar() {
		Marca m1 = new Marca();
		// m1.setNome("Honda");
		m1.setNome("Honda");
		m1.setTipo("esportivo");
		m1.setModelo("Civic");

		Marca m2 = new Marca();
		// m2.setNome("Toyota");
		m2.setNome("Toyota");
		m2.setTipo("esportivo");
		m2.setModelo("Corolla");

		Marca m3 = new Marca();
		m3.setNome("Fiat");
		m3.setTipo("passeio");
		m3.setModelo("UNO");

		MarcaDAO dao = new MarcaDAO();

		dao.salvar(m1);
		dao.salvar(m2);
		dao.salvar(m3);

	}

	@Test
	@Ignore
	public void listar() {
		MarcaDAO dao = new MarcaDAO();
		List<Marca> marcas = dao.listar();

		for (Marca marca : marcas) {
			System.out.println(marca);

		}
	}

	@Test
	@Ignore
	public void buscarPorId() {
		MarcaDAO dao = new MarcaDAO();

		Marca m1 = dao.buscarPorId(4L);
		Marca m2 = dao.buscarPorId(10L);

		System.out.println(m1);
		System.out.println(m2);

	}

	@Test
	@Ignore

	public void excluir() {
		MarcaDAO dao = new MarcaDAO();

		Marca marca = dao.buscarPorId(10L);
		dao.excluir(marca);

	}

	@Test

	public void editar() {
		MarcaDAO dao = new MarcaDAO();

		Marca marca = dao.buscarPorId(8L);
		marca.setNome("Honda");
		marca.setModelo("City");
		marca.setTipo("Sedan");

		dao.editar(marca);
	}
}

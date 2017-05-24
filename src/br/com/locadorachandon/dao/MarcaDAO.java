package br.com.locadorachandon.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.locadorachandon.domain.Marca;
import br.com.locadorachandon.util.HibernateUtil;

public class MarcaDAO {
	public void salvar(Marca marca) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(marca);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Marca> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Marca> marcas = null;

		try {
			Query consulta = sessao.getNamedQuery("Marca.listar");
			marcas = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return marcas;
	}

	public Marca buscarPorId(Long id) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Marca marca = null;

		try {
			Query consulta = sessao.getNamedQuery("Marca.buscarPorId");
			consulta.setLong("id", id);

			marca = (Marca) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return marca;
	}

	public void excluir(Marca marca) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(marca);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void editar(Marca marca) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			// Marca marcaEditar = buscarPorId(marca.getId());
			// marcaEditar.setNome(marca.getNome());
			// marcaEditar.setModelo(marca.getModelo());
			// marcaEditar.setTipo(marca.getTipo());
			// sessao.update(marcaEditar);

			sessao.update(marca);

			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}
}

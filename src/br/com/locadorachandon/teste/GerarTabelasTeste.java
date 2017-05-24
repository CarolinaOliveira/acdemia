package br.com.locadorachandon.teste;

import org.junit.Test;

import br.com.locadorachandon.util.HibernateUtil;

public class GerarTabelasTeste {
	@Test
	public void gerar(){
		HibernateUtil.getFabricaDeSessoes();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}

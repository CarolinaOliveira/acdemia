package br.com.locadorachandon.main;

import br.com.locadorachandon.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getFabricaDeSessoes();
		HibernateUtil.getFabricaDeSessoes().close();

	}

}

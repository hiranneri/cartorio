package vc.com.cartorios.util;

import javax.persistence.Persistence;

public class CriaTabela {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("desafiocartoriosPU");
		System.exit(0);
	}
	
}
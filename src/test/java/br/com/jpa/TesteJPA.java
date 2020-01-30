package br.com.jpa;

import javax.persistence.Persistence;

public class TesteJPA {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("jdev_jsf");
	}
}

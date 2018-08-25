package br.com.listaEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		Evento e = new Evento();
		e.setNome("Rafael Carvalho");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springUP");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

}

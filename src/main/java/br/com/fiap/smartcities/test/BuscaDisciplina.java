package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Disciplina;

public class BuscaDisciplina {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities-orm");
		EntityManager em = factory.createEntityManager();

		Disciplina disciplina = em.find(Disciplina.class, 1);

		System.out.println(disciplina.getId() + " " + disciplina.getNome() + " " + disciplina.getCargaHoraria());

		em.merge(disciplina);

		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		factory.close();

	}
}

package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Aluno;

public class BuscaAluno {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities-orm");
		EntityManager em = factory.createEntityManager();

		Aluno aluno = em.find(Aluno.class, 3);

		System.out.println(aluno.getId() + " " + aluno.getNome() + " " + aluno.getIdade());

		em.merge(aluno);

		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		factory.close();

	}

}

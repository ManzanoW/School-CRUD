package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Aluno;

public class CadastroAluno {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities-orm");
		EntityManager em = factory.createEntityManager();

		Aluno aluno = new Aluno();
		aluno.setNome("Samuel Rosa");
		aluno.setIdade(19);

		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		em.close();
		factory.close();
	}

}
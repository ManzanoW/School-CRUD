package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Disciplina;

public class CadastroDisciplina {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities-orm");
		EntityManager em = factory.createEntityManager();

		Disciplina disciplina = new Disciplina();
		disciplina.setNome("Matemagica");
		disciplina.setCargaHoraria(369);

		try {
			em.getTransaction().begin();
			em.persist(disciplina);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		em.close();
	}
}

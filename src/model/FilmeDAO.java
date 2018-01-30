package model;

import java.util.List;
import javax.persistence.EntityManager;

public class FilmeDAO {
	private static EntityManager em = ConnectionFactory.getEntityManager();
	
	public static void save(Filme filme) {
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
	}
	
	public static void update(Filme filme) {
		em.getTransaction().begin();
		em.merge(filme);
		em.getTransaction().commit();
	}
	
	public static void delete(Filme filme) {
		em.getTransaction().begin();
		em.remove(filme);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Filme> findAll() {
		//return em.createQuery("from "+Filme.class.getName()).getResultList();
		return em.createQuery("from Filme").getResultList();
	}
	
	public static Filme findById(Long id) {
		return em.find(Filme.class, id);
	}
	
	public static int findBetweenNota(float start, float end) {
		return em.createQuery("from Filme as f where f.nota between :start and :end ")
				.setParameter("start", start)
				.setParameter("end",  end)
				.getResultList().size();
	}
}

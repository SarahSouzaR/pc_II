package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Venda;

public class VendaJpaDAO {
	
	private static VendaJpaDAO instance;
	protected EntityManager entityManager;
	
	public static VendaJpaDAO getInstance() {
		if (instance == null) {
			instance = new VendaJpaDAO();			
		}
		
		return instance;
	}
	
	private VendaJpaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		
		return entityManager;
	}
	
	public Venda getById (final int id) {
		return entityManager.find(Venda.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> findAll() {
		return entityManager.createQuery("FROM" + Venda.class.getName()).getResultList();
	}
	
	public void persist(Venda venda) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(venda);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void merge (Venda venda) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(venda);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void remove (Venda venda) {
		try {
			entityManager.getTransaction().begin();
			venda = entityManager.find(Venda.class, venda.getId_venda());
			entityManager.remove(venda);
			entityManager.getTransaction().commit();
		} catch(Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void removeById (final int id) {
		try {
			Venda venda = getById(id);
			remove(venda);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}

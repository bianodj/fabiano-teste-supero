package br.com.supero.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.supero.model.entity.Task;

public class TaskRepository {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	
	public TaskRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(Task task) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(task);
		this.entityManager.getTransaction().commit();
	}
	
	public List<Task> TodasPessoas() {
		return this.entityManager.createNamedQuery("Task.findAll", Task.class).getResultList();
	}
	
	public Task GetTask(Integer id) {
		return this.entityManager.find(Task.class, id);
	}
	
	public void Excluir(Integer id) {
		Task task = this.GetTask(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(task);
		this.entityManager.getTransaction().commit();
	}
	
}

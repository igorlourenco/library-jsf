package br.unitins.topicos1.library.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.topicos1.library.model.Book;

public class BooksRepository {
	private EntityManager entityManager = null;

	private EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library");
			entityManager = emf.createEntityManager();
		}

		return entityManager;
	}

	public List<Book> getAll() {
		Query query = getEntityManager().createQuery("SELECT b FROM Book b");
		List<Book> books = query.getResultList();
		return books;
	}

	public void registerOrUpdate(Book book) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(book);
		getEntityManager().getTransaction().commit();
	}

	public void delete(int id) {
		Book book = getEntityManager().find(Book.class, id);
		if(book != null) {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(book);
			getEntityManager().getTransaction().commit();
		}
	}
}

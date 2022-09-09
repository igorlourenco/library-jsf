package br.unitins.topicos1.library.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos1.library.model.Book;
import br.unitins.topicos1.library.repository.BooksRepository;

@Named
@ViewScoped
public class BookController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7032784641902880464L;
	private Book book = null;
	private List<Book> books;
	
	public void registerOrUpdate() {
		BooksRepository repo = new BooksRepository();
		repo.registerOrUpdate(getBook());
		clear();
		books = null;
	}
	
	public void delete() {
		delete(getBook());
		clear();
	}
	
	public void delete(Book book) {
		BooksRepository repo = new BooksRepository();
		repo.delete(book.getId());
		books = null;
	}
	
	public void clear() {
		book = null;
	}
	
	public void edit(Book book) {
		setBook(book);
	}
	
	public List<Book> getBooks() {
		if (books == null) {
			BooksRepository repo = new BooksRepository();
			books = repo.getAll();
			if (books == null)
				books = new ArrayList<Book>();
		}
		return books;
	}

	public Book getBook() {
		if (book == null)
			book = new Book();
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

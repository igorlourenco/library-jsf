package br.unitins.topicos1.library;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BookController {

	private String title;
	private String author;
	private String genre;
	private String year;
	private String company;

	public BookController() {
	}

	public void saveBook() {
		System.out.println(title);
		System.out.println(author);
		System.out.println(genre);
		System.out.println(year);
		System.out.println(company);		
	}
	
	public void clearForm() {
		this.title = null;
		this.author = null;
		this.genre = null;
		this.year = null;
		this.company = null;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}

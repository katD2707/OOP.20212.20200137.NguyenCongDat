package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	private String content;
	
	public Book() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, float cost) {
		super(title, cost);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Book(String title, String category, float cost, String content) {
		super(title, category, cost);
		this.content = content;
	}
	
	public void addAuthor(String authorName) {
		for (String author: authors) {
			if (author.equals(authorName)) {
				System.out.println("Author is already added");
				return ;
			}
		}
		authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		for (String author: authors) {
			if (author.equals(authorName)) {
				System.out.println("Found author!");
				authors.remove(authorName);
				System.out.println("Remove author " + authorName);
				return ;
			}
		}
		System.out.println("Author is not in list of authors");
	}
	
	public String toString() {
		return "Book: " + this.getTitle() + " - " + 
				"Category: " + this.getCategory() + 
				"\n" + "Authors: " + "\n" + 
				((this.authors.size()==0) ? null : String.join("||", this.authors)) + "\n" +
				"Content length: " + ((this.content==null)?null:(this.content.trim().split("\\s+").length)); 
	}
	
}

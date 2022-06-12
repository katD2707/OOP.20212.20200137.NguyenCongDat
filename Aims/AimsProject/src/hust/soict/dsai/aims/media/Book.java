package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens;
	private Map<String, Integer> wordFrequency;
	
	
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
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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
				"Content length: " + ((this.getContent()==null)?null:(this.getContent().trim().split("\\s+").length)) + "\n" +
				"Token list: " + this.wordFrequency.keySet() + "\n" +
				"Word frequency: " + this.wordFrequency; 
	}
	
	public void processContent() {
		List<String> sorted = Arrays.asList(this.getContent().toLowerCase().split("\\s+"));
		java.util.Collections.sort(sorted);
		this.contentTokens = sorted;
		
		wordFrequency = new TreeMap<String, Integer>();
		for (String token:this.contentTokens) {
			if (wordFrequency.get(token)==null) {
				wordFrequency.put(token, 1);
			}
			else {
				wordFrequency.put(token, wordFrequency.get(token)+1);
			}
		}
		
	}
}

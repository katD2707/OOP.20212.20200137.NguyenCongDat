package hust.soict.dsai.test.map;

import hust.soict.dsai.aims.media.Book;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book("Jungle book");
		String content = "The Jungle Book is a 2016 American adventure drama film directed and produced by Jon Favreau, written by Justin Marks and produced by Walt Disney Pictures.";
		book.setContent(content);
		
		book.processContent();
		System.out.println(book.toString());
	}

}

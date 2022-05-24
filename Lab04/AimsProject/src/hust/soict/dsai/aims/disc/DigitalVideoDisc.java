package hust.soict.dsai.aims.disc;

import java.time.LocalDate;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private final LocalDate dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	private static int count = 0;
	private int id = 0;

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		DigitalVideoDisc.nbDigitalVideoDiscs += 1;
		DigitalVideoDisc.count += 1;
		this.id = DigitalVideoDisc.count;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title);
		this.category = category;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title, category, cost);
		this.director = director;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this(title, category, director, cost);
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}

	public static int getCount() {
		return count;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + 
				((this.getCategory()=="") ? null : this.getCategory()) + " - " + 
				((this.getDirector()=="") ? null : this.getDirector()) + " - " + 
				((this.getLength()==0) ? null : this.getLength()) + ": " + 
				((this.getCost()==0.) ? null : (this.getCost() + "$")); 
	}
	
	public boolean isMatch(String title) {
		String[] tokens = title.toLowerCase().trim().split("\\s+");
		String[] discTitle = this.getTitle().toLowerCase().trim().split("\\s+");
		
		for (int i=0; i<tokens.length; i++) {
			for (int j=0; j<discTitle.length; j++) {
				if (discTitle[j].equals(tokens[i])) {
					return true;
				}
			}
		}
		return false;
		
	}
}

package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private static int nbMedia = 0;
	private final LocalDate dateAddedMedia;
	private static int count = 0;

	
	public Media() {
		// TODO Auto-generated constructor stub
		this.dateAddedMedia = LocalDate.now();
		count ++;
		this.id = count;
		nbMedia ++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public static int getNbMedia() {
		return nbMedia;
	}

	public static void setNbMedia(int nbMedia) {
		Media.nbMedia = nbMedia;
	}

	public LocalDate getDateAddedMedia() {
		return dateAddedMedia;
	}
	
	
	
	

}

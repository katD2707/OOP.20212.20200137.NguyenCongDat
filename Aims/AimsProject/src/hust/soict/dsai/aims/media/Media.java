package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private static int nbMedia = 0;
	private final LocalDate dateAddedMedia;
	
	public Media() {
		// TODO Auto-generated constructor stub
		this.dateAddedMedia = LocalDate.now();
		nbMedia ++;
		this.id = nbMedia;
	}
	
	public Media(String title) {
		this();
		this.title = title;
	}
	
	public Media(String title, float cost) {
		this(title);
		this.cost = cost;
	}
	
	public Media(String title, String category, float cost) {
		this(title, cost);
		this.category = category;
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
	
	public String toString() {
		return "I'm just a media!";
	}
	
	@Override 
	public boolean equals(Object media) {
		if (this.getId()==((Media)media).getId()) {
			return true;
		}
		return false;
	}

}

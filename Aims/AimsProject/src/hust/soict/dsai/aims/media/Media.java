package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.dsai.aims.utils.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.utils.MediaComparatorByTitleCost;

public abstract class Media implements Comparable<Media> {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	private final LocalDate dateAddedMedia;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	
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
	
	public int compareTo(Media media) {
		if (media.getTitle()==null) {
			throw new NullPointerException("Media doesn't have a title. Please add a title!");
		}
		
		if (this.getTitle().compareToIgnoreCase(media.getTitle())==0) {
			return this.getCategory().compareToIgnoreCase(media.getCategory());
		}
		else {
			return this.getTitle().compareToIgnoreCase(media.getTitle());
		}
	}
	
	@Override 
	public boolean equals(Object media) {
		if  (!(media instanceof Media)) {
			throw new ClassCastException("Object must be a Media");
		}
		if (((Media)media).getTitle()==null) {
			throw new NullPointerException("Media doesn't have a title. Please add a title!");
		}
		if (this.getTitle().equals(((Media)media).getTitle()) && (this.getCost()==(((Media)media).getCost()))) {
			return true;
		}
		return false;
	}

}

package hust.soict.dsai.aims.media;

public class Disc extends Media{
	protected int length;
	protected String director;
	
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Disc(String title) {
	    super(title);
	}
	
	public Disc(String title, float cost) {
	    super(title, cost);
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String director, String category, int length, float cost) {
		this(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
}

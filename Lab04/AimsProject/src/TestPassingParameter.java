
public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void fineSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String title2 = dvd2.getTitle();
		dvd2.setTitle(dvd1.getTitle());
		dvd1.setTitle(title2);
		
		String category2 = dvd2.getCategory();
		dvd2.setCategory(dvd1.getCategory());
		dvd1.setCategory(category2);
		
		String director2 = dvd2.getDirector();
		dvd2.setDirector(dvd1.getDirector());
		dvd1.setDirector(director2);
		
		int length2 = dvd2.getLength();
		dvd2.setLength(dvd1.getLength());
		dvd1.setLength(length2);
		
		float cost2 = dvd2.getCost();
		dvd2.setCost(dvd1.getCost());
		dvd1.setCost(cost2);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	
}

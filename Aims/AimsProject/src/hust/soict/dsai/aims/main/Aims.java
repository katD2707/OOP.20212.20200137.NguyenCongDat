package hust.soict.dsai.aims.main;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.thread.MemoryDaemon;

public class Aims {
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
			
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add medias to store");
		System.out.println("2. Remove media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Place order");		
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Store store = new Store();
		Cart cart = new Cart();
//		MemoryDaemon memory = new MemoryDaemon();
//		memory.run();
		
		boolean stop0 = false;
		while (stop0 != true) {
			showMenu();
			int showOption = Integer.parseInt(input.nextLine());
			
			if (showOption==1) {
				store.displayStore();
				System.out.println("----------------------------------------------------------------");
	
				boolean stop1 = false;
				while (stop1 != true) {
					storeMenu();
					
					int storeOption = Integer.parseInt(input.nextLine());
					if (storeOption==1) {
						System.out.println("Enter title of the media you are looking for: ");
						String nameTitle = input.nextLine();
						System.out.println(store.searchByTitle(nameTitle));
					}
					else if (storeOption==2) {
						System.out.print("Enter title of the media you see on the screen: ");
						String dvdTitle = input.nextLine();
						cart.addMedia(store.getMedia(dvdTitle));
						System.out.print("Number of DVDs in the cart: ");
						System.out.println(cart.getNumOrdered());
					}
					else if (storeOption==3) {
						cart.display();
						boolean stop3 = false;
						while (stop3!=true) {
							cartMenu();
							
							int cartOption = Integer.parseInt(input.nextLine());
							if (cartOption==1) {
								
								System.out.println("Please choose filtering options: (1-ID/2-Title)");
								int filterOption = Integer.parseInt(input.nextLine());
								boolean stopFilter = false;
								
								while (stopFilter!=true) {
									if (filterOption==1) {
										System.out.println("Enter ID of media: ");
										int filterId = Integer.parseInt(input.nextLine());
										cart.searchById(filterId);
										stopFilter = true;
									}
									else if (filterOption==2) {
										System.out.println("Enter title of media: ");
										String filterTitle = input.nextLine();
										cart.searchByTitle(filterTitle);
										stopFilter = true;
									}
									else {
										System.out.println("Please choose only 1/2!");
									}
								}
							}
							
							else if (cartOption==2) {								
								System.out.println("Please choose sorting options: (1-Title/2-Cost)");
								int sortOption = Integer.parseInt(input.nextLine());
								
								boolean stopSort = false;
								while (stopSort!=true) {
									if (sortOption==1) {
										cart.titleSortDisplay();
										stopSort = true;
									}
									else if (sortOption==2) {
										System.out.println("Enter title of media: ");
										cart.costSortDisplay();
										stopSort = true;
									}
									else {
										System.out.println("Please choose only 1/2!");
									}
								}
							}
							else if (cartOption==3) {
								
								System.out.println("Enter title of media: ");
								String removeCart = input.nextLine();
								cart.removeMedia(store.getMedia(removeCart));
							}
							else if (cartOption==4) {
								//Place order
								System.out.println("An order is created");
								cart = new Cart();
								stop3 = true;
							}
							
							else if (cartOption==0) {
								stop3 = true;
							}
							else {
								System.out.println("Please choose only 0/1/2/3/4!");
							}
						}
					}
					else if (storeOption==0) {
						stop1 = true;
					}
					else {
						System.out.println("Please choose only 0/1/2/3!");
					}
				}
			}
			else if (showOption==2) {
				
				boolean stop2 = false;
				while (stop2 != true) {
					updateStore();
					
					int updateOption = Integer.parseInt(input.nextLine());
					if (updateOption==1) {
						System.out.println("Enter type of media: (cd/dvd/book)");
						String type = input.nextLine();
						
						///////////////////////
						System.out.println("Enter information for media: ");
						System.out.println("Title of media (compulsory): ");
						String addTitle = input.nextLine();
						
						boolean stopCategory = false;
						System.out.println("Do you want to enter category of this media? (1-Yes/0-No)");
								
						String addCategory = "";
						while (stopCategory!=true) {
							int addCate = Integer.parseInt(input.nextLine());
							if (addCate==1) {
								System.out.println("Enter category for this media: ");
								addCategory = input.nextLine();
								stopCategory = true;
							}
							else if (addCate==0) {
								stopCategory = true;
							}
							else {
								System.out.println("Please choose only 0/1");
							}
						}
						
						boolean stopDirector = false;
						String addDirector = "";
						System.out.println("Do you want to enter director of this media? (1-Yes/0-No)");
						while (stopDirector!=true) {
							int addDir = Integer.parseInt(input.nextLine());		
							if (addDir==1) {
								System.out.println("Enter director of this media: ");
								addDirector = input.nextLine();
								stopDirector = true;
							}
							else if (addDir==0) {
								stopDirector = true;
							}
							else {
								System.out.println("Please choose only 0/1");
							}
						}
						
						boolean stopLength = false;
						System.out.println("Do you want to enter length of this media? (1-Yes/0-No)");
						int addLength = 0;					
						while (stopLength!=true) {
							int addLe = Integer.parseInt(input.nextLine());	
							if (addLe==1) {
								System.out.println("Enter length of this media: ");
								addLength = Integer.parseInt(input.nextLine());
								stopLength = true;
							}
							else if (addLe==0) {
								stopLength = true;
							}
							else {
								System.out.println("Please choose only 0/1");
							}
						}
						
						System.out.println("Cost of media (compulsory): ");
						float addCost = Float.parseFloat(input.nextLine());
						
						DigitalVideoDisc dvd = new DigitalVideoDisc(addTitle, addCategory, addDirector, addLength, addCost);
						store.addMedia(dvd);
					}
					else if (updateOption==2) {
						//remove
						System.out.println("Enter title of media you want to remove: ");
						String removeTitle = input.nextLine();
						store.removeMedia(store.getMedia(removeTitle));
					}
					else if (updateOption==0) {
						//back
						stop2 = true;
					}
					else {
						System.out.println("Please choose only 0/1/2/3!");
					}
				}
			}
			else if (showOption==3) {
				cart.display();
				
				boolean stop3 = false;
				while (stop3!=true) {
					
					cartMenu();
					int cartOption = Integer.parseInt(input.nextLine());
					if (cartOption==1) {
						System.out.println("Please choose filtering options: (1-ID/2-Title)");
						int filterOption = Integer.parseInt(input.nextLine());
						
						boolean stopFilter = false;
						while (stopFilter!=true) {
							if (filterOption==1) {
								System.out.println("Enter ID of media: ");
								int filterId = Integer.parseInt(input.nextLine());
								cart.searchById(filterId);
								stopFilter = true;
							}
							else if (filterOption==2) {
								System.out.println("Enter title of media: ");
								String filterTitle = input.nextLine();
								cart.searchByTitle(filterTitle);
								stopFilter = true;
							}
							else {
								System.out.println("Please choose only 1/2!");
							}
						}
					}
					else if (cartOption==2) {
						//Sort DVD in cart
						System.out.println("Please choose sorting options: (1-Title/2-Cost)");
						int sortOption = Integer.parseInt(input.nextLine());
						boolean stopSort = false;
						while (stopSort!=true) {
							if (sortOption==1) {
								cart.titleSortDisplay();
								stopSort = true;
							}
							else if (sortOption==2) {
								System.out.println("Enter title of media: ");
								cart.costSortDisplay();
								stopSort = true;
							}
							else {
								System.out.println("Please choose only 1/2!");
							}
						}
					}
					else if (cartOption==3) {
						//remove DVD from cart
						System.out.println("Enter title of media: ");
						String removeCart = input.nextLine();
						cart.removeMedia(store.getMedia(removeCart));
					}
					else if (cartOption==4) {
						//Place order
						System.out.println("An order is created");
						cart = new Cart();
						stop3 = true;
					}
					
					else if (cartOption==0) {
						stop3 = true;
					}
					else {
						System.out.println("Please choose only 0/1/2/3/4!");
					}
				}
			}
			else if (showOption==0) {
				System.out.println("Thank you for visiting us");
				stop0 = true;
			}
			else {
				System.out.println("Please choose only 0/1/2/3!");
			}
		}	
		input.close();
	}

}

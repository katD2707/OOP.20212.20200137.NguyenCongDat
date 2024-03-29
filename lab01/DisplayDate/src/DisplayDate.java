import java.util.Scanner;

public class DisplayDate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input month: ");
		String month = sc.nextLine();
		System.out.println("Input year: ");
		int year = sc.nextInt();
		
		
		String noti = "Days of month in common year: ";
		
		if (month.toLowerCase().contains("jan") | month.contains("1") |
				month.toLowerCase().contains("mar") | month.contains("3") | 
				month.toLowerCase().contains("may") | month.contains("5") |
				month.toLowerCase().contains("july") | month.contains("7") | 
				month.toLowerCase().contains("sep") | month.contains("9") |
				month.toLowerCase().contains("nov") | month.contains("11")) {
			System.out.println(noti + 31);
		}
		else if (month.toLowerCase().contains("apr") | month.contains("4") |
				month.toLowerCase().contains("jun") | month.contains("6") | 
				month.toLowerCase().contains("aug") | month.contains("8") |
				month.toLowerCase().contains("oct") | month.contains("10") | 
				month.toLowerCase().contains("dec") | month.contains("12")) {
			System.out.println(noti + 30);
		}
		else if (month.toLowerCase().contains("feb") | month.contains("2")){
			if ((year%4!=0) | (year%100==0 & year%400!=0)) {
				System.out.println(noti + 28);
			}
			else {
				System.out.println(noti + 29);
			}
		}
		else {
			System.out.println("Wrong month input, please enter again.");
		}
	}
}

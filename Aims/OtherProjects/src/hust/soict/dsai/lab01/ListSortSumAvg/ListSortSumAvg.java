package hust.soict.dsai.lab01.ListSortSumAvg;
import java.util.Scanner;
import java.util.Arrays;

public class ListSortSumAvg {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Choose source of list (ui/const): ");
			String opt = sc.nextLine();
			double[] arr = {80, 30, 90, 100, 10, 20};
			
			if (opt.equals("ui")) {
				System.out.println("Length of array: ");
				int n = sc.nextInt();
				arr = new double[n];
				
				for (int i=0; i<n; i++) {
					System.out.println("Input element " + (i+1) + ":");
					arr[i] = sc.nextDouble();
				}
			}
			else if (opt.equals("const")) {
			}
			else {
				System.out.println("Type correct option!");
			}
			System.out.print("Content of array: ");
			for (int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			
			Arrays.sort(arr);
			double sum = Arrays.stream(arr).sum();
			
			System.out.println("Sorted array: " + Arrays.toString(arr));
			System.out.println("Sum of array: " + sum);
			System.out.println("Sorted array: " + sum/arr.length);
		}
		
	}
		
}

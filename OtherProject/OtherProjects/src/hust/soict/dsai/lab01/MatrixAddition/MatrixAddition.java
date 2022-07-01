package hust.soict.dsai.lab01.MatrixAddition;
import java.util.Scanner;

public class MatrixAddition {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Choose source of matrix (ui/const): ");
			String option = sc.nextLine();
			
			double[][] a = {{1,3,4},{2,4,3},{3,4,5}};    
			double b[][] = {{1,3,4},{2,4,3},{1,2,4}};        
			double c[][] = new double[3][3];   
			
			if (option.equals("ui")) {
				System.out.println("Number of rows: ");
				int row = sc.nextInt();
				System.out.println("Number of columns: ");
				int column = sc.nextInt();
				
				a = new double[row][column];
				b = new double[row][column];
				
				for (int i=0; i<row; i++) {
					for (int j=0; j<column; j++) {
						System.out.println("Matrix 1: Input element in row " + (i+1) + ", column " + (j+1));
						a[i][j] = sc.nextDouble();
					}
				}
				for (int i=0; i<row; i++) {
					for (int j=0; j<column; j++) {
						System.out.println("Matrix 2: Input element in row " + (i+1) + ", column " + (j+1));
						b[i][j] = sc.nextDouble();
					}
				}
			}
			else if (option.equals("const")) {	
			}
			else {
				System.out.println("Type correct option!");
			}
			
			for(int i=0;i<a.length;i++){    
				for(int j=0;j<a[0].length;j++){    
					c[i][j]=a[i][j]+b[i][j];
					System.out.print(c[i][j]+" ");    
				}    
				System.out.println();    
			}
		}   
	}
}

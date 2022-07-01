package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class SolveEquation {
	public static void main(String[] args) {
		String order, strNumvar;
		
		order = JOptionPane.showInputDialog(null, "Input the degree of equation you want to solve (first/second): ",
				"Input degree", JOptionPane.INFORMATION_MESSAGE);
		
		if (order.equals("first")) {
			strNumvar = JOptionPane.showInputDialog(null, "Input the number of variables (1/2): ",
					"Input a number", JOptionPane.INFORMATION_MESSAGE);
			int numvar = Integer.parseInt(strNumvar);
			
			if (numvar == 1) {
				String stra = JOptionPane.showInputDialog(null, "Input the first parameter: ",
						"Input paramter", JOptionPane.INFORMATION_MESSAGE);
				double a = Double.parseDouble(stra);
				
				String strb = JOptionPane.showInputDialog(null, "Input the second parameter: ",
						"Input paramter", JOptionPane.INFORMATION_MESSAGE);
				double b = Double.parseDouble(strb);
				
				if (a == 0) {
					JOptionPane.showMessageDialog(null, "The first parameter must not be 0", 
							"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "The solution of equation is " + (-b/a), 
							"Show solution", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (numvar == 2) {
				String strA11 = JOptionPane.showInputDialog(null, "Input a11: ",
						"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
				double a_11 = Double.parseDouble(strA11);
				
				String strA12 = JOptionPane.showInputDialog(null, "Input a12: ",
						"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
				double a_12 = Double.parseDouble(strA12);
				
				String strB1 = JOptionPane.showInputDialog(null, "Input b1: ",
						"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
				double b_1 = Double.parseDouble(strB1);
				
				String strA21 = JOptionPane.showInputDialog(null, "Input a21: ",
						"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
				double a_21 = Double.parseDouble(strA21);
				
				String strA22 = JOptionPane.showInputDialog(null, "Input a22: ",
						"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
				double a_22 = Double.parseDouble(strA22);
				
				String strB2 = JOptionPane.showInputDialog(null, "Input b2: ",
						"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
				double b_2 = Double.parseDouble(strB2);
				
				double D = a_11*a_22-a_21*a_12;
				double D1 = b_1*a_22-b_2*a_12;
				double D2 = a_11*b_2-a_21*b_1;
				if (D==0) {
					if (D1 == 0 && D2 == 0) {
						JOptionPane.showMessageDialog(null, "The system has infinitely many solutions");
					}
					else {
						JOptionPane.showMessageDialog(null, "The system has no solution");
					}
				}
				else {
					double x_1 = D1 / D;
					double x_2 = D2 / D;
					JOptionPane.showMessageDialog(null, "The system has one solution: " + x_1 + " and " + x_2);
				}
			}
		}
		else {
			String strA = JOptionPane.showInputDialog(null, "Input a: ",
					"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
			double a = Double.parseDouble(strA);
			
			String strB = JOptionPane.showInputDialog(null, "Input b: ",
					"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
			double b = Double.parseDouble(strB);
			
			String strC = JOptionPane.showInputDialog(null, "Input c: ",
					"Input coefficient", JOptionPane.INFORMATION_MESSAGE);
			double c = Double.parseDouble(strC);
			
			if (a==0) {
				JOptionPane.showMessageDialog(null, "The system has one solution: " + (-c/b));
			}
			else {
				double delta = b*b - 4*a*c;
				if (delta < 0) {
					JOptionPane.showMessageDialog(null, "The system has no solution");
				}
				else if (delta == 0) {
					JOptionPane.showMessageDialog(null, "The system has one solution: " + (-b/(2*a)));
				}
				else {
					double x1 = (-b + Math.sqrt(delta)/ (2*a));
					double x2 = (-b - Math.sqrt(delta)/ (2*a));
					JOptionPane.showMessageDialog(null, "The system has two solutions: " + x1 + " and " + x2);
				}
			}
		}
	}
}
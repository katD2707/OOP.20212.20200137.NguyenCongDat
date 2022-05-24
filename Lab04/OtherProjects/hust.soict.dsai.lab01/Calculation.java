import javax.swing.JOptionPane;

public class Calculation {
	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ", "Input the first number", 
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ", "Input the second number", 
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		
		double sum = num1 + num2;
		double diff = Math.abs(num1 - num2);
		double prod = num1 * num2;
		
		String notif = "Show the sum of 2 double numbers: " + sum + "\n" +
				"Show the difference of 2 double numbers: " + diff + "\n" +
				"Show the product of 2 double numbers: " + prod + "\n";
		
		if (num2 == 0) {
			JOptionPane.showMessageDialog(null, "The second number must not be 0!",
					"Warning", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			notif += "Show the div of 2 double numbers: " + (num1/num2);
		}
				
		JOptionPane.showMessageDialog(null, notif,
				"Show calculation", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);

		
	}
}
import javax.swing.JOptionPane;

public class SolveEquation {
	public static void main(String[] args) {
		String order, strNumvar;
		
		order = JOptionPane.showInputDialog(null, "Input the degree of equation you want to solve: ",
				"Input degree", JOptionPane.INFORMATION_MESSAGE);
		strNumvar = JOptionPane.showInputDialog(null, "Input the number of variables: ",
				"Input a number", JOptionPane.INFORMATION_MESSAGE);
		
		int numvar = Integer.parseInt(strNumvar);
		if (order == "first") {
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
				
			}
		}
		else {
			
		}
	}
}
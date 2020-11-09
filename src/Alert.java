import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * The class to generate a consumer alert interface when electricity or gas cost is transcend the budget.
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class Alert extends JFrame{
	JLabel lblNewLabel = new JLabel();
	public Alert(String str) {
		setBounds(100,100,800,600);
		getContentPane().setLayout(null);
		if (str.equals("ELECTRICITY")) Electricity.eleAlert=true; else Gas.gasAlert=true;
		lblNewLabel.setText("Oops!!! Your consumption of "+str+" is overflow the budget!");
		lblNewLabel.setBounds(14, 94, 754, 34);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("1.jpg"));
		lblNewLabel_1.setBounds(48, 188, 346, 303);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("2.jpg"));
		lblNewLabel_2.setBounds(395, 188, 337, 303);
		getContentPane().add(lblNewLabel_2);
		setVisible(true);
	}
}

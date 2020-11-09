/**
 * Title      : ChangeBudget.java
 * Description: This class contains GUI of change budget.
 * @author      Yueting Du
 * @version     1.0
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeBudget {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changebudget window = new changebudget();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ChangeBudget(Consumer con) {
		initialize();
		this.con=con;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 451, 784, 111);
		frame.getContentPane().add(panel);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 784, 153);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Change Electricity and Gas Budget");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_2.setBounds(14, 44, 754, 29);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 153, 784, 300);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 784, 150);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Electricity budget:");
		lblNewLabel.setBounds(212, 28, 180, 50);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(412, 40, 135, 30);
		panel_3.add(textField);
		textField.setColumns(12);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 150, 784, 150);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gas budget:");
		lblNewLabel_1.setBounds(259, 0, 135, 50);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(411, 12, 135, 30);
		panel_4.add(textField_1);
		textField_1.setColumns(12);
		
		JButton btnChange = new JButton("Submit");

		btnChange.setBounds(330, 9, 120, 30);
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String str1=textField.getText();
			String str2=textField_1.getText();
			boolean judge=true;
			boolean judge1=true;
			int p=0;
			int w=0;
			for (int i=0;i<str1.length();i++){
				if(!Character.isDigit(str1.charAt(i))){
					judge=false;
					if(str1.charAt(i)=='.'){
					if(i==0)
					judge=false;
					else
					judge=true;
					p=p+1;
						}
					if(p==2 )
					judge=false;
					if(judge==false)
					break;
					}

				}
			if(judge==false){
				lblNewLabel.setBounds(100, 28, 300, 50);
					lblNewLabel.setText("Electricty budget must be number!");
       					 //clear the textfield.
					textField.setText("");
				}
			else if(judge==true){
				if(!str1.equals("")){
				Double ele = Double.parseDouble(str1);
					if(ele<0 || ele>10000){
						lblNewLabel.setBounds(100, 28, 300, 50);
						lblNewLabel.setText("Electricty budget between 0-10000!");
       					 	//clear the textfield.
						textField.setText("");	
							}
					else{
							Budget a=new Budget(con);
							String y1=a.changeEbudget(str1);
							lblNewLabel.setBounds(212, 28, 500, 50);
							lblNewLabel.setText("You have changed Electricty budget: "+y1);
							textField.setVisible(false);
						}
					}
				else{
					lblNewLabel.setBounds(100, 28, 300, 50);
							lblNewLabel.setText("You didn't change Electricty budget");
							//textField.setVisible(false);
					}			
				}
			for (int i=0;i<str2.length();i++){
				if(!Character.isDigit(str2.charAt(i))){
					judge1=false;
					if(str2.charAt(i)=='.'){
					if(i==0)
					judge1=false;
					else
					judge1=true;
					w=w+1;
						}
					if(w==2 )
					judge1=false;
					if(judge1==false)
					break;
					}
				}
			if(judge1==false){
				lblNewLabel_1.setBounds(147, 0, 300, 50);
					lblNewLabel_1.setText("Gas budget must be number!");
       					 //clear the textfield.
					textField_1.setText("");
				}
			else if(judge1==true){
				if(!str2.equals("")){
				Double ele = Double.parseDouble(str2);
				if(ele<0 || ele>10000){
					lblNewLabel_1.setBounds(147, 0, 300, 50);
					lblNewLabel_1.setText("Gas budget between 0-10000!");
       					 //clear the textfield.
					textField_1.setText("");	
						}
				else{
							//Consumer a=new Consumer(id);
							Budget a=new Budget(con);
							String y2=a.changeGbudget(str2);
							lblNewLabel_1.setBounds(212, 0, 500, 50);
							lblNewLabel_1.setText("You have changed Gas budget: "+y2);
							textField_1.setVisible(false);
						}
					}
				else{
					lblNewLabel_1.setBounds(140, 0, 300, 50);
							lblNewLabel_1.setText("You didn't change Gas budget");
							//textField_1.setVisible(false);
						}	
					}
			}
		});
		panel.setLayout(null);
		btnChange.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(btnChange);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(657, 62, 111, 27);
		panel.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI window = new GUI(con);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
	}
}

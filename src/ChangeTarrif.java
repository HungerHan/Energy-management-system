/**
 * Title      : ChangeTarrif.java
 * Description: This class contains GUI of change tariff.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeTarrif {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the application.
	 */
	public ChangeTarrif() {
		initialize();
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
		panel.setBounds(0, 0, 784, 562);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Electricity:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(255, 191, 112, 36);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(377, 194, 135, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Change Tarrif");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(14, 44, 754, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gas:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(295, 315, 54, 15);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 309, 135, 30);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginGUI loginInGui = new LoginGUI();
				frame.dispose();
				loginInGui.provMenuScreenInit();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(657, 513, 111, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
					lblNewLabel.setBounds(150, 191, 250, 36);
					lblNewLabel.setText("Electricty Tarrif is number!");
       					 //clear the textfield.
					textField.setText("");
				}
			else if(judge==true){
				if(!str1.equals("")){
				Double ele = Double.parseDouble(str1);
					if(ele<0 || ele>100){
						lblNewLabel.setBounds(80, 191, 300, 36);
						lblNewLabel.setText("Electricty Tarrif between 0-100!");
       					 	//clear the textfield.
						textField.setText("");	
							}
					else{
							Change a=new Change();
							String y1=a.changeETarrif(str1);
							lblNewLabel.setBounds(255, 191, 350, 36);
							lblNewLabel.setText("You have changed Electricty tarrif: "+y1);
							textField.setVisible(false);
						}
					}
				else{
					lblNewLabel.setBounds(80, 191, 300, 36);
							lblNewLabel.setText("You didn't change Electricty tarrif");
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
				lblNewLabel_2.setBounds(120, 305, 300, 36);
					lblNewLabel_2.setText("Gas Tarrif must be number!");
       					 //clear the textfield.
					textField_1.setText("");
				}
			else if(judge1==true){
				if(!str2.equals("")){
				Double ele = Double.parseDouble(str2);
				if(ele<0 || ele>100){
					lblNewLabel_2.setBounds(120, 305, 300, 36);
					lblNewLabel_2.setText("Gas Tarrif between 0-100!");
       					 //clear the textfield.
					textField_1.setText("");	
						}
				else{
							//Consumer a=new Consumer(id);
							Change a=new Change();
							String y2=a.changeGTarrif(str2);
							lblNewLabel_2.setBounds(295, 305, 300, 36);
							lblNewLabel_2.setText("You have changed Gas tarrif: "+y2);
							textField_1.setVisible(false);
						}
					}
				else{
					lblNewLabel_2.setBounds(120, 305, 300, 36);
							lblNewLabel_2.setText("You didn't change Gas tarrif");
							//textField_1.setVisible(false);
						}	
					}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(330, 460, 120, 30);
		panel.add(btnNewButton_1);
	}
}

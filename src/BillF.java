import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * The class for the GUI of Meter
 * Show the bill of the customer
 * @author Zihan Zhang
 * @version 5.0 2018.5.31
 */
public class BillF {

	public JFrame frame;
	public JTextField textField;
	public String buserName;
	public String bmonth;
	public String byear;
	public String BFbill;
	public String[] splitB;
	public String eBill;
	public String gBill;
	
	/**
	 * The main to setup up
	 * Used in independent test
	 * @param args The input
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillF window = new BillF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for setting up
	 */
	public BillF() {
		initialize();
	}

	/**
	 * the function of GUI
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 782, 553);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblViewBill = new JLabel("View Bill");
		lblViewBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewBill.setFont(new Font("Arial", Font.BOLD, 24));
		lblViewBill.setBounds(14, 44, 754, 18);
		panel.add(lblViewBill);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUserName.setBounds(117, 170, 111, 18);
		panel.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(266, 168, 180, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMonth.setBounds(117, 240, 111, 18);
		panel.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Arial", Font.PLAIN, 18));
		lblYear.setBounds(117, 316, 111, 18);
		panel.add(lblYear);
		
		JLabel lblEnterTheUser = new JLabel("Enter the User Name, Month and Year of data you want to view.");
		lblEnterTheUser.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterTheUser.setBounds(59, 95, 565, 18);
		panel.add(lblEnterTheUser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(266, 238, 99, 24);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setBounds(268, 314, 99, 24);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2018", "2017"}));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 18));
		btnSubmit.setBounds(330, 460, 120, 30);
		panel.add(btnSubmit);
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buserName=(String)textField.getText();
				bmonth=(String)comboBox.getSelectedItem();
				byear=(String)comboBox_1.getSelectedItem();
				
				Meter meterFun=new Meter();
				BFbill=meterFun.meterRead(buserName, byear, bmonth);//0 eBill 1 gBill
				if(BFbill=="NO")
				{
					System.out.println(BFbill);
					panel.removeAll();
					panel.updateUI();
					
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_2.setIcon(new ImageIcon("header-logo-eps.jpg"));
					lblNewLabel_2.setBounds(0, 10, 784, 147);
					panel.add(lblNewLabel_2);
					
					JLabel Jword=new JLabel("There is no corresponding data!");
					Jword.setForeground(Color.RED);
					Jword.setFont(new Font("Arial", Font.BOLD, 20));
					Jword.setBounds(150, 240, 600, 40);
					
					JLabel Jword1=new JLabel("Please enter the right User Name and Date, try again. ");
					Jword1.setForeground(Color.RED);
					Jword1.setFont(new Font("Arial", Font.BOLD, 20));
					Jword1.setBounds(150, 320, 600, 40);
					
					panel.add(Jword);
					panel.add(Jword1);
				}
				else {
					
				
				splitB=BFbill.split(",");
				eBill=splitB[3];
				gBill=splitB[5];
				
				panel.removeAll();
				panel.updateUI();
				
				JLabel Jword=new JLabel("The following is your data:");
				Jword.setFont(new Font("Arial", Font.BOLD, 18));
				Jword.setBounds(100, 50, 600, 40);
				
				JLabel ebill=new JLabel("Elec Bill:");
				ebill.setFont(new Font("Arial", Font.PLAIN, 18));
				ebill.setBounds(200, 150, 450, 18);
				
				JLabel edata=new JLabel();
				edata.setFont(new Font("Arial", Font.PLAIN, 18));
				edata.setText(eBill);
				edata.setBounds(200, 200, 450, 18);
				
				JLabel gbill=new JLabel("Gas Bill:");
				gbill.setFont(new Font("Arial", Font.PLAIN, 18));
				gbill.setBounds(200, 250, 450, 18);
				
				JLabel gdata=new JLabel();
				gdata.setFont(new Font("Arial", Font.PLAIN, 18));
				gdata.setText(gBill);
				gdata.setBounds(200, 300, 450, 18);
				panel.add(edata);
				panel.add(ebill);
				panel.add(gdata);
				panel.add(gbill);
				panel.add(Jword);
				
				}
				JButton BFGoBack = new JButton("Go Back");
				BFGoBack.setFont(new Font("Arial", Font.BOLD, 18));
				BFGoBack.setBounds(657, 513, 111, 27);
				panel.add(BFGoBack);
				
				BFGoBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						LoginGUI loginInGui = new LoginGUI();
						frame.dispose();
						loginInGui.provMenuScreenInit();
					}
				});
				
				
				
			}
		});
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Arial", Font.BOLD, 18));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI loginInGui = new LoginGUI();
				frame.dispose();
				loginInGui.provMenuScreenInit();
			}
		});
		btnGoBack.setBounds(657, 513, 111, 27);
		panel.add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Zihan Zhang\\Desktop\\GroupWork-v1\\b.jpg"));
		label.setBounds(482, 240, 227, 137);
		panel.add(label);
		
	}
}

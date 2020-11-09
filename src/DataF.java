import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * The class for GUI of viewData
 * Show the required data
 * @author Zihan Zhang
 * @version 4.1 2018.5.31
 */
public class DataF {

	public JFrame frame;
	public JTextField textField;
	public String strDate;
	public String DFuserName;
	public String DFcontent;
	public String[] splitD;

	/**
	 * Set up the GUi
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataF window = new DataF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for GUI
	 * Create the application.
	 */
	public DataF() {
		initialize();
	}

	/**
	 * The GUI functions
	 * Initialize the contents of the frame.
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_2.setBounds(376, 290, 45, 24);
		panel.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setBounds(332, 290, 45, 24);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(265, 290, 73, 24);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2017"}));
		
		textField = new JTextField();
		textField.setBounds(262, 185, 177, 24);
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblViewData = new JLabel("View Data");
		lblViewData.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewData.setFont(new Font("Arial", Font.BOLD, 24));
		lblViewData.setBounds(14, 44, 754, 30);
		panel.add(lblViewData);
		
		JLabel lblEnterTheUser = new JLabel("Enter the User Name and the Date.");
		lblEnterTheUser.setFont(new Font("Arial", Font.BOLD, 18));
		lblEnterTheUser.setBounds(59, 95, 565, 18);
		panel.add(lblEnterTheUser);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUserName.setBounds(110, 187, 129, 18);
		panel.add(lblUserName);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDate.setBounds(110, 293, 129, 18);
		panel.add(lblDate);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 18));
		btnSubmit.setBounds(330, 460, 120, 30);
		panel.add(btnSubmit);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Arial", Font.BOLD, 18));
		btnGoBack.setBounds(657, 513, 111, 27);
		panel.add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("data.jpg"));
		label.setBounds(467, 240, 284, 158);
		panel.add(label);
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DFuserName=(String)textField.getText();
				String Year=(String)comboBox.getSelectedItem();
				String Month=(String)comboBox_1.getSelectedItem();
				String Day=(String)comboBox_2.getSelectedItem();
				StringBuffer Fdate=new StringBuffer("");
				Fdate=Fdate.append(Year);
				Fdate=Fdate.append(".");
				Fdate=Fdate.append(Month);
				Fdate=Fdate.append(".");
				Fdate=Fdate.append(Day);
				
				strDate=Fdate.toString();
				//System.out.println(strDate);
				//System.out.println(DFuserName);
				
				ViewData dataFun=new ViewData();
				String DFcontent=dataFun.checkData(DFuserName, strDate);
				//System.out.println(DFuserName);
				//System.out.println(DFcontent);
				if(DFcontent=="NO")
				{
					System.out.println(DFcontent);
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
					splitD=DFcontent.split("\\,");
				
				
				panel.removeAll();
				panel.updateUI();
				JLabel Jword=new JLabel("The following is your data:");
				Jword.setFont(new Font("Arial", Font.BOLD, 18));
				Jword.setBounds(100, 50, 600, 40);
						
				JLabel date=new JLabel("Date:");
				date.setFont(new Font("Arial", Font.PLAIN, 18));
				date.setBounds(200, 130, 450, 18);
				
				JLabel ldate=new JLabel();
				ldate.setText(splitD[0]);
				ldate.setFont(new Font("Arial", Font.PLAIN, 18));
				ldate.setBounds(200, 160, 450, 18);
				
				JLabel econ=new JLabel("Elec Consume:");
				econ.setFont(new Font("Arial", Font.PLAIN, 18));
				econ.setBounds(200, 190, 450, 18);
				
				JLabel le=new JLabel();
				le.setFont(new Font("Arial", Font.PLAIN, 18));
				le.setText(splitD[1]);
				le.setBounds(200, 220, 450, 18);
				
				JLabel ecost=new JLabel("Elec Cost:");
				ecost.setFont(new Font("Arial", Font.PLAIN, 18));
				ecost.setBounds(200, 250, 450, 18);
				
				JLabel ec=new JLabel();
				ec.setFont(new Font("Arial", Font.PLAIN, 18));
				ec.setText(splitD[2]);
				ec.setBounds(200, 280, 450, 18);
				
				JLabel gcon=new JLabel("Gas Consume:");
				gcon.setFont(new Font("Arial", Font.PLAIN, 18));
				gcon.setBounds(200, 310, 450, 18);
				
				JLabel lg=new JLabel();
				lg.setFont(new Font("Arial", Font.PLAIN, 18));
				lg.setText(splitD[3]);
				lg.setBounds(200, 340, 450, 18);
				
				JLabel gcost=new JLabel("Gas Cost:");
				gcost.setFont(new Font("Arial", Font.PLAIN, 18));
				gcost.setBounds(200, 370, 450, 18);
				
				JLabel gc=new JLabel();
				gc.setFont(new Font("Arial", Font.PLAIN, 18));
				gc.setText(splitD[4]);
				gc.setBounds(200, 400, 450, 18);
				
				panel.add(date);
				panel.add(ldate);
				panel.add(econ);
				panel.add(le);
				panel.add(ecost);
				panel.add(ec);
				panel.add(gcon);
				panel.add(lg);
				panel.add(gcost);
				panel.add(gc);
				//panel.add(DFGoBack);
				panel.add(Jword);
				}//else end
				JButton DFGoBack = new JButton("Go Back");
				DFGoBack.setFont(new Font("Arial", Font.BOLD, 18));
				DFGoBack.setBounds(657, 513, 111, 27);
				panel.add(DFGoBack);
				
				DFGoBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						LoginGUI loginInGui = new LoginGUI();
						frame.dispose();
						loginInGui.provMenuScreenInit();
					}
				});
				
				
				
			}
		});
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI loginInGui = new LoginGUI();
				frame.dispose();
				loginInGui.provMenuScreenInit();
			}
		});
	}
}

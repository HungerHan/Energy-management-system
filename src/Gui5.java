//package gui;
/**
 * Title      : Gui5.java
 * Description: This class contains the GUI of checking historic day data.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Gui5 {

	public JFrame frame;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui5 window = new gui5();
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
	public Gui5(Consumer con) {
		initialize(con);
		this.con=con;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Consumer con) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel pane2 = new JPanel();
		pane2.setBounds(0, 456, 784, 106);
		frame.getContentPane().add(pane2);
		


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 784, 84);
		frame.getContentPane().add(panel_1);


		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 84, 784, 373);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Please select the Day:");
		lblNewLabel_1.setBounds(180, 174, 217, 19);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		panel_2.add(lblNewLabel_1);
		JTextArea txtrPleaseSelectThe = new JTextArea(8,50);
		txtrPleaseSelectThe.setFont(new Font("Arial", Font.PLAIN, 18));
		JScrollPane scroll = new JScrollPane(txtrPleaseSelectThe); 
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(3, 50, 784, 300);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View day data");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 44, 754, 29);
		panel_1.add(lblNewLabel);
		

		ViewHistory a=new ViewHistory(con);
		String[] m=new String[10];
		int o=0;
		m=a.getYear();
				for(int j=0;j<m.length;j++){
					if(m[j]!=null){
						o++;
						}
					else{}

				}
		//System.out.println(o);
		String[] m1=new String[o];
		for(int f=0;f<m1.length;f++)
		m1[f]=m[f];		
		JComboBox comboBox0 = new JComboBox();
		comboBox0.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox0.setModel(new DefaultComboBoxModel(m1));
		comboBox0.setBounds(407, 166, 92, 36);
		panel_2.add(comboBox0);
		
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox1.setBounds(517, 165, 92, 36);
		panel_2.add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox2.setBounds(627, 165, 92, 36);
		panel_2.add(comboBox2);
		pane2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(330, 4, 120, 30);
		pane2.add(btnNewButton_1);
		
				JButton btnNewButton = new JButton("Go back");
				btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
				btnNewButton.setBounds(657, 57, 111, 27);
				pane2.add(btnNewButton);
				btnNewButton.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String che;
				String q1=(String)comboBox0.getSelectedItem();
				String q2=(String)comboBox1.getSelectedItem();
				String q3=(String)comboBox2.getSelectedItem();
				String q4=q1+"."+q2+"."+q3;
				ViewHistory a=new ViewHistory(con);
				txtrPleaseSelectThe.setText("Date,Electricity consumption(kWh),Electricity cost(pound),Gas consumption(kWh),Gas cost(pound)\t\n");
				che=a.historicDayCost(q4);
				panel_2.removeAll();
				panel_2.updateUI();
				btnNewButton_1.setVisible(false);
				panel_2.add(scroll);
				txtrPleaseSelectThe.append(che);
				//txtrPleaseSelectThe.setLineWrap(true);
						
			}
		});
		
		comboBox1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			JComboBox combo = (JComboBox) e.getSource();
			if (comboBox1.getSelectedItem().equals("01")||comboBox1.getSelectedItem().equals("03")||comboBox1.getSelectedItem().equals("05")||comboBox1.getSelectedItem().equals("07")||comboBox1.getSelectedItem().equals("08")||comboBox1.getSelectedItem().equals("10")||comboBox1.getSelectedItem().equals("12")) {
			comboBox2.removeAllItems();
			comboBox2.addItem("01");
			comboBox2.addItem("02");
			comboBox2.addItem("03");			
			comboBox2.addItem("04");
			comboBox2.addItem("05");
			comboBox2.addItem("06");
			comboBox2.addItem("07");
			comboBox2.addItem("08");			
			comboBox2.addItem("09");
			comboBox2.addItem("10");			
			comboBox2.addItem("11");
			comboBox2.addItem("12");
			comboBox2.addItem("13");
			comboBox2.addItem("14");
			comboBox2.addItem("15");
			comboBox2.addItem("16");
			comboBox2.addItem("17");			
			comboBox2.addItem("18");
			comboBox2.addItem("19");
			comboBox2.addItem("20");
			comboBox2.addItem("21");
			comboBox2.addItem("22");			
			comboBox2.addItem("23");
			comboBox2.addItem("24");			
			comboBox2.addItem("25");
			comboBox2.addItem("26");
			comboBox2.addItem("27");
			comboBox2.addItem("28");			
			comboBox2.addItem("29");
			comboBox2.addItem("30");
			comboBox2.addItem("31");
		
			
			}  else if(comboBox1.getSelectedItem().equals("04")||comboBox1.getSelectedItem().equals("06")||comboBox1.getSelectedItem().equals("09")||comboBox1.getSelectedItem().equals("11")) {
				comboBox2.removeAllItems();
				comboBox2.addItem("01");
				comboBox2.addItem("02");
				comboBox2.addItem("03");			
				comboBox2.addItem("04");
				comboBox2.addItem("05");
				comboBox2.addItem("06");
				comboBox2.addItem("07");
				comboBox2.addItem("08");			
				comboBox2.addItem("09");
				comboBox2.addItem("10");			
				comboBox2.addItem("11");
				comboBox2.addItem("12");
				comboBox2.addItem("13");
				comboBox2.addItem("14");
				comboBox2.addItem("15");
				comboBox2.addItem("16");
				comboBox2.addItem("17");			
				comboBox2.addItem("18");
				comboBox2.addItem("19");
				comboBox2.addItem("20");
				comboBox2.addItem("21");
				comboBox2.addItem("22");			
				comboBox2.addItem("23");
				comboBox2.addItem("24");			
				comboBox2.addItem("25");
				comboBox2.addItem("26");
				comboBox2.addItem("27");
				comboBox2.addItem("28");			
				comboBox2.addItem("29");
				comboBox2.addItem("30");
				
			}
			
			else {comboBox2.removeAllItems();
			comboBox2.addItem("01");
			comboBox2.addItem("02");
			comboBox2.addItem("03");			
			comboBox2.addItem("04");
			comboBox2.addItem("05");
			comboBox2.addItem("06");
			comboBox2.addItem("07");
			comboBox2.addItem("08");			
			comboBox2.addItem("09");
			comboBox2.addItem("10");			
			comboBox2.addItem("11");
			comboBox2.addItem("12");
			comboBox2.addItem("13");
			comboBox2.addItem("14");
			comboBox2.addItem("15");
			comboBox2.addItem("16");
			comboBox2.addItem("17");			
			comboBox2.addItem("18");
			comboBox2.addItem("19");
			comboBox2.addItem("20");
			comboBox2.addItem("21");
			comboBox2.addItem("22");			
			comboBox2.addItem("23");
			comboBox2.addItem("24");			
			comboBox2.addItem("25");
			comboBox2.addItem("26");
			comboBox2.addItem("27");
			comboBox2.addItem("28");
			}
			
			}
			});
			
		
		}
}	


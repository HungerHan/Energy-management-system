//package gui;
/**
 * Title      : Gui4.java
 * Description: This class contains the GUI of checking historic month data.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;

public class Gui4 {

	public JFrame frame;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui4 window = new gui4();
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
	public Gui4(Consumer con) {
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
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View month data");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 44, 754, 29);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 84, 784, 373);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Please select the month:");
		lblNewLabel_1.setBounds(180, 174, 217, 19);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1);
		JTextArea txtrPleaseSelectThe = new JTextArea(8, 50);
		txtrPleaseSelectThe.setFont(new Font("Arial", Font.PLAIN, 18));
		JScrollPane scroll = new JScrollPane(txtrPleaseSelectThe); 
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(3, 50, 784, 300);
		
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
		JComboBox<String> comboBox;
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(m1));
		comboBox.setBounds(407, 166, 92, 36);
		panel_2.add(comboBox);
		
		JComboBox<String> comboBox_1;
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_1.setBounds(517, 165, 92, 36);
		panel_2.add(comboBox_1);
		pane2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(330, 4, 120, 30);
		pane2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		pane2.add(btnNewButton);
		btnNewButton.setBounds(657, 57, 111, 27);
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
				String[] che=new String[31];
				String q1=(String)comboBox.getSelectedItem();
				String q2=(String)comboBox_1.getSelectedItem();
				String q3=q1+"."+q2;
				ViewHistory a=new ViewHistory(con);
				txtrPleaseSelectThe.setText("Date,Electricity consumption(kWh),Electricity cost(pound),Gas consumption(kWh),Gas cost(pound)\t\n");
				che=a.historicMonthCost(q3);
				panel_2.removeAll();
				panel_2.updateUI();
				btnNewButton_1.setVisible(false);
				panel_2.add(scroll);
				for(int i=0;i<che.length;i++){
					if(che[i]!=null){
					txtrPleaseSelectThe.setBounds(0, 80, 450, 270);
					txtrPleaseSelectThe.append(che[i]+"\t\n");

					//txtrPleaseSelectThe.setLineWrap(true);
						}
					else{}

				}
			}
		});
	}

}

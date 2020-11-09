/**
 * Title      : Warning.java
 * Description: This class contains GUI of checking whether current cost has over the budget.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

public class Warning {

	public JFrame frame;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					warning window = new warning();
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
	public Warning(Consumer con) {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 79);
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 454, 784, 108);
		frame.getContentPane().add(panel_1);

		String use;
		String[] spl=new String[5];

		Budget a=new Budget(con);
		use=a.checkBudget();
		spl=use.split(" ");
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Check Alert");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_2.setBounds(14, 44, 754, 29);
		panel.add(lblNewLabel_2);
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 78, 354, 378);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Current Electricity Budget: "+spl[3]);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel6 = new JLabel("Current Electricity cost: "+spl[1]);
		lblNewLabel6.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_2.add(lblNewLabel6);

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(499, 78, 285, 378);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JLabel lblNewLabel_1 = new JLabel("Current Gas Budget: "+spl[4]);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_1);
		JLabel lblNewLabel_6 = new JLabel("Current Gas cost: "+spl[2]);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_6);


		if(spl[0].equals("00")){
		Green myDrawingPanel = new Green();
		panel_2.add(myDrawingPanel);
		Green myDrawingPanel1 = new Green();
		panel_3.add(myDrawingPanel1);
		}

		if(spl[0].equals("01")){
		Green myDrawingPanel = new Green();
		panel_2.add(myDrawingPanel);
		Red myDrawingPanel1 = new Red();
		panel_3.add(myDrawingPanel1);
		}

		if(spl[0].equals("10")){
		Red myDrawingPanel = new Red();
		panel_2.add(myDrawingPanel);
		Green myDrawingPanel1 = new Green();
		panel_3.add(myDrawingPanel1);
		}
		
		if(spl[0].equals("11")){
		Red myDrawingPanel = new Red();
		panel_2.add(myDrawingPanel);
		Red myDrawingPanel1 = new Red();
		panel_3.add(myDrawingPanel1);
		}

		
		JButton btnCheckBudget = new JButton("Submit");
		btnCheckBudget.setBounds(330, 6, 120, 30);
		btnCheckBudget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String use1;
			String[] spl1=new String[5];
			use1=a.checkBudget();
			spl1=use.split(" ");
			panel_2.removeAll();
			panel_2.updateUI();
			panel_3.removeAll();
			panel_3.updateUI();

			lblNewLabel.setText("Current Electricity Budget: "+spl1[3]);
			panel_2.add(lblNewLabel);

			lblNewLabel6.setText("Current Electricity cost: "+spl1[1]);
			panel_2.add(lblNewLabel6);

			lblNewLabel_1.setText("Current Gas Budget: "+spl1[4]);
			panel_3.add(lblNewLabel_1);

			lblNewLabel_6.setText("Current Gas cost: "+spl1[2]);
			panel_3.add(lblNewLabel_6);
			
			if(spl1[0].equals("00")){
			Green myDrawingPanel = new Green();
			panel_2.add(myDrawingPanel);
			Green myDrawingPanel1 = new Green();
			panel_3.add(myDrawingPanel1);
			}

			if(spl1[0].equals("01")){
			Green myDrawingPanel = new Green();
			panel_2.add(myDrawingPanel);
			Red myDrawingPanel1 = new Red();
			panel_3.add(myDrawingPanel1);
			}

			if(spl1[0].equals("10")){
			Red myDrawingPanel = new Red();
			panel_2.add(myDrawingPanel);
			Green myDrawingPanel1 = new Green();
			panel_3.add(myDrawingPanel1);
			}
		
			if(spl1[0].equals("11")){
			Red myDrawingPanel = new Red();
			panel_2.add(myDrawingPanel);
			Red myDrawingPanel1 = new Red();
			panel_3.add(myDrawingPanel1);
				}
			}
		});
		panel_1.setLayout(null);
		btnCheckBudget.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(btnCheckBudget);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(657, 59, 111, 27);
		panel_1.add(btnNewButton);
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

	}

}

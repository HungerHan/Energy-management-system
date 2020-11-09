/**
 * Title      : CheckBudget.java
 * Description: This class contains GUI which is used to choose check alert or change budget.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class CheckBudget {

	public JFrame frame;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkbudget window = new checkbudget();
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
	public CheckBudget(Consumer con) {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 496, 784, 66);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(657, 17, 111, 27);
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
		panel_1.setLayout(null);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 784, 498);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("check alert");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(280, 168, 217, 60);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
					try {
						Warning window = new Warning(con);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("change budget");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));

		btnNewButton_2.setBounds(280, 313, 217, 60);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeBudget window = new ChangeBudget(con);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		panel_2.add(btnNewButton_2);
		
		JLabel lblBudgetAndAlert = new JLabel("Budget and Alert");
		lblBudgetAndAlert.setFont(new Font("Arial", Font.BOLD, 24));
		lblBudgetAndAlert.setHorizontalAlignment(SwingConstants.CENTER);
		lblBudgetAndAlert.setBounds(14, 44, 754, 29);
		panel_2.add(lblBudgetAndAlert);
	}

}

/**
 * Title      : GUI.java
 * Description: This class contains the GUI of consumer main manual.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUI {

	public JFrame frame;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the applaication.
	 */
	
	public GUI(Consumer con) {
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
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("View electricity consumption&cost");
		btnNewButton.setBounds(212, 138, 363, 60);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			ViewEle viewEle=new ViewEle(con);
			}
		});
		
		JButton btnNewButton_1 = new JButton("View gas consumption&cost");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(212, 211, 363, 60);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			ViewGas viewGas=new ViewGas(con);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Budget and alert");
		btnNewButton_2.setBounds(212, 284, 363, 60);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBudget window = new CheckBudget(con);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View historic consumption&cost");
		btnNewButton_3.setBounds(212, 357, 363, 60);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui1 window = new Gui1(con);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Check tarrif");
		btnNewButton_4.setBounds(212, 430, 363, 60);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckTariff window = new CheckTariff(con);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Log out");
		btnNewButton_5.setBounds(657, 513, 111, 27);
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			Electricity.co=null;
			Gas.co=null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI window = new UserGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		panel_1.add(btnNewButton_5);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("customer.jpg"));
		label.setBounds(126, 0, 534, 119);
		panel_1.add(label);
	}
	/*public void actionPerformed(ActionEvent event) {
		String choice=event.getActionCommand();
		if (choice.equals("View electricity consumption&cost")) {
			frame.dispose();
			ViewEle viewEle=new ViewEle(id);
		} else if (choice.equals("View gas consumption&cost")) {
			frame.dispose();
			ViewGas viewGas=new ViewGas(id);
		}
			
	}*/

}

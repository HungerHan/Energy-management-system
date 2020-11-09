/**
 * Title      : Gui1.java
 * Description: This class contains the GUI which is used to choose view month or day hictoric data.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Gui1 {

	public JFrame frame;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private Consumer con;
	private JLabel lblViewHistoryData;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui1 window = new gui1();
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
	public Gui1(Consumer con) {
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
		
		btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(657, 513, 111, 27);
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
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton = new JButton("View day");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui5 window = new Gui5(con);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		btnNewButton.setBounds(280, 166, 217, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("View mounth");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(280, 284, 217, 60);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui4 window = new Gui4(con);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		lblViewHistoryData = new JLabel("View Historic Data");
		lblViewHistoryData.setFont(new Font("Arial", Font.BOLD, 24));
		lblViewHistoryData.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewHistoryData.setBounds(14, 44, 754, 29);
		frame.getContentPane().add(lblViewHistoryData);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("history.jpg"));
		label.setBounds(14, 376, 754, 112);
		frame.getContentPane().add(label);
	}
}

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * The class for GUI of viewName
 * Show all the names
 * @author Zihan Zhang
 * @version 3.2 2018.5.31
 */
public class NameF {

	public JFrame frame;

	/**
	 * The Main of GUI
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameF window = new NameF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor of GUI
	 * Create the application.
	 */
	public NameF() {
		initialize();
	}

	/**
	 * The GUI functions
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		ViewName viewN=new ViewName();
		NameEntity myNameEntity=new NameEntity();
		StringBuffer data=viewN.getFile(myNameEntity.path,myNameEntity.deep);
		String nameData=data.toString();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHereAreAll = new JLabel("Here are all the users in the system");
		lblHereAreAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereAreAll.setFont(new Font("Arial", Font.BOLD, 24));
		lblHereAreAll.setBounds(14, 44, 754, 30);
		frame.getContentPane().add(lblHereAreAll);
		
		JLabel Lname = new JLabel();
		Lname.setVerticalAlignment(SwingConstants.TOP);
		Lname.setText(nameData);
		Lname.setFont(new Font("Arial", Font.BOLD, 20));
		Lname.setBounds(138, 240, 498, 171);
		frame.getContentPane().add(Lname);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
		    
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI loginInGui = new LoginGUI();
				frame.dispose();
				loginInGui.provMenuScreenInit();
			}
		});
		btnGoBack.setFont(new Font("Arial", Font.BOLD, 18));
		btnGoBack.setBounds(657, 513, 111, 27);
		frame.getContentPane().add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("name.jpg"));
		label.setBounds(175, 103, 431, 124);
		frame.getContentPane().add(label);
	}

}

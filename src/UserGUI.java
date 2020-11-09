//package userGUI;
/**
 * Title      : UserGUI.java
 * Description: This class contains the GUI of main interface for user .
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserGUI {

	public JFrame frame;

    /**
* The main method is to realize all the function of system
* @param args is not used in this system 
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI window = new UserGUI();
					window.frame.setVisible(true);
					Update up=new Update();
					Thread thread=new Thread(up);
					thread.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserGUI() {
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
		panel.setBounds(0, 439, 784, 123);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Provider");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(200, 22, 144, 51);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();

    LoginGUI loginInGui = new LoginGUI();
    //loginInGui.userTypeScreenInit();
                        loginInGui.isProvider = 1;
			loginInGui.accountOrNotScreenInit();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customer");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(455, 22, 144, 51);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
    //String provider_login_filepath = "C:/csw/provider_ID_password.csv";
    //String customer_login_filepath = "C:/csw/customer_ID_password.csv";
    //String customer_parameter_path_prefix = "C:/csw/customer_parameters/";

    LoginGUI loginInGui = new LoginGUI();
    //loginInGui.userTypeScreenInit();
                        loginInGui.isProvider = 0;
			loginInGui.accountOrNotScreenInit();
			}
			
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 784, 439);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHelloWelcomeTo = new JLabel("Hello, welcome to the Energy System!");
		lblHelloWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWelcomeTo.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblHelloWelcomeTo.setBounds(0, 218, 784, 99);
		panel_1.add(lblHelloWelcomeTo);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("header-logo-eps.jpg"));
		lblNewLabel_2.setBounds(0, 10, 784, 147);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 10, 784, 429);
		panel_1.add(lblNewLabel_1);
		
	}
}

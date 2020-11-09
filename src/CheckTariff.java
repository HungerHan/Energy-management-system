/**
 * Title      : CheckTariff.java
 * Description: This class contains GUI to check current budget for consumer.
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
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
public class CheckTariff {

	public JFrame frame;
	private Consumer con;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checktariff window = new checktariff();
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
	public CheckTariff(Consumer con) {
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
		panel_1.setBounds(0, 0, 784, 492);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

	

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 784, 492);
		panel_1.add(panel_3);

		String info;		
		//Consumer a=new Consumer(id);
		ViewTarrif a=new ViewTarrif();
		info=a.checkTarrif();
		panel_3.setLayout(null);
		
	

		JLabel label1 = new JLabel(info);
		label1.setBounds(14, 220, 754, 45);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label1);
		label1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblCurrentTarrif = new JLabel("Current Tarrif");
		lblCurrentTarrif.setFont(new Font("Arial", Font.BOLD, 24));
		lblCurrentTarrif.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentTarrif.setBounds(14, 44, 754, 29);
		panel_3.add(lblCurrentTarrif);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 495, 784, 67);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setBounds(657, 18, 111, 27);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
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
		panel.setLayout(null);
		panel.add(btnNewButton);
	}

}

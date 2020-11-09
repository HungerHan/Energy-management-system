
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The class to generate a provider interface showing "Check tarrif" function
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class Tarrif extends JFrame{
	//JButton button3=new JButton("Go back");
	JPanel panel=new JPanel(),panel1=new JPanel(),panel2=new JPanel();
	JButton btnGoBack = new JButton("Go Back");
	
	JButton button1=new JButton("View Tariff");
	JButton button2=new JButton("Change Tariff");
	private final JLabel label = new JLabel("");
	
	public Tarrif() {
		setBounds(100,100,800,600);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, 784, 562);
		button1.setBounds(300, 199, 180, 51);
		button2.setBounds(300, 303, 180, 51);
		panel.add(button1);
		panel.add(button2);
		panel.add(btnGoBack);
		button1.setFont(new Font("Arial", Font.BOLD, 18));
		button2.setFont(new Font("Arial", Font.BOLD, 18));
		btnGoBack.setFont(new Font("Arial", Font.BOLD, 18));
		btnGoBack.setBounds(330, 460, 120, 30);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("Tarrif2.jpg"));
		label.setBounds(14, 13, 756, 129);
		
		panel.add(label);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI loginInGui = new LoginGUI();
				dispose();
				loginInGui.provMenuScreenInit();
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ShowTarrif();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ChangeTarrif window = new ChangeTarrif();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		setVisible(true);
	}
}
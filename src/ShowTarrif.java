
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The class to generate a provider interface showing tarrif information
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class ShowTarrif extends JFrame{
	JPanel panel=new JPanel(),panel1=new JPanel();
	JButton btnGoBack = new JButton("Go Back");
	JLabel label=new JLabel();
	String eprice;
	String gprice;
	private final JLabel label_1 = new JLabel("");
	
	public ShowTarrif() {
		setBounds(100,100,800,600);
		getContentPane().setLayout(null);
		System.out.println("show tarrif");
		getContentPane().add(panel);
		panel.setBounds(0, 0, 784, 562);
		panel.setLayout(null);
		panel.setLayout(null);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		label.setBounds(14, 113, 756, 82);
		panel.add(btnGoBack);
		btnGoBack.setFont(new Font("Arial", Font.BOLD, 18));
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		btnGoBack.setBounds(330, 460, 120, 30);
		label.setText(ViewTarrif.checkTarrif());
		label_1.setIcon(new ImageIcon("tariff.jpg"));
		label_1.setBounds(178, 243, 414, 167);
		
		panel.add(label_1);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI loginInGui = new LoginGUI();
				dispose();
				loginInGui.provMenuScreenInit();
			}
		});
		setVisible(true);
	}
}
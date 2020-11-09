import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The class to generate a consumer interface showing electricity consumption and cost
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class ViewEle extends JFrame implements ActionListener{
	JPanel panel=new JPanel();
	JButton button=new JButton("Go back");
	JLabel label=new JLabel();
	private Consumer con;
	String filename;
	private String content;
	private final JLabel lblNewLabel = new JLabel("New label");
	
	public ViewEle(Consumer con) {
		setTitle("View electricity consumption&cost");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		this.con=con;
		filename="customer_parameters/"+con.getID()+".csv";
		getContentPane().add(panel);
		panel.setBounds(0, 0, 784, 562);
		panel.setLayout(null);
		panel.add(button);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.setBounds(650, 505, 120, 30);
		button.addActionListener(this);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		label.setBounds(160, 41, 567, 111);
		panel.add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setText(content);
		Update.eleLabel=label;
		lblNewLabel.setIcon(new ImageIcon("electri.jpg"));
		lblNewLabel.setBounds(172, 120, 446, 377);
		
		panel.add(lblNewLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content=viewEle();
			//pack();
		setVisible(true);
		Update.viewEle=true;
	}
	/**
	 * Get the consumer's electricity consumption and cost this month
	 * @return The string of the electricity consumption and cost information
	 */
	public String viewEle() {
		try {
			FileReader fileReader=new FileReader(filename);
			BufferedReader reader=new BufferedReader(fileReader);
			//System.out.println("success open");
			String line=null;
			String[] result=new String[10];
			int m=0;
			while ((line=reader.readLine())!=null){
				result=line.split(",");
				//System.out.println(m+":"+line);
				m++;
			}
			reader.close();
			if (m>2) {
				SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
				Date time=new Date();
				String date=df.format(time);
				if (result[0].equals(date)) {
					String str="<html><p>The electricity consumption today is "+result[1]+" kWh, </p><p>and the cost is "+result[2]+" pound.</p></html>";
					return str;
				} 
			}
			return "Today has no record.";		
		}catch(Exception ex){
			ex.printStackTrace();
			return "error";
		}
	}
	/**
	 * Define the interface will be closed and tranfer to consumer list interface
	 * when user clicks "Go back" button
	 */
	public void actionPerformed(ActionEvent event) {
		dispose();
		Update.viewEle=false;
		GUI window=new GUI(con);
		window.frame.setVisible(true);
	}
}

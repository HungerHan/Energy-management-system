/**
 * Title	: provFuncAddRemov.java
 * Description	: This is the GUI of provider adding and removing customer system.
 * @author	: Hao Hu
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
import LoginGUI.ProvAddCustBackButtonListener;
import LoginGUI.ProvAddCustConfirmButtonListener;
import LoginGUI.ProvRemovCustBackButtonListener;
import LoginGUI.ProvRemovCustConfirmButtonListener;
*/
import javax.swing.SwingConstants;

public class provFuncAddRemov {
	  public int textFieldLength = 20;
	  public LoginGUI aLoginGUI;
	  //Provider adds customer function screen
	  public JPanel provAddCustSloganPanel, provAddCustInputPanel, provAddCustConfirmPanel;
	  public JLabel provAddCustSlogan, provAddCustIDSlogan, provAddCustPasswordSlogan;
	  public JTextField provAddCustID, provAddCustPassword;
	  public JButton provAddCustConfirmButton, provAddCustBackButton;
	  public String provAddCustNewID, provAddCustNewPassword;

	  //Provider removes customer function screen
	  public JPanel provRemovCustSloganPanel, provRemovCustInputPanel, provRemovCustConfirmPanel;
	  public JLabel provRemovCustSlogan, provRemovCustIDSlogan, provRemovCustPasswordSlogan;
	  public JTextField provRemovCustID, provRemovCustPassword;
	  public JButton provRemovCustConfirmButton, provRemovCustBackButton;
	  public String provRemovCustInputID, provRemovCustInputPassword;

	  public provFuncAddRemov(){
		  aLoginGUI = new LoginGUI();
	  }
	  
		/**
	     *	This is the layout of the screen.
	     */
	  public void provAddCustLayout(){
	    provAddCustInputPanel = new JPanel(null);
	    aLoginGUI.f.getContentPane().add(provAddCustInputPanel);
	  }

		/**
	     *	These are the labels of the screen.
	     */
	  public void provAddCustSlogan(){
		  JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setIcon(new ImageIcon("header-logo-eps.jpg"));
			lblNewLabel_2.setBounds(0, 10, 784, 147);
			provAddCustInputPanel.add(lblNewLabel_2);
	    provAddCustSlogan = new JLabel("Add Customer Account");
	    provAddCustSlogan.setBounds(300, 190, 300, 20);
	    provAddCustSlogan.setFont(new Font("Arial", Font.BOLD, 18));
	    this.provAddCustInputPanel.add(this.provAddCustSlogan);
	  }
	  
		/**
	     *	These are the text fields of the screen.
	     */
	  public void provAddCustInput(){
	    provAddCustIDSlogan = new JLabel("Customer ID: ");
	    provAddCustPasswordSlogan = new JLabel("Customer password: ");
	    provAddCustID = new JTextField(textFieldLength);
	    provAddCustPassword = new JTextField(textFieldLength);
	    
	    // (50, 100, 80, 20); (50, 140, 80, 20);  (200, 100, 100, 20); (200, 140, 100, 20);
	    provAddCustIDSlogan.setBounds(210, 240, 200, 20);
	    provAddCustPasswordSlogan.setBounds(210, 280, 200, 20);
	    provAddCustID.setBounds(450, 240, 150, 20);
	    provAddCustPassword.setBounds(450, 280, 150, 20);
	    provAddCustIDSlogan.setFont(new Font("Arial", Font.BOLD, 18));
	    provAddCustPasswordSlogan.setFont(new Font("Arial", Font.BOLD, 18));
	    provAddCustID.setFont(new Font("Arial", Font.BOLD, 18));
	    provAddCustPassword.setFont(new Font("Arial", Font.BOLD, 18));

	    this.provAddCustInputPanel.add(this.provAddCustIDSlogan);
	    this.provAddCustInputPanel.add(this.provAddCustID);
	    this.provAddCustInputPanel.add(this.provAddCustPasswordSlogan);
	    this.provAddCustInputPanel.add(this.provAddCustPassword);
	  }

		/**
	     *	These are the buttons of the screen.
	     */
	  public void provAddCustConfirm(){
	    provAddCustConfirmButton = new JButton("Confirm");
	    provAddCustBackButton = new JButton("Back");

	    //(210, 190, 100, 20);  (70, 190, 100, 20);
	    provAddCustConfirmButton.setBounds(440, 350, 130, 30); 
	    provAddCustBackButton.setBounds(240, 350, 100, 30);
	    provAddCustConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));
	    provAddCustBackButton.setFont(new Font("Arial", Font.BOLD, 18));
	    
	    this.provAddCustInputPanel.add(provAddCustBackButton);
	    this.provAddCustInputPanel.add(provAddCustConfirmButton);

	    this.provAddCustConfirmButton.addActionListener(new ProvAddCustConfirmButtonListener());
	    this.provAddCustBackButton.addActionListener(new ProvAddCustBackButtonListener());
	  }

		/**
	     *	This is the way to delete this screen.
	     */
	  public void deleteProvAddCustScreen(){
	    provAddCustInputPanel.setVisible(false);
	  }

		/**
	     *	This is the listener of confirm button.
	     */
	  class ProvAddCustConfirmButtonListener implements ActionListener{
	    int provAddCustNewIDUnique;

	    public void actionPerformed(ActionEvent e){
	      provAddCustNewID = provAddCustID.getText();
	      provAddCustNewPassword = provAddCustPassword.getText();
	      
	      CustLoginFunc aCustLoginFunc = new CustLoginFunc();
	      provAddCustNewIDUnique = aCustLoginFunc.checkCustomerID(provAddCustNewID);

	      if(provAddCustNewIDUnique == 1){
	        System.out.println("Add customer.");
	        aCustLoginFunc.createCustomerAccount(provAddCustNewID, provAddCustNewPassword);
	        provAddCustSlogan.setText("Add Customer Account: Success!");
	        provAddCustSlogan.setForeground(Color.green);
	      }
	      else{
	        provAddCustSlogan.setText("Add Customer Account: Failed!");
	        provAddCustSlogan.setForeground(Color.red);
	        System.out.println("Add customer account failed. Customer new ID has already existed.");
	      }
	    }
	  }

		/**
	     *	This is the listener of back button.
	     */
	  class ProvAddCustBackButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	      System.out.println("Back");
	      deleteProvAddCustScreen();
	      aLoginGUI.provMenuScreenInit();
	    }
	  }
	  //---------------------------------------------------------------------------------

		/**
	     *	This is the layout of the screen.
	     */
	  public void provRemovCustLayout(){
	    provRemovCustInputPanel = new JPanel(null);
	    aLoginGUI.f.getContentPane().add(provRemovCustInputPanel);
	  }

		/**
	     *	These are the labels of the screen.
	     */
	  public void provRemovCustSlogan(){
		  JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setIcon(new ImageIcon("header-logo-eps.jpg"));
			lblNewLabel_2.setBounds(0, 10, 784, 147);
			provRemovCustInputPanel.add(lblNewLabel_2);
			
	    provRemovCustSlogan = new JLabel("Remove Customer");
	    provRemovCustSlogan.setBounds(320, 200, 300, 20);
	    provRemovCustSlogan.setFont(new Font("Arial", Font.BOLD, 18));
	    this.provRemovCustInputPanel.add(this.provRemovCustSlogan);
	  }

		/**
	     *	These are the text fields of the screen.
	     */
	  public void provRemovCustInput(){
	    provRemovCustIDSlogan = new JLabel("Customer ID: ");
	    provRemovCustID = new JTextField(textFieldLength);
	    
	    //(70, 130, 100, 20);   (210, 130, 100, 20); 
	    provRemovCustIDSlogan.setBounds(250, 250, 150, 20); 
	    provRemovCustID.setBounds(410, 250, 150, 20);
	    provRemovCustIDSlogan.setFont(new Font("Arial", Font.BOLD, 18));
	    provRemovCustID.setFont(new Font("Arial", Font.BOLD, 18));

	    this.provRemovCustInputPanel.add(this.provRemovCustIDSlogan);
	    this.provRemovCustInputPanel.add(this.provRemovCustID);
	  }

		/**
	     *	These are the buttons of the screen.
	     */
	  public void provRemovCustConfirm(){
	    provRemovCustConfirmButton = new JButton("Confirm");
	    provRemovCustBackButton = new JButton("Back");

	    // (210, 190, 100, 20);  (70, 190, 100, 20);
	    provRemovCustConfirmButton.setBounds(430, 320, 130, 30); 
	    provRemovCustBackButton.setBounds(250, 320, 100, 30);
	    provRemovCustConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));
	    provRemovCustBackButton.setFont(new Font("Arial", Font.BOLD, 18));
	    
	    this.provRemovCustInputPanel.add(this.provRemovCustBackButton);
	    this.provRemovCustInputPanel.add(this.provRemovCustConfirmButton);
	  
	    provRemovCustBackButton.addActionListener(new ProvRemovCustBackButtonListener());
	    provRemovCustConfirmButton.addActionListener(new ProvRemovCustConfirmButtonListener());
	  }

		/**
	     *	This is the way to delete this screen.
	     */
	  public void deleteProvRemovCustScreen(){
	    provRemovCustInputPanel.setVisible(false);
	  }

		/**
	     *	This is the listener of confirm button.
	     */
	  class ProvRemovCustConfirmButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	CustLoginFunc aCustLoginFunc = new CustLoginFunc();
	    	
	      System.out.println("Remove customer");
	      provRemovCustInputID = provRemovCustID.getText();
	      aCustLoginFunc.deleteCustomerAccount(provRemovCustInputID);
	      provRemovCustSlogan.setText("Romove Customer: Success!");
	      provRemovCustSlogan.setForeground(Color.green);
	    }
	  }

		/**
	     *	This is the listener of back button.
	     */
	  class ProvRemovCustBackButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	      System.out.println("Back");
	      deleteProvRemovCustScreen();
	      aLoginGUI.provMenuScreenInit();
	    }
	  }
	  //-------------------------------------------------------------------------------
	  
		/**
	     *	This is the initialization of adding customer screen.
	     */
	  public void provAddCustScreenInit(){
	    this.provAddCustLayout();
	    this.provAddCustSlogan();
	    this.provAddCustInput();
	    this.provAddCustConfirm();
	  }

		/**
	     *	This is the initialization of removing customer screen.
	     */
	  public void provRemovCustScreenInit(){
	    this.provRemovCustLayout();
	    this.provRemovCustSlogan();
	    this.provRemovCustInput();
	    this.provRemovCustConfirm();
	  }

}

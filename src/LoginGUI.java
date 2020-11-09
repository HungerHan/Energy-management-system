//package provider;
/**
 * Title	: LoginGUI.java
 * Description	: This is the GUI of provider and customer login system.
 * @author	: Hao Hu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI{
  public int window_width = 800;  //450
  public int window_height = 600;  //300
  public int textFieldLength = 20;
  public String provLoginFilePath, custLoginFilePath, custParamtPathPrefix;
  public JFrame f; 
  
  //welcome screen
  public JPanel welcomePanel, welcomeNextPanel;
  public JLabel welcomeLabel;
  public JButton welcomeNextButton;
  
  //user type selection screen
  public JPanel userTypeQuesPanel, userTypePanel, userTypeBackPanel;
  public JLabel userTypeQues;
  public JButton providerButton, customerButton, userTypeBackButton;
  public int isProvider; //0 is customer, 1 is provider

  //have account or not screen
  public JPanel accountOrNotQuesPanel, accountOrNotPanel, accountOrNotBackPanel;
  public JLabel accountOrNotQues;
  public JButton hasAccountButton, noAccountButton, accountOrNotBackButton;
  public int hasAccount; //0: no account, 1: has an account

  //Provider, no account screen
  public JPanel provRegstSloganPanel, provRegstInputPanel, provRegstNextPanel;
  public JLabel provRegstSlogan, provRegstIDSlogan, provRegstPasswordSlogan;
  public JTextField provRegstID, provRegstPassword;
  public JButton provRegstNextButton, provRegstBackButton;
  public String provNewID, provNewPassword;

  //Provider, has an account screen
  public JPanel provLoginInSloganPanel, provLoginInInputPanel, provLoginInNextPanel;
  public JLabel provLoginInSlogan, provLoginInIDSlogan, provLoginInPasswordSlogan;
  public JTextField provLoginInID, provLoginInPassword;
  public JButton provLoginInNextButton, provLoginInBackButton;
  public String provInputID, provInputPassword;

  //Customer, no account screen
  public JFrame custNoAcctFrame;
  public JPanel custNoAcctWarningPanel, custNoAcctNextPanel;
  public JLabel custNoAcctWarningLabel;
  public JButton custNoAcctNextButton;

  //Customer, has an account screen
  public JPanel custLoginInSloganPanel, custLoginInInputPanel, custLoginInNextPanel;
  public JLabel custLoginInSlogan, custLoginInIDSlogan, custLoginInPasswordSlogan;
  public JTextField custLoginInID, custLoginInPassword;
  public JButton custLoginInNextButton, custLoginInBackButton;
  public String custInputID, custInputPassword;

  //Provider main menu
  public JPanel provMenuPanel;
  public JButton[] provMenuFuncs;

  /*
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
*/
  
  
  public LoginGUI(){
	LoginAttribute aLoginAttribute = new LoginAttribute();
    this.provLoginFilePath = aLoginAttribute.provLoginFilePath;
    this.custLoginFilePath = aLoginAttribute.custLoginFilePath;
    this.custParamtPathPrefix = aLoginAttribute.custParamtPathPrefix;

    f = new JFrame();
    f.setTitle("Energy Manager");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //f.setSize(his.window_width, this.window_height);
    f.setBounds(100,100,this.window_width, this.window_height);
    f.setVisible(true);
    //f.pack();
  }

  //---------------------------------------------------------------
  //welcome screen
	/**
   *	This is the layout of the screen.
   */
  public void welcomeLayout(){
    welcomePanel = new JPanel(null);
    f.getContentPane().add(this.welcomePanel);
  }    

	/**
   *	These are the labels of the screen.
   */
  public void welcomeSlogan(){
    welcomeLabel = new JLabel("Welcome to Energy Provider!");
    welcomeLabel.setBounds(135, 70, 200, 20);
    this.welcomePanel.add(this.welcomeLabel);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void welcomeNextButton(){
    welcomeNextButton = new JButton("Next");
    welcomeNextButton.setBounds(165, 130, 100, 20);
    this.welcomePanel.add(this.welcomeNextButton);
    welcomeNextButton.addActionListener(new welcomeNextListener());
  }

	/**
   *	These are the buttons of the screen.
   */
  class welcomeNextListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Welcome screen next button pass");
      welcomePanel.setVisible(false);
      userTypeScreenInit();
    }
  }
  //--------------------------------------------------------------
  
  //user type selection screen
  public void userTypeLayout(){
    userTypePanel = new JPanel(null);
    f.getContentPane().add(userTypePanel);
  }

  public void userTypeQuestion(){
    userTypeQues = new JLabel("Are you a provider or customer?");
    userTypeQues.setBounds(300, 250, 200, 30);

    this.userTypePanel.add(this.userTypeQues);
  }
  
  //insert two buttons representing users are providers or customers.
  public void provAndCustButton(){
    providerButton = new JButton("Provider");
    customerButton = new JButton("Customer");
    userTypeBackButton = new JButton("Back");
    
    providerButton.setBounds(280, 300, 100, 30);
    customerButton.setBounds(410, 300, 100, 30);
    userTypeBackButton.setBounds(340, 300, 100, 30);
    
    this.userTypePanel.add(this.providerButton);
    this.userTypePanel.add(this.customerButton);
    this.userTypePanel.add(this.userTypeBackButton);
    
    providerButton.addActionListener(new providerButtonListener());
    customerButton.addActionListener(new customerButtonListener());
    userTypeBackButton.addActionListener(new userTypeBackButtonListener());
  }

  public void deleteUserTypeScreen(){
    userTypePanel.setVisible(false);
  }

  class providerButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Provider type selection button pass");
      isProvider = 1;
      deleteUserTypeScreen();
      accountOrNotScreenInit();
    }
  }

  class customerButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Customer type selection button pass");
      isProvider = 0;
      deleteUserTypeScreen();
      accountOrNotScreenInit();
    }
  }    
 
  class userTypeBackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Back");
      deleteUserTypeScreen();
      welcomeScreenInit();
    }
  }
      
  //--------------------------------------------------------------------------------

	/**
   *	This is the layout of the screen.
   */
  public void accountOrNotLayout(){
    accountOrNotPanel = new JPanel(null);
    f.getContentPane().add(accountOrNotPanel);
  }

	/**
   *	These are the labels of the screen.
   */
  public void accountOrNotQues(){
	  JLabel lblNewLabel_2 = new JLabel("");
	  lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	  lblNewLabel_2.setIcon(new ImageIcon("header-logo-eps.jpg"));
	  lblNewLabel_2.setBounds(0, 10, 784, 147);
	  this.accountOrNotPanel.add(lblNewLabel_2);
	  
    accountOrNotQues = new JLabel("Do you have an account?");
    accountOrNotQues.setBounds(250, 200, 300, 30);
    accountOrNotQues.setHorizontalAlignment(SwingConstants.CENTER);
    accountOrNotQues.setFont(new Font("Arial", Font.BOLD, 24));
    this.accountOrNotPanel.add(this.accountOrNotQues);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void accountOrNotButton(){
    hasAccountButton = new JButton("Yes");
    noAccountButton = new JButton("No");
    accountOrNotBackButton = new JButton("Back");
    
    hasAccountButton.setBounds(270, 300, 100, 30);   //(70, 130, 100, 20);   (210, 130, 100, 20); (140, 190, 100, 20);
    noAccountButton.setBounds(410, 300, 100, 30);
    accountOrNotBackButton.setBounds(340, 450, 100, 30);
    hasAccountButton.setFont(new Font("Arial", Font.BOLD, 18));
    noAccountButton.setFont(new Font("Arial", Font.BOLD, 18));
    accountOrNotBackButton.setFont(new Font("Arial", Font.BOLD, 18));

    this.accountOrNotPanel.add(hasAccountButton);
    this.accountOrNotPanel.add(noAccountButton);
    this.accountOrNotPanel.add(accountOrNotBackButton);

    hasAccountButton.addActionListener(new hasAccountButtonListener());
    noAccountButton.addActionListener(new noAccountButtonListener());
    accountOrNotBackButton.addActionListener(new accountOrNotBackButtonListener());
  }

	/**
   *	This is the way to delete this screen.
   */
  public void deleteAccountOrNotScreen(){
    accountOrNotPanel.setVisible(false);
  }

	/**
   *	This is the listener of having account button.
   */
  class hasAccountButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Yes, I have an account.");
      hasAccount = 1;

      if(isProvider == 1){
        System.out.println("Provider, has account.");
        deleteAccountOrNotScreen();
        provLoginInScreenInit();
      }
      else{
        System.out.println("Customer, has account.");
        deleteAccountOrNotScreen();
        custLoginInScreenInit();
      }
    }
  }

	/**
   *	This is the listener of having no account button.
   */
  class noAccountButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("No, I do not have an account.");
      hasAccount = 0;

      if(isProvider == 1){
        System.out.println("Provider, no account.");
        deleteAccountOrNotScreen();
        provRegstScreenInit();
      }
      else{
        System.out.println("Customer, no account.");
        custNoAcctScreenInit();
      }
    }
  }
  
	/**
   *	This is the listener of back button.
   */
  class accountOrNotBackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Back");
      deleteAccountOrNotScreen();
      //userTypeScreenInit();
		f.dispose();
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
  }
  //---------------------------------------------------------------------

	/**
   *	This is the layout of the screen.
   */
  public void provRegstLayout(){
    provRegstInputPanel = new JPanel(null);
    f.getContentPane().add(provRegstInputPanel);
  }

	/**
   *	These are the labels of the screen.
   */
  public void provRegstSlogan(){
    provRegstSlogan = new JLabel("PROVIDER REGISTRATION: Please enter your ID and password");
    provRegstSlogan.setBounds(150, 190, 600, 20);
    provRegstSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    this.provRegstInputPanel.add(this.provRegstSlogan);
  }

	/**
   *	These are the text fields of the screen.
   */
  public void provRegstInput(){
    provRegstIDSlogan = new JLabel("ID: ");
    provRegstPasswordSlogan = new JLabel("Password: ");
    provRegstID = new JTextField(textFieldLength);
    provRegstPassword = new JTextField(textFieldLength);
    
    provRegstIDSlogan.setBounds(280, 240, 130, 20);
    provRegstPasswordSlogan.setBounds(280, 280, 130, 20);
    provRegstID.setBounds(400, 240, 130, 20);
    provRegstPassword.setBounds(400, 280, 130, 20);
    provRegstIDSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    provRegstPasswordSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    provRegstID.setFont(new Font("Arial", Font.BOLD, 18));
    provRegstPassword.setFont(new Font("Arial", Font.BOLD, 18));

    this.provRegstInputPanel.add(this.provRegstIDSlogan);
    this.provRegstInputPanel.add(this.provRegstID);
    this.provRegstInputPanel.add(this.provRegstPasswordSlogan);
    this.provRegstInputPanel.add(this.provRegstPassword);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void provRegstNextButton(){
    provRegstNextButton = new JButton("Next");
    provRegstBackButton = new JButton("Back");
    
    provRegstNextButton.setBounds(440, 350, 150, 30);   // (210, 190, 100, 20);  (70, 190, 100, 20);
    provRegstBackButton.setBounds(230, 350, 150, 30);
    provRegstNextButton.setFont(new Font("Arial", Font.BOLD, 18));
    provRegstBackButton.setFont(new Font("Arial", Font.BOLD, 18));

    this.provRegstInputPanel.add(this.provRegstBackButton);
    this.provRegstInputPanel.add(this.provRegstNextButton);

    provRegstNextButton.addActionListener(new provRegstNextButtonListener());
    provRegstBackButton.addActionListener(new provRegstBackButtonListener());
  }

	/**
   *	This is the way to delete this screen.
   */
  public void deleteProvRegstScreen(){
    provRegstInputPanel.setVisible(false);
  }

	/**
   *	This is the listener of next button.
   */
  class provRegstNextButtonListener implements ActionListener{
    int provNewIDUnique;

    public void actionPerformed(ActionEvent e){
      provNewID = provRegstID.getText();
      provNewPassword = provRegstPassword.getText();
      ProvLoginFunc aProvLoginFunc = new ProvLoginFunc();
      provNewIDUnique = aProvLoginFunc.checkProviderID(provNewID);
 
      if(provNewIDUnique == 1){
        aProvLoginFunc.createProviderAccount(provNewID, provNewPassword);
        deleteProvRegstScreen();
        provMenuScreenInit();
        System.out.println("Successful provider registration.");
        System.out.println("Enter provider main menu.");
      }
      else{
        provRegstSlogan.setText("PROVIDER REGISTRATION: Failed!\nProvider ID " + provNewID + " has already existed.");
        provRegstSlogan.setForeground(Color.red);
        System.out.println("Registration failed. Provider new ID has already existed.");
      }
    }
  }

	/**
   *	This is the listener of back button.
   */
  class provRegstBackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Back");
      deleteProvRegstScreen();
      accountOrNotScreenInit();

    }
  }
  //--------------------------------------------------------------------------------
    
	/**
   *	This is the layout of the screen.
   */
  public void provLoginInLayout(){
    provLoginInInputPanel = new JPanel(null);
    f.getContentPane().add(provLoginInInputPanel);
  }

	/**
   *	These are the labels of the screen.
   */
  public void provLoginInSlogan(){
	  	JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("header-logo-eps.jpg"));
		lblNewLabel_3.setBounds(0, 10, 784, 147);
		this.provLoginInInputPanel.add(lblNewLabel_3);
		
    provLoginInSlogan = new JLabel("PROVIDER LOGIN: Please enter your ID and password ");
    provLoginInSlogan.setBounds(170, 220, 500, 20);
    provLoginInSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    this.provLoginInInputPanel.add(this.provLoginInSlogan);
  }

	/**
   *	These are the text fields of the screen.
   */
  public void provLoginInInput(){
    provLoginInIDSlogan = new JLabel("ID: ");
    provLoginInPasswordSlogan = new JLabel("Password: ");
    provLoginInID = new JTextField(textFieldLength);
    provLoginInPassword = new JTextField(textFieldLength);
    
    provLoginInIDSlogan.setBounds(280, 280, 130, 20);  
    provLoginInPasswordSlogan.setBounds(280, 340, 130, 20);
    provLoginInID.setBounds(400, 280, 100, 20);
    provLoginInPassword.setBounds(400, 340, 100, 20);
    provLoginInIDSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    provLoginInPasswordSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    provLoginInID.setFont(new Font("Arial", Font.BOLD, 18));
    provLoginInPassword.setFont(new Font("Arial", Font.BOLD, 18));

    this.provLoginInInputPanel.add(provLoginInIDSlogan);
    this.provLoginInInputPanel.add(provLoginInID);
    this.provLoginInInputPanel.add(provLoginInPasswordSlogan);
    this.provLoginInInputPanel.add(provLoginInPassword);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void provLoginInNext(){
    provLoginInNextButton = new JButton("Next");
    provLoginInBackButton = new JButton("Back");
    
    provLoginInNextButton.setBounds(440, 480, 150, 30);  //(210, 190, 100, 20);  (70, 190, 100, 20);
    provLoginInBackButton.setBounds(230, 480, 150, 30);
    provLoginInNextButton.setFont(new Font("Arial", Font.BOLD, 18));
    provLoginInBackButton.setFont(new Font("Arial", Font.BOLD, 18));

    this.provLoginInInputPanel.add(this.provLoginInBackButton);
    this.provLoginInInputPanel.add(this.provLoginInNextButton);

    this.provLoginInNextButton.addActionListener(new provLoginInNextButtonListener());
    this.provLoginInBackButton.addActionListener(new provLoginInBackButtonListener());
  }

	/**
   *	This is the way to delete this screen.
   */
  public void deleteProvLoginInScreen(){
    provLoginInInputPanel.setVisible(false);
  }
  
	/**
   *	This is the listener of next button.
   */
  class provLoginInNextButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      int provToken = 0;
      ProvLoginFunc aProvLoginFunc = new ProvLoginFunc();

      provInputID = provLoginInID.getText();
      provInputPassword = provLoginInPassword.getText();
      //System.out.println("Provider input ID: " + this.provInputID);
      //System.out.println("Provider input password: " + this.provInputPassword);
      provToken = aProvLoginFunc.verifyProviderAccount(provInputID, provInputPassword);

      if(provToken == 1){
        deleteProvLoginInScreen();
        provMenuScreenInit();
        System.out.println("Enter provider main menu.");
      }
      else{
        System.out.println("Provider logins failed.");
        provLoginInSlogan.setText("PROVIDER LOGIN: Login failed.");
        provLoginInSlogan.setForeground(Color.red);
      }
      //System.out.println("Input ID: " + provInputID);
      //System.out.println("Input password: " + provInputPassword);
      //System.out.println("Provider login in successfully!");
    }
  }

	/**
   *	This is the listener of back button.
   */
  class provLoginInBackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Back");
      deleteProvLoginInScreen();
      accountOrNotScreenInit();
    }
  }
  //-----------------------------------------------------------------------------

	/**
   *	This is the layout of the screen.
   */
  public void custNoAcctLayout(){
    custNoAcctFrame = new JFrame();
    custNoAcctFrame.setTitle("Customer Registration Notice");
    //custNoAcctFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    custNoAcctFrame.setBounds(400,400,450,80);
    custNoAcctFrame.setVisible(true);

    custNoAcctWarningPanel = new JPanel();
    custNoAcctNextPanel = new JPanel();

    custNoAcctFrame.getContentPane().setLayout(new BorderLayout(10,10));
    custNoAcctFrame.getContentPane().add(custNoAcctWarningPanel, BorderLayout.NORTH);
    custNoAcctFrame.getContentPane().add(custNoAcctNextPanel, BorderLayout.SOUTH);
  }

	/**
   *	These are the labels of the screen.
   */
  public void custNoAcctWarning(){
    custNoAcctWarningLabel = new JLabel("Warning: No Authority! Please contact with the administrators.");
    this.custNoAcctWarningPanel.add(this.custNoAcctWarningLabel);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void custNoAcctNext(){
    custNoAcctNextButton = new JButton("Next");
    //this.custNoAcctNextPanel.add(this.custNoAcctNextButton);

    //custNoAcctNextButton.addActionListener(new CustNoAcctNextButtonListener());
  }

	/**
   *	This is the way to delete this screen.
   */
  public void deleteCustNoAcctScreen(){
    this.custNoAcctWarningPanel.setVisible(false);
    this.custNoAcctNextPanel.setVisible(false);
  }

	/**
   *	This is the listener of next button.
   */
  class CustNoAcctNextButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Next");
      custNoAcctFrame.dispose();
      accountOrNotScreenInit();
    }
  }
  //----------------------------------------------------------------------------- 

	/**
   *	This is the layout of the screen.
   */
  public void custLoginInLayout(){
    custLoginInInputPanel = new JPanel(null);
    f.getContentPane().add(custLoginInInputPanel);
  }

	/**
   *	These are the labels of the screen.
   */
  public void custLoginInSlogan(){
	  JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("header-logo-eps.jpg"));
		lblNewLabel_4.setBounds(0, 10, 784, 147);
		this.custLoginInInputPanel.add(lblNewLabel_4);
	  
    custLoginInSlogan = new JLabel("CUSTOMER LOGIN: Please enter your ID and password");
    custLoginInSlogan.setBounds(180, 190, 500, 20);
    custLoginInSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    this.custLoginInInputPanel.add(custLoginInSlogan);
  }

	/**
   *	These are the text fields of the screen.
   */
  public void custLoginInInput(){
    custLoginInIDSlogan = new JLabel("ID: ");
    custLoginInPasswordSlogan = new JLabel("Password: ");
    custLoginInID = new JTextField(textFieldLength);
    custLoginInPassword = new JTextField(textFieldLength);
    
    custLoginInIDSlogan.setBounds(280, 280, 130, 20);
    custLoginInPasswordSlogan.setBounds(280, 340, 130, 20);
    custLoginInID.setBounds(400, 280, 150, 20);
    custLoginInPassword.setBounds(400, 340, 150, 20);
    custLoginInIDSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    custLoginInPasswordSlogan.setFont(new Font("Arial", Font.BOLD, 18));
    custLoginInID.setFont(new Font("Arial", Font.BOLD, 18));
    custLoginInPassword.setFont(new Font("Arial", Font.BOLD, 18));

    this.custLoginInInputPanel.add(this.custLoginInIDSlogan);
    this.custLoginInInputPanel.add(this.custLoginInID);
    this.custLoginInInputPanel.add(this.custLoginInPasswordSlogan);
    this.custLoginInInputPanel.add(this.custLoginInPassword);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void custLoginInNext(){
    custLoginInNextButton = new JButton("Next");
    custLoginInBackButton = new JButton("Back");
    
    custLoginInNextButton.setBounds(440, 480, 150, 30);
    custLoginInBackButton.setBounds(230, 480, 150, 30);
    custLoginInNextButton.setFont(new Font("Arial", Font.BOLD, 18));
    custLoginInBackButton.setFont(new Font("Arial", Font.BOLD, 18));
    

    this.custLoginInInputPanel.add(this.custLoginInBackButton);
    this.custLoginInInputPanel.add(this.custLoginInNextButton);

    this.custLoginInNextButton.addActionListener(new CustLoginInNextButtonListener());
    this.custLoginInBackButton.addActionListener(new CustLoginInBackButtonListener());
  }

	/**
   *	This is the way to delete this screen.
   */
  public void deleteCustLoginInScreen(){
    custLoginInInputPanel.setVisible(false);
  }

	/**
   *	This is the listener of next button.
   */
  class CustLoginInNextButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      int custToken = 0;      
      CustLoginFunc aCustLoginFunc = new CustLoginFunc();

      custInputID = custLoginInID.getText();
      custInputPassword = custLoginInPassword.getText();
      custToken = aCustLoginFunc.verifyCustomerAccount(custInputID, custInputPassword);

      if(custToken == 1){
		//deleteCustLoginInScreen();
        //screen
        System.out.println("Enter customer main menu.");
		f.dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consumer a=new Consumer(custInputID,custInputPassword);
					Electricity.co=a;
					Gas.co=a;
					GUI window = new GUI(a);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
      }
      else{
        System.out.println("Customer logins failed.");
        custLoginInSlogan.setText("CUSTOMER LOGIN: Login failed.");
        custLoginInSlogan.setForeground(Color.red);
      }
    }
  }

	/**
   *	This is the listener of back button.
   */
  class CustLoginInBackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Back");
      deleteCustLoginInScreen();
      accountOrNotScreenInit();
    }
  }
  //-----------------------------------------------------------------------------------

	/**
   *	This is the layout of the screen.
   */
  public void provMenuLayout(){
    provMenuPanel = new JPanel(null);
    f.getContentPane().add(provMenuPanel);
  }

	/**
   *	These are the buttons of the screen.
   */
  public void provMenuFunctions(){
	int k=150;
	
	JLabel label = new JLabel("");
	label.setVerticalAlignment(SwingConstants.CENTER);
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setIcon(new ImageIcon("manager.jpg"));
	label.setBounds(135, 10, 534, 119);
	this.provMenuPanel.add(label);
	
    provMenuFuncs = new JButton[7];
    provMenuFuncs[0] = new JButton("Add customer");
    provMenuFuncs[1] = new JButton("Remove customer");
    provMenuFuncs[2] = new JButton("View all customers");
    provMenuFuncs[3] = new JButton("View customers' data");
    provMenuFuncs[4] = new JButton("View customers' costs");
    provMenuFuncs[5] = new JButton("Check tarrif");
    provMenuFuncs[6] = new JButton("Log out");

    for(int i=0; i<7; i++){
      provMenuFuncs[i].setBounds(240, k, 350, 40);
      provMenuFuncs[i].setFont(new Font("Arial", Font.BOLD, 20));
      this.provMenuPanel.add(provMenuFuncs[i]);
      k += 50;
    }

    this.provMenuFuncs[0].addActionListener(new provMenuFuncs0ButtonListener());
    this.provMenuFuncs[1].addActionListener(new provMenuFuncs1ButtonListener());
    this.provMenuFuncs[2].addActionListener(new provMenuFuncs2ButtonListener());
    this.provMenuFuncs[3].addActionListener(new provMenuFuncs3ButtonListener());
    this.provMenuFuncs[4].addActionListener(new provMenuFuncs4ButtonListener());
    this.provMenuFuncs[5].addActionListener(new provMenuFuncs5ButtonListener());
    this.provMenuFuncs[6].addActionListener(new provMenuFuncs6ButtonListener());
  }

	/**
   *	This is the way to delete this screen.
   */
  public void deleteProvMenuScreen(){
    provMenuPanel.setVisible(false);
  }

	/**
   *	This is the listener of adding customer button.
   */
  class provMenuFuncs0ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Add customer function");
      f.dispose();
      deleteProvMenuScreen();
      
      provFuncAddRemov aProvFuncAddRemov = new provFuncAddRemov();
      aProvFuncAddRemov.provAddCustScreenInit();
    }
  }

	/**
   *	This is the listener of removing customer button.
   */
  class provMenuFuncs1ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Remove customer function");
      f.dispose();
      deleteProvMenuScreen();
      
      provFuncAddRemov aProvFuncAddRemov = new provFuncAddRemov();
      aProvFuncAddRemov.provRemovCustScreenInit();
    }
  }
  
	/**
   *	This is the listener of viewing all customer button.
   */
  class provMenuFuncs2ButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	      System.out.println("View all customer");
	      //deleteProvMenuScreen();
	      f.dispose();
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
	  }
  
	/**
   *	This is the listener of viewing customers' data button.
   */
  class provMenuFuncs3ButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	      System.out.println("View customer's data");
	      //deleteProvMenuScreen();
	      f.dispose();
	      EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DataF window = new DataF();
						window.frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
          //
	    }
	  }
  
	/**
   *	This is the listener of viewing customer's data button.
   */
  class provMenuFuncs4ButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	      System.out.println("View customer's cost");
	      //deleteProvMenuScreen();
	      //provRemovCustScreenInit();
	      f.dispose();
	      EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						BillF window = new BillF();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    }
	  }
 
	/**
   *	This is the listener of checking tariff button.
   */
  class provMenuFuncs5ButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e){
	     System.out.println("Check tarrif");
	      //deleteProvMenuScreen();
	      //provRemovCustScreenInit();
	      f.dispose();
	      Tarrif tarrif=new Tarrif();
	      //tarrif.frame.setVisible(true);
	      //
	    }
	  }

	/**
   *	This is the listener of back button.
   */
  class provMenuFuncs6ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.out.println("Back");
      deleteProvMenuScreen();
      //welcomeScreenInit();
		f.dispose();
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
  }

  public void welcomeScreenInit(){
    this.welcomeLayout();
    this.welcomeSlogan();
    this.welcomeNextButton();
	f.validate();  
	f.repaint(); 
  }
  
  public void userTypeScreenInit(){
    this.userTypeLayout();
    this.userTypeQuestion();
    this.provAndCustButton();
  }

	/**
   *	This is the initialization of having account or not screen.
   */
  public void accountOrNotScreenInit(){
    this.accountOrNotLayout();
    this.accountOrNotQues();
    this.accountOrNotButton();
  }

	/**
   *	This is the initialization of provider registration screen.
   */
  public void provRegstScreenInit(){
    this.provRegstLayout();
    this.provRegstSlogan();
    this.provRegstInput();
    this.provRegstNextButton();
  }

	/**
   *	This is the initialization of provider login screen.
   */
  public void provLoginInScreenInit(){
    this.provLoginInLayout();
    this.provLoginInSlogan();
    this.provLoginInInput();
    this.provLoginInNext();
  }

	/**
   *	This is the initialization of customer registration screen.
   */
  public void custNoAcctScreenInit(){
    this.custNoAcctLayout();
    this.custNoAcctWarning();
    this.custNoAcctNext();
  }

	/**
   *	This is the initialization of customer login screen.
   */
  public void custLoginInScreenInit(){
    this.custLoginInLayout();
    this.custLoginInSlogan();
    this.custLoginInInput();
    this.custLoginInNext();
  }

	/**
   *	This is the initialization of provider main menu screen.
   */
  public void provMenuScreenInit(){
    this.provMenuLayout();
    this.provMenuFunctions();
  }
/*
  public static void main(String args[]){
    LoginGUI loginInGui = new LoginGUI();
    loginInGui.welcomeScreenInit();
  }*/
}
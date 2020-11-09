/**
 * Title	: LoginGUI.java
 * Description	: This is the class about customer login.
 * @author	: Hao Hu
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustLoginFunc {
	public String provLoginFilePath, custLoginFilePath, custParamtPathPrefix;
	
	public CustLoginFunc(){
		LoginAttribute aLoginAttribute = new LoginAttribute();
	    this.provLoginFilePath = aLoginAttribute.provLoginFilePath;
	    this.custLoginFilePath = aLoginAttribute.custLoginFilePath;
	    this.custParamtPathPrefix = aLoginAttribute.custParamtPathPrefix;
	}
	
	/**
     *	This is the method for customer login.
     */
	  public int verifyCustomerAccount(String custInputID, String custInputPassword){
	    int customer_token = 0;

	    try{
	      String str = " ";
	      String[] list1;
				
	      FileInputStream fis = new FileInputStream(this.custLoginFilePath);
	      InputStreamReader isr = new InputStreamReader(fis);
	      BufferedReader bw = new BufferedReader(isr);

	      while((str=bw.readLine()) != null){
	        list1 = str.split(",");
	 
	        if(list1[0].equals(custInputID) && list1[1].equals(custInputPassword)){
	          System.out.println("\nCustomer " + custInputID + " logins successfully!\n");
	          customer_token = 1;
	        }
	      }
				
	      bw.close();
	      isr.close();
	      fis.close();
	    }
	    catch(FileNotFoundException e){
	      System.out.println("Can not find the file.\n");
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
			
	    return customer_token;
	  }


		/**
	     *	This is the method for customer opening accounts.
	     */
	  public void createCustomerAccount(String provAddCustNewID, String provAddCustNewPassword){
	    String customer_parameter_path = custParamtPathPrefix + provAddCustNewID + ".csv";
			
	    File customer_create = new File(custLoginFilePath);
	    File customer_parameter_csv = new File(customer_parameter_path);
			
	    try{
	      FileWriter fw = new FileWriter(customer_create, true);
	      FileWriter fw2 = new FileWriter(customer_parameter_csv);
	      BufferedWriter bw = new BufferedWriter(fw);
	      BufferedWriter bw2 = new BufferedWriter(fw2);
	      SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
	      String date=df.format(new Date());
	      bw.write(provAddCustNewID + "," + provAddCustNewPassword);
	      bw.newLine();
	      bw2.write("budget,0,0\n");
	      //bw2.newLine();
	      bw2.write("Date,Electricity consumption(kWh),Electricity cost(¡ê),Gas consumption(kWh),Gas cost(¡ê)\n");

	      bw2.write(date+",0,0,0,0\n");

	      bw.flush();
	      bw2.flush();
	      bw.close();
	      bw2.close();
	      fw.close();
	      fw2.close();

	      System.out.println("\nCreating customer account " + provAddCustNewID + " successfully!");
	      System.out.println("Creating customer parameters CSV file: " + provAddCustNewID + ".csv successfully!\n");
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
	  }

		/**
	     *	This is the method to check whether the customer ID exists or not during registration.
	     */
	  public int checkCustomerID(String provAddCustNewID){
	    int customer_ID_token = 1;
	    String str = " ";

	    try{
	      FileInputStream fis = new FileInputStream(this.custLoginFilePath);
	      InputStreamReader isr = new InputStreamReader(fis);
	      BufferedReader br = new BufferedReader(isr);

	      while((str=br.readLine())!=null){
	        if((str.split(",")[0].equals(provAddCustNewID))){
	          customer_ID_token = 0;
	        }
	      }
	      br.close();
	      isr.close();
	      fis.close();
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
	    return customer_ID_token;
	  }


		/**
	     *	This is the method for providers deleting specific customers.
	     */
	  public void deleteCustomerAccount(String provRemovCustInputID){
	    String str = " ";
	    String str_all = "";
			
	    try{
	      FileInputStream fis = new FileInputStream(this.custLoginFilePath);
	      InputStreamReader isr = new InputStreamReader(fis);
	      BufferedReader br = new BufferedReader(isr);
				
	      while((str=br.readLine()) != null){
	        if((str.split(",")[0]).equals(provRemovCustInputID)){
	        }
	        else
	          str_all = str_all + str + "\n";
	      }
	      //System.out.println("\n" + str_all);
				
	      br.close();
	      isr.close();
	      fis.close();
	    }
	    catch(FileNotFoundException e){
	      System.out.println("Can not find the file: " + this.custLoginFilePath + "\n");
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }

	    try{
	      File modified_customer_login_file = new File(this.custLoginFilePath);
	      FileWriter fw = new FileWriter(modified_customer_login_file);
	      BufferedWriter bw = new BufferedWriter(fw);

	      bw.write(str_all);
	      //bw.newLine();

	      bw.flush();
	      bw.close();
	      fw.close();
				
	      System.out.println("\n...Deleting the customer account " + provRemovCustInputID + " successfully!");
	    }
	    catch(FileNotFoundException e){
	      System.out.println("Can not find the file: " + this.custLoginFilePath);
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
			
	    String customer_parameter_path = custParamtPathPrefix + provRemovCustInputID + ".csv";
	      File deleted_file = new File(customer_parameter_path);

	      if(!deleted_file.exists()){
	      //  throw new FileNotFoundException();
	        System.out.println("File not found.");
	      }
	      else{
	        deleted_file.delete();
	        System.out.println("Delete the customer data file " + provRemovCustInputID + ".csv successfully!\n");
	      }  
	  }
}

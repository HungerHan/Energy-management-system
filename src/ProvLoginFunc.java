/**
 * Title	: LoginGUI.java
 * Description	: This is the class about provider login.
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

public class ProvLoginFunc {
	public String provLoginFilePath, custLoginFilePath, custParamtPathPrefix;
	
	public ProvLoginFunc(){
		LoginAttribute aLoginAttribute = new LoginAttribute();
	    this.provLoginFilePath = aLoginAttribute.provLoginFilePath;
	    this.custLoginFilePath = aLoginAttribute.custLoginFilePath;
	    this.custParamtPathPrefix = aLoginAttribute.custParamtPathPrefix;
	}
	
	/**
     *	This opens the accounts for providers.
     */
	  public void createProviderAccount(String provNewID, String provNewPassword){
	    File provider_create = new File(this.provLoginFilePath);
	    try{
	      FileWriter fw = new FileWriter(provider_create, true);
	      BufferedWriter bw = new BufferedWriter(fw);
				
	      bw.write(provNewID + "," + provNewPassword);
	      bw.newLine();

	      bw.flush();
	      bw.close();
	      fw.close();
	 
	      System.out.println("Open file successfully!");
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
	  }

		/**
	     *	This is the method to check whether the provider ID exists or not during registration.
	     */
	  public int checkProviderID(String provNewID){
	    int provider_ID_token = 1;
	    String str = " ";

	    try{
	      FileInputStream fis = new FileInputStream(this.provLoginFilePath);
	      InputStreamReader isr = new InputStreamReader(fis);
	      BufferedReader br = new BufferedReader(isr);

	      while((str=br.readLine())!=null){
	        if((str.split(",")[0].equals(provNewID))){
	          provider_ID_token = 0;
	        }
	      }
	      br.close();
	      isr.close();
	      fis.close();
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }

	    return provider_ID_token;
	  }

	 
		/**
	     *	This is the method for provider login.
	     */
	  public int verifyProviderAccount(String provInputID, String provInputPassword){
	    int provider_token = 0;		

	    try{
	      String str = " ";
	      String[] list;

	      FileInputStream fis = new FileInputStream(this.provLoginFilePath);
	      InputStreamReader isr = new InputStreamReader(fis);
	      BufferedReader br = new BufferedReader(isr);

	      while((str = br.readLine()) != null){
	        list = str.split(",");
				
	        if(list[0].equals(provInputID) && list[1].equals(provInputPassword)){
	          System.out.println("\nAdministrator " + provInputID + " logins successfully!\n");	
	          provider_token = 1;
	        }
	      }

	      br.close();
	      isr.close();			
	      fis.close();
	    }
	    catch(FileNotFoundException e){
	      System.out.println("Can not find the file.\n");
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
			
	    return provider_token;
	  }
}

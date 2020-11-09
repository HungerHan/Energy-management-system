import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The class to get the data of given 
 * customer name and date
 * @author Zihan Zhang
 * @version 4.1 2018.5.31
 */
public class ViewData {
	String fileName;
	String userName;
	String date;
	String contents;
	boolean f=false;
	
	
	/**
	 * Get one line data of given userName and given date in user data files
	 * @param userName The user name of the data
	 * @param date The date of data want to view
	 * @return content The data of the required line
	 */
	public String checkData(String userName,String date)
	{
		
	 BufferedReader reader = null;
	 fileName="customer_parameters/"+userName+".csv";
	 File file = new File(fileName); 
	 try
		{
	    	reader=new BufferedReader(new FileReader(file));
	    	
	    	while((contents=reader.readLine()) != null)
	    	{
	    		while((contents.indexOf(date)) >-1)
	    		{
	    			/*System.out.print("\nThe data of user ");
	    			System.out.print(userName);
	    			System.out.print(" on ");
	    			System.out.print(date);
	    			System.out.println(" is: ");
	    			System.out.println("  Date  |Elec Consume|ELec Cost|Gas Consume|Gas Cost");
	    			System.out.println(contents+"\n");*/
	    			f=true;
	    			break;
	    		}
	    		if(f==true)
	    			break;
	    		
	    	}
	    	
	    	reader.close();	
	    	return contents;
		}catch(IOException e)
	    {
			System.out.println("NO*******************************!");
			e.printStackTrace();
			return "NO";
	    }finally
	    {
	    	if(reader!=null)
	    	{
	    		try
	    		{
	    			reader.close();
	    		}
	    		catch(IOException e1) {
	    			System.out.println("NO *******************************!");
	    			return "NO";
	    		}
	    	}
	    }

	//return contents;
	}
	
	

}

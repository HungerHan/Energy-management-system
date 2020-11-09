import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The class to get the month bill
 * @author Zihan Zhang
 * @version 3.1 2018.5.31
 */
public class Meter {
	String date;
	String monthDate;
	boolean g=false;
	String bill;
	String fileName;
	String eBill;
	String gBill;
	//String[] sBill;
	
	/*
	 * Method meterRead(): get the monthly bill (gas bill & elec bill)
	 * 						of given userName ,year and month
	 * File: meterreading.csv
	 * @: userName, date
	 * return: print these two data elements on screen
	 */
	/**
	 * Get the monthly bill (gas bill & elec bill)
	 * of given userName ,year and month
	 * @param MuserName The user name
	 * @param year The year of the wanted bill
	 * @param month The month of wanted bill
	 * @return bill The content of the required bill
	 */
	public String meterRead(String MuserName, String year, String month)
	{
		
		BufferedReader reader = null;
		fileName="meterreading.csv";
		File file = new File(fileName);
		
		
		//convert the month input
		switch(month)
		{
			case "January": monthDate=".1.31"; break;
			case "February": monthDate=".2.28"; break;
			case "March": monthDate=".3.31"; break;
			case "April": monthDate=".4.30"; break;
			case "May": monthDate=".5.31"; break;
			case "June": monthDate=".6.30"; break;
			case "July": monthDate=".7.31"; break;
			case "August": monthDate=".8.31"; break;
			case "September": monthDate=".9.30"; break;
			case "October": monthDate=".10.31"; break;
			case "November": monthDate=".11.30"; break;
			case "December": monthDate=".12.31"; break;
			default: monthDate="NULL";
		}
		date=year+monthDate;
		try
		{
			reader=new BufferedReader(new FileReader(file));
			while((bill=reader.readLine()) != null)
	    	{
				
				String Str[]=bill.split ("\\,");//split the every list of string in one line into
												//several string by " , "
	
	    		while( (Str[0].equals(MuserName)) && (Str[1].equals(date)))
	    		{
	    			
	    			eBill=Str[3];
	    			gBill=Str[5];

	    			System.out.print("The bill of the user ");
	   				System.out.print(MuserName);
	    			System.out.print(" on ");
	    			System.out.print(year+" "+month);
	    			System.out.print(" is: Electricity bill ");
	    			System.out.print(eBill);
	    			System.out.print("| Gas bill ");
	    			System.out.println(gBill+"\n");
	    			//sBill[0]=eBill;
	    			//sBill[1]=gBill;
	    			//System.out.println(sBill[0]+"****");
	    			g=true;
	    			break;
	    		}
	    		if(g==true)
	    			break;
	    		return "NO";
	    	}
			reader.close();
			return bill;
		}catch(IOException e)
	    {
			e.printStackTrace();
	    }finally
	    {
	    	if(reader!=null)
	    	{
	    		try
	    		{
	    			reader.close();
	    		}
	    		catch(IOException e1) {
	    			return "NO";
	    		}
	    	}
	    }
    	return bill;
	}

}

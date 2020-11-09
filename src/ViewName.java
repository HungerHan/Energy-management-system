import java.awt.FlowLayout;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The class to get all the customer
 * names in the system
 * @author Zihan Zhang
 * @version 5.0 2018.5.31
 */
public class ViewName{
	
	
	/**
	 * Get all the userName in the users data folder
	 * @param path The path of the customer_parameters
	 * 			folder's file directory
	 * @param deep The depth of the directory, 0 for
	 * 			current directory
	 * @return name The StringBuffer holding the names
	 * 			of customers
	 */
	
	public StringBuffer getFile (String path, int deep) 
	{
		 File file = new File(path);   
         File[] array = file.listFiles();	//get all files in folder
         StringBuffer name=new StringBuffer("");
         
         
         System.out.println("The users accounts in the system are: ");
         for(int i=0;i<array.length;i++)
         {   
             if(array[i].isFile())	//if it is actually a file
             {   
                     for (int j = 0; j < deep; j++)
                    	 System.out.print(" ");
                 // print out the file name  
                     String str[]=(array[i].getName()).split("\\.");
                     name=name.append(str[0]);
                     name=name.append(", ");
             }
             else if(array[i].isDirectory())	//if it is the folder
             {  
                     for (int j = 0; j < deep; j++)
                    	System.out.print(" ");
                     String str[]=(array[i].getName()).split("\\.");
                     name=name.append(str[0]);
                     name=name.append(", ");
                     //recursion,call getFile(),deep+1
                 getFile(array[i].getPath(),deep+1);  
             }   
         }  
         System.out.println(name);
         return name;
     }   
		


}

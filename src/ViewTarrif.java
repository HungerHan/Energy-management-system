/**
 * Title      : ViewTarrif.java
 * Description: This class contains method which is to view tariff.
 * @author      Yueting Du
 * @version     1.0
 */
import java.io.*;
public class ViewTarrif{

    /**
* This method is to check current tariff
* @return the current tariff
*/
public static String checkTarrif(){
try{
	File file=new File("Tarrif.csv");
	FileReader fileReader = new FileReader(file);
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	String line,eprice,gprice=null;
	bufferedReader.readLine();
	line=bufferedReader.readLine();
	String[] re=new String[10];
	re=line.split(",");
	gprice=re[1];
	line=bufferedReader.readLine();
	eprice=re[1];	
	fileReader.close();
	return "<html><p>The electricity price is "+eprice+" pound/kWh.</p><p>The gas price is "+gprice+" pound/kWh.</p></html>";
}
catch(Exception ex){
	ex.printStackTrace();
        return "wrong";
}
	}
}

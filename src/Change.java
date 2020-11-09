/**
 * Title      : Change.java
 * Description: This class contains some method which is related to change tariff.
 * @author      Yueting Du
 * @version     1.0
 */

import java.io.*;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
/**
* This method is to change current electricity tariff
* @param tarrif The parameter is the tariff provider want to change .
* @return the electricity tariff
*/
public class Change{
public String changeETarrif(String tarrif){
try{
	int j=0;
	int k;
        File myFile=new File("Tarrif.csv");
	FileReader fileReader=new FileReader(myFile);
	BufferedReader reader=new BufferedReader(fileReader);
	String line=null;
	String[] result=new String[100];
	String gain[][]=new String[100][2];
		while((line=reader.readLine())!=null){
		result=line.split(",");
			for(int i=0;i<result.length;i++){
			gain[j][i]=result[i];
			}
		j++;
		}
       k=j;
        FileWriter fileWriter=new FileWriter("Tarrif.csv");
	BufferedWriter Writer=new BufferedWriter(fileWriter);
	BigDecimal bd = new BigDecimal(tarrif);
	bd= bd.setScale(2,BigDecimal.ROUND_HALF_UP);
	String m=String.valueOf(bd);
        gain[1][1]=m;
        for(j=0;j<k;j++){
	for(int i=0;i<gain[j].length;i++){
	Writer.write(gain[j][i]+",");
	}
        Writer.write("\n");
	}
	reader.close();
        Writer.close();
	return m;
	}
catch(Exception ex){
	ex.printStackTrace();
	return "wrong";
}
}
/**
* This method is to change current gas tariff
* @param tarrif The parameter is the tariff provider want to change .
* @return the gas tariff
*/
public String changeGTarrif(String tarrif){
try{
	int j=0;
	int k;
        File myFile=new File("Tarrif.csv");
	FileReader fileReader=new FileReader(myFile);
	BufferedReader reader=new BufferedReader(fileReader);
	String line=null;
	String[] result=new String[100];
	String gain[][]=new String[100][2];
		while((line=reader.readLine())!=null){
		result=line.split(",");
			for(int i=0;i<result.length;i++){
			gain[j][i]=result[i];
			}
		j++;
		}
       k=j;
        FileWriter fileWriter=new FileWriter("Tarrif.csv");
	BufferedWriter Writer=new BufferedWriter(fileWriter);
	BigDecimal bd = new BigDecimal(tarrif);
	bd= bd.setScale(2,BigDecimal.ROUND_HALF_UP);
	String m=String.valueOf(bd);
        gain[2][1]=m;
        for(j=0;j<k;j++){
	for(int i=0;i<gain[j].length;i++){
	Writer.write(gain[j][i]+",");
	}
        Writer.write("\n");
	}
	reader.close();
        Writer.close();
	return m;
	}
catch(Exception ex){
	ex.printStackTrace();
	return "wrong";
}
}

}
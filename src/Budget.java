/**
 * Title      : Budget.java
 * Description: This class contains the attribute of Budget and some method which is related to the Budget.
 * @author      Yueting Du
 * @version     1.0
 */

import java.io.*;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.lang.reflect.Array;
public class Budget{
	private Consumer con;
  /**
* Constructor
* initialize some attribute of Budget
* @param con The parameter is the Consumer object.
*/
	public Budget(Consumer con){
		this.con=con;
	}
    /**
* This method is to check current budget and judget whether current cost has over Budget 
* @return determine whether account current cost has over Budget and current budget and cost
*/
public String checkBudget(){
try{
	String csv=".csv";
	String file="customer_parameters/"+con.getID()+csv;
	int j=0;
	double Ebudget,Gbudget;
	File myFile=new File(file);
	FileReader fileReader=new FileReader(myFile);
	BufferedReader reader=new BufferedReader(fileReader);
	String line=null;
        String light=null;
	String[] result=new String[200];
	String get[][]=new String[100][5];
		while((line=reader.readLine())!=null){
		result=line.split(",");
			for(int i=0;i<result.length;i++){
			get[j][i]=result[i];
			}
		j++;
		}
	Ebudget=Double.parseDouble(get[0][1]);
	Gbudget=Double.parseDouble(get[0][2]);
		if(Double.parseDouble(get[j-1][2])>Ebudget){
			light="1";
		}
		if(Double.parseDouble(get[j-1][2])<=Ebudget){
			light="0";
		}
		if(Double.parseDouble(get[j-1][4])>Gbudget){
			light=light+"1";
		}
		if(Double.parseDouble(get[j-1][4])<=Gbudget){
			light=light+"0";
		}
	reader.close();
		return light+" "+get[j-1][2]+" "+get[j-1][4]+" "+get[0][1]+" "+get[0][2];
}
catch(Exception ex){
	ex.printStackTrace();
	return "wrong";
}
}
/**
* This method is to check current budget and judget whether current cost has over Budget 
* @return determine whether account current cost has over Budget and current budget and cost
*/
public String changeEbudget(String budget){
try{
	int j=0;
	int k;
	String csv=".csv";
	String file="customer_parameters/"+con.getID()+csv;
        File myFile=new File(file);
	FileReader fileReader=new FileReader(myFile);
	BufferedReader reader=new BufferedReader(fileReader);
	String line=null;
	String[] result=new String[100];
	String gain[][]=new String[100][5];
		while((line=reader.readLine())!=null){
		result=line.split(",");
			for(int i=0;i<result.length;i++){
			gain[j][i]=result[i];
			}
		j++;
		}
       k=j;
        FileWriter fileWriter=new FileWriter(file);
	BufferedWriter Writer=new BufferedWriter(fileWriter);
	BigDecimal bd = new BigDecimal(budget);
	bd= bd.setScale(2,BigDecimal.ROUND_HALF_UP);
	String m=String.valueOf(bd);
        gain[0][1]=m;
	gain[0][3]="";
	gain[0][4]="";
        for(j=0;j<k;j++){
	for(int i=0;i<gain[j].length;i++){
	Writer.write(gain[j][i]+",");
	}
        Writer.write("\n");
	}
    Electricity.eleAlert=false;
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
* This method is to change current gas budget
* @param budget The parameter is the budget consumer want to change .
* @return the gas budget
*/
public String changeGbudget(String budget){
try{
	int j=0;
	int k;
	String csv=".csv";
	String file="customer_parameters/"+con.getID()+csv;
        File myFile=new File(file);
	FileReader fileReader=new FileReader(myFile);
	BufferedReader reader=new BufferedReader(fileReader);
	String line=null;
	String[] result=new String[100];
	String gain[][]=new String[100][5];
		while((line=reader.readLine())!=null){
		result=line.split(",");
			for(int i=0;i<result.length;i++){
			gain[j][i]=result[i];
			}
		j++;
		}
        k=j;
        FileWriter fileWriter=new FileWriter(file);
	BufferedWriter Writer=new BufferedWriter(fileWriter);
	BigDecimal bd = new BigDecimal(budget);
	bd= bd.setScale(2,BigDecimal.ROUND_HALF_UP);
	String m=String.valueOf(bd);
        gain[0][2]=m;
	gain[0][3]="";
	gain[0][4]="";
        for(j=0;j<k;j++){
	for(int i=0;i<gain[j].length;i++){
	Writer.write(gain[j][i]+",");
	}
        Writer.write("\n");
	}
    Gas.gasAlert=false;
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
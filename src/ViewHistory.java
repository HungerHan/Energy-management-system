/**
 * Title      : ViewHistory.java
 * Description: This class contains the attribute of ViewHistory and method to view historic data.
 * @author      Yueting Du
 * @version     1.0
 */
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.lang.reflect.Array;

public class ViewHistory {
	private Consumer con;
    /**
* Constructor
* initialize some attribute of ViewHistory
* @param con The parameter is the Consumer object.
*/
	public ViewHistory(Consumer con){
		this.con=con;
	}
    /**
* This method is to view historic day data
* @param y The parameter is the day which consumer want to check.
* @return the data of that day
*/
	public String historicDayCost(String y){
		try{
			String csv=".csv";
			String file="customer_parameters/"+con.getID()+csv;
			int j=0;
			double Ehistory,Ghistory;
			File myFile=new File(file);
			FileReader fileReader=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fileReader);
			String line=null;
			String[] inf=new String[200];
			String z1;
			String[] inf1=new String[200];
			String z2;
			String text1=null;
			Double h,f,g,l;
			String[] result=new String[100];
			String get[][]=new String[100][5];
				while((line=(reader.readLine()))!=null){
				result=line.split(",");
					for(int i=0;i<result.length;i++){
					get[j][i]=result[i];
					}
				j++;
				}
			int k=j;
			boolean find = false;
			for(j=0;j<k;j++){
						if(get[j][0].equals(y)){
						find=true;
						break;
					}
			}
				if(find){
				if(j!=2){
				z1=get[j][0];
				inf=z1.split("\\.");
				String s=inf[0]+"."+inf[1];
				z2=get[j-1][0];
				inf1=z2.split("\\.");
				String s1=inf1[0]+"."+inf1[1];
				if(!s.equals(s1)){
				text1=get[j][0]+", "+get[j][1]+", "+get[j][2]+", "+get[j][3]+", "+get[j][4];
				//System.out.println("The electicity consumption is£º"+get[j][1]+" cost:"+get[j][2]);
				//System.out.println("The gas consumption is £º"+get[j][3]+" cost:"+get[j][4]);
			}
				else{
				h=Double.parseDouble(get[j][1])-Double.parseDouble(get[j-1][1]);
				h=(double)Math.round(h*100)/100;
				f=Double.parseDouble(get[j][2])-Double.parseDouble(get[j-1][2]);
				f=(double)Math.round(f*100)/100;
				g=Double.parseDouble(get[j][3])-Double.parseDouble(get[j-1][3]);
				g=(double)Math.round(g*100)/100;
				l=Double.parseDouble(get[j][4])-Double.parseDouble(get[j-1][4]);
				l=(double)Math.round(l*100)/100;
				text1=get[j][0]+", "+String.valueOf(h)+", "+String.valueOf(f)+", "+String.valueOf(g)+", "+String.valueOf(l);
					}
				}	
					if(j==2){
					text1=get[j][0]+", "+get[j][1]+", "+get[j][2]+", "+get[j][3]+", "+get[j][4];
					}	

			}
				
				else{
				text1="Query failed";
				//System.out.println("Query failed");
			}


			reader.close();
			return text1;
		}


		catch(Exception ex){
			ex.printStackTrace();
			return "wrong";
		}
		}
    /**
* This method is to view historic month data
* @param y The parameter is the month which consumer want to check.
* @return the data of that month
*/
		public String[] historicMonthCost(String y){
		try{
			String csv=".csv";
			String file="customer_parameters/"+con.getID()+csv;
			int j=0;
			double Ehistory,Ghistory;
			File myFile=new File(file);
			FileReader fileReader=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fileReader);
			String line=null;
			String[] result=new String[100];
			String[] inf=new String[200];
			String z;
			String[] text=new String[31];
			String get[][]=new String[100][5];
				while((line=(reader.readLine()))!=null){
				result=line.split(",");
					for(int i=0;i<result.length;i++){
					get[j][i]=result[i];
					}
				j++;
				}
			int k=j;
			boolean find = false;
			text=(String[])arrayReduceLength(text,j);
			for(j=2;j<k;j++){
					z=get[j][0];
					inf=z.split("\\.");
					String s=inf[0]+"."+inf[1];
					if(s.equals(y)){
						//if(j==2)
					//System.out.println("Date Electricity consumption(kWh) Electricity cost(¡ê) Gas consumption(kWh) Gas cost(¡ê)\n");
					//System.out.println(get[j][0]+" "+get[j][1]+" "+get[j][2]+" "+get[j][3]+" "+get[j][4]);
					find=true;
					text[j-2]=get[j][0]+","+get[j][1]+", "+get[j][2]+", "+get[j][3]+", "+get[j][4];
					}
			}
		           if(find==false){
				//System.out.println("Query failed");
				text[0]="Query failed";
			}


			reader.close();
			return text;
		}


		catch(Exception ex){
				String[] text=new String[200];
			text[0]="wrong";
			ex.printStackTrace();
			return text;
				
		}
		}
        /**
	 * This method is to reduce the array length
	 * @param oldArray The parameter is the old array.
	 * @param reduceLength The parameter is the reduce length.
	 * @return the new array
	 */
		public static Object arrayReduceLength(Object oldArray,int reduceLength) {  
			Class c = oldArray.getClass();  
			if(!c.isArray())return null;  
			Class componentType = c.getComponentType();  
			int length = Array.getLength(oldArray);  
			int newLength = length - reduceLength;  
			Object newArray = Array.newInstance(componentType,newLength);  
			System.arraycopy(oldArray,0,newArray,0,newLength);  
			return newArray;  
			}  

        /**
	 * This method is to get how many year the consumer use our software
	 * @return the years
	 */
			public String[] getYear() {
				try{
					String csv=".csv";
					String file="customer_parameters/"+con.getID()+csv;
					int j=0;
					int x=1;
					File myFile=new File(file);
					FileReader fileReader=new FileReader(myFile);
					BufferedReader reader=new BufferedReader(fileReader);
					String line=null;
				        String light=null;
					String[] p=new String[1000];
					String[] q=new String[100];
					String[] result=new String[200];
					String get[][]=new String[100][5];
					String[] inf=new String[200];
					String z;
						while((line=reader.readLine())!=null){
						result=line.split(",");
							for(int i=0;i<result.length;i++){
							get[j][i]=result[i];
						}	
						j++;
						}
						int k=j;
						for(j=2;j<k;j++) {
						z=get[j][0];
						inf=z.split("\\.");
						p[j-2]=inf[0]; 
						if(j>=3){
						if(!p[j-3].equals(p[j-2])){
							q[x]=p[j-2];
							x++;
								}
							}
						else{
							q[0]=p[j-2];
							}
				            }
							q=(String[])arrayReduceLength(q,x);
				reader.close();	
				return q;
			}
					catch(Exception ex){
						String[] q=new String[100];
						q[0]="wrong";
						ex.printStackTrace();
						return q;
					}
			}

}

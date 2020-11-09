import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * The class to update all the consumers' electricity consumption and cost in system
 * and send a meter reading to provider every first day of a month
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class Electricity{
	private String tarrif="Tarrif.csv";
	private String metername="meterreading.csv";
	public String[] con=new String[10000];
	public static Consumer co;
	public static boolean eleAlert=false;
	
	public Electricity() {};
	public Electricity(Consumer con) {
		this.co=con;
	}	
	/**
	 * Get the updated consumer's electricity consumption and cost this month
	 * @return The string of the electricity consumption and cost information
	 */
	public String changeEle(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
		String str="error";
		Date time=new Date();
		String date=df.format(time);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		try{
			int j;
			String get[][]=new String[1000][5];
			String line=null;
			String[] result=new String[10];
			ViewName b=new ViewName();
			StringBuffer name=b.getFile("./customer_parameters/",0);
			String nameData=name.toString();
			if(nameData.equals("")){}
			else{
				con=nameData.split(", ");
				for (int n=0;n<con.length;n++) {
					System.out.println("consumer: "+con[n]);
					File myFile=new File("./customer_parameters/"+con[n]+".csv");
					if (!myFile.exists()) {
						try {
							myFile.createNewFile();							
						} catch(IOException e) {
							e.printStackTrace();
						}
					}
					FileReader fileReader1=new FileReader(myFile);
					BufferedReader reader=new BufferedReader(fileReader1);
					j=0;
					while((line=reader.readLine())!=null){
						System.out.println(line);
						result=line.split(",");
						for(int i=0;i<result.length;i++){
							get[j][i]=result[i];
							//System.out.println(i+":"+result[i]);
						}
						j++;
					}
					reader.close();
					DecimalFormat form = new DecimalFormat("#.00"); 
					FileWriter fileWriter=new FileWriter("./customer_parameters/"+con[n]+".csv");
					BufferedWriter writer=new BufferedWriter(fileWriter);
					Random ran=new Random();
					int cons=ran.nextInt(16);
					double cost=calculate(cons);
					if (j>2) {
						if (get[j-1][0].equals(date)) {
							System.out.println("r1="+get[j-1][1]+"j="+j);
							int r1=Integer.parseInt(get[j-1][1]);
							double r2=Double.parseDouble(get[j-1][2]);
							r1+=cons;
							r2+=cost;
							get[j-1][1]=""+r1;
							get[j-1][2]=""+r2;
						}else {
							result=get[j-1][0].split("[.]");
							int lastmonth=Integer.parseInt(result[1]);
							int lastyear=Integer.parseInt(result[0]);
							if (lastyear==year&lastmonth==month) {
								cons+=Integer.parseInt(get[j-1][1]);
								cost+=Double.parseDouble(get[j-1][2]);
							}
							get[j][0]=date;
							get[j][1]=""+cons;
							get[j][2]=""+cost;
							get[j][3]=get[j-1][3];
							get[j][4]=get[j-1][4];
							j++;
						}
						get[j-1][2]=form.format(Double.parseDouble(get[j-1][2]));
						if (co!=null)
							if (con[n].equals(co.getID())) {
								double ebudget=Double.parseDouble(get[0][1]);
								double ecost=Double.parseDouble(get[j-1][2]);
								if (ecost>ebudget&(!eleAlert)) new Alert("ELECTRICITY");
							}
					}
					else{	
						get[2][0]=date;
						get[2][1]=""+cons;
						get[2][2]=""+cost;
						get[2][3]="";
						get[2][4]="";
						j=3;
					}
					get[0][3]="";
					get[0][4]="";
					if (co!=null)
						if (con[n].equals(co.getID()))
						str="<html><p>The electricity consumption today is "+get[j-1][1]+"kWh, </p><p>and the cost is "+get[j-1][2]+" pound.</p></html>";
					for(int i=0;i<j;i++){
						for(int k=0;k<get[i].length;k++){
							writer.write(get[i][k]+",");
						}
						writer.write("\n");
					}
					writer.close();
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		meterReading();
		return str;
	}
	/**
	 * Send a meter reading to provider every first day of a month
	 */
	public void meterReading(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM");
		Date time=new Date();
		String date=df.format(time);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int day = c.get(Calendar.DATE); 
		String[] result=new String[10];
		String[] read=new String[10000];
		String line=null;
		int j=0;
		int b=0;
		int k;
		day=1;
		if (day==1) {
			try {
				File meterfile=new File(metername);
				if (!meterfile.exists()) {
					try {
						meterfile.createNewFile();							
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
				FileReader fileReader2=new FileReader(meterfile);
				BufferedReader meterReader=new BufferedReader(fileReader2);
				while ((line=meterReader.readLine())!=null){
					read[j]=line;
					j++;
				}
				meterReader.close();
				int meternum=j;
				int metermonth;
				int meteryear;
				if (j>1) {
					result=read[j-1].split(",");
					String[] t=new String[10];
					t=result[1].split("[.]");
					metermonth=Integer.parseInt(t[1]);
					meteryear=Integer.parseInt(t[0]);
				}else {
					metermonth=month-2;
					meteryear=year;
				}
			    String line1=null;
			    String[] info=new String[1000];
				String[] info1=new String[1000];
				j=0;
				ViewName l=new ViewName();
			StringBuffer name=l.getFile("./customer_parameters/",0);
			String nameData=name.toString();
			if(nameData.equals("")){}
			else{
			con=nameData.split(", ");
				k=con.length;
				for(j=0;j<k;j++){
					info1[j]="";
					try{
						line1=null;
						b=0;
						System.out.println("./customer_parameters/"+con[j]+".csv");
						File inf=new File("./customer_parameters/"+con[j]+".csv");
						if (!inf.exists()) {
							try {
								inf.createNewFile();							
							} catch(IOException e) {
								e.printStackTrace();
							}
						}else {
							FileReader fileRead=new FileReader(inf);
							BufferedReader Read=new BufferedReader(fileRead);
							while((line1=Read.readLine())!=null){
								info[b]=line1;
								b++;
							}
							if(b>3){
								result=info[b-2].split(",");
								info[b-2]=result[1]+","+result[2]+","+result[3]+","+result[4];
								result=result[0].split("[.]");
								int lastyear=Integer.parseInt(result[0]);
								int lastmonth=Integer.parseInt(result[1]);
								System.out.println(con[j]+" meter reading: month="+month+"year="+year);
								System.out.println("lastmonth="+lastmonth+"lastyear="+lastyear);
								if (month>1) {
									if ((lastyear==year&lastmonth==month-1)&((meteryear==year&metermonth<month-1)||(meteryear<year)))
										info1[j]=con[j]+","+date+","+info[b-2];
								}else if ((lastyear<year&lastmonth==12)&((meteryear==year-1&metermonth<12)||(meteryear<year-1)))
									info1[j]=con[j]+","+date+","+info[b-2];
							}
							Read.close();
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
		
				}
		        FileWriter Writer=new FileWriter(metername,true);
		        if (meternum==0)
		        	Writer.write("consumer ID,Date,Electricity consumption(kWh),Electricity cost(¡ê),Gas consumption(kWh),Gas cost(¡ê)\n");
		        for(j=0;j<k;j++){
		        	if(!info1[j].equals("")) 
		        		Writer.write(info1[j]+"\n");
		        }
		        Writer.close();
			}
				}
		    catch(Exception ex){
		    	ex.printStackTrace();
		    }
		}
	}
	/**
	 * Get the electricity cost of new electricity consumption
	 * @return The increased electricity cost
	 */
	public double calculate(int cons) {
		try {
			File file=new File(tarrif);
			if (!file.exists()) {
				try {
					file.createNewFile();							
				} catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				FileReader fileReader=new FileReader(file);
				BufferedReader reader=new BufferedReader(fileReader);
				String line=null;
				reader.readLine();
				line=reader.readLine();
				String[] result=new String[5];
				result=line.split(",");
				double price=Double.parseDouble(result[1]);
				reader.close();
				return cons*price;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0.00;
	}
}

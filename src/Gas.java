import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * The class to update all the consumers' gas consumption and cost in system
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class Gas{
	private String tarrif="Tarrif.csv";
	public static Consumer co;
	public static boolean gasAlert=false;
	
	public Gas() {};
	public Gas(Consumer con) {
		this.co=con;
	}	
	/**
	 * Get the updated consumer's gas consumption and cost this month
	 * @return The string of the gas consumption and cost information
	 */
	public String changeGas(){
		String str="error";
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
		String date=df.format(new Date());
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		try{
			String line=null;
			String[] result=new String[1000];
			String[] con=new String[1000];
			ViewName b=new ViewName();
			StringBuffer name=b.getFile("./customer_parameters/",0);
			String nameData=name.toString();
			if(nameData.equals("")){}
			else{
				con=nameData.split(", ");
				for (int n=0;n<con.length;n++) {
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
					String get[][]=new String[1000][5];
					int j=0;
					while((line=reader.readLine())!=null){
						result=line.split(",");
						for(int i=0;i<result.length;i++){
							get[j][i]=result[i];
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
					if (j>0) {
						if (get[j-1][0].equals(date)) {
							int r3=Integer.parseInt(get[j-1][3]);
							double r4=Double.parseDouble(get[j-1][4]);
							r3+=cons;
							r4+=calculate(cons);
							get[j-1][3]=""+r3;
							get[j-1][4]=""+r4;
						}else {
							result=get[j-1][0].split("[.]");
							System.out.println(get[j-1][0]);
							System.out.println("month:"+result[1]);
							int lastmonth=Integer.parseInt(result[1]);
							int lastyear=Integer.parseInt(result[0]);
							if (lastyear==year&lastmonth==month) {
								cons+=Integer.parseInt(get[j-1][3]);
								cost+=Double.parseDouble(get[j-1][4]);
							}
							get[j][0]=date;
							get[j][1]=get[j-1][1];
							get[j][2]=get[j-1][2];
							get[j][3]=""+cons;
							get[j][4]=""+calculate(cons);
							j++;
						}
						get[j-1][4]=form.format(Double.parseDouble(get[j-1][4]));
						if (co!=null)
							if (con[n].equals(co.getID())) {
								double gbudget=Double.parseDouble(get[0][2]);
								double gcost=Double.parseDouble(get[j-1][4]);
								if (gcost>gbudget&(!gasAlert)) new Alert("GAS");
							}
					}
					else{
						get[2][0]=date;
						get[2][3]=""+cons;
						get[2][4]=""+cost;
						get[2][1]="";
						get[2][2]="";						
							j=3;
					}
					get[0][3]="";
					get[0][4]="";
					if (co!=null)
						if (con[n].equals(co.getID()))
						str="<html><p>The gas consumption today is "+get[j-1][3]+"kWh, </p><p>and the cost is "+get[j-1][4]+" pound.</p></html>";
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
		return str;
	}
	/**
	 * Get the gas cost of new electricity consumption
	 * @return The increased gas cost
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

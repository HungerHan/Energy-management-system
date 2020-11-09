import javax.swing.JLabel;

/**
 * The class to update all the consumers' gas consumption and cost periodically in system
 * @author Yidan Xu
 * @version 3.1 2018.5.31
 */
public class Update implements Runnable{
	private Electricity ele;
	private Gas gas;
	public static boolean viewEle=false;
	public static boolean viewGas=false;
	public static JLabel eleLabel;
	public static JLabel gasLabel;
	
	public Update() {
		ele=new Electricity();
		gas=new Gas();
	};
	/**
	 * Thread for periodically updating data and showing in interface
	 */
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		String str1=null;
		String str2=null;
		str1=ele.changeEle();
		if (viewEle) {eleLabel.setText(str1);System.out.println("run start setText");}
		str2=gas.changeGas();
		if (viewGas) gasLabel.setText(str2);
		while (true) {
			long startTime = System.currentTimeMillis(); 
			long endTime   = System.currentTimeMillis();
			long TotalTime = endTime - startTime; 
			while (TotalTime<3*1000) {
				endTime   = System.currentTimeMillis(); 
				TotalTime = endTime - startTime;       
			}
			i++;
			str1=ele.changeEle();
			if (viewEle) eleLabel.setText(str1);
			if (i>=3) {
				str2=gas.changeGas();
				if (viewGas) gasLabel.setText(str2);
				i=0;
			}
		}
	}

}

/**
 * Title      : Consumer.java
 * Description: This class contains the attribute of customer.
 * @author      Yueting Du
 * @version     1.0
 */
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.lang.reflect.Array;
public class Consumer{
	private String ID;
	private String password;
    /**
* Constructor
* initialize some attribute of Consuemr
* @param ID The parameter is the Consumer id.
* @param password The parameter is the Consumer password.
*/
	Consumer(String ID,String password){
		this.ID=ID;
	}

    /**
* This method is to get consumer id
* @return the consumer id
*/
	public String getID(){
		return this.ID;
	}
    /**
* This method is to get consumer password
* @return the consumer password
*/
	public String getPassword(){
		return this.password;
	}
}


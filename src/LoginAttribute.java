/**
 * Title	: LoginGUI.java
 * Description	: This is the entity class of login system.
 * @author	: Hao Hu
 */
public class LoginAttribute {
	  public String provLoginFilePath, custLoginFilePath, custParamtPathPrefix;

	public LoginAttribute(){
	    this.provLoginFilePath = "provider_ID_password.csv";
	    this.custLoginFilePath = "customer_ID_password.csv";
	    this.custParamtPathPrefix = "customer_parameters/";
	}
}

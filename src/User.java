/**
 * Title      : User.java
 * Description: This class contains the attribute of user.
 * @author      Yueting Du
 * @version     1.0
 */
public class User{
	protected String ID;
	protected String password;
    /**
* Constructor
* initialize some attribute of user
* @param ID The parameter is the user id.
* @param password The parameter is the Consumer password.
*/
	User(String ID, String password){
		this.ID=ID;
		this.password=password;
	}

    /**
* This method is to get user id
* @return the user id
*/
	public String getID(){
		return this.ID;
	}
    /**
* This method is to get user password
* @return the user password
*/
	public String getPassword(){
		return this.password;
	}
}		

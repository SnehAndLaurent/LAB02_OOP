package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBUnique {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBUnique.class);
	/*
	* Variable Declarations
	*/
	private String uKColumnName;
	/*
	* Parametrized Constructor
	*/
	public DBUnique(final String uKColumnName) {
		// TODO Auto-generated constructor stub
		this.uKColumnName=uKColumnName;
	}

	/*
	* Method to append the information
	*/
	public String toSQL() {
		// TODO Auto-generated method stub
		final StringBuffer sb = new StringBuffer();
        sb.append(this.uKColumnName);
        return sb.toString();
	}

}

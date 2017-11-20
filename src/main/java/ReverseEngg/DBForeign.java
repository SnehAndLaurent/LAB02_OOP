package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBForeign {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBForeign.class);
	/*
	* Variable Declarations
	*/
	private String fKColumnName;
	/*
	* Parameterized Constructor
	*/
	public DBForeign(String fKColumnName) {
		// TODO Auto-generated constructor stub
		this.fKColumnName=fKColumnName;
	}

	/*
	* Method to append the information
	*/
	public String toSQL() {
		// TODO Auto-generated method stub
		final StringBuffer sb = new StringBuffer();
        sb.append(this.fKColumnName);

        return sb.toString();
	}

}

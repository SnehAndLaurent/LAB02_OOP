package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBPrimary {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBPrimary.class);
	/*
	* Variable Declarations
	*/
	private String pKColumnName;
    /*
	* Parameterized Constructor
	*/
    public DBPrimary(final String pKColumnName) {
		// TODO Auto-generated constructor stub
    	this.pKColumnName=pKColumnName;
	}
	/*
	* Method to append the information
	*/
	public String toSQL() throws Exception
    {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.pKColumnName);

        return sb.toString();
    }

}

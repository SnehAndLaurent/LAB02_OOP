package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPrimaryFactory {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBPrimaryFactory.class);
	/*
	* Parameterized Constructor
	*/
	public static DBPrimary DBPrimaryFactor(ResultSet pKResult) throws Exception {
		// TODO Auto-generated method stub
		/*
		* Retrieving primary key column name 
		*/
		String PKColumnName = pKResult.getString(4);
		return new DBPrimary(PKColumnName);
	}

}

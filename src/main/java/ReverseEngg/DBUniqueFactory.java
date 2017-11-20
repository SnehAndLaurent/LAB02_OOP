package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUniqueFactory {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBUniqueFactory.class);
	/*
	* Parametrized Constructor of DBUnique Type
	*/
	public static DBUnique DBUniqueFactory(ResultSet uKResult) throws SQLException {
		// TODO Auto-generated method stub
		/*
		* Retrieve unique column name
		*/
		String UKColumnName = uKResult.getString(9);
		return new DBUnique(UKColumnName);
	}

}

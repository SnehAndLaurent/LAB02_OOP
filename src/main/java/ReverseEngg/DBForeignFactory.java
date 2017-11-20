package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBForeignFactory {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBForeignFactory.class);
	/*
	* Parameterized Constructor of DBForeign Type
	*/
	public static DBForeign DBForeignFactory(ResultSet fKResult) throws SQLException {
		// TODO Auto-generated method stub
		String FKColumnName = fKResult.getString(4);
		return new DBForeign(FKColumnName);
	}

}

package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBViewFactory {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBViewFactory.class);
	/*
	* Variable Declarations
	*/
	private static String tableName=null;
	private static ResultSet columnResult=null;
	private static String catalog = null;
	private static String schema = null;
	private static String column = null;

	/*
	* Parametrized Constructor of DBView Type
	*/
	public static DBView DBViewFactory(ResultSet rs, DatabaseMetaData dbMetaData) {
		// TODO Auto-generated method stub
		try {
			/*
			* Retrieve Tablename
			*/
			tableName = rs.getString("TABLE_NAME");
			/*
			* Retrieve the information from the database regarding catalog etc
			*/
			columnResult = dbMetaData.getColumns(catalog, schema, tableName, column);
			//System.out.println("CREATE VIEW "+DBTableName+"\n"+ "As \n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DBView (tableName,columnResult) ;
	}

}

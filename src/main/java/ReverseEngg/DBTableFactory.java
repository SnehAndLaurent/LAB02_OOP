package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTableFactory {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBTableFactory.class);
	/*
	* Variable Declarations
	*/
	private static String catalog = null;
	private static String schema = null;
	private static String column = null;
	private static ResultSet columnResult=null;
	private static ResultSet PKResult=null;
	private static ResultSet FKResult=null;
	private static ResultSet UKResult=null;
	private static String tableName=null;
	
	/*
	 * Parametrized Constructor of DBTable type
	 */
	public static DBTable DBTableFactory(ResultSet rs, DatabaseMetaData dbMetaData) throws Exception {
		// TODO Auto-generated method stub
		try {
			/*
			 * Retrieve table name
			 */
			tableName = rs.getString("TABLE_NAME");
			//System.out.println("CREATE TABLE "+ tableName+" ( \n");
			/*
			 * Retrieve all the information regarding columns and keys
			 */
			columnResult = dbMetaData.getColumns(catalog, schema, tableName, column);
			PKResult= dbMetaData.getPrimaryKeys(catalog, schema, tableName);
			FKResult = dbMetaData.getImportedKeys(catalog, schema, tableName);
			UKResult = dbMetaData.getIndexInfo(catalog, schema, tableName, true, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DBTable(tableName, columnResult, PKResult, FKResult, UKResult);
	}

}

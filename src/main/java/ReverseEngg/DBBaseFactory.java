package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBBaseFactory {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBBaseFactory.class);
	/*
	* Variable Declarations
	*/
	private static String catalog = null;
	private static String schemaPattern = null;
	private static String tableNamePattern = null;
	private static String[] types = null;
	private static String schema = null;
	private static String columnNamePattern = null;
	private static DatabaseMetaData dbMetaData=null;
	private static ResultSet rs=null;
	/*
	* Default Constructor
	*/
	private DBBaseFactory() {}
 
	/*
	 * Create parameterized constructor of DBBase type
	 */
	public static DBBase DBBaseFactory(final String dbName, final Connection conn) throws Exception {
		// TODO Auto-generated method stub
		try {
			/*
			 * MetaData contains all the information about database table, SQLType etc
			 */
			 dbMetaData = conn.getMetaData();
			 //System.out.println(dbMetaData);
			 
			/*
			* Retrieve all the information about the table present in the catalog
			*/
			rs = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types );
			//System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DBBase(dbName, rs, dbMetaData);
	}
}

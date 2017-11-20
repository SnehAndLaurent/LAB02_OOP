package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBView {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBView.class);
	/*
	* Variable Declarations
	*/
	private List<DBColumn> columns = new LinkedList<DBColumn>();
	private String tableName;
	private ResultSet columnResult;
	private DBColumn dbColumn;

	/*
	* Parameterized Constructor
	*/
	public DBView(String tableName, ResultSet columnResult) {
		// TODO Auto-generated constructor stub
		this.tableName = tableName;
		this.columnResult = columnResult;

		// Columns Information and calling it's factory
		try {
			while (columnResult.next()) {
				dbColumn = DBColumnFactory.DBColumnFactory(columnResult);
				// System.out.println("DBColumn"+dbColumn);
				columns.add(dbColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * protected static DBView DBView(ResultSet rs, DatabaseMetaData dbMetaData) {
	 * // TODO Auto-generated method stub try { String DBTableName =
	 * rs.getString("TABLE_NAME");
	 * System.out.println("CREATE VIEW "+DBTableName+"\n"+ "As \n"); columnResult =
	 * dbMetaData.getColumns(catalog, schema, DBTableName, column);
	 * System.out.println(columnResult); while(columnResult.next()) { dbColumn =
	 * DBColumnFactory.DBColumnFactory(columnResult); columns.add(dbColumn); }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return null; }
	 */

	public String toSQL() throws Exception {

		final StringBuffer sb = new StringBuffer();
		sb.append("CREATE VIEW " + this.tableName + "( \n");
		/*
		* Appending DBColumn name
		*/
		for (DBColumn column : columns) {
			sb.append(column.toSQL());
		}
		sb.append("\n);\n\n");
        sb.append("----------------------------------------\n");
		return sb.toString();
	}
}

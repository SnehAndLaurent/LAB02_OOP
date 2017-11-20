package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBTable {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBTable.class);
	/*
	* Variable Declarations
	*/
	private List<DBColumn> columns = new LinkedList<DBColumn>();
	private List<DBPrimary> primarys = new LinkedList<DBPrimary>();
	private List<DBUnique> uniques = new LinkedList<DBUnique>();
	private List<DBForeign> foreigns = new LinkedList<DBForeign>();
	private String tableName;
	private ResultSet columnResult;
	private ResultSet pKResult;
	private ResultSet fKResult;
	private ResultSet uKResult;
	private DBColumn dbColumn;
	private DBPrimary primary;
	private DBUnique unique;
	private DBForeign foreign;

	/*
	* Parametrized Constructor
	*/
	public DBTable(String tableName, ResultSet columnResult, ResultSet pKResult, ResultSet fKResult,
			ResultSet uKResult) throws Exception {
		// TODO Auto-generated constructor stub
		this.tableName = tableName;
		this.columnResult = columnResult;
		this.pKResult = pKResult;
		this.fKResult = fKResult;
		this.uKResult = uKResult;

		//Columns Information and calling it's factory
		try {
			while (columnResult.next()) {
				dbColumn = DBColumnFactory.DBColumnFactory(columnResult);
				//System.out.println("DBColumn"+dbColumn);
				columns.add(dbColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Primary Key Information and calling it's factory
		try {
			while (pKResult.next()) {
				primary = DBPrimaryFactory.DBPrimaryFactor(pKResult);
				//System.out.println("Primary"+primary);
				primarys.add(primary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UniqueKey Information and calling it's factory
		try {
			while(uKResult.next()) {
				unique = DBUniqueFactory.DBUniqueFactory(uKResult);
				uniques.add(unique);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Foreign Key Information and calling it's factory
		try {
			while (fKResult.next()) {
				foreign = DBForeignFactory.DBForeignFactory(fKResult);
				foreigns.add(foreign);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	* Method to append the information
	*/
	public String toSQL() throws Exception {
		
		final StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE " + this.tableName + "( \n");
		/*
		* Appending DBColumn information
		*/
        for (DBColumn column : columns)
	      {
	        sb.append(column.toSQL());
	      }
        
        /*
		* Appending Primary Key 
		*/
        if (!primarys.isEmpty()) {
	        sb.append("PRIMARY KEY (");
	        for(DBPrimary primary:primarys) {
	        	sb.append(primary.toSQL());
	        	sb.append(",");
	        }
			/*
			* Removing last character
			*/
	        sb.setLength(sb.length()-1);
	        sb.append(")\n");
        }
        
		/*
		* Appending Unique Key 
		*/
        if (!uniques.isEmpty()) {
	        sb.append("UNIQUE KEY (");
	        for(DBUnique unique:uniques) {
	        	sb.append(unique.toSQL());
	        	sb.append(",");
	        }
			/*
			* Removing last character
			*/
	        sb.setLength(sb.length()-1);
	        sb.append(")\n");
        }
        
		/*
		* Appending Foreign Key 
		*/
        if (!foreigns.isEmpty()) {
	        sb.append("FOREIGN KEY (");
	        for(DBForeign foreign :foreigns) {
	        	sb.append(foreign.toSQL());
	        	sb.append(",");
	        }
			/*
			* Removing last character
			*/
	        sb.setLength(sb.length()-1);
	        sb.append(")");
        }
        
        sb.append("\n);\n\n");
        sb.append("----------------------------------------\n");
        
        return sb.toString();
	}

}

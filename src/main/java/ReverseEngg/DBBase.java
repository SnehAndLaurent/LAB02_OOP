package ReverseEngg;

/*
* Import Packages
*/
import org.apache.log4j.*;
import java.util.List;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DBBase {
		/*
		* Put a logger
		*/
		protected static Logger log = Logger.getLogger(DBBase.class);
		/*
		* Variable Declarations
		*/
	 	private List<DBTable> tables = new LinkedList<DBTable>();
	    private String dbName = null;
		private ResultSet rs=null;
		private DatabaseMetaData dbMetaData=null;
		private DBTable dbTable;
		private DBView dbView;
		private List<DBView> views = new LinkedList<DBView>();
	    
		/*
		* Parametrized Constructor
		*/
	    protected DBBase(final String dbName, ResultSet rs, DatabaseMetaData dbMetaData) throws Exception
	    {
	      this.dbName = dbName;
	      this.rs=rs;
	      this.dbMetaData=dbMetaData;
	      System.out.println("List all the tables in database with it's information");
			try {
				/*
				 * Retrieve all the tables and views present in the database row by row
				 */
				while(this.rs.next()) {
					/*
					 * Retrieve all the table type present in SQLType
					 */
					String tableType = rs.getString("TABLE_TYPE");
					//System.out.println("-------------------------------------");
					/*
					 * Check whether it's a table, view  or none of them
					 */
					if(tableType.equalsIgnoreCase("VIEW")) {
						/*
						 * Call DBView class
						 */
						dbView = DBViewFactory.DBViewFactory(this.rs, this.dbMetaData);  
			            views.add(dbView);	
					}else if(tableType.equalsIgnoreCase("TABLE")){
						/*
						 * Call DBTableFactory
						 */
						dbTable = DBTableFactory.DBTableFactory(this.rs, this.dbMetaData);  
			            tables.add(dbTable);	
					}else {
						System.out.println("It is not a table nor a view");
					}
							
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }        
	    
	    /*
	     * Method to append the information
	     */
	    public String toSQL() throws Exception
	    {
	      final StringBuffer sb = new StringBuffer();
	      sb.append("\nCREATE DATABASE " + this.dbName +"\n\n");
		  /*
		  * Loop for displaying the tables
		  */
	      for (DBTable table : tables)
	      {
	        sb.append(table.toSQL());
	      }
		  /*
		  * Loop for displaying the views
		  */
	      for (DBView view : views)
	      {
	        sb.append(view.toSQL());
	      }
	      return sb.toString();
	    }
	    
	    
}

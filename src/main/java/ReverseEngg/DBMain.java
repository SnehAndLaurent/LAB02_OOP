package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.Connection;

public class DBMain {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBMain.class);
   /*
    * Variable Declaration
	*/
	private static DBBase dbBase;
	private static DBScript dbScript;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * Calling DBConnection class method by creating an object
			 */
			DBConnection dbConnection = new DBConnection();
			Connection conn=dbConnection.getDBConnetion();
			//System.out.println("Call Database Factory");
			/*
			 * Calling DBBaseFactory which is of DBBase type 
			 * Arguments contain DBname and object of DBConnection class
			 */
			dbBase= DBBaseFactory.DBBaseFactory("sakila",conn);
			/*
			 * Calling method of DBBase class
			 */
			String dbBaseOutput = dbBase.toSQL();
			System.out.println("Output of the dbBase");
			System.out.println(dbBaseOutput);
			/*
			* Calling DBBaseFactory in order to form a script
			*/
			dbScript = DBScriptFactory.DBScriptFactory(dbBaseOutput);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

}

package ReverseEngg;

import org.apache.log4j.*;
import junit.framework.Test; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
import static org.junit.Assert.*;
import java.sql.*;


public class ScriptTest extends TestCase {
	/**Create the test case     
	 *    
	 * @param testName name of the test case  
     */   
	  protected static Logger log = Logger.getLogger(ScriptTest.class);
	  public ScriptTest( String testName ) 
	  {        
		 super( testName );
 	  } 
 
 	 /**     
	  * @return the suite of tests being tested  
	  */   
	  public static Test suite() 
	  {     
		 System.out.println();
		 System.out.println("Test case for ScriptTest class of package ReverseEngg");
		 log.info("Testing JDBC Info");
	     return new TestSuite( ScriptTest.class );  
	  } 
 
 	   /** 
	    * Rigourous Test :-)    
	    */   

		public void testScript() throws Exception {
		/*
		 * Calling the main function of a program as this is static so no need to create an object
		 */
			/*String[] conn = new String[] {"jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver", "root","root","Select * from actor"}; 
			String[] dbName= new String[] {"sakila"};
			DBBaseFactory dbBaseFactory = new DBBaseFactory(dbName, conn);*/
			DBMain.main(new String[]{});
		}
	}
		


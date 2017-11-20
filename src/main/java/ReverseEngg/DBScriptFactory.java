package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.io.IOException;

public class DBScriptFactory {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBScriptFactory.class);
	
	/*
	* Parameterized Constructor of DBScript type
	*/
	public static DBScript DBScriptFactory(String dbBaseOutput) throws IOException {
		// TODO Auto-generated method stub
		return new DBScript(dbBaseOutput);
	}

}

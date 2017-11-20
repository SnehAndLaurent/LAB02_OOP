package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBObject extends DBColumn {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBObject.class);
	/*
	* Parameterized Constructor
	*/
	public DBObject(String columnName, String columnType, boolean isNullable) {
		super(columnName, columnType, isNullable);
		// TODO Auto-generated constructor stub
	}
	//BLOB TEXT CLOB
	/*
	* Method to append the information
	*/
	@Override
    public String toSQL()
    {
      final StringBuffer sb = new StringBuffer();
      sb.append(super.getName() + " " + super.getType() + " "+ super.isNullable());
  
      return sb.toString();
    }

}

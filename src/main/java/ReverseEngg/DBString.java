package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBString extends DBColumn {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBString.class);
	/*
	* Variable Declarations
	*/
    protected int size;
    
    /*
	* Parametrized Constructor
	*/
    public DBString(final String columnName, final String columnType, final int columnSize, final boolean isNullable)
    {
		/* 
		* Calling parent class variables 
		*/
    	super(columnName, columnType, isNullable);
    	this.size = columnSize;
    }
    
	/*
	* Method to append the information
	*/
    @Override
    public String toSQL()
    {
      final StringBuffer sb = new StringBuffer();
      sb.append(super.getName() + " " + super.getType() + "(" + this.size + "),\n" );
  
      return sb.toString();
    }

}

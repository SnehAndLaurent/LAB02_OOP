package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBNumeric extends DBColumn {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBNumeric.class);
	/*
	* Variable Declarations
	*/
	protected int precision;
    protected int radix;
    
	/*
	* Parameterized Constructor
	*/
    public DBNumeric(String colName, String columnType, boolean isNullable) {
		super(colName, columnType, isNullable);
		// TODO Auto-generated constructor stub
	}
    
    /*
	* Getter and Setter
	*/
   public final int getPrecision() {
		return precision;
	}


	public final void setPrecision(int precision) {
		this.precision = precision;
	}


	public final int getRadix() {
		return radix;
	}


	public final void setRadix(int radix) {
		this.radix = radix;
	}


	/*
	* Method to append the information
	*/
	@Override
    public String toSQL()
    {
      final StringBuffer sb = new StringBuffer();
      sb.append(String.format("%s %s (%d,%d),\n", this.getName(), this.getType(), this.getPrecision(), this.getRadix()));
  
      return sb.toString();
    }

}

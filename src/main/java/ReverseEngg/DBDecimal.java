package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBDecimal extends DBColumn {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBDecimal.class);
	/*
	* Variable Declarations
	*/
	protected int precision;
    protected int radix;
	/*
	* Parametrized Constructor
	*/
	public DBDecimal(String columnName, String columnType, int columnSize, int decimalDigits,
			boolean isNullableBool) {
		// TODO Auto-generated constructor stub
		/*
		* Calling parent variables
		*/
		super(columnName, columnType, isNullableBool);
		this.precision=decimalDigits;
		this.radix=columnSize;
		
	}
	/*
	* Getter and Setter
	*/
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getRadix() {
		return radix;
	}
	public void setRadix(int radix) {
		this.radix = radix;
	}
	
	/*
	* Method to append the information
	*/
	@Override
    public String toSQL()
    {
      final StringBuffer sb = new StringBuffer();
      //sb.append(String.format("\n%s %s(%d, %d),", this.getName(), this.getType(), this.precision, this.radix));
      sb.append(String.format("%s %s (%d,%d),\n", this.getName(), this.getType(), this.getPrecision(), this.getRadix()));
  
      return sb.toString();
    }

}

package ReverseEngg;

/*
* Import Packages
*/
import org.apache.log4j.*;
public class DBColumn {
	
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBColumn.class);
	/*
	* Variable Declarations
	*/
	private String name;
    private String type; 
    private boolean isNullable;

    enum SQLType {
      CHAR, VARCHAR,NVARCHAR, NCHAR,LONGVARCHAR,
      NUMERIC, SMALLINT, TINYINT,INTEGER,BIGINT,
      REAL,FLOAT, DOUBLE, DECIMAL,
      DATE,
      TIMESTAMP,
      NCLOB,CLOB,BLOB,
      BOOLEAN,
      BINARY,
      ARRAY,TIME
    }
    
	/*
	* Parametrized Constructor
	*/
    public DBColumn(final String columnName, final String columnType, final boolean isNullable)
    {
    	this.name = columnName;
    	this.type = columnType;
    	this.isNullable = isNullable;
    }
    /*
	* Getter and Setter
	*/
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
    
    /*public String getName() {
        return name;
    }

    public String getSQLType() {
        return SQLType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSQLType(String SQLType) {
        this.SQLType = SQLType;
    }*/
   
    
	/*
	* Method to append the information
	*/
	public String toSQL()
    {
      final StringBuffer sb = new StringBuffer();
      sb.append(this.name + " " + this.type+ ", \n");
  
      return sb.toString();
    }
}

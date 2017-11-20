package ReverseEngg;

/*
* Import Packages
*/
import org.apache.log4j.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBColumnFactory {
	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBColumnFactory.class);
	/*
	* Variable Declarations
	*/
	private static final String isAutoIncrement = null;

	/*
	* Parametrized Constructor of type DBColumn
	*/
	public static DBColumn DBColumnFactory(ResultSet columnResult) throws SQLException {
		// TODO Auto-generated method stub
		/*
		* Retrieve all the column information like name, type etc
		*/
        final String columnName = columnResult.getString(4);
		String dataType = columnResult.getString("DATA_TYPE");
		//System.out.println(dataType);
		String columnType = columnResult.getString("TYPE_NAME");
		//System.out.println(columnType);
		int columnSize = columnResult.getInt("COLUMN_SIZE");
		//String typeNameNumbers = (columnSize != null)? "(" + columnSize + ")" : "";
		int decimalDigits = columnResult.getInt("DECIMAL_DIGITS");
		String isNullable = columnResult.getString("IS_NULLABLE");
		boolean isNullableBool = (isNullable == "YES") ? true : false;
		String isAutoIncrement = columnResult.getString("IS_AUTOINCREMENT");
        String isAutoIncrementBool = (isAutoIncrement == "YES") ? " AUTO_INCREMENT" : "";
		
		//sqlInstructions += columnName + " " + typeName + typeNameNumbers + " " + isNullableBool + ", \n";
		/*final DBColumn.SQLType datatype = DBColumn.SQLType.valueOf(rs.getString("DATA_TYPE").toUpperCase().trim());
        final DBColumn.SQLType colType = DBColumn.SQLType.valueOf(dataType);
        //java.sql.Types.
		final DBColumn.SQLType columnType = DBColumn.SQLType.valueOf(typeName.toUpperCase().trim());
		System.out.println(columnType);*/
        return DBColumnFactory(columnName, columnType, columnSize, decimalDigits, isNullableBool, isAutoIncrementBool);
    }

	/*
	* Parametrized Constructor
	*/
	private static DBColumn DBColumnFactory(final String columnName, final String columnType, final int columnSize, final int decimalDigits,
			final boolean isNullableBool, String isAutoIncrementBool) {
		// TODO Auto-generated method stub
		/*
		* Checking condition which class to call according to the parameter
		*/
		if(columnType.equalsIgnoreCase("DECIMAL")||columnType.equalsIgnoreCase("REAL")||columnType.equalsIgnoreCase("FLOAT")||columnType.equalsIgnoreCase("DOUBLE")) {
			return new DBDecimal(columnName, columnType, columnSize, decimalDigits, isNullableBool);
		}else if(columnType.equalsIgnoreCase("NUMERIC")||columnType.equalsIgnoreCase("SMALLINT")||columnType.equalsIgnoreCase("TINYINT")||columnType.equalsIgnoreCase("BIGINT")||columnType.equalsIgnoreCase("INTEGER")) {
			return new DBNumeric(columnName, columnType, isNullableBool);
		}else if(columnType.equalsIgnoreCase("VARCHAR")||columnType.equalsIgnoreCase("CHAR")||columnType.equalsIgnoreCase("NVARCHAR")||columnType.equalsIgnoreCase("NCHAR")||columnType.equalsIgnoreCase("LONGVARCHAR")) {
			return new DBString(columnName,columnType,columnSize,isNullableBool);
		}else if(columnType.equalsIgnoreCase("BLOB") || columnType.equalsIgnoreCase("CLOB") || columnType.equalsIgnoreCase("DATE") || columnType.equalsIgnoreCase("TIME")) {
			return new DBObject(columnName, columnType, isNullableBool);
		}else { 
			return new DBColumn(columnName, columnType, isNullableBool);
		}
	}


	

	/*public static DBColumn DBColumnFactory(final String colName, final DBColumn.SQLType colType, final int columnSize, final boolean isNullable) {
        switch (colType) {
            case VARCHAR:
            case CHAR:
                return new DBString(colName, colType, columnSize, isNullable);
            case NUMERIC:
            	return new DBNumeric(colName, colType, isNullable);
            	
            default:
                return new DBColumn(colName, colType, isNullable);
        }
    }*/

}

package ReverseEngg;
/*
* Import Packages
*/
import org.apache.log4j.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DBScript {

	/*
	* Put a logger
	*/
	protected static Logger log = Logger.getLogger(DBScript.class);
	/*
	* Variable Declarations
	*/
	private static File file;
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;
    
	public DBScript(String dbBaseOutput) throws IOException {
		// TODO Auto-generated constructor stub
		/*
		* Create a file name SQLScript
		*/
		file = new File("SQLScript.sql");
		/*
		* If file exists delete it and create new
		*/
        if(file.exists())
        {
            file.delete();
        }
		/*
		* Writing in to the file
		*/
        fileWriter = new FileWriter(file.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();
        bufferedWriter.write(dbBaseOutput);
        bufferedWriter.close();//To save every change
	}

}

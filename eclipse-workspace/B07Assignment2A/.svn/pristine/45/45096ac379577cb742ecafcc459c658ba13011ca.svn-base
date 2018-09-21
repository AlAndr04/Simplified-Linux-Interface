// **********************************************************
// Assignment2:

// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #: 1004354263
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID user_name: babubala
// UT Student #: 1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID user_name: huang472
// UT Student #:1002671094
// Author: Zhi Zhong Huang
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package fileCommands;
import java.net.*;
import java.io.*;
import org.apache.commons.io.FilenameUtils;

public class Curl {
	
	/**
	 * Instance variable url is a String and it stores the url given by user
	 */
	private String urlPath;
	private String fileName;
	private URL url;
	
	/**
	 * Constructor for Curl, throws MalformedURLException if urlPath is invalid or missing
	 * @param url
	 */
	public Curl (String urlPath) throws MalformedURLException {
		try {
			this.urlPath = urlPath;
			this.url = new URL(this.urlPath);
			this.fileName = FilenameUtils.getBaseName(url.getPath());
		} catch (MalformedURLException e) {
			Output.printURLerror();
		}
	}
		
	
	/**
	 * Execute method for command Curl. utilizes Echo class implementation of new file creation
	 * and its data.
	 * @param void 
	 */
	public void execute() {
		
		Echo executionCurl;
		InputStream streamOfInput;
		DataInputStream streamOfData;
		String data;
		String contents = "";
		String[] echoParams;
		try {
			streamOfInput = this.url.openStream();//throws IOException
			//want to use readline method so i convert to datainputstream
			streamOfData = new DataInputStream(new BufferedInputStream(streamOfInput));

			//get entire contents of file into a String
			while((data = streamOfdata.readLine()) != null ) {
				contents = contents+data;
			}
			echoParams = new String[] {contents,">"+this.fileName};
			executionCurl = new Echo(echoparams);
			executionCurl.execute;
		
			streamOfInput.close();
		} catch (IOException e) {}
	}

}//class closing

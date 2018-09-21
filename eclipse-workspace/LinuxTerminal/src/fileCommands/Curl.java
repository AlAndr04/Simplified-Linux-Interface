// **********************************************************
// Assignment2:

// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #: 1004354263
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID username: babubala
// UT Student #: 1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID username: huang472
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
import input.Location;
import dirCommands.Commands;
import java.io.*;
import input.Output;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Curl class
 * 
 * @author babubala
 *
 */
public class Curl extends Commands<Void> {

  /**
   * Location reference to utilize location class attributes
   */
  private Location loc;
  /**
   * Instance variable url is a String and it stores the url given by user
   */
  private String urlPath;
  /**
   * Instance variable fileName is a String and it stores file name from url
   */
  private String fileName;
  /**
   * Instance variable is of type URL and it is for utilizing native URL methods
   * on given url path name
   */
  private URL url;

  /**
   * Constructor for Curl, throws MalformedURLException/URISyntaxException if
   * urlPath is invalid or missing.
   * 
   * @param url
   */
  public Curl(String urlPath, Location loc)
      throws MalformedURLException, URISyntaxException {
    try {
      this.loc = loc;
      this.urlPath = urlPath;
      // url object for input stream
      this.url = new URL(this.urlPath);
      // temporary URI object to get file name cleanly
      URI urlForFileName = new URI(this.urlPath);
      this.fileName =
          Paths.get(urlForFileName.getPath()).getFileName().toString();
    } catch (URISyntaxException e) {
      Output.commandInvalid();
    } catch (MalformedURLException f) {
      Output.commandInvalid();
    }
  }

  /**
   * Getter method for fileName, returns String (fileName)
   * 
   * @return fileName associated with url
   */
  public String getFileName() {
    return this.fileName;
  }

  /**
   * Getter method for URL obj, returns type URL
   * 
   * @return URL obj associated with url
   */
  public URL getUrl() {
    return this.url;
  }

  /**
   * Getter method for String urlPath(literally the url path)
   * 
   * @return String urlPath (literally the url path)
   */
  public String urlPath() {
    return this.urlPath;
  }

  /**
   * Execute method for command Curl. Utilizes Echo class implementation of new
   * file creation and its data.
   * 
   * @param void
   * @return void
   */
  public Void execute() {
    if (url != null) {
      Echo executionCurl;
      String contents = "";
      String line;
      String[] echoParams;
      try {
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(url.openStream()));
        // get entire contents of file into a String
        while ((line = reader.readLine()) != null) {
          contents = contents + line + "\n";
        }
        // fill out echo constructor parameters as we are using echo
        // functionality
        echoParams = new String[] {contents, ">" + this.fileName};
        executionCurl = new Echo(echoParams, loc);
        executionCurl.execute();

        reader.close();
      } catch (IOException e) {
      }
    }
    return null;
  }

}// class closing

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
// UT Student #: 1002671094
// Author: Zhi Zhong Huang
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package input;

import java.util.*;

/**
 * Parses the commands
 */
public class Parse {
  /**
   * Default Constructor
   */
  public Parse() {}

  /**
   * Takes in a string and parses it into an array
   * by using helper function
   * @param command: Array String
   * @return String[]
   */
  public static String[][] string_to_array(String command) {
    String[] command_array = null;
    String[] file_array = null;
    if (command.contains(">") && (command.contains("echo")== false)) {
    	String[] command_array2 = redirection(command);
    	command_array = Arrays.copyOfRange(command_array2,0, (command_array2.length)-2);
    	file_array = Arrays.copyOfRange(command_array2,(command_array2.length)-2,command_array2.length);
    	}
    else if (command.contains("echo")) {
        command_array = echo(command);
        file_array =null;
        }
    else if (command.charAt(0) == '!') {
    	command_array = historySpecialCase(command);
    	file_array = null;
    	}
    else {
    	command_array = parseAsNormal(command);
    	file_array = null;
    	}
    String [][] ret  = {command_array,file_array};
    
  	System.out.println("The Parse Array is : {"+Arrays.toString(ret[0])+", "+Arrays.toString(ret[1])+"}");
  	return ret;
  }
  /**
   * Takes in a string and parses it into an array
   * But only if its echo
   * EXAMPLE: echo "I like cookies" > file 
   *          -> [echo, "I like Cookies", file1]
   * @param command: Array String
   * @return String[]
   */
  public static String[] echo(String command) {
	  String[] command_array = command.split("\"");
      command_array[0] = command_array[0].replace(" ", "");
	  return command_array;
  }
  /**
   * Takes in a string and parses it into an array
   * But only if its a redirection command for any
   * command except exit. Also it could be new file
   * or append which would be the last element of the
   * array.
   * EXAMPLE: ls /some/directory > output 
   *          -> [ls, /some/directory, output, New]
   * @param command: Array String
   * @return String[]
   */
  public static String[] redirection(String command) {
	//new command 
	String[] command_array;
	command = command.trim();
  	if(command.contains(">>")) {
  		command = command + " Append";
  	}
  	else if (command.contains(">")) {
  		command = command + " New";
  	}
  	command = command.replaceAll("\\s+","!");
  	command = command.replaceAll(">","!");
  	command_array = command.split("!");
  	ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(command_array));
  	arrayList.removeAll(Arrays.asList("", null));
  	command_array = new String[arrayList.size()];
  	command_array = arrayList.toArray(new String[arrayList.size()]);
	return command_array ;
  }
  /**
   * ALEX COULD YOU WRITE THE DOC STRINGS FOR THIS
   * EXAMPLE: 
   * @param command: Array String
   * @return String[]
   */  
  public static String[] historySpecialCase(String command) {
	  String[] command_array;
      String[] temp = command.substring(1).split("\\s+");
      command_array = new String[temp.length + 1];
      command_array[0] = "hist_command";
      for (int i = 1; i < temp.length + 1; i++) {
        command_array[i] = temp[i-1];
      }
	return command_array;
  }
  /**
   * This is to parse the command into an array
   * with no special requirements
   * EXAMPLE: mkdir Abhi Alec Balaji Henry
   *          -> [mkdir, Abhi, Alec, Balaji, Henry]
   * @param command: Array String
   * @return String[]
   */
  public static String[] parseAsNormal(String command) {
	String[] temp = command.split("\\s+");
    String[] command_array;
	if (temp[0].equals("")) {
        command_array = Arrays.copyOfRange(temp, 1, temp.length);
      } else {
        command_array = temp;
      }
	return command_array;	  
  }
  
}



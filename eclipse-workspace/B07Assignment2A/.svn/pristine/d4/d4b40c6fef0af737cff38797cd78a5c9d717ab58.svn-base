// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #:
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID user_name: babubala
// UT Student #:1003354871
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
package input;

import driver.JShell;
import java.util.*;

/**
 * Class for Validating userInput
 * 
 * @author Balaji Babu
 *
 */
public class Validator {
  /**
   * in_string is userIn (user input)
   */
  private String in_string;
  /**
   * com_array is userInput parsed (divided) in an array
   */
  private String[] com_array;
private String[][] com_array_and_file;

  /**
   * Constructor for object Validator, instantiates userInput and the parameters
   * etc
   * 
   * @param userIn: the Input from user
   * @return None
   */
  public Validator(String userIn) {
    this.in_string = userIn;
    this.com_array_and_file = Parse.string_to_array(this.in_string);
    this.com_array = com_array_and_file[0];
  }

  /**
   * Returns true or false in accordance with whether the input is valid in
   * terms of being an actual command, and if it is a command, are the number of
   * parameters valid.
   * 
   * @param None
   * @return boolean: True or false depending whether the input is valid
   */
  public boolean isvalid() {
    boolean flag = true;
    int size = this.com_array.length;
    if (size >= 6 && "find".contains(com_array[0])
        && "-name".contains(com_array[size - 2])
        && Arrays.asList("d", "f").contains(com_array[size - 3])
        && "-type".contains(com_array[size - 4])) {
      flag = true;
    } else if (size >= 1 && "ls".contains(com_array[0])) {
      flag = true;
    } else if (size >= 2
        && Arrays.asList("mkdir", "cat").contains(com_array[0])) {
      flag = true;
    } else if (size == 3
        && Arrays.asList("mv", "cp").contains(com_array[0])) {
      flag = true;
    }else if (size == 2 && Arrays.asList("cd", "history", "pushd", "man", "hist_command")
        .contains(com_array[0])) {
      flag = true;
    } else if (size == 1 && Arrays.asList("pwd", "tree", "history", "popd")
        .contains(com_array[0])) {
      flag = true;
    } else if ((size == 2 || size == 3) && com_array[0].contains("echo")) {
    	flag = true;
      if(size == 3 && com_array[2].contains(">")) {
    	  String com = com_array[2].trim();
    	  com = com.replaceAll(">", "");
    	  com = com.trim();
    	  String[] com_arr = com.split(" ");
    	  if (com_arr.length == 1) {
    		  flag = true;
    	  							} 
    	  else {
    		  flag = false;
    	  		}
      						}

    } 
    System.out.println(flag);
    return flag;
  }

  /**
   * Returns an array of the input command string parsed, i.e the name and the
   * paramaters seperated
   * 
   * @param: None
   * @return String[]: array of the parsed cmd string
   */
  public String[] valid_parsed_commands() {
    if (this.isvalid() == true) {
    } else {
      Output.commandInvalid();
      this.com_array = null;
    }
    return com_array;

  }


}

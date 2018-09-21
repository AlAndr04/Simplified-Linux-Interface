// **********************************************************
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #:
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID username: babubala
// UT Student #:1003354871
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
package input;

import driver.JShell;
import test.MockParse;
import java.util.*;

/**
 * Class for Validating userInput
 * 
 * @author Balaji Babu
 *
 */
public class Validator {
  /**
   * instring is userIn (user input)
   */
  private String instring;
  /**
   * comarray is userInput parsed (divided) in an array
   */
  private String[] comArray;
  private String[][] comarrayandfile;

  /**
   * Constructor for object Validator, instantiates userInput and the parameters
   * etc
   * 
   * @param userIn: the Input from user
   * @return None
   */
  public Validator(String userIn) {
    this.instring = userIn;
    this.comarrayandfile = Parse.stringtoarray(this.instring);
    this.comArray = comarrayandfile[0];
  }

  /**
   * Constructor for object Validator, this constructor is used for testing and
   * does not actually depend on the the class Parse.
   * 
   * @param userIn: the Input from user
   * @return None
   */
  public Validator(String userIn, boolean flag) {
    if (flag == true) {
      this.instring = userIn;
      MockParse parse = new MockParse();
      this.comarrayandfile = parse.stringtoarray(instring);
      this.comArray = comarrayandfile[0];
    }
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
    boolean flag = false;
    int size = this.comArray.length;
    if (size >= 6 && "find".contains(comArray[0])
        && "-name".contains(comArray[size - 2])
        && Arrays.asList("d", "f").contains(comArray[size - 3])
        && "-type".contains(comArray[size - 4])) {
      flag = true;
    } else if (size >= 1 && Arrays.asList("ls", "ls-R").contains(comArray[0])) {
      flag = true;
    } else if (size >= 2
        && Arrays.asList("mkdir", "cat").contains(comArray[0])) {
      flag = true;
    } else if (size >= 3
        && Arrays.asList("grep", "grep-R").contains(comArray[0])) {
      flag = true;
    } else if (size == 3 && Arrays.asList("mv", "cp").contains(comArray[0])) {
      flag = true;
    } else if (size == 2
        && Arrays.asList("cd", "history", "pushd", "man", "histcommand", "curl")
            .contains(comArray[0])) {
      flag = true;
    } else if (size == 1 && Arrays.asList("pwd", "tree", "history", "popd")
        .contains(comArray[0])) {
      flag = true;
    } else if ((size == 2 || size == 3) && comArray[0].contains("echo")) {
      flag = true;
      if (size == 3 && comArray[2].contains(">")) {
        String com = comArray[2].trim();
        com = com.replaceAll(">", "");
        com = com.trim();
        String[] comarr = com.split(" ");
        if (comarr.length == 1) {
          flag = true;
        } else {
          flag = false;
        }
      }
    }
    return flag;
  }

  /**
   * Returns an array of the input command string parsed, i.e the name and the
   * paramaters seperated
   * 
   * @param: None
   * @return String[]: array of the parsed cmd string
   */
  public String[][] validparsedcommands() {
    if (this.isvalid() == true) {
    } else {
      Output.commandInvalid();
      this.comarrayandfile[0] = null;
    }
    return comarrayandfile;
  }


}

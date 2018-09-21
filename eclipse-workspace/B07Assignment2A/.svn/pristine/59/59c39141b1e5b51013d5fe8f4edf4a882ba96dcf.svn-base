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
   * Takes in a string and parses it into an array by using helper function
   * 
   * @param command: Array String
   * @return String[]
   */
  public static String[][] stringtoarray(String command) {
    String[] commandArray = null;
    String[] filearray = null;
    if (command.contains(">") && (command.contains("echo") == false)) {
      int index = command.indexOf(">");
      filearray = new String[1];
      filearray[0] = command.substring(index);
      commandArray = parseAsNormal(command.substring(0, index));
    } else if (command.contains("echo")) {
      commandArray = echo(command);
      filearray = null;
    } else if (command.charAt(0) == '!') {
      commandArray = historySpecialCase(command);
      filearray = null;
    } else {
      commandArray = parseAsNormal(command);
      filearray = null;
    }
    if ((commandArray.length >= 2) && (commandArray[1].equals("-R"))) {
      commandArray = changeRName(commandArray);
    }
    String[][] ret = {commandArray, filearray};
    return ret;
  }

  /**
   * Takes in a string and parses it into an array But only if its echo EXAMPLE:
   * echo "I like cookies" > file -> [echo, "I like Cookies", file1]
   * 
   * @param command: Array String
   * @return String[]
   */
  private static String[] echo(String command) {
    String[] commandarray = command.split("\"");
    commandarray[0] = commandarray[0].replace(" ", "");
    return commandarray;
  }

  /**
   * Given the !number command, splits the string into [histcommand, number].
   * 
   * @param command: Array String
   * @return String[]
   */
  private static String[] historySpecialCase(String command) {
    String[] commandarray;
    String[] temp = command.substring(1).split("\\s+");
    commandarray = new String[temp.length + 1];
    commandarray[0] = "histcommand";
    for (int i = 1; i < temp.length + 1; i++) {
      commandarray[i] = temp[i - 1];
    }
    return commandarray;
  }

  /**
   * This is to parse the command into an array with no special requirements
   * EXAMPLE: mkdir Abhi Alec Balaji Henry -> [mkdir, Abhi, Alec, Balaji, Henry]
   * 
   * @param command: Array String
   * @return String[]
   */
  private static String[] parseAsNormal(String command) {
    String[] temp = command.split("\\s+");
    String[] commandarray;
    if (temp[0].equals("")) {
      commandarray = Arrays.copyOfRange(temp, 1, temp.length);
    } else {
      commandarray = temp;
    }
    return commandarray;
  }

  /**
   * Given a command that user -R, it combines -R with the name of the command
   * 
   * @param command: Array String
   * @return String[]
   */
  private static String[] changeRName(String[] comArray) {
    String[] temp = new String[comArray.length - 1];
    temp[0] = comArray[0] + "-R";
    for (int i = 2; i < comArray.length; i++) {
      temp[i - 1] = comArray[i];
    }
    return temp;
  }
}



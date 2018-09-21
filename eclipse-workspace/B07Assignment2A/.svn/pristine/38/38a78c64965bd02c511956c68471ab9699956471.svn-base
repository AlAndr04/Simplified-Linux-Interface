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
package input;

import java.util.Arrays;
import fileCommands.Echo;
import java.util.HashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import dirCommands.*;
import driver.*;

/**
 * class Command Manger handles commands by validating and varseing it
 */
public class CommandManager {
  // Creates 3 instance variables: command to store the raw input string,
  // arraycommand to store the parsed valid commands, and arraycommand2
  // where the all the paths used (if any), are transformed to absolute.
  /**
   * command inputted by the user of type string
   */
  private String command;
  /**
   * An arraycommand of type array used for parseing
   */
  private String[][] commandfile;
  /**
   * STring array to store command parts
   */
  private String[] arraycommand;
  /**
   * An arraycommand2 of type array used for parseing
   */
  private String[] arraycommand2;
  /**
   * Location type var to store location
   */
  private Location loc;

  /**
   * Constructs: CommandManager accepts input checks wheathere is valid or not
   * parses it and exectues it accordigly
   * 
   * @param None
   * @return None
   */
  public CommandManager(String command, Location location) {
    this.command = command;
    this.loc = location;
    // Array nopath contains all the commands that have no path and
    // should be passed through relativetoabsolute.
    String[] nopath = {"history", "echo", "man", "histcommand", "curl"};
    // Calling the class Validator
    Validator arrcommand = new Validator(this.command);
    // Parses the command and stores it in arraycommand.
    this.commandfile = arrcommand.validparsedcommands();
    this.arraycommand = this.commandfile[0];
    // Checks if the array of commands is not null, so it does not
    // work with classes that did not pass.
    if (arraycommand != null) {
      // Checks if the command is not in nopath.
      if (!(Arrays.asList(nopath).contains(arraycommand[0]))) {
        // Does special stuff if the command is find, since
        // it includes commands besides paths.
        if (arraycommand[0].equals("find")) {
          // Gets the strings name and file to be name of
          // the file that is searched, which is the last
          // element, and the type of file that is searched
          // that is third last in arraycommand.
          String name = arraycommand[arraycommand.length - 1];
          String file = arraycommand[arraycommand.length - 3];
          // Changes arraycommand so that it stores everything
          // except the type and name commands.
          arraycommand =
              Arrays.copyOfRange(arraycommand, 0, (arraycommand.length - 4));
          // Creates a temporary array that stores all the
          // paths changed to absolute paths.
          String[] temp = this.relativetoabsolute();
          // Makes arraycommand2 to be 2 strings bigger than
          // the temporary array, to store the name and file strings.
          arraycommand2 = new String[temp.length + 2];
          // Copies all the contents of temp, file and name into
          // arraycommand2.
          for (int i = 0; i < temp.length; i++) {
            arraycommand2[i] = temp[i];
          }
          arraycommand2[arraycommand2.length - 2] = file;
          arraycommand2[arraycommand2.length - 1] = name;
        } else if (Arrays.asList("grep", "grep-R").contains(arraycommand[0])) {
          String name = arraycommand[0];
          arraycommand =
              Arrays.copyOfRange(arraycommand, 1, (arraycommand.length));
          String[] temp = this.relativetoabsolute();
          // Makes arraycommand2 to be 2 strings bigger than
          // the temporary array, to store the name and file strings.
          arraycommand2 = new String[temp.length + 1];
          // Copies all the contents of temp, file and name into
          // arraycommand2.
          arraycommand2[0] = name;
          // System.out.println(arraycommand2[0]);
          for (int i = 0; i < temp.length; i++) {
            arraycommand2[i + 1] = temp[i];
          }
        }
        // If the only thing the command deals with is paths,
        // stores in arraycommand2 the entire arraycommand
        // with all paths changed to absolute.
        else {
          arraycommand2 = this.relativetoabsolute();
        }
      }
      // If the command is not valid, makes arraycommand2 null.
      else {
        arraycommand2 = arraycommand;
      }
      RunCommand();
      // System.out.println(arraycommand2[1]);
      // Commands com = new Commands(arraycommand2);
    }
  }

  /**
   * Method RunCommand This is the execution part of the class it uses
   * polymomrphism and calls the appropriate command
   * 
   * @param None
   * @return None
   */

  public void RunCommand() {
    // Creates 3 dictionaries, noinput stores all commands that
    // have no input required and the paths to access the classes.
    // oneinput stores all commands with one input required and all
    // all the paths to their respective classes. Arrayinput stores
    // everything that has a String[] as an input parameter. The split
    // is done because all of those 3 types of commands have different
    // constructors.
    String output = "";
    Map<String, String> noinput = new HashMap<String, String>();
    noinput.put("pwd", "dirCommands.Pwd");
    noinput.put("popd", "dirCommands.Popd");
    noinput.put("history", "input.History");
    noinput.put("tree", "dirCommands.Tree");
    Map<String, String> oneinput = new HashMap<String, String>();
    oneinput.put("cd", "dirCommands.Cd");
    oneinput.put("history", "input.History");
    oneinput.put("pushd", "dirCommands.Pushd");
    oneinput.put("man", "dirCommands.Man");
    oneinput.put("histcommand", "input.ExecuteHistory");
    oneinput.put("curl", "fileCommands.Curl");
    Map<String, String> arrayinput = new HashMap<String, String>();
    arrayinput.put("find", "dirCommands.Find");
    arrayinput.put("mkdir", "dirCommands.Mkdir");
    arrayinput.put("echo", "fileCommands.Echo");
    arrayinput.put("cat", "fileCommands.Cat");
    arrayinput.put("cp", "dirCommands.Cp");
    arrayinput.put("mv", "dirCommands.Mv");
    Map<String, String> RInput = new HashMap<String, String>();
    RInput.put("ls-R", "dirCommands.Ls");
    RInput.put("grep-R", "dirCommands.Grep");
    RInput.put("ls", "dirCommands.Ls");
    RInput.put("grep", "dirCommands.Grep");
    final Commands<?> com;
    Constructor<?> c;
    try {
      // Checks first if the command is a part of arrayinput, since commands
      // like ls and mkdir can have any number of inputs, including one input,
      // so this is done to prevent crashing.
      if (RInput.get(arraycommand2[0]) != null) {
        c = Class.forName(RInput.get(arraycommand2[0]))
            .getConstructor(String[].class, boolean.class, Location.class);
        boolean r = false;
        if (arraycommand2[0].contains("-R")) {
          r = true;
        }
        String[] temp =
            Arrays.copyOfRange(arraycommand2, 1, arraycommand2.length);
        // Instantiate and execute the command.
        com = (Commands) c.newInstance(new Object[] {temp, r, loc});
        output = (String) com.execute();
      } else if (arrayinput.get(arraycommand2[0]) != null) {
        // Gets the constructor for the respective command.
        c = Class.forName(arrayinput.get(arraycommand2[0]))
            .getConstructor(String[].class, Location.class);
        // Creates a temp array that stores everything except the first
        // element, which is the name.
        String[] temp =
            Arrays.copyOfRange(arraycommand2, 1, arraycommand2.length);
        // Instantiate and execute the command.
        com = (Commands) c.newInstance(new Object[] {temp, loc});
        output = (String) com.execute();
        // Now checks if the length is 2. Now it checks the length, and not
        // the contents of the dictionaries, because history is in both
        // remaining dictionaries.
      } else if (arraycommand2.length == 2) {
        // Gets the constructor for the class, instantiates and executes it.
        c = Class.forName(oneinput.get(arraycommand2[0]))
            .getConstructor(String.class, Location.class);
        com = (Commands) c.newInstance(new Object[] {arraycommand2[1], loc});
        output = (String) com.execute();
      } else if (arraycommand2.length == 1) {
        // Instantiates and executes the command.
        c = Class.forName(noinput.get(arraycommand2[0]))
            .getConstructor(Location.class);
        com = (Commands) c.newInstance(new Object[] {loc});
        output = (String) com.execute();
      } // These are the errors that should not show up, but Java knows better
    } catch (IllegalAccessException | InstantiationException
        | NoSuchMethodException | InvocationTargetException
        | ClassNotFoundException e) {
      Output.commandInvalid();
    }
    if (commandfile[1] == null) {
      if (output != null) {
        Output.printTextToShell(output);
      }
    } else {
      if (output != null) {
        String[] temp = {output, commandfile[1][0]};
        Echo echo = new Echo(temp, loc);
        echo.execute();
      }
      else {
        Output.redirectionInvalid();
      }
    }
  }
  /**
   * turns relative path to absolute path and returns String array of it
   * @param None
   * @return String array of absolute path.
   */
  private String[] relativetoabsolute() {
    // Finding the length of the command
    int size = arraycommand.length;
    // Checks if there are any paths to parse.
    if (size >= 2) {
      for (int i = 1; i < size; i++) {
        // Checks if this is not an absolute path already.
        if (arraycommand[i].charAt(0) != '/') {
          // Returns the string that stores the address of the current
          // directory and stores it in absolute.
          String absolute = Pwd.returnPathFromRoot(this.loc.getCurrDir());
          // Gets the path that was requested in the input.
          String path = arraycommand[i];
          String absolutepath = "";
          // Checks if absolute does not equal /, which would mean the current
          // directory is the root directory, then it makes absolutepath
          // equal to ab returnsolute, then it adds / and adds the path to it.
          if (!(absolute.equals("/"))) {
            absolutepath = absolute;
          }
          absolutepath += "/" + path;
          // Restores the absolute path at the same index as the input path.
          arraycommand[i] = absolutepath;
        }
      }

    }

    return arraycommand;

  }

}

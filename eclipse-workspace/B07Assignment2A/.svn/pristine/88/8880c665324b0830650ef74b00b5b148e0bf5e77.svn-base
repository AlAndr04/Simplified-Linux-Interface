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
package input;

import java.util.Arrays;
import java.util.HashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import dirCommands.*;
import driver.*;
/**
 * class Command Manger handles commands by 
 * validating and varseing it
 */
public class CommandManager {
  // Creates 3 instance variables: command to store the raw input string,
  // array_command to store the parsed valid commands, and array_command2
  // where the all the paths used (if any), are transformed to absolute.
	/**
	 * command inputted by the user of type string
	 */
  private String command;
	/**
	 * An array_command of type array used for parseing
	 */
  private String[] array_command;
	/**
	 *  An array_command2 of type array used for parseing
	 */
  private String[] array_command2;
	/**
	 *  Constructs: CommandManager
	 *  accepts input checks wheathere is valid or not
	 *  parses it and exectues it accordigly
	 *  @param None
	 *  @return None
	 */
  public CommandManager(String command) {
    this.command = command;
    // Array no_path contains all the commands that have no path and
    // should be passed through relative_to_absolute.
    String[] no_path = {"history", "echo", "man", "hist_command"};
    // Calling the class Validator
    Validator arr_command = new Validator(this.command);
    // Parses the command and stores it in array_command.
    this.array_command = arr_command.valid_parsed_commands();
    // Checks if the array of commands is not null, so it does not
    // work with classes that did not pass.
    if (array_command != null) {
      // Checks if the command is not in no_path.
      if (!(Arrays.asList(no_path).contains(array_command[0]))) {
        // Does special stuff if the command is find, since
        // it includes commands besides paths.
        if (array_command[0].equals("find")) {
          // Gets the strings name and file to be name of
          // the file that is searched, which is the last
          // element, and the type of file that is searched
          // that is third last in array_command.
          String name = array_command[array_command.length - 1];
          String file = array_command[array_command.length - 3];
          // Changes array_command so that it stores everything
          // except the type and name commands.
          array_command =
              Arrays.copyOfRange(array_command, 0, (array_command.length - 4));
          // Creates a temporary array that stores all the
          // paths changed to absolute paths.
          String[] temp = this.relative_to_absolute();
          // Makes array_command2 to be 2 strings bigger than
          // the temporary array, to store the name and file strings.
          array_command2 = new String[temp.length + 2];
          // Copies all the contents of temp, file and name into
          // array_command2.
          for (int i = 0; i < temp.length; i++) {
            array_command2[i] = temp[i];
          }
          array_command2[array_command2.length - 2] = file;
          array_command2[array_command2.length - 1] = name;
        }
        // If the only thing the command deals with is paths,
        // stores in array_command2 the entire array_command
        // with all paths changed to absolute.
        else {
          array_command2 = this.relative_to_absolute();
        }
      }
      // If the command is not valid, makes array_command2 null.
      else {
        array_command2 = array_command;
      }
      RunCommand();
      // System.out.println(array_command2[1]);
      // Commands com = new Commands(array_command2);
    }
  }
	/**
	 *  Method RunCommand
	 *  This is the execution part of the class
	 *  it uses polymomrphism and calls the appropriate
	 *  command
	 *  @param None
	 *  @return None
	 */

  public void RunCommand() {
    // Creates 3 dictionaries, no_input stores all commands that
    // have no input required and the paths to access the classes.
    // one_input stores all commands with one input required and all
    // all the paths to their respective classes. Array_input stores
    // everything that has a String[] as an input parameter. The split
    // is done because all of those 3 types of commands have different
    // constructors.
    Map<String, String> no_input = new HashMap<String, String>();
    no_input.put("pwd", "dirCommands.Pwd");
    no_input.put("popd", "dirCommands.Popd");
    no_input.put("history", "input.History");
    no_input.put("tree", "dirCommands.Tree");
    Map<String, String> one_input = new HashMap<String, String>();
    one_input.put("cd", "dirCommands.Cd");
    one_input.put("history", "input.History");
    one_input.put("pushd", "dirCommands.Pushd");
    one_input.put("man", "dirCommands.Man");
    one_input.put("hist_command", "input.ExecuteHistory");
    Map<String, String> array_input = new HashMap<String, String>();
    array_input.put("find", "dirCommands.Find");
    array_input.put("mkdir", "dirCommands.Mkdir");
    array_input.put("echo", "fileCommands.Echo");
    array_input.put("ls", "dirCommands.Ls");
    array_input.put("cat", "fileCommands.Cat");
    array_input.put("cp", "dirCommands.Cp");
    array_input.put("mv", "dirCommands.Mv");
    Commands com;
    Constructor<?> c;
    try {
      // Checks first if the command is a part of array_input, since commands
      // like ls and mkdir can have any number of inputs, including one input,
      // so this is done to prevent crashing.
      if (array_input.get(array_command2[0]) != null) {
        // Gets the constructor for the respective command.
        c = Class.forName(array_input.get(array_command2[0]))
            .getConstructor(String[].class);
        // Creates a temp array that stores everything except the first
        // element, which is the name.
        String[] temp =
            Arrays.copyOfRange(array_command2, 1, array_command2.length);
        // Instantiate and execute the command.
        com = (Commands) c.newInstance(new Object[] {temp});
        com.execute();
        // Now checks if the length is 2. Now it checks the length, and not
        // the contents of the dictionaries, because history is in both
        // remaining dictionaries.
      } else if (array_command2.length == 2) {
        // Gets the constructor for the class, instantiates and executes it.
        c = Class.forName(one_input.get(array_command2[0]))
            .getConstructor(String.class);
        com = (Commands) c.newInstance(array_command2[1]);
        com.execute();
      } else if (array_command2.length == 1) {
        // Instantiates and executes the command.
        com = (Commands) Class.forName(no_input.get(array_command2[0]))
            .newInstance();
        com.execute();
      } // These are the errors that should not show up, but Java knows better
    } catch (IllegalAccessException | InstantiationException
        | NoSuchMethodException | InvocationTargetException
        | ClassNotFoundException e) {
      Output.commandInvalid();
    }
  }

  public String[] relative_to_absolute() {
    // Finding the length of the command
    int size = array_command.length;
    // Checks if there are any paths to parse.
    if (size >= 2) {
      for (int i = 1; i < size; i++) {
        // Checks if this is not an absolute path already.
        if (array_command[i].charAt(0) != '/') {
          // Returns the string that stores the address of the current
          // directory and stores it in absolute.
          String absolute = Pwd.returnPathFromRoot(JShell.curr_dir);
          // Gets the path that was requested in the input.
          String path = array_command[i];
          String absolute_path = "";
          // Checks if absolute does not equal /, which would mean the current
          // directory is the root directory, then it makes absolute_path
          // equal to absolute, then it adds / and adds the path to it.
          if (!(absolute.equals("/"))) {
            absolute_path = absolute;
          }
          absolute_path += "/" + path;
          // Restores the absolute path at the same index as the input path.
          array_command[i] = absolute_path;
        }
      }

    }

    return array_command;

  }

}

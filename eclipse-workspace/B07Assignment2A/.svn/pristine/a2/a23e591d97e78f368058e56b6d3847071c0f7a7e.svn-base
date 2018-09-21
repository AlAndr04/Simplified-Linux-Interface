// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #: 1004354264
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

package dirCommands;

import driver.JShell;
import fileSystemObjects.*;
import fileCommands.Mkfile;
import input.PathIncorrectException;
import input.UniqueNameException;
import input.Output;

public class Cp extends Commands<Void>{
  private String newFile;
  private String text;
  private String dest;

  public Cp(String[] input) {
    try {
      File src = Traverse.returnGivenPathFromRootFile(input[0].split("/"));
      this.text = src.getContent();
      this.newFile = src.getName();
      this.dest = input[1];
    } catch (PathIncorrectException e) {
      Output.pathIncorrect(dest);
    }
  }
  public Void execute() {
    try {
    Mkfile mkfile = new Mkfile(dest.split("/"));
    File copy = mkfile.mkFileWPath(this.newFile);
    copy.addToContent(text);
    } catch (UniqueNameException e) {
      Output.nameNotValid(this.newFile);
    } catch (PathIncorrectException e) {
      Output.pathIncorrect(dest);
    }
    return null;
  }
}

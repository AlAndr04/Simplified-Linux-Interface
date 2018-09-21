package dirCommands;

import fileSystemObjects.*;
import input.Output;
import input.PathIncorrectException;
import java.util.Arrays;
import driver.JShell;

public class Mv extends Commands<Void> {
  private File src;
  private Directory dest;

  public Mv(String[] input) {
    try {
      this.src = Traverse.returnGivenPathFromRootFile(input[0].split("/"));
      this.dest = Traverse.findPathString(input[1], JShell.root);
    } catch (PathIncorrectException e) {
      Output.pathIncorrect(input[0]);
    }
  }

  public Void execute() {
    if ((src != null) && (this.dest != null)) {
      this.src.removeFromParentRef();
    } else if (this.dest == null){
      Output.directoryInvalid();
    }
    return null;
  }
  
}

package input;
import dirCommands.Commands;
public class ExecuteHistory extends Commands<Void>{
  private int num_command;
  public ExecuteHistory(String num_history) {
    try {
      // Makes start the size minus new_start.
      this.num_command = Integer.parseInt(num_history) - 1;
      // If new_start is not a number, throws an exception to output and
      // makes new_start bigger than history array.
    } catch (NumberFormatException e) {
      Output.mustBeIntegers();
    }
  }
  public Void execute() {
    if (num_command == Input.History_Arr.size() - 1) {
      Output.InfiniteLoop();
    } else if ((num_command >= 0) && (num_command < Input.History_Arr.size())) {
      CommandManager command = new CommandManager(Input.History_Arr.get(num_command));
    }
    return null;
  }
}

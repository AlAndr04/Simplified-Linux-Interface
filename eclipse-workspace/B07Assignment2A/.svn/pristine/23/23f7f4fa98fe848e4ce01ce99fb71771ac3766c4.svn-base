// **********************************************************
// Assignment2:
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
package test;

import java.util.Arrays;
import java.util.HashMap;


public class MockParse {
  String[] output = {"[[mkdir, abhi, /abhi/Doc, /abhi/Doc/B07], null]",
      "[[mkdir, /abhi/apple], null]", "[[mkdir, /Abhi/Doc/], null]",
      "[[ls-R, /abhi/cdcbo7], null]", "[[ls], [> pop.txt]]",
      "[[ls], [> /Abhi/cscbo7.txt]]", "[[pwd], null]",
      "[[pwd], [> /Abhi/fileName.txt]]", "[[mv, a/b/apple.txt, a/b/c], null]",
      "[[mv, apple.txt, a/b/b], null]", "[[cp, a/b/apple.txt, a/b/c], null]",
      "[[cp, apple.txt, a/b/b], null]", "[[cat, apple.txt], null]",
      "[[cat, /Abhi/Document/apple.txt], null]",
      "[[curl, http://www.cs.cmu.edu/~spok/grimmtmp/073.txt], null]",
      "[[curl, http://www.ub.edu/gilcub/SIMPLE/simple.html], null]",
      "[[echo, This should work,  > pop.txt], null]",
      "[[echo, This should work], null]",
      "[[echo, This should work,  >>pop.txt], null]", "[[man, echo], null]",
      "[[man, boooo], null]", "[[pushd, /user/Abhi/Doc], null]",
      "[[popd], null]", "[[history, 5], null]", "[[histcommand], null]",
      "[[grep-R, /abhi/documents/b07], null]", "[[cd,a], null]",
      "[[cd,/b/c/f], null]", "[[cd,/Hello/], null]"};
  String[] input = {"mkdir abhi /abhi/Doc /abhi/Doc/B07", "mkdir /abhi/apple ",
      "mkdir          /Abhi/Doc/", "ls -R /abhi/cdcbo7", "ls > pop.txt",
      " ls > /Abhi/cscbo7.txt", "pwd", "pwd > /Abhi/fileName.txt",
      "mv a/b/apple.txt a/b/c", "mv apple.txt a/b/b", "cp a/b/apple.txt a/b/c",
      "cp apple.txt             a/b/b", "cat apple.txt",
      "cat      /Abhi/Document/apple.txt",
      "curl http://www.cs.cmu.edu/~spok/grimmtmp/073.txt",
      " curl http://www.ub.edu/gilcub/SIMPLE/simple.html",
      "echo \"This should work\" > pop.txt", " echo \"This should work\"",
      " echo \"This should work\" >>pop.txt", "man \"echo\"", "man boooo",
      "pushd /user/Abhi/Doc", "popd", "history 5", "!3",
      "grep -R /abhi/documents/b07", "cd a", "cd     /b/c/f", "cd /Hello/"};
  static HashMap<String, String> parsedString = new HashMap<>();

  public MockParse() {
    for (int i = 0; i < input.length; i++) {
      parsedString.put(input[i], output[i]);
    }
  }



  public String[][] stringtoarray(String instring) {
    System.out.println("This is the instring " + instring);
    String output = parsedString.get(instring);
    System.out.println("This is the output " + output);
    output = output.replace("[[", "");
    output = output.replace("]", "");
    System.out.println(output);
    String[] pop = output.split(",");
    String[] a1 = Arrays.copyOfRange(pop, 0, (pop.length) - 1);
    System.out.println(Arrays.toString(a1));
    if (a1[0].contains("ls")) {
      String[][] ret = {a1, {"> pop.txt"}};
      System.out.println("This is the reurned array " + "["
          + Arrays.toString(ret[0]) + "],[" + ret[1] + "]");
      return ret;
    } else {
      String[][] ret = {a1, null};
      return ret;
    }
  }

}

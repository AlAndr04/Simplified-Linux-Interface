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

import dirCommands.*;
import input.Location;
import fileCommands.*;
import fileSystemObjects.*;
import input.UniqueNameException;
import java.util.ArrayList;
import java.util.Stack;

public class MockJShell {
  private Directory moveDir;
  private File fileRef;
  private File file1;
  private File file2;
  private File file3;
  private Directory rootDir = new Directory("/");
  private Location MockLocation;

  public Directory getRootDir() {
    return rootDir;
  }

  public MockJShell() {
    try {
      ArrayList<String> MockHistory = new ArrayList<String>();
      MockHistory.add("apple.txt");
      MockHistory.add("mkdir a");
      MockHistory.add("pwd");
      MockHistory.add("grep -R a /Dir_1");
      MockHistory.add("history");
      MockLocation = new Location(rootDir, MockHistory, new Stack<String>());
      Directory onelevelOne = Directory.makeDir("Dir_1", rootDir);
      moveDir = onelevelOne;
      Directory.makeDir("Dir_1_1", onelevelOne);
      File oneFileLevelTwo = new File("file_1_1", onelevelOne);
      file1 = oneFileLevelTwo;
      fileRef = oneFileLevelTwo;
      Directory.makeDir("Dir_1_2", onelevelOne);
      Directory twolevelOne = Directory.makeDir("Dir_2", rootDir);
      File twoFileLevelTwo = new File("file_2_1", twolevelOne);
      Directory threelevelOne = Directory.makeDir("Dir_3", rootDir);
      Directory fourlevelOne = Directory.makeDir("Dir_4", rootDir);
      Directory fivelevelOne = Directory.makeDir("Dir_5", rootDir);
      Directory.makeDir("Dir_5_1", fivelevelOne);
      File fiveFileLevelTwo = new File("file_5_1", fivelevelOne);
      file2 = twoFileLevelTwo;
      file3 = fiveFileLevelTwo;
      Directory.makeDir("Dir_5_2", fivelevelOne);
      Directory.makeDir("Dir_1_2", fivelevelOne);
      // Tree newTree = new Tree(getMockLocation());
      // System.out.println(newTree.buildTree(rootDir, 0));
    } catch (UniqueNameException e) {
      System.out.println("This shouldn't be reached.");
    }
  }

  public Location getMockLocation() {
    return MockLocation;
  }

  public void moveCurrDirOneLevelOne() {
    MockLocation.setCurrDir(moveDir);
  }

  public Directory returnMoveDir() {
    return moveDir;
  }

  public File returnFileRef() {
    return fileRef;
  }

  public void makeFolderWithSameName() throws UniqueNameException {
    Directory.makeDir("file", rootDir);
  }

  public void catFileEdit() {
    file1.addToContent("This is my file 1_1");
    file2.addToContent("This is my file 2_1");
    file3.addToContent("This is my file 5_1");
  }

  public void catFileWipe() {
    file1.delStrings();
    file2.delStrings();
    file3.delStrings();
  }
}

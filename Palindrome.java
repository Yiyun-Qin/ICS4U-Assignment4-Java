import java.util.ArrayList;
import java.util.Scanner;
/**
 * The function reverses a string.
 *
 * @author  Yiyun Qin
 * @version 1.0
 * @since 2022-11-13
 *
 */

class Palindrome {
  public static ArrayList<Integer> checking(int someInt, int turn) {
    final int turnRun = turn + 1;
    ArrayList<Integer> answer = new ArrayList<Integer>();
    final String someIntString = String.valueOf(someInt);
    final int newInt = Integer.parseInt(reverse(someIntString));
    final int sum = someInt + newInt;
    if (someInt == Float.parseFloat(reverse(String.valueOf(someInt)))) {
      answer.add(someInt);
      answer.add(0);
      return answer;
    } else if (sum == Float.parseFloat(reverse(String.valueOf(sum)))) {
      answer.add(sum);
      answer.add(turnRun);
      return answer;
    } else {
      return checking(sum, turnRun);
    }
  }

  static String reverse(String someIntString) {
    if (someIntString.isEmpty()) {
      return someIntString;
    } else {
      return reverse(someIntString.substring(1)) + someIntString.charAt(0);
    }
  }

  /**
   * The main function.
   *
   */

  public static void main(String[] args) {
    final String someIntString;
    ArrayList<Integer> answerList = new ArrayList<Integer>();

    Scanner myobj = new Scanner(System.in);
    System.out.print("Please enter an integer: ");
    someIntString = myobj.next();

    System.out.println("");
    try {
      final int someInt = Integer.parseInt(someIntString);
      if (someInt < 0) {
        System.out.println("Please enter a positive integer.");
      } else {
        answerList = checking(someInt, 0);
        System.out.println(answerList.get(0) + " is a palindrome. " + someInt
                        + " is a depth " + answerList.get(1) + " palinerome.");
      }
    } catch (Exception e) {
      System.out.println("Invalid number!");
    } finally {
      System.out.println("\nDone.");
    }
  }
}
  

// Implement an algorithm to determine if a string has all unique characters What if you can not use
// additional data structures?

public class HasAllUniqueChars {

  final static int CHAR_SET = 256;

  static boolean hasAllUniqueChars(final String str) {
    boolean[] counter = new boolean[CHAR_SET];
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      counter[c] = true;
    }
    for (boolean b : counter) {
      if (!b) {
        return false;
      }
    }
    return true;
  }

}

// Implement an algorithm to determine if a string has all unique characters. What if you can not use
// additional data structures?

public class IsAllUniqueChars {

  final static int CHAR_SET = 256;

  static boolean isAllUniqueChars(final String str) {
    boolean[] counter = new boolean[CHAR_SET];
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      if (counter[c]) {
        return false;
      }
      counter[c] = true;
    }
    return true;
  }

  public static void main(String[] args) {
    assert isAllUniqueChars("123");
    assert isAllUniqueChars("");
    assert isAllUniqueChars("1");
    assert !isAllUniqueChars("11");
    assert !isAllUniqueChars("121");
  }
}

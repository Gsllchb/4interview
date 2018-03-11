// Design an algorithm and write code to remove the duplicate characters in a string without using
// any additional buffer. NOTE: One or two additional variables are fine.An extra copy of the array
// is not.
// FOLLOW UP
// Write the test cases for this method.

class RemoveDuplicates {

  static void removeDuplicates(char[] str) {
    if (str == null) {
      return;
    }
    int tail = 0;
    for (int i = 0; i < str.length; ++i) {
      boolean hasDuplicate = false;
      for (int j = 0; j < tail; ++j) {
        if (str[j] == str[i]) {
          hasDuplicate = true;
          break;
        }
      }
      if (!hasDuplicate) {
        str[tail++] = str[i];
      }
    }
    if (tail != str.length) {
      str[tail] = 0;
    }
  }


  //================ Test =================
  public static void main(String[] args) {
    String[][] tests = {
        {"1111", "1"},
        {"1234", "1234"},
        {"112211", "12"},
        {"", ""},
        {"1", "1"},
        {"121212", "12"}
    };
    for (String[] test : tests) {
      char[] res = test[0].toCharArray();
      removeDuplicates(res);
      assert equal(res, test[1]);
    }
    char[] res = null;
    removeDuplicates(res);
    assert equal(res, null);
  }

  static boolean equal(final char[] test, String correct) {
    if (test == null) {
      if (correct == null) {
        return true;
      } else {
        return false;
      }
    }
    if (test.length == 0) {
      if (correct.equals("")) {
        return true;
      } else {
        return false;
      }
    }
    int i;
    for (i = 0; i < test.length && test[i] != 0; ++i) {
      if (test[i] != correct.charAt(i)) {
        return false;
      }
    }
    if (i != correct.length()) {
      return false;
    }
    return true;
  }
}

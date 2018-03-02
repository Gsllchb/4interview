// Design an algorithm and write code to remove the duplicate characters in a string without using
// any additional buffer. NOTE: One or two additional variables are fine.An extra copy of the array
// is not.
// FOLLOW UP
// Write the test cases for this method.

public class RemoveDuplicateChars {

  // test cases:
  // "1111" -> "1"
  // "1234" -> "1234"
  // "112211" -> "12"
  // "" -> ""
  // "1" -> "1"
  // "121212" -> "12"
  static void removeDuplicateChars(char[] str) {

    int length = str.length;
    for (int i = 0; i < length; ++i) {
      char c = str[i];
      if (c == 0) {
        break;
      }
      for (int j = length - 1; j > i; --j) {
        if (str[j] == c) {
          for (int k = j + 1; k < length; ++k) {
            str[k - 1] = str[k];
          }
          str[length - 1] = 0;
        }
      }
    }
  }

}

// Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five
// characters, including the null character. )

public class ReverseCStr {

  static void reverse(char[] source) {
    for (int i = 0; i < (source.length - 1) / 2; ++i) {
      swap(source, i, source.length - 2 - i);
    }
  }

  static void swap(char[] source, int index1, int index2) {
    char temp = source[index1];
    source[index1] = source[index2];
    source[index2] = temp;
  }

}

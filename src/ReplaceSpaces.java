// Write a method to replace all spaces in a string with ‘%20’.

class ReplaceSpaces {
  static String replaceSpaces(String str) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      if (c == ' ') {
        res.append("%20");
      } else {
        res.append(c);
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    assert replaceSpaces("").equals("");
    assert replaceSpaces(" ").equals("%20");
    assert replaceSpaces("a").equals("a");
    assert replaceSpaces("a%20").equals("a%20");
    assert replaceSpaces(" %20  ").equals("%20%20%20%20");
  }
}

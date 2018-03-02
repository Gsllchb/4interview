// Write a method to decide if two strings are anagrams or not.

import java.util.HashMap;

public class AreAnagrams {

  static boolean areAnagrams(String str1, String str2) throws Exception {
    if (str1.length() != str2.length()) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str1.length(); ++i) {
      char c = str1.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < str2.length(); ++i) {
      char c = str2.charAt(i);
      if (map.containsKey(c)) {
        int value = map.get(c);
        if (value == 1) {
          map.remove(c);
        } else {
          map.put(c, value - 1);
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    assert areAnagrams("cinema", "iceman");
    assert areAnagrams("", "");
    assert areAnagrams("1", "1");
    assert areAnagrams("12", "12");
    assert areAnagrams("12345", "54321");
    assert !areAnagrams("11", "1");
  }
}

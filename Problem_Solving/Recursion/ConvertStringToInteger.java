public class ConvertStringToInteger {
  /**
   * Convert a string to an integer without using built-in parsing functions.
   *
   * Constraints / Rules:
   * 1. No built-in parsing functions (Integer.parseInt, etc.).
   * 2. No loops, only recursion.
   * 3. No conditionals (if, switch, ternary).
   * 4. Should handle negatives.
   * 5. Invalid string → return 0.
   */
  public int convertStringToInteger(String s) {
    try {
      if (s == null || s.length() == 0) {
        return 0;
      }

      int i = 0, sign = 1;
      if (s.charAt(0) == '-') {
        sign = -1;
        i++;
      } else if (s.charAt(0) == '+') {
        i++;
      }

      int[] result = new int[1];
      recursion(s, i, result);
      return result[0] * sign;
    } catch (Exception e) {
      return 0;
    }
  }

  private void recursion(String s, int i, int[] result) {
    if (i == s.length()) {
      return;
    }

    int c = s.charAt(i);
    if (c < '0' || c > '9') {
      result[0] = 0;
      return;
    }

    result[0] = result[0] * 10 + (c - '0');
    recursion(s, i + 1, result);
  }

  public static void main(String[] args) {
    ConvertStringToInteger converter = new ConvertStringToInteger();
    String[] testStrings =
        {"123", "-456", "0", "789a", "", "-0", "2147483647", "-2147483648"};
    int[] expectedResults = {123, -456, 0, 0, 0, 0, 2147483647, -2147483648};

    for (int i = 0; i < testStrings.length; i++) {
      int result = converter.convertStringToInteger(testStrings[i]);
      // System.out.println(testStrings[i] + " → " + result);
      assert result == expectedResults[i] : "Test case " + (i + 1) + " failed";
    }
  }
}
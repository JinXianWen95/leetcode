package dp;

import java.util.Arrays;

public class ShortestCommonSupersequence_1092 {
  public static void main(String[] args) {
    new ShortestCommonSupersequence_1092().shortestCommonSupersequence("abac", "cab");
  }

  public String shortestCommonSupersequence(String str1, String str2) {
    // memory exceed
    /*
    String[][] dp = new String[str1.length() + 1][str2.length() + 1];

    // base case: if one of the string is empty then the supersequence is itself
    for (int i = 0; i < str1.length(); i++) {
      dp[i + 1][0] = str1.substring(0, i + 1);
    }

    for (int i = 0; i < str2.length(); i++) {
      dp[0][i + 1] = str2.substring(0, i + 1);
    }

    dp[0][0] = "";

    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {
        if (str1.charAt(i-1) == str2.charAt(j-1)) {
          // if match pick the char
          dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
        } else {
          // pick the shortest one
          dp[i][j] = dp[i - 1][j].length() <= dp[i][j - 1].length() ? dp[i - 1][j] + str1.charAt(i-1)
              : dp[i][j - 1] + str2.charAt(j-1);
        }
      }
    }

    for (String[] strings : dp) {
      System.out.println(Arrays.toString(strings));
    }
    return dp[str1.length()][str2.length()];

     */

    // we just need the prevRow instead of the whole dp table
    // we just need the prevRow instead of the whole dp table
    // we just need the prevRow instead of the whole dp table
    String[] prevRow = new String[str2.length()+1];
    for (int col = 0; col <= str2.length(); col++) {
      prevRow[col] = str2.substring(0, col);
    }

    for (int row = 1; row <= str1.length(); row++) {
      String[] currRow = new String[str2.length()+1];
      currRow[0] = str1.substring(0, row);
      for (int col = 1; col <= str2.length(); col++) {
        if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
          // if match pick the diagonal value
          currRow[col] = prevRow[col - 1] + str1.charAt(row - 1);
        } else {
          // pick the shorter one
          currRow[col] = currRow[col - 1].length() < prevRow[col].length()
              ? currRow[col - 1] + str2.charAt(col - 1)
              : prevRow[col] + str1.charAt(row-1);
        }
      }
      prevRow = currRow;
    }

    return prevRow[str2.length()];
  }
}

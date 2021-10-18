package com.solution;

/*
Write a function that adds two strings, where each string represents an arbitrarily large non-negative number.

function String addNumbers(String str1, String str2)

Examples:
- addNumbers("123456789012345678901", "12345678") should return "123456789012358024579".
- addNumbers("123", "11") should return "134".
*/

// Simple class to add two numbers provided as string
public class AddNumbers {

  /**
   * Takes two string and add them and provides the result as String as well
   * @param str1 number 1 as string
   * @param str2 number 2 as string
   * @return sum of the above 2 numbers as string
   */
  public String addNumbers(String str1, String str2) {
    // Check if null or empty; if one is empty its just ambigous to assume it as 0, so throwing error
    if((str1 == null || str1.trim().length() == 0) || str2 == null || str2.trim().length() == 0)
      throw new IllegalArgumentException("Please check the input numbers, "
          + "having blank or null args is not allowed");

    // Remove any whitespace at front or at end, however not assuming any alphabets in the string
    String s1 = str1.trim();
    String s2 = str2.trim();



    // Just getting their lengths
    int index1 = s1.length() - 1;
    int index2 = s2.length() - 1;

    // In order to improve efficiency using StringBuilder
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while(index1 >= 0 || index2 >= 0) {
      int n1 = index1 >= 0 ? s1.charAt(index1--) - '0' : 0;
      int n2 = index2 >= 0 ? s2.charAt(index2--) - '0' : 0;
      int tmpSum = n1 + n2 + carry;
      sb.append(tmpSum % 10);
      carry = tmpSum / 10;
    }

    if(carry > 0) sb.append(carry);

    // Remove unwanted forward zeros, as they are of no use
    for(int i=sb.length()-1; i >= 0; i--) {
      if(sb.charAt(i) != '0' || i==0) {
        sb.setLength(i+1);
        break;
      }
    }
    return sb.reverse().toString();
  }
}

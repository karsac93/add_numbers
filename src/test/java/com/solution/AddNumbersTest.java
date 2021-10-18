package com.solution;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddNumbersTest {

  AddNumbers addNumbers;
  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setup() {
    addNumbers = new AddNumbers();
  }

  @Test
  public void testWithBothStrsNull() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers(null, null);
  }

  @Test
  public void testWithStr1asNull() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers(null, "123");
  }

  @Test
  public void testWithStr2asNull() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers("123", null);
  }

  @Test
  public void testWithStr1asEmptyString() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers("", "123");
  }

  @Test
  public void testWithStr2asEmptyString() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers("123", "");
  }

  @Test
  public void testWithStr1AsEmptySpaces() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers("  ", "123");
  }

  @Test
  public void testWithStr2AsEmptySpaces() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers("123", "  ");
  }

  @Test
  public void testWithBothAsEmptySpaces() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Please check the input numbers, "
        + "having blank or null args is not allowed");
    addNumbers.addNumbers("  ", "  ");
  }

  @Test
  public void testWithSpacesInFrontAndBack() {
    String res = addNumbers.addNumbers(" 123 ", " 45");
    assertEquals("168", res);
  }

  @Test
  public void testWithForwardZerosForBothNumbers() {
    String res = addNumbers.addNumbers("000123", "045");
    assertEquals("168", res);
  }

  @Test
  public void testWithZerosForBothNumbers() {
    String res = addNumbers.addNumbers("0", "0");
    assertEquals("0", res);
  }

  @Test
  public void testWithMultipleZerosForBothNumbers() {
    String res = addNumbers.addNumbers("000000", "00");
    assertEquals("0", res);
  }

  @Test
  public void testWithZerosForstr1() {
    String res = addNumbers.addNumbers("0000000", "4");
    assertEquals("4", res);
  }

  @Test
  public void testWithSmallNumbers() {
    String res = addNumbers.addNumbers("9", "1");
    assertEquals("10", res);
  }

  @Test
  public void testWithLargeNumber() {
    String res = addNumbers.addNumbers("123456789012345678901", "12345678");
    assertEquals("123456789012358024579", res);
  }

  @Test
  public void testWithTwoLargeNumber() {
    String res = addNumbers.addNumbers("84004658108069881199270369130985521",
        "42705838593371775199466706923866020");
    assertEquals("126710496701441656398737076054851541", res);
  }

  @Test
  public void testWithTwoLargeNumberAlsoSomeForwardZeros() {
    String res = addNumbers.addNumbers("00000084004658108069881199270369130985521",
        "0042705838593371775199466706923866020");
    assertEquals("126710496701441656398737076054851541", res);
  }
}

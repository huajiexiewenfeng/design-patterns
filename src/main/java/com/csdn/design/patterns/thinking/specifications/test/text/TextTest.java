package com.csdn.design.patterns.thinking.specifications.test.text;


/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 15:42
 */
public class TextTest {

  public void testToNumber() {
    Text text = new Text("123");
    Assert.assertEquals(123, text.toNumber());
  }

  public void testToNumber_nullOrEmpty() {
    Text text1 = new Text(null);
    Assert.assertNull(text1.toNumber());

    Text text2 = new Text("");
    Assert.assertNull(text2.toNumber());
  }

  public void testToNumber_containsLeadingAndTrailingSpaces() {
    Text text1 = new Text(" 123");
    Assert.assertEquals(123, text1.toNumber());

    Text text2 = new Text("123 ");
    Assert.assertEquals(123, text1.toNumber());

    Text text3 = new Text(" 123 ");
    Assert.assertEquals(123, text1.toNumber());
  }

  public void testToNumber_containsMultiLeadingAndTrailingSpaces() {
    Text text1 = new Text("  123");
    Assert.assertEquals(123, text1.toNumber());

    Text text2 = new Text("123  ");
    Assert.assertEquals(123, text1.toNumber());

    Text text3 = new Text("  123  ");
    Assert.assertEquals(123, text1.toNumber());
  }

  public void testToNumber_containsInvalidCharters() {
    Text text1 = new Text("123a5");
    Assert.assertNull(text1.toNumber());

    Text text2 = new Text("123 5");
    Assert.assertNull(text2.toNumber());
  }
}


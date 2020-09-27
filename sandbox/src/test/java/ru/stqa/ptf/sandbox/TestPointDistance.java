package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPointDistance {
  @Test

  public void distance() {
    Point p1 = new Point(4, 3);
    Assert.assertEquals(p1.distance2(0, 0), 5.0);
  }

  @Test

  public void distance2() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(5, 5);
    assert p1.distance2(p2) > 4.242;
  }

  @Test
  public void distance3() {
    Point p3 = new Point(3.0, 4.0);
    assert p3.distance2(0, 0) == 5;
  }
  @Test
  public void distance4() {
    Point p1 = new Point(4, 3);
    Point p2 = new Point(234, 5);
    Assert.assertEquals(p1.distance2(p2), Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));

  }
}

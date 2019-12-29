package pl.stqa.javafortesters.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void checkIfPointIsNotNull(){
    Point firstPoint = new Point(2,3);
    Point secondPoint = new Point(4,5);

    Assert.assertNotNull(firstPoint);
    Assert.assertNotNull(secondPoint);
  }

  @Test
  public void checkIfTheDistanceBetweenPointsIsCorrect(){
    Point firstPoint = new Point(2, 5);
    Point secondPoint = new Point(5, 9);

    Assert.assertNotEquals(firstPoint.distance(secondPoint), 5.0);
  }
  @Test
  public void checkIfTheDistanceBetweenPointsIsNotCorrect(){
    Point firstPoint = new Point(2, 5);
    Point secondPoint = new Point(5, 9);

    Assert.assertNotEquals(firstPoint.distance(secondPoint), 5);
  }

  @Test
  public void checkThatNoDistanceBetweenPoints() {
    Point firstPoint = new Point(3,3);
    Point secondPoint = new Point(3,3);

    Assert.assertEquals(firstPoint.distance(secondPoint), 0.0);

  }
}

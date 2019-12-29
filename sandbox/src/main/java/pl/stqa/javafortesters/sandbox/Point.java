package pl.stqa.javafortesters.sandbox;

public class Point {

  public double p1;
  public double p2;


  public Point (double p1, double p2){
    this.p1=p1;
    this.p2=p2;
  }
  public double distance(Point point) {
    return Math.sqrt(Math.pow(point.p1 - this.p1, 2) + Math.pow(point.p2 - this.p2, 2));
  }

  public static void main(String[] args) {

    Point a = new Point(3,4);
    Point b = new Point(4,6);
    Point c = new Point(-2, 1);
    Point d = new Point(5, 8);

    System.out.println("Distance beetwen points a=(" + a.p1 + ", " + a.p2 + ") " + "and b=" + "(" + b.p1 + ", " + b.p2 + ") = " + a.distance(b) );
    System.out.println("Distance beetwen points a=(" + c.p1 + ", " + c.p2 + ") " + "and b=" + "(" + d.p1 + ", " + d.p2 + ") = " + c.distance(d) );


  }

  }




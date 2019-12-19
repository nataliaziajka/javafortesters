package pl.stqa.javafortesters.sandbox;

public class MyFirstProgram {

 public static void main(String[] args) {

  hello("world");
  hello("user");
  hello("Alexei");

  Square s = new Square(6);

  System.out.println("Square surface with side " + s.l + " = " + s.area());

  Rectangle r = new Rectangle(4,6);

  System.out.println("Rectangular surface with a side "  + r.a + " and second side " + r.b + " = " + r.area());
 }

  public static  void hello(String somebody){

   System.out.println("Hello" + somebody + "!");
 }
}
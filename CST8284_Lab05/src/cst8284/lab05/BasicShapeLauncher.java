package cst8284.lab05;



public class BasicShapeLauncher {

	public static void main(String[] args){
		
//		BasicShape shape = new BasicShape(2);
		
	    Circle circle = new Circle(4.5);
	    System.out.println(circle.toString());
	    System.out.printf("The circumference of the circle is %.3f", circle.getPerimeter());
	    System.out.printf(" and its area is %.3f \n\n", circle.getArea());
	
	    Square square = new Square(3.0);

	    System.out.println(square.toString());
	    System.out.printf("The circumference of the square is %.3f", square.getPerimeter());
	    System.out.printf(" and its area is %.3f \n\n", square.getArea());
	    
	    Triangle triangle = new Triangle(6.0);
	    System.out.println(triangle.toString());
	    System.out.printf("The circumference of the triangle is %.3f", triangle.getPerimeter());
	    System.out.printf(" and its area is %.3f \n\n", triangle.getArea());
	    
	    Square defaultSquare = new Square();
	    Triangle triangle1 = new Triangle(triangle);
	    Triangle triangle2 = new Triangle(6.0);
	  
	      
	    System.out.println("A square & circle are " + (square.equals(circle)?"":"NOT ") + "equal");
	    System.out.println("The default square is " + (defaultSquare.equals(square)?"":"NOT ") + "equal to a square of width 2.0");
	    
	    System.out.println("\nA triangle is " + (triangle.equals(triangle)?"":"NOT ") + "equal to itself");
	    System.out.println("The copy constructor triangle is " + (triangle.equals(triangle1)?"":"NOT ") + "equal to its source triangle");
	    System.out.println("triangle1 is " + (triangle1.equals(triangle2)?"":"NOT ") + "equal to triangle2");

	}
}

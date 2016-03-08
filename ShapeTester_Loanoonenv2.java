import java.awt.Color;

class Shape {
    private int xLoc;
    private int yLoc;
    private Color color;
    // 1) Add an instance variable for Color...


    public Shape( int xLocation, int yLocation ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
    }
    public int getX() {return xLoc;}
    public int getY() {return yLoc;}
    
    /**
     2) Write an alternate constructor that takes the x, y location AND
     	a color object and initializes all instance variables.
    */
    public Shape( int xLocation, int yLocation, Color c ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
      color = c;
    }










} // end class Shape

/** 3) Write a class Circle that has an instance field for radius and
	   inherits the x,y and color from the Shape class. Write a
	   constructor for Circle that initializes all instance variables,
	   including location.
*/
class Circle extends Shape
{
   private int radius;
   
   public Circle(int xLocation, int yLocation, Color color, int radiusLength)
   {
      super(xLocation,yLocation,color);
      radius = radiusLength;
   }
}



















/** 4) Write a class Rectangle that inherits from Shape and has an instance
 		field for width, height, color and x,y location.
       (4b)Implement a suitable contructor
       for the class (that initializes all instance members.
       (4c) Add a method, int getArea() that returns the area of the
       Rectangle. (4d) Add a method, getBottomRightY that takes no
       parameters and returns the y coordinate of the bottom right
       corner of this rectangle.
*/
class Rectangle extends Shape
{
   private int width;
   private int height;
   
   public Rectangle(int xLocation, int yLocation, Color color, int width1, int height1)
   {
      super(xLocation,yLocation,color);
      width = width1;
      height = height1;
   }
   
   public int getArea()
   {
      return (width*height);
   }
   
   public int getBottomRightY()
   {
      int sum = getY() + height;
      return sum;
   }
   
}


/** 5) Create a public tester class: ShapeTester_Lastna
       Create a few objects
*/

public class ShapeTester_Loanoonenv2
{
   public static void main(String[] args)
   {
      Color black = Color.black; 
      Circle circle = new Circle(50,50,black,5);
      Rectangle rectangle = new Rectangle(50,50,Color.gray, 20, 10);
      System.out.println("Area of Rectangle: "+ rectangle.getArea());
      System.out.println("YLoc of Rectangle's Bottom-Right Corner: " + rectangle.getBottomRightY());
   }
}
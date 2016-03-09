import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

public class TurtleWalk extends GraphicsProgram
{
   public void run()
   {
      GTurtle christian = new GTurtle(300,100);
      add(christian);
      christian.penDown();
      int x = 0;
      christian.left(180);
      while (x<100)
      {
        christian.forward(3);
        x+=3;
      }
      x = 0;
      christian.left(90);
      while (x<200)
      {
        christian.forward(3);
        x+=3;

      }
      x = 0;
      christian.left(90);
      while (x<100)
      {
        christian.forward(3);
        x+=3;
      }
      //New turtle
      GTurtle loanzon = new GTurtle (500,100);
      add(loanzon);
      loanzon.penDown();
      x = 0;
      while (x<100)
      {
         loanzon.forward(3);
         x+=3;
      }
      x = 0;
      loanzon.left(180);
      while (x<50)
      {
         loanzon.forward(3);
         x+=3;
      }
      x = 0;
      loanzon.left(90);
      while (x<200)
      {
        loanzon.forward(3);
        x+=3;
      }
      x = 0;
      loanzon.left(90);
      while (x<100)
      {
        loanzon.forward(3);
        x+=3;
      }
      x = 0;
      loanzon.left(45);
      while (x<25)
      {
        loanzon.forward(3);
        x+=3;
      }
      x = 0;
      loanzon.left(180);
      while (x<25)
      {
        loanzon.forward(3);
        x+=3;
      }
      x = 0;
      loanzon.right(45);
      while (x<150)
      {
        loanzon.forward(3);
        x+=3;
      }
   }
   public static void main(String[] args)
   {
     new TurtleWalk().start(args);
   }
}
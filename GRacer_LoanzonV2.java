import java.awt.Color;
import acm.graphics.GTurtle;
import acm.graphics.GRect;
import acm.graphics.GLine;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class GRacer_LoanzonV2 extends GraphicsProgram
{
   public void run()
   {
      boolean winnerYet = false;
      GTurtle winner;
      GLabel starter = new GLabel("Start",50,250);
      GLabel finisher = new GLabel("Finish",250,250);
      GLine finish = new GLine(300,0,300,500);
      GLine start = new GLine(100,0,100,500);
      add(starter);
      add(finisher);
      add(finish);
      add(start);
      int noTurtles = Integer.parseInt(JOptionPane.showInputDialog(null, "How many turtles are racing?"));
      GTurtle[] racers = new GTurtle[noTurtles];
      int ypos = 100;
      for(int x = 0; x < racers.length; x++)
      {
        racers[x] = new GTurtle(100,ypos);
        ypos+=50;
        add(racers[x]);
      }
      winner = racers[0];
      int crossed = 0;
      while(crossed!=noTurtles)
      {  
          
         try
            {
            Thread.sleep( 1000 );
            }
         catch ( InterruptedException e )
            {
            }
         crossed = 0;
         for(int x = 0; x < racers.length; x++)
         {
           if(racers[x].getX()+5 <300)
           {
               int move = ((int)(Math.random() * 10))+10;
               racers[x].forward(move);

           }
           else
           {
               crossed++;
           }
           if(racers[x].getX()+5 >=300&&!winnerYet)
           {
               winner = racers[x];
               winnerYet=true;
           }
         }
         }
      while(winnerYet)
      {
         winner.setLocation(500,250);
         winner.right((int)(Math.random()*100));
         winner.forward((int)(Math.random()*10));
      }
   }
   public static void main(String[] args)
   {
     new GRacer_LoanzonV2().start(args);
   }
}

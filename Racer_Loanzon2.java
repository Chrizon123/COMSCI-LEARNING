import java.awt.Color;
import acm.graphics.GTurtle;
import acm.graphics.GRect;
import acm.graphics.GLine;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Racer_Loanzon2 extends GraphicsProgram
{
   public void run()
   {
      //Initializes several graphic objects
      GRect podium1 = new GRect(475,275,50,150);
      GLabel first = new GLabel("1st",490,303);
      GRect podium2 = new GRect(425,300,50,125);
      GLabel second = new GLabel("2nd",440,328);
      GRect podium3 = new GRect(525,325,50,100);
      GLabel third = new GLabel("3rd",540,353);
      GLabel starter = new GLabel("Start",50,250);
      GLabel finisher = new GLabel("Finish",250,250);
      GLine finish = new GLine(300,0,300,500);
      GLine start = new GLine(100,0,100,500);
      GTurtle turtle1 = new GTurtle(100,100);
      GTurtle turtle2 = new GTurtle(100,200);
      GTurtle turtle3 = new GTurtle(100,300);
      //Adds these graphics
      add(podium1);
      add(first);
      add(podium2);
      add(second);
      add(podium3);
      add(third);
      add(starter);
      add(finisher);
      add(finish);
      add(start);
      add(turtle1);
      add(turtle2);
      add(turtle3);
      //Initializes booleans necessary to figure out 1st, 2nd, 3rd
      boolean cross1 = false;
      boolean cross2 = false;
      boolean cross3 = false;
      boolean winnerYet = false;
      boolean isWinner1 = false;
      boolean isWinner2 = false;
      boolean isWinner3 = false;
      boolean secondYet = false;
      boolean isSecond1 = false;
      boolean isSecond2 = false;
      boolean isSecond3 = false;
      boolean lastYet = false;
      boolean isLast1 = false;
      boolean isLast2 = false;
      boolean isLast3 = false;
      //Sets pen down and pen colors
      Color blue = new Color(0,0,255);
      Color red = new Color(255,0,0);
      Color green = new Color(0,255,0);
      turtle1.setColor(blue);
      turtle2.setColor(red);
      turtle3.setColor(green);
      turtle1.penDown();
      turtle2.penDown();
      turtle3.penDown();
      while (!cross1 || !cross2 || !cross3)
      {
        int move1 = (int)(Math.random() * 10);
        int move2 = (int)(Math.random() * 10);
        int move3 = (int)(Math.random() * 10);
        turtle1.forward(move1);
        if (turtle1.getX()+5 >= 300)
        {
            cross1 = true;
            if (!winnerYet)
            {
               isWinner1 = true;
               winnerYet = true;
            }
            if (!secondYet&&!isWinner1)
            {
               isSecond1 = true;
               secondYet = true;
            }
            if (!lastYet&&!isSecond1&&!isWinner1)
            {
               isLast1 = true;
               lastYet = true;
            }
        }
        turtle2.forward(move2);
        if (turtle2.getX()+5 >= 300)
        {
            cross2 = true;
            if (!winnerYet)
            {
               isWinner2 = true;
               winnerYet = true;
            }
            if (!secondYet&&!isWinner2)
            {
               isSecond2 = true;
               secondYet = true;
            }
            if (!lastYet&&!isSecond2&&!isWinner2)
            {
               isLast2 = true;
               lastYet = true;
            }
        }
        turtle3.forward(move3);
        if (turtle3.getX()+5 >= 300)
        {
            cross3 = true;
            if (!winnerYet)
            {
               isWinner3 = true;
               winnerYet = true;
            }
            if (!secondYet&&!isWinner3)
            {
               isSecond3 = true;
               secondYet = true;
            }
            if (!lastYet&&!isSecond3&&!isWinner3)
            {
               isLast3 = true;
               lastYet = true;
            }
        }
      }
      while(isWinner1)
      {
         turtle1.setLocation(500,250);
         turtle1.right((int)(Math.random()*100));
         turtle1.forward((int)(Math.random()*10));
         podium1.setFillColor(blue);
         podium1.setFilled(true);
         if (isSecond2)
         {
            turtle2.setLocation(450,275);
            turtle2.right((int)(Math.random()*100));
            turtle2.forward((int)(Math.random()*10));
            podium2.setFillColor(red);
            podium2.setFilled(true);
            turtle3.setLocation(550,300);
            turtle3.right((int)(Math.random()*100));
            turtle3.forward((int)(Math.random()*10));
            podium3.setFillColor(green);
            podium3.setFilled(true);   
         }
         if (isSecond3)
         {
            turtle3.setLocation(450,275);
            turtle3.right((int)(Math.random()*100));
            turtle3.forward((int)(Math.random()*10));   
            podium2.setFillColor(green);
            podium2.setFilled(true);
            turtle2.setLocation(550,300);
            turtle2.right((int)(Math.random()*100));
            turtle2.forward((int)(Math.random()*10)); 
            podium3.setFillColor(red);
            podium3.setFilled(true);
         } 
      }
      while(isWinner2)
      {
         turtle2.setLocation(500,250);
         turtle2.right((int)(Math.random()*100));
         turtle2.forward((int)(Math.random()*10));
         podium1.setFillColor(red);
         podium1.setFilled(true);
         if (isSecond1)
         {
            turtle1.setLocation(450,275);
            turtle1.right((int)(Math.random()*100));
            turtle1.forward((int)(Math.random()*10));
            podium2.setFillColor(blue);
            podium2.setFilled(true);
            turtle3.setLocation(550,300);
            turtle3.right((int)(Math.random()*100));
            turtle3.forward((int)(Math.random()*10));
            podium3.setFillColor(green);
            podium3.setFilled(true);      
         }
         if (isSecond3)
         {
            turtle3.setLocation(450,275);
            turtle3.right((int)(Math.random()*100));
            turtle3.forward((int)(Math.random()*10));   
            podium2.setFillColor(green);
            podium2.setFilled(true);
            turtle1.setLocation(550,300);
            turtle1.right((int)(Math.random()*100));
            turtle1.forward((int)(Math.random()*10));
            podium3.setFillColor(blue);
            podium3.setFilled(true); 
         } 
      }
      while(isWinner3)
      {
         turtle3.setLocation(500,250);
         turtle3.right((int)(Math.random()*100));
         turtle3.forward((int)(Math.random()*10));
         podium1.setFillColor(green);
         podium1.setFilled(true);
         if (isSecond1)
         {
            turtle1.setLocation(450,275);
            turtle1.right((int)(Math.random()*100));
            turtle1.forward((int)(Math.random()*10));
            podium2.setFillColor(blue);
            podium2.setFilled(true); 
            turtle2.setLocation(550,300);
            turtle2.right((int)(Math.random()*100));
            turtle2.forward((int)(Math.random()*10));
            podium3.setFillColor(red);
            podium3.setFilled(true);     
         }
         if (isSecond2)
         {
            turtle2.setLocation(450,275);
            turtle2.right((int)(Math.random()*100));
            turtle2.forward((int)(Math.random()*10)); 
            podium2.setFillColor(red);
            podium2.setFilled(true);
            turtle1.setLocation(550,300);
            turtle1.right((int)(Math.random()*100));
            turtle1.forward((int)(Math.random()*10));
            podium3.setFillColor(blue);
            podium3.setFilled(true);   
         }
      }
   }
   public static void main(String[] args)
   {
     new Racer_Loanzon2().start(args);
   }
}

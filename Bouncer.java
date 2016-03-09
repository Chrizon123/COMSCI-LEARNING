//Christian Loanzon ArraysA12: Bouncing Balls (alternate)
import java.awt.Color;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLine;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
  Class that creates an array of ovals, along with parallel arrays of speeds and directions, based on input.
  This class then utilizes primarily the GOval move method in order to move the ball, then checks for
  barrier infringements and switches directions when necessary.
*/
public class Bouncer extends GraphicsProgram
{
   public void run()
   {
      //creates barrier
      GRect barrier = new GRect(0,0,300,300);
      add(barrier);
      //inputs # of balls
      int noBalls = Integer.parseInt(JOptionPane.showInputDialog(null, "How many balls are bouncing?"));
      //declares array of balls and directions for horizontal(directionS) and vertical(directionV)
      //also declares array of doubles for how fast the balls travel, horizontally and vertically
      GOval[] bouncers = new GOval[noBalls];
      int[] directionS = new int[noBalls];
      int[] directionV = new int[noBalls];
      double[] speedS = new double[noBalls];
      double[] speedV = new double[noBalls];
      for(int x = 0; x < bouncers.length; x++)
      {
        //initializes balls using random values for the xpos and ypos
        bouncers[x] = new GOval(Math.random()*280,Math.random()*280,20,20);
        add(bouncers[x]);
        Color fill = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        bouncers[x].setFillColor(fill);
        bouncers[x].setFilled(true);
        //randomly assigns -1 or 1 to each direction individually
        if(Math.random()*10>=5) {directionS[x] = 1;}
        else {directionS[x] = -1;}
        if(Math.random()*10>=5) {directionV[x] = 1;}
        else {directionV[x] = -1;}
        //assigns speed, minimum is 0.0001, max is 0.0002
        speedS[x] = Math.random() * 0.0001 + 0.0001;
        speedV[x] = Math.random() * 0.0001 + 0.0001;
      }
      //infinite while loop
      while(true)
      {
        //determines whether to switch directions based on proximity to barrier before actually moving
        for(int x = 0; x< bouncers.length;x++)
        {
          if(bouncers[x].getX() + speedS[x] >= 280&&directionS[x]==1)
          {
            directionS[x]*=-1;
          }
          if(bouncers[x].getX() - speedS[x] <= 0&&directionS[x]!=1)
          {
            directionS[x]*=-1;
          }
          if(bouncers[x].getY() - speedV[x] <= 0&&directionV[x]!=1)
          {
            directionV[x]*=-1;
          }
          if(bouncers[x].getY() + speedV[x] >= 280&&directionV[x]==1)
          {
            directionV[x]*=-1;
          }
        }
        //actually moves balls based on previous values
        for(int x = 0; x< bouncers.length;x++)
        {
          bouncers[x].move(speedS[x]*directionS[x],speedV[x]*directionV[x]);
        }
      }
   }
   public static void main(String[] args)
   {
     new Bouncer().start(args);
   }
}
//(new Color((Math.random()*255)(int), (Math.random()*255)(int), (Math.random()*255)(int)))
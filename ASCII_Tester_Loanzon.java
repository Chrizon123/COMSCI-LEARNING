public class ASCII_Tester_Loanzon
{
   public static void main(String[] args)
   {
      ASCII tester = new ASCII();
      tester.printChart();
   }
}
class ASCII
{
   public void printChart()
   {
     for (int x = 32; x <=127; x+=3)
     {
       String stringX = "" + x;
       if (stringX.length()<3)
       {
         stringX = " " + stringX;
       }
       String stringY = "" + (x+1);
       if (stringY.length()<3)
       {
         stringY = " " + stringY;
       }
       String stringZ = "" + (x+2);
       if (stringZ.length()<3)
       {
         stringZ = " " + stringZ;
       }
       System.out.println("" + stringX + " " + (char)x + " " + stringY + " " + (char)(x+1) + " " + stringZ + " " + (char)(x+2)) ;
     }
   }
   public ASCII()
   {
   
   }
}
class dobo
{
   public dobo()
   {
   
   }
   public void c(int x)
   {
   System.out.println("D");
   }
}

class bodo extends dobo
{
   public bodo()
   {
      super();
   }
   public void c(double x)
   {
      System.out.println("C");
   }
}
public class test
{
   public static void main(String[] args)
   {
      dobo x = new bodo();
      x.c(1);
   }
}

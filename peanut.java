public class peanut
{
   public static void main(String[] args)
   {
      Sandwich  sub = new Sub();
      sub.speak(1);
   }
}
class Sandwich
{
   public Sandwich(){}
   public void speak(int i)
   {
      System.out.println("T");
   }
}
class Sub extends Sandwich
{
   public Sub(){}
   public void speak(int i)
   {
      System.out.println("S");
   }
}
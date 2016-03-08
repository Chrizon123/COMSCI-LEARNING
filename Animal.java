public class Zoo_Tester
{
   public static void main(String[] args)
   {
      ArrayList<Animal> zoo = new ArrayList<Animal>();
      
   }
}
abstract class Animal
{
   private String name;
   private String genus;
   public abstract void talk();
   public Animal(String name, String genus)
   {
      this.name = name;
      this.genus = genus;
   }
   public String getName()
   {
      return name;
   }
   public String getGenus()
   {
      return genus;
   }
}
class Monkey extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Monkey()
   {
      super("", "");
   }
}
class Deer extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Deer()
   {
      super("", "");
   }
}
class Seal extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Seal()
   {
      super("", "");
   }
}
class Elephant extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Elephant()
   {
      super("", "");
   }
}
class Lion extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Lion()
   {
      super("", "");
   }
}
class Hawk extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Hawk()
   {
      super("", "");
   }
}
class Cobra extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus());
   }
   public Cobra()
   {
      super("", "");
   }
}
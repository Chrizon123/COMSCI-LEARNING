import java.util.ArrayList;
public class Zoo_Tester
{
   public static void main(String[] args)
   {
      ArrayList<Animal> zoo = new ArrayList<Animal>();
      for(int i = 0; i < 20; i++)
      {
         double random = Math.random();
         if(random < 0.125)
         {
            zoo.add(new Monkey());
         }
         else if(random < 0.25)
         {
            zoo.add(new Deer());
         }
         else if(random < 0.375)
         {
            zoo.add(new Seal());
         }
         else if(random < 0.5)
         {
            zoo.add(new Elephant());
         }
         else if(random < 0.625)
         {
            zoo.add(new Lion());
         }
         else if(random < 0.75)
         {
            zoo.add(new Hawk());
         }
         else if(random < 0.875)
         {
            zoo.add(new Cobra());
         }
         else
         {
            zoo.add(new Otter());
         }
      }
      System.out.println("List of Zoo residents: ");
      for(int i = 0; i < zoo.size(); i++)
      {
         zoo.get(i).talk();
         try
         {
            Thread.sleep(2000);
         }        
         catch(InterruptedException ex) 
         {
            Thread.currentThread().interrupt();
         }
      }
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
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Monkey()
   {
      super("Baboon", "Papio");
   }
}
class Deer extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Deer()
   {
      super("Water Deer", "Hydropote");
   }
}
class Seal extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Seal()
   {
      super("Walrus", "Odobenus");
   }
}
class Elephant extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Elephant()
   {
      super("African Elephant", "Loxodonta");
   }
}
class Lion extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Lion()
   {
      super("Senegal Lion", "Panthera");
   }
}
class Hawk extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Hawk()
   {
      super("Peregrine Falcon", "Falco");
   }
}
class Cobra extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Cobra()
   {
      super("Burrowing Cobra", "Naja");
   }
}
class Otter extends Animal
{
   public void talk()
   {
      System.out.println("I'm a " + getName()  + ", of the genus " + getGenus() + ".");
   }
   public Otter()
   {
      super("Sea Otter", "Enhydra");
   }
}

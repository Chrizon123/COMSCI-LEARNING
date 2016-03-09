/* 
This class deals with a chaotic zoo
*/
import java.util.Collections;
import java.util.ArrayList;
public class ZooTester_Self
{
   public static void main(String args[])
   {
      ArrayList<Animal> zoo= new ArrayList<Animal>();
      zoo.add(new Bird("Kevin"));
      zoo.add(new Lizard("Devin"));
      zoo.add(new Fish("Gavin"));
      Collections.sort(zoo);
      for(Animal ani: zoo)
      {
         ani.speak();
         System.out.print("\n");
      }
   }
}

class Animal implements Comparable
{
   String genus;
   String name;
   int value;
   public void speak() 
   {
      System.out.println("Genus: "+genus+"\nName: "+name +"\nValue: "+ value);
   }
   public Animal(String speciesName)
   {
      name=speciesName;
      value= 1;
   }
   public int getValue() {return value;}
   public int compareTo(Object other)
   {
      Animal temp = (Animal) other;
      if(value >= temp.getValue()){return 1;}
      return -1;
   }
}
class Fish extends Animal
{
   public Fish(String speciesName)
   {
   super(speciesName);
   genus= "Fish";
   value= 2;
   }
}
class Lizard extends Animal
{
   public Lizard(String speciesName)
   {
   super(speciesName);
   genus= "Lizard";
   value = 3;
   }
}
class Bird extends Animal
{
   public Bird(String speciesName)
   {
   super(speciesName);
   genus="Bird";
   value= 4;
   }
}

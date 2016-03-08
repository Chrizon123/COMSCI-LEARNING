import java.util.List;
abstract class Pet
{
   private String name;
   public Pet(String petName)
   {
      name = petName;
   }
   public String getName()
   {
      return name;
   }
   public abstract String speak();
}
//3A.
class Cat extends Pet
{
   public Cat(String name)
   {
      super(name);
   }
   public String speak()
   {
      return "meow";
   }
}
//3B.
class Dog extends Pet
{
   public Dog(String petName)
   {
      super(petName);
   }
   public String speak()
   {
      return "dog-noise";
   }
}
class LoudDog extends Dog
{
   public LoudDog(String name)
   {
      super(name);
   }
   public String speak()
   {
      return super.speak() + super.speak();
   }
}
//3C.
class Kennel
{
   private List<Pet> petList;
   public void allSpeak()
   {
      for(Pet i : petList)
      {
         System.out.println(i.getName() + ": " + i.speak());
      }
   }
}
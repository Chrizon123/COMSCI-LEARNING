import java.util.ArrayList;
class Bell 
{

  private int studentId;
  public Bell( int id )
  {
     studentId = id;
  }
  /**
    Returns student ID
  */
  public int id()
  {
     return studentId;
  }
  /**
    Returns student ID in string form
  */
  public String toString() 
  {
     return "" + studentId;
  }
  /**
    Sets ID
  */
  public void setId(int value)
  {
     studentId = value;
  }
} 
public class BellTester_Loan
{
   public static void main(String[]args)
   { 
      /**
        Initializes original array, this one doesn't get modified, instead it gets copied by methods into a new arraylist, 
        which is then modified.
      */
      System.out.println("**************\nOriginal Array:\n");
      ArrayList<Bell> bells = new ArrayList<Bell>();
      for(int x = 0; x < 10; x++)
      {
         bells.add(new Bell((int)(Math.random()*400)+219000));
         System.out.println("Bell " + (x+1) + ": " + bells.get(x).toString());
      }
      
      System.out.println("**************\nAfter swapping first & last IDs:\n");
      swap(bells);

      System.out.println("**************\nAfter shifting IDs to the right:\n");
      shiftRight(bells);
      
      System.out.println("**************\nAfter zeroing the evens:\n");
      zero(bells);
      
      System.out.println("**************\nAfter replacing with larger neighbors:\n");
      neighbor(bells);
      
      System.out.println("**************\nAfter removing middle elements:\n");
      middle(bells);
      
      System.out.println("**************\nAfter shifting even elements to the front:\n");
      evens(bells);
      
      System.out.println("**************\nSecond largest Bell ID: " + second(bells));
      
      System.out.println("**************\nDuplicates: " + duplicate(bells));
   }
   /**
     Swaps first and last elements after creating a temporary array, then prints out the array in the new order 
   */
   public static void swap(ArrayList<Bell> list)
   {
     ArrayList<Bell> temp = new ArrayList<Bell>(10);
     for(int x = 0; x < 10; x++)
     {
       temp.add(new Bell(list.get(x).id()));
     }
     temp.get(list.size()-1).setId(list.get(0).id());
     temp.get(0).setId(list.get(list.size()-1).id());
     for(int x = 0; x < 10; x++)
     {
         System.out.println("Bell " + (x+1) + ": " + temp.get(x).toString());
     }
   }
   /**
     Shifts all elements to the right after creating a temporary array, then prints out the array in the new order 
   */
   public static void shiftRight(ArrayList<Bell> list)
   {
     ArrayList<Bell> temp = new ArrayList<Bell>(10);
     for(int x = 0; x < 10; x++)
     {
       temp.add(new Bell(list.get(x).id()));
     }
     int tempLast = list.get(list.size()-1).id();
     for(int x = 9; x > 0; x--)
     {
        temp.get(x).setId(list.get(x-1).id());
     }
     temp.get(0).setId(tempLast);
     for(int x = 0; x < 10; x++)
     {
         System.out.println("Bell " + (x+1) + ": " + temp.get(x).toString());
     }
   }
   /**
     Makes all even IDs 219222 after creating a temporary array, then prints out the array in the new values
   */
   public static void zero(ArrayList<Bell> list)
   {
     ArrayList<Bell> temp = new ArrayList<Bell>(10);
     for(int x = 0; x < 10; x++)
     {
       temp.add(new Bell(list.get(x).id()));
     }
     for(int x = 0; x < 10; x++)
     {
        if(temp.get(x).id()%2==0)
        {
          temp.get(x).setId(216222);
        }
     }
     for(int x = 0; x < 10; x++)
     {
         System.out.println("Bell " + (x+1) + ": " + temp.get(x).toString());
     }
   }
   /**
     Replaces IDs with larger ID neighbors after creating a temporary array, then prints out the array in the new order 
   */
   public static void neighbor(ArrayList<Bell> list)
   {
     ArrayList<Bell> temp = new ArrayList<Bell>(10);
     for(int x = 0; x < 10; x++)
     {
       temp.add(new Bell(list.get(x).id()));
     }

     for(int x = 1; x < 9; x++)
     {
       if(temp.get(x).id()<list.get(x+1).id())
       {
         temp.get(x).setId(list.get(x+1).id());
       }
       if(temp.get(x).id()<list.get(x-1).id())
       {
         temp.get(x).setId(list.get(x-1).id());
       }
     }
     for(int x = 0; x < 10; x++)
     {
         System.out.println("Bell " + (x+1) + ": " + temp.get(x).toString());
     }
   }
   /**
     Cuts out middle 2 elements after creating a temporary array, then prints out the array in the new order 
   */
   public static void middle(ArrayList<Bell> list)
   {
     ArrayList<Bell> temp = new ArrayList<Bell>(10);
     for(int x = 0; x < 10; x++)
     {
       temp.add(new Bell(list.get(x).id()));
     }
     temp.remove(4);
     temp.remove(5);
     for(int x = 0; x < 8; x++)
     {
         System.out.println("Bell " + (x+1) + ": " + temp.get(x).toString());
     }
   }
   /**
     Shifts all evens to the front after creating a temporary array, then prints out the array in the new order 
   */
   public static void evens(ArrayList<Bell> list)
   {
     ArrayList<Bell> temp = new ArrayList<Bell>(10);
     for(int x = 0; x < 10; x++)
     {
       if(list.get(x).id()%2==0)
       {
       temp.add(new Bell(list.get(x).id()));
       }
     }
     for(int x = 0; x < 10; x++)
     {
       if(list.get(x).id()%2!=0)
       {
       temp.add(new Bell(list.get(x).id()));
       }
     }
     for(int x = 0; x < 10; x++)
     {
         System.out.println("Bell " + (x+1) + ": " + temp.get(x).toString());
     }
   }
   /**
     Returns second largest Bell
   */
   public static Bell second(ArrayList<Bell> list)
   {
     int secondMax = 0;
     int max = 0;
     for(int x = 0; x < 10; x++)
     {
       if(list.get(max).id()<list.get(x).id())
       {
         max = x;
       }
       if(list.get(secondMax).id()<list.get(x).id()&&x=!max)
       {
         secondMax = x;
       }
     }
     return list.get(secondMax);
   }
   /**
     Returns whether duplicates exist or not
   */
   public static boolean duplicate(ArrayList<Bell> list)
   {
     for(int x = 0; x < 10; x++)
     {
       for(int y = 0; y < 10; y++)
       {
         if(x!=y && list.get(x).id() == list.get(y).id())
         {
           return true;
         }
       }
     }
     return false;
   }
     
   
}
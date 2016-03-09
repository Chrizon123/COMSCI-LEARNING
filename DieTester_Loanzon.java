/**
javadoc:
*/

class Die
{
  //Initializes instance variables
  private int numSides;
  private int faceValue;
  //Accessors
  public int getNumSides()
  {
    return numSides;
  }
  public int getFaceValue()
  {
    return faceValue;
  }
  public String toString()
  {
    String stringValue = "" + getFaceValue();
    return stringValue;
  }
  public void print()
  {
    String printString = this.toString();
    System.out.println(printString);
  }
  //Mutators
  public void roll()
  {
    faceValue = (int)(Math.random() * numSides + 1);
  } 
  //Default constructor
  public Die()
  {
    numSides = 6;
    //faceValue is 0, an extremely temporary value, when constructed
    faceValue = 0 ;
    //Now faceValue has a random value after construction
    roll();
  }
}

public class DieTester_Loanzon
{
  public static void main(String[] args)
  {
    Die die1 = new Die();
    die1.roll();
    Die die2 = new Die();
    die2.roll();
    //even though these dice were rolled during construction, I roll them again
    System.out.println("The first die's face value is: " + die1.getFaceValue() 
                                 + "\nThe second die's face value is: " + die2.getFaceValue());
    die1.print();
    die2.print();
  }
}

//May have may some indentation errors due to canvas
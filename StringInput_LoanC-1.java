//Christian	Loanzon
//Types Asg2
import java.util.Scanner;     
public class StringInput_LoanC
{         
	public static void main(String[]	args)
	{
      //Put declarations in method!!!
      System.out.print("Please enter your first name:  ");
      Scanner firstNa = new Scanner(System.in);
      String first = firstNa.nextLine();
      System.out.print("Please enter you last name:  ");
      Scanner lastNa = new Scanner(System.in);
      String last = lastNa.nextLine();
      //Declarations ^^^
		System.out.println("\"Oh, " + first + " " + last + ", you're such a funny guy!\"");
      //Methods ^^^
      String message = "Hello";
      message = message.toUpperCase();
      System.out.println(message);
      //For question 2.8
	}
}
/*
2.8:
String message = "Hello";
message = message.toUpperCase();

2.10:
An object is anything that you manipulate with a method and is created whenever
a variable is initialized, also holding the information of initialization, but an object variable refers to the location 
of the object.

2.11:
new Rectangle(xCorner,yCorner,width,height);
Rectangle box = new Rectangle(xCorner,yCorner,width,height);

2.16:
a. To construct an object under the class of Rectange, "new Rectangle" must be added 
before the arguments "(5,10,15,20)"
i.e new Rectangle(5,10,15,20)"

b. Even though the value of this rectangle's width is an integer with no decimals, 
double is used as the class, which is incorrect due to the lack of decimals.

c. The variable r was declared, but never initialized its rectangle's values, 
so no object was constructed.

d. First of all, r has no class, as well as no values. Second of all, the method translate
uses integers as an argument, not strings such as "far, far away!"
*/
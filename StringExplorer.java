/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
class MagpieRunner2
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie2 maggie = new Magpie2();

		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}

class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (findKeyword(statement, "no", 0) >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother", 0) >= 0
				|| findKeyword(statement, "father", 0) >= 0
				|| findKeyword(statement, "sister", 0) >= 0
				|| findKeyword(statement, "brother", 0) >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (findKeyword(statement, "dog", 0) >= 0
			    || findKeyword(statement, "cat", 0) >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (findKeyword(statement, "Mr. ", 0) >= 0)
		{
			response = "He sounds like a great teacher.";
		}
		else if (findKeyword(statement, "movie", 0) >= 0)
		{
			response = "I love the James Bond movies.";
		}
		else if (findKeyword(statement, "book", 0) >= 0)
		{
			response = "Books are interesting. I don't read much.";
		}
		else if ((statement.trim()).length() == 0)
		{
			response = "Say something, please.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

    public int findKeyword(String statement, String goal, int startPos)
    {
    	String phrase = statement.trim().toLowerCase();
    	goal = goal.toLowerCase();
    	int psn = phrase.indexOf(goal, startPos);
    	while (psn >= 0)
    	{
    		String before = " ", after = " ";
    		if (psn > 0)
    		{
    			before = phrase.substring(psn - 1, psn);
    		}
    		if (psn + goal.length() < phrase.length())
    		{
    			after = phrase.substring(psn + goal.length(),
    			psn + goal.length() + 1);
    		}
    		/* determine the values of psn, before, and after at this point in the method. */
    		if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
    		&&
    		((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
    		{
    			return psn;
    		}
    		psn = phrase.indexOf(goal, psn + 1);
    	}
    	return -1;
    }

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Cool story, bro.";
		}
		else if (whichResponse == 5)
		{
			response = "What a fascinating statement.";
		}

		return response;
	}
}

/**
 * A program to allow students to try out different
 * String methods.
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";

		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);

		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

		//  Try other methods here:
		Magpie2 maggy = new Magpie2();
		System.out.println(maggy.findKeyword("She's my sister", "sister", 0));
        System.out.println(maggy.findKeyword("Brother Tom is helpful", "brother", 0));
        System.out.println(maggy.findKeyword("I can't catch wild cats.", "cat", 0));
        System.out.println(maggy.findKeyword("I know nothing about snow plows.", "no", 0));
	}
}

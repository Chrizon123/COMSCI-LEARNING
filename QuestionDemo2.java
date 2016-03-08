import java.util.Scanner;
import java.util.ArrayList;
/**
   This program shows a simple quiz with two choice questions.
*/
public class QuestionDemo2
{
   public static void main(String[] args)
   {
      ChoiceQuestion first = new ChoiceQuestion();
      first.setText("What was the original name of the Java language?");
      first.addChoice("*7", false);
      first.addChoice("Duke", false);
      first.addChoice("Oak", true);
      first.addChoice("Gosling", false);

      ChoiceQuestion second = new ChoiceQuestion();
      second.setText("In which country was the inventor of Java born?");
      second.addChoice("Australia", false);
      second.addChoice("Canada", true);
      second.addChoice("Denmark", false);
      second.addChoice("United States", false);
      
      NumericQuestion third = new NumericQuestion("1/10 = ?",0.1);
      
      FillInQuestion fourth = new FillInQuestion("The inventor of Java was _Gosling_");
      
      presentQuestion(first);
      presentQuestion(second);
      presentQuestion(third);
      presentQuestion(fourth);
   }

   /**
      Presents a question to the user and checks the response.
      @param q the question
   */
   public static void presentQuestion(Question q)
   {
      q.display();
      System.out.print("Your answer: ");
      Scanner in = new Scanner(System.in);
      String response = in.nextLine();
      System.out.println(q.checkAnswer(response));
   }
}

class Question
{
   private String text;
   private String answer;

   /**
      Constructs a question with empty question and answer.
   */
   public Question() 
   {
      text = "";
      answer = "";
   }

   /**
      Sets the question text.
      @param questionText the text of this question
   */
   public void setText(String questionText)   
   {
      text = questionText;
   }

   /**
      Sets the answer for this question.
      @param correctResponse the answer
   */
   public void setAnswer(String correctResponse)
   {
      answer = correctResponse;
   }

   /**
      Checks a given response for correctness.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {
      return response.equals(answer);
   }

   /**
      Displays this question.
   */
   public void display()
   {
      System.out.println(text);
   }
}

/**
   A question with multiple choices.
*/
class ChoiceQuestion extends Question
{
   private ArrayList<String> choices;

   /**
      Constructs a choice question with no choices.
   */
   public ChoiceQuestion()
   {
      choices = new ArrayList<String>();
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      choices.add(choice);
      if (correct) 
      {
         // Convert choices.size() to string
         String choiceString = "" + choices.size();
         setAnswer(choiceString);
      }
   }
   
   public void display()
   {
      // Display the question text
      super.display();
      // Display the answer choices
      for (int i = 0; i < choices.size(); i++)
      {
         int choiceNumber = i + 1;
         System.out.println(choiceNumber + ": " + choices.get(i));     
      }
   }
}

class NumericQuestion extends Question
{
   public double answer;
   public NumericQuestion(String text, double answer1)
   {
      setText(text);
      answer = answer1;
   }
   public void setAnswer(double answer1)
   {
      answer = answer1;
   }
   public boolean checkAnswer(String response1)
   {
     double response = Double.parseDouble(response1);
     if(response > answer)
     {
         return (response - answer <= 0.1);
     } 
     else
     {
         return (answer - response <= 0.1);
     }
   }
}

class FillInQuestion extends Question
{
   public FillInQuestion(String question)
   {
      String[] sets = separate(question);
      setAnswer(sets[0]);
      setText(sets[1]);
   }
   
   public String[] separate(String full)
   {
      String[] returns = new String[2];
      String answer = "";
      String question = "";
      boolean inBlank = false;
      for(int i = 0; i<full.length(); i++)
      {
         if(String.valueOf(full.charAt(i)).equals("_"))
         {
            inBlank = !inBlank;
            question = question + full.charAt(i);
         }
         else if(inBlank)
         {
            answer = answer + full.charAt(i);
         }
         else
         {
            question = question + full.charAt(i);
         }
      }
      returns[0] = answer;
      returns[1] = question;
      return returns;
   }
}
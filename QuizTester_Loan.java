public class QuizTester_Loan
{
   public static void main(String[] args)
   {
      Data test = new Data();
      Quiz[] quizzes = new Quiz[10];
      for( int x = 0; x < 10 ; x++ )
      {
         int random = (int) (Math.random() * 100);
         quizzes[x] = new Quiz(random);
         System.out.println((x+1) + ". " + quizzes[x]);
      }
      Measurable[] measured = (Measurable[]) quizzes;
      Measurable max = test.max(measured);
      double average = test.average(measured);
      System.out.println("Highest Score: " + max.getMeasure() + "\tAverage Score: " + average);
   }
}

interface Measurable
{
   double getMeasure();
}

class Data
{
   public static double average(Measurable[] objects)
   {
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      if (objects.length > 0) {return sum/ objects.length;}
      return 0;
   }
   public static Measurable max(Measurable[] objects)
   {
      Measurable max = objects[0];
      for (Measurable obj : objects)
      {
         if(obj.getMeasure() > max.getMeasure())
         {
            max = obj;
         }
      }
      return max;
   }
}

class Quiz implements Measurable
{
   private int score;
   private String grade;
   public Quiz()
   {
      score = 0;
      grade = "F";
   }
   public Quiz(int score1)
   {
      score = score1;
      if(score >= 90) {grade = "A";}
      else if(score >= 80) {grade = "B";}
      else if(score >= 70) {grade = "C";}
      else if(score >= 60) {grade = "D";}
      else                 {grade = "F";}
   }
   public double getMeasure()
   {
      return score;
   }
   public String toString()
   {
      String string = "Quiz Score: " + score + "\tQuiz Grade: " + grade;
      return string;
   }
}
class Question
{
   private String text;
   private String answer;
   
   public Question()
   {
      text = "";
      answer = "";
   }
   
   public void setText(String questionText)
   {
      text = questionText;
   }
   
   public void setAnswer(String correctResponse)
   {
      answer = correctResponse;
   }
   
   public boolean checkAnswer(String response)
   {
      return response.equals(answer);
   }
   
   public void display()
   {
      System.out.println(text);
   }
   
   public String getAnswer()
   {
      return answer;
   }
}

class NumericQuestion extends Question
{
   public double answer;
   
   public void setAnswer(double answer1)
   {
      answer = answer1;
   }
   public boolean checkAnswer(double response)
   {
     if(response > answer)
     {
         return (response - answer < 0.1);
     } 
     else
     {
         return (answer - response < 0.1);
     }
   }
}
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentTester_Loan
{
   public static void main(String[] args)
   {
      ArrayList<Appointment> appointments = new ArrayList<Appointment>();
      for(int i = 0; i < 10; i++)
      {
         if(i%3 == 0)
         {
            appointments.add(new Daily( (int) (Math.random() * 6) + 2000, (int) (Math.random() * 12) + 1, (int) (Math.random() * 31) + 1, "Therapy Talk"));
         }
         else if(i%3 == 1)
         {
            appointments.add(new Onetime( (int) (Math.random() * 6) + 2000, (int) (Math.random() * 12) + 1, (int) (Math.random() * 31) + 1, "Fillings"));
         }
         else
         {
            appointments.add(new Monthly( (int) (Math.random() * 6) + 2000, (int) (Math.random() * 12) + 1, (int) (Math.random() * 31) + 1, "Monthly Brushing"));
         }
      }
      Scanner input = new Scanner(System.in); 
      System.out.println("Enter a day (1-30): ");
      int day = input.nextInt(); 
      System.out.println("Enter a month (1-12): ");
      int month = input.nextInt(); 
      System.out.println("Enter a year (2000-2005): ");
      int year = input.nextInt();    
      System.out.println("Appointments on that day: ");
      for(int i = 0; i < 10; i++)
      {
         if(appointments.get(i).occursOn(year,month,day))
         {
            System.out.println(appointments.get(i));
         }
      }
      boolean isMaking = true;
      while(isMaking)
      {
         System.out.println("Add an appointment!");
         System.out.println("Enter a day (1-30): ");
         int day1 = input.nextInt(); 
         System.out.println("Enter a month (1-12): ");
         int month1 = input.nextInt(); 
         System.out.println("Enter a year (2000-2005): ");
         int year1 = input.nextInt();    
         System.out.println("Enter a description: ");
         Scanner input1 = new Scanner(System.in);
         String description1 = input1.nextLine();
         System.out.println("Type? 1. Daily 2. Onetime 3. Monthly");
         int type1 = input.nextInt();
         if(type1 == 1)
         {
            appointments.add(new Daily(year1,month1,day1,description1));
         }
         else if(type1 == 2)
         {
            appointments.add(new Onetime(year1,month1,day1,description1));
         }
         else if(type1 == 3)
         {
            appointments.add(new Monthly(year1,month1,day1,description1));
         }
         System.out.println("Another? Y/N?");
         Scanner newScan = new Scanner(System.in);
         String answer = newScan.nextLine();
         if(answer.equals("Y")){isMaking = true;}
         else if(answer.equals("N")){isMaking = false;}
      }
      System.out.println("All appointments: ");
      for(int i = 0; i<appointments.size(); i++)
      {
         System.out.println(appointments.get(i));
      }
   }
}

/**
   A class to keep track of a single appointment.
*/
class Appointment
{
   private String description;
   private int year;
   private int month;
   private int day;

   /**
      Initializes appointment for a given date.
      @param year the year
      @param month the month
      @param day the day
      @param description the text description of the appointment
   */
   public Appointment(int year, int month, int day, String description)
   {
      this.year = year;
      this.month = month;
      this.day = day;
      this.description = description;
   }

   /**
      Returns the year of the appointment.
      @return the year
   */
   public int getYear()
   {
      return year;
   }

   /**
      Returns the month of the appointment.
      @return the month
   */
   public int getMonth()
   {
      return month;
   }

   /**
      Returns the day of the appointment.
      @return the day
   */
   public int getDay()
   {
      return day;
   }

   /**
      Determines if the appointment is on the date given.
      @param year the year to check
      @param month the month to check
      @param day the day to check
      @return true if the appointment matches all three parameters
   */
   public boolean occursOn(int year, int month, int day)
   {
      return (year == this.year) && (month == this.month) && (day == this.day);
   }

   /**
      Converts appointment to string description.
   */
   public String toString()
   {
      return description;
   }
}

class Onetime extends Appointment
{
   public Onetime(int year, int month, int day, String description)
   {
      super(year,month,day,description);
   }
   
   public boolean occursOn(int year, int month, int day)
   {
      return (year == getYear()) && (month == getMonth()) && (day == getDay());
   }
   public String toString()
   {
      return "Appointment: Onetime, Date: " + getMonth() + "/" + getDay() + "/" + getYear() + ", Description: " + super.toString();
   }
}

class Daily extends Appointment
{
   public Daily(int year, int month, int day, String description)
   {
      super(year,month,day,description);
   }
   
   public boolean occursOn(int year, int month, int day)
   {
      return ( (day >= getDay()) && (month == getMonth()) ) || (month > getMonth() && year == getYear() || (year > getYear()));
   }
   public String toString()
   {
      return "Appointment: Daily, Date: " + getMonth() + "/" + getDay() + "/" + getYear() + ", Description: " + super.toString();
   }
}

class Monthly extends Appointment
{
   public Monthly(int year, int month, int day, String description)
   {
      super(year,month,day,description);
   }
   
   public boolean occursOn(int year, int month, int day)
   {
      return (day == getDay()) && (year >= getYear());
   }
   public String toString()
   {
      return "Appointment: Monthly, Date: " + getMonth() + "/" + getDay() + "/" + getYear() + ", Description: " + super.toString();
   }
}


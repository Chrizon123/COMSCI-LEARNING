class CoinChanger
{
   private int quarters;
   private int dimes;
   private int nickels;
   private int pennies;
   final public double QV = 0.25;
   final public double DV = 0.10;
   final public double NV = 0.05;
   final public double PV = 0.01;
   public CoinChanger(int setQuarters,int setDimes,int setNickels,int setPennies)
   {
      quarters = setQuarters;
      dimes = setDimes;
      nickels = setNickels;
      pennies = setPennies;
   }
   public void purchase(double purchase, double given)
   {
      double totalChange = purchase - given;
      int quartersNeeded = (int) (totalChange/QV);
      double nextChange = totalChange%QV;
      int dimesNeeded = (int) (nextChange/DV);
      nextChange = nextChange%DV;
      int nickelsNeeded = (int) (nextChange/NV);
      nextChange = nextChange%NV;
      int penniesNeeded = (int) (nextChange/PV);
      quarters = quarters - quartersNeeded;
      dimes = dimes - dimesNeeded;
      nickels = nickels - nickelsNeeded;
      pennies = pennies - penniesNeeded;
      System.out.println("Purchase: $" + purchase + "\nGiven: $" + given + "\nChange: $" + totalChange + "\nQuarters: " +
                         quartersNeeded + "\nDimes: " + dimesNeeded + "\nNickels: " + nickelsNeeded + "\nPennies: " + penniesNeeded);
   }
}
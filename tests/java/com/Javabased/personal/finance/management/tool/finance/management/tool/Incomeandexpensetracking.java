import java.util.Scanner;

public class FinancialTracker {

  private static Scanner sc = new Scanner(System.in);
  private static double totalIncome;
  private static double totalExpense;
  
  public static void main(String[] args) {
    while (true) {
      System.out.println("Enter your transaction type (income/expense) or 'q' to quit: ");
      String transactionType = sc.nextLine();
      if (transactionType.equals("q")) {
        break;
      }
      
      System.out.println("Enter the amount: ");
      double amount = sc.nextDouble();
      sc.nextLine(); // to handle next line character
      
      System.out.println("Enter the category: ");
      String category = sc.nextLine();
      
      if (transactionType.equals("income")) {
        totalIncome += amount;
      } else if (transactionType.equals("expense")) {
        totalExpense += amount;
      }
    }
    
    System.out.println("Total Income: " + totalIncome);
    System.out.println("Total Expense: " + totalExpense);
  }
}

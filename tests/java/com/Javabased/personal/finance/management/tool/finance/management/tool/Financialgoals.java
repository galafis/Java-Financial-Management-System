import java.util.Scanner;
import java.util.HashMap;

public class FinancialTracker {

  private static Scanner sc = new Scanner(System.in);
  private static double totalIncome;
  private static double totalExpense;
  private static HashMap<String, Double> budgets = new HashMap<>();
  private static HashMap<String, Double> goals = new HashMap<>();
  
  public static void main(String[] args) {
    System.out.println("Enter your budgets for each category: ");
    while (true) {
      System.out.println("Enter the category name or 'q' to quit: ");
      String category = sc.nextLine();
      if (category.equals("q")) {
        break;
      }
      
      System.out.println("Enter the budget amount: ");
      double budgetAmount = sc.nextDouble();
      sc.nextLine(); // to handle next line character
      
      budgets.put(category, budgetAmount);
    }
    
    System.out.println("Enter your financial goals: ");
    while (true) {
      System.out.println("Enter the goal name or 'q' to quit: ");
      String goal = sc.nextLine();
      if (goal.equals("q")) {
        break;
      }
      
      System.out.println("Enter the goal amount: ");
      double goalAmount = sc.nextDouble();
      sc.nextLine(); // to handle next line character
      
      goals.put(goal, goalAmount);
    }
    
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
        if (budgets.containsKey(category)) {
          double remainingBudget = budgets.get(category) - amount;
          if (remainingBudget < 0) {
            System.out.println("Warning: Overbudget in category " + category);
          }
          budgets.put(category, remainingBudget);
        }
      }
    }
    
    System.out.println("Total Income: " + totalIncome);
    System.out.println("Total Expense: " + totalExpense);
    System.out.println("Remaining Budgets: " + budgets);
    System.out.println("Financial Goals Progress: ");
    for (String goal : goals.keySet()) {
      double goalAmount = goals.get(goal);
      double savedAmount = totalIncome - totalExpense;

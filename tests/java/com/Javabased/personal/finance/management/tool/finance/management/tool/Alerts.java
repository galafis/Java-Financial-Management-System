import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Alerts {
  private HashMap<String, Double> budgets = new HashMap<>();
  private HashMap<String, Double> expenses = new HashMap<>();

  public void checkBudgets() {
    for (String category : budgets.keySet()) {
      double budget = budgets.get(category);
      double expense = expenses.getOrDefault(category, 0.0);
      if (expense >= budget) {
        sendAlert("Budget exceeded for category: " + category);
      }
    }
  }

  public void scheduleAlerts() {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      public void run() {
        checkBudgets();
      }
    };
    timer.scheduleAtFixedRate(task, 0, 1000 * 60 * 60 * 24);  // run every 24 hours
  }

  private void sendAlert(String message) {
    // send an alert using your preferred method (e.g. email, SMS, etc.)
  }
}

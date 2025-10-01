import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class SpendingAnalysis extends Application {
  private HashMap<String, Double> expenses = new HashMap<>();

  public void start(Stage stage) {
    stage.setTitle("Spending Analysis");

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    barChart.setTitle("Expense by Category");
    xAxis.setLabel("Category");
    yAxis.setLabel("Amount");

    XYChart.Series<String, Number> data = new XYChart.Series<>();
    data.setName("Expenses");
    for (String category : expenses.keySet()) {
      double amount = expenses.get(category);
      data.getData().add(new XYChart.Data<>(category, amount));
    }
    barChart.getData().add(data);

    Scene scene = new Scene(barChart, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

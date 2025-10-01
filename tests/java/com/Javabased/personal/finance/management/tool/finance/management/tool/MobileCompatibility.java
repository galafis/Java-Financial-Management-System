import java.awt.Button;
import java.awt.Insets;
import java.awt.TextField;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MobileFinanceApp extends Application {
  private TransactionManager transactionManager = new TransactionManager();

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Mobile Finance");

    Label titleLabel = new Label("Mobile Finance");
    titleLabel.setAlignment(Pos.CENTER);
    titleLabel.setPadding(new Insets(10));
    titleLabel.setMinHeight(50);
    titleLabel.setMaxWidth(Double.MAX_VALUE);
    titleLabel.setStyle("-fx-font-size: 20px;");

    Label descriptionLabel = new Label("Track your income and expenses on-the-go");
    descriptionLabel.setAlignment(Pos.CENTER);
    descriptionLabel.setPadding(new Insets(10));
    descriptionLabel.setMinHeight(50);
    descriptionLabel.setMaxWidth(Double.MAX_VALUE);

    TextField amountField = new TextField();
    amountField.setPromptText("Amount");
    amountField.setMaxWidth(Double.MAX_VALUE);

    TextField categoryField = new TextField();
    categoryField.setPromptText("Category");
    categoryField.setMaxWidth(Double.MAX_VALUE);

    Button addTransactionButton = new Button("Add Transaction");
    addTransactionButton.setMaxWidth(Double.MAX_VALUE);
    addTransactionButton.setOnAction(event -> {
      double amount = Double.parseDouble(amountField.getText());
      String category = categoryField.getText();
      Transaction transaction = new Transaction(new Date(), amount, category, "");
      transactionManager.addTransaction(transaction);
      amountField.clear();
      categoryField.clear();
    });

    VBox root = new VBox();
    root.setSpacing(10);
    root.setPadding(new Insets(10));
    root.getChildren().addAll(titleLabel, descriptionLabel, amountField, categoryField, addTransactionButton);

    stage.setScene(new Scene(root, 300, 400));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

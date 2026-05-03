/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
This class creates a JavaFX Future Value Application.
It allows users to input an investment amount, interest rate,
and number of years to calculate the future value.
*/
public class YourLastNameFutureValueApp extends Application {

    // Global variables (UI controls)
    private TextField gTxtInvestmentAmount = new TextField();
    private TextField gTxtInterestRate = new TextField();
    private TextArea gTxtFutureValue = new TextArea();

    private Label gLblInvestmentAmount = new Label("Investment Amount:");
    private Label gLblInterestRate = new Label("Interest Rate:");
    private Label gLblYears = new Label("Years:");
    private Label gLblFutureValue = new Label("Future Value:");
    private Label gLblInterestRateFormat = new Label("Enter rate as a percentage");

    private ComboBox<Integer> gCmbYears = new ComboBox<>();

    private Button gBtnCalculate = new Button("Calculate");
    private Button gBtnClear = new Button("Clear");

    /*
    The start method builds the UI and displays the primary stage.
    */
    @Override
    public void start(Stage primaryStage) {

        // Populate ComboBox with years 1–30
        for (int i = 1; i <= 30; i++) {
            gCmbYears.getItems().add(i);
        }
        gCmbYears.setValue(1);

        // Configure TextArea
        gTxtFutureValue.setEditable(false);

        // Set label styling
        gLblInterestRateFormat.setTextFill(Color.RED);

        // Create GridPane layout
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Add components to GridPane
        pane.add(gLblInvestmentAmount, 0, 0);
        pane.add(gTxtInvestmentAmount, 1, 0);

        pane.add(gLblInterestRate, 0, 1);
        pane.add(gTxtInterestRate, 1, 1);
        pane.add(gLblInterestRateFormat, 2, 1);
        GridPane.setHalignment(gLblInterestRateFormat, HPos.RIGHT);

        pane.add(gLblYears, 0, 2);
        pane.add(gCmbYears, 1, 2);

        pane.add(gLblFutureValue, 0, 3);
        pane.add(gTxtFutureValue, 1, 3);

        // Create button container
        HBox actionBtnContainer = new HBox(10);
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.getChildren().addAll(gBtnCalculate, gBtnClear);

        pane.add(actionBtnContainer, 1, 4);

        // Button actions
        gBtnCalculate.setOnAction(e -> calculateFutureValue());
        gBtnClear.setOnAction(e -> clearFields());

        // Setup scene and stage
        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setTitle("YourLastName Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
    This method calculates the future value based on user input.
    Input: investment amount, interest rate, years
    Output: calculated future value displayed in TextArea
    */
    private void calculateFutureValue() {
        try {
            double lInvestmentAmount = Double.parseDouble(gTxtInvestmentAmount.getText());
            double lInterestRate = Double.parseDouble(gTxtInterestRate.getText()) / 100;
            int lYears = gCmbYears.getValue();

            double lFutureValue = lInvestmentAmount * Math.pow(1 + lInterestRate, lYears);

            gTxtFutureValue.setText(String.format("%.2f", lFutureValue));

        } catch (Exception e) {
            gTxtFutureValue.setText("Invalid input");
        }
    }

    /*
    This method clears all input and output fields.
    */
    private void clearFields() {
        gTxtInvestmentAmount.clear();
        gTxtInterestRate.clear();
        gTxtFutureValue.clear();
        gCmbYears.setValue(1);
    }

    /*
    Main method to launch the application.
    */
    public static void main(String[] args) {
        launch(args);
    }
}
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

import java.text.SimpleDateFormat;
import java.util.Date;

/*
This class builds the JavaFX user interface and connects it
to the FinanceCalculator class to compute future values.
*/
public class BalrajEnhancedFutureValueApp extends Application {

    // Global UI controls
    private TextField gTxtMonthlyPayment = new TextField();
    private TextField gTxtInterestRate = new TextField();
    private TextArea gTxtResults = new TextArea();

    private Label gLblMonthlyPayment = new Label("Monthly Payment:");
    private Label gLblInterestRate = new Label("Interest Rate:");
    private Label gLblYears = new Label("Years:");
    private Label gLblFutureValueDate = new Label("");
    private Label gLblInterestRateFormat = new Label("Enter rate as a percentage");

    private ComboBox<Integer> gCbYears = new ComboBox<>();

    private Button gBtnCalculate = new Button("Calculate");
    private Button gBtnClear = new Button("Clear");

    /*
    Builds and displays the application window.
    */
    @Override
    public void start(Stage primaryStage) {

        // Populate ComboBox with values 1 through 30
        for (int i = 1; i <= 30; i++) {
            gCbYears.getItems().add(i);
        }
        gCbYears.setValue(1);

        // Configure results TextArea
        gTxtResults.setEditable(false);

        // Style label
        gLblInterestRateFormat.setTextFill(Color.RED);

        // Create layout
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Add components
        pane.add(gLblMonthlyPayment, 0, 0);
        pane.add(gTxtMonthlyPayment, 1, 0);

        pane.add(gLblInterestRate, 0, 1);
        pane.add(gTxtInterestRate, 1, 1);
        pane.add(gLblInterestRateFormat, 2, 1);
        GridPane.setHalignment(gLblInterestRateFormat, HPos.RIGHT);

        pane.add(gLblYears, 0, 2);
        pane.add(gCbYears, 1, 2);

        pane.add(gLblFutureValueDate, 1, 3);
        pane.add(gTxtResults, 1, 4);

        // Button container
        HBox actionBox = new HBox(10);
        actionBox.setPadding(new Insets(15, 0, 15, 30));
        actionBox.getChildren().addAll(gBtnCalculate, gBtnClear);

        pane.add(actionBox, 1, 5);

        // Button events
        gBtnCalculate.setOnAction(e -> calculateResults());
        gBtnClear.setOnAction(e -> clearFormFields());

        // Scene setup
        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setTitle("Balraj Enhanced Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
    Clears all form fields and resets values.
    */
    private void clearFormFields() {
        gTxtMonthlyPayment.clear();
        gTxtInterestRate.clear();
        gTxtResults.clear();
        gLblFutureValueDate.setText("");
        gCbYears.setValue(1);
    }

    /*
    Calculates the future value and updates UI.
    */
    private void calculateResults() {
        try {
            // Parse inputs
            double lMonthlyPayment = Double.parseDouble(gTxtMonthlyPayment.getText());
            double lRate = Double.parseDouble(gTxtInterestRate.getText());
            int lYears = gCbYears.getValue();

            // Perform calculation
            double lFutureValue = FinanceCalculator.calculateFutureValue(
                    lMonthlyPayment, lRate, lYears
            );

            // Display results
            gLblFutureValueDate.setText("Calculation as of " + getTodayDate());
            gTxtResults.setText("The future value is " + String.format("%.2f", lFutureValue));

        } catch (Exception e) {
            gTxtResults.setText("Invalid input");
        }
    }

    /*
    Returns today's date formatted as MM/dd/yyyy.
    */
    private String getTodayDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(new Date());
    }

    /*
    Launches the application.
    */
    public static void main(String[] args) {
        launch(args);
    }
}
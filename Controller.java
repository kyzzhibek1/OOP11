package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private Text savedNumbers;

    private String firstNumber = "";
    private String currentNumber = "";
    private String calculationType;

    @FXML
    void addAction(ActionEvent event) throws DivisionByZeroException {
        calculationSetup("+");
    }

    @FXML
    void minusAction(ActionEvent event) throws DivisionByZeroException {
        calculationSetup("-");
    }

    @FXML
    void divideAction(ActionEvent event) {
        try {
            calculationSetup("/");
        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void multiplicationAction(ActionEvent event) throws DivisionByZeroException {
        calculationSetup("*");
    }

    public void calculationSetup(String calculationType) throws DivisionByZeroException {
        if (calculationType.equals("/") && currentNumber.equals("0")) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }

        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void calculate(ActionEvent event) {
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);

        switch (calculationType) {
            case "+" -> handleCalculation(firstNumberInt + secondNumberInt);
            case "-" -> handleCalculation(firstNumberInt - secondNumberInt);
            case "/" -> handleCalculation((double) firstNumberInt / secondNumberInt);
            case "*" -> handleCalculation(firstNumberInt * secondNumberInt);
        }
    }

    private void handleCalculation(double result) {
        savedNumbers.setText(firstNumber + " " + calculationType + " " + currentNumber + " = " + result);
        textField.setText(String.valueOf(result));
    }

    @FXML
    void clearTextField(ActionEvent event) {
        currentNumber = "";
        textField.setText("");
        savedNumbers.setText("");
    }

    @FXML
    void button0Clicked(ActionEvent event) {
        if (!currentNumber.equals("")) {
            addNumber("0");
        }
    }

    @FXML
    void button1Clicked(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void button2Clicked(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    void button3Clicked(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void button4Clicked(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void button5Clicked(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void button6Clicked(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void button7Clicked(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void button8Clicked(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void button9Clicked(ActionEvent event) {
        addNumber("9");
    }

    public void updateTextField() {
        textField.setText(currentNumber);
    }

    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }
}

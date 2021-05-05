package controllers;

import javafx.scene.text.Font;
import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private String buffer = "0";
    private BinaryOperations lastOperation;
    private boolean isCommaPressed = false;
    private boolean isMenuVisible = false;
    @FXML
    private Label calcLabel;
    @FXML
    private Label secondaryLabel;
    @FXML
    private Label mainLabel;
    @FXML
    private Button plusMinus;
    @FXML
    private Button zero;
    @FXML
    private Button comma;
    @FXML
    private Button equals;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button plus;
    @FXML
    private Button four;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button minus;
    @FXML
    private Button six;
    @FXML
    private Button five;
    @FXML
    private Button oneDividedX;
    @FXML
    private Button multiply;
    @FXML
    private Button nine;
    @FXML
    private Button square;
    @FXML
    private Button sqrt;
    @FXML
    private Button divide;
    @FXML
    private Button ce;
    @FXML
    private Button percent;
    @FXML
    private Button c;
    @FXML
    private Button del;
    @FXML
    private Button mc;
    @FXML
    private Button mr;
    @FXML
    private Button mPlus;
    @FXML
    private Button mMinus;
    @FXML
    private Button ms;
    @FXML
    private Button mOption;
    @FXML
    private Button option;
    @FXML
    private Button history;
    @FXML
    private Button changeSize;
    @FXML
    private AnchorPane menu;

    private Stage stage;
    MainModel model = new MainModel();
    String result = "0";
    double x, y;

    @FXML
    void dragged(MouseEvent event) {
        if (stage.getScene().getCursor() != Cursor.N_RESIZE) {
            stage.setX(event.getScreenX() + x);
            stage.setY(event.getScreenY() + y);
        }
    }

    @FXML
    void pressed(MouseEvent event) {
        x = stage.getX() - event.getScreenX();
        y = stage.getY() - event.getScreenY();
    }

    @FXML
    void minimize() {
        stage.setIconified(true);
    }

    @FXML
    void close() {
        stage.close();
    }

    @FXML
    public void plusMinusPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.NEGATIVE).toString();
        setMainLabelText(buffer);
    }

    @FXML
    public void digitButtonPressed(ActionEvent actionEvent) {
        String source = actionEvent.getSource().toString();
        String digitButton = source.substring(source.length() - 2, source.length() - 1);
        //System.out.println(digitButton);
        if (digitButton.equals("0")) {
            if (!(new BigDecimal(buffer).equals(BigDecimal.ZERO)) || isCommaPressed) {
                addToBuffer(digitButton);
            }
        } else {
            addToBuffer(digitButton);
        }
    }

    @FXML
    public void commaPressed(ActionEvent actionEvent) {
        if (!isCommaPressed) {
            if (mainLabel.getText().equals("0")) {
                addToBuffer("0.");
            } else {
                addToBuffer(".");
            }
            isCommaPressed = true;
        }
    }

    @FXML
    public void equalsPressed() {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastOperation).toString();
        }
        setMainLabelText(buffer);
        lastOperation = null;
    }

    @FXML
    public void plusPressed() {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastOperation).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastOperation = BinaryOperations.PLUS;

    }

    @FXML
    public void minusPressed() {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastOperation).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastOperation = BinaryOperations.MINUS;
    }

    @FXML
    public void oneDividedXPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.ONE_DIVIDED_X).toString();
        setMainLabelText(buffer);
    }

    @FXML
    public void multiplyPressed() {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastOperation).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastOperation = BinaryOperations.MULTIPLY;
    }

    @FXML
    public void squarePressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.SQUARE).toString();
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
    }

    @FXML
    public void radicalPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.SQRT).toString();
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
    }

    @FXML
    public void dividePressed() {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastOperation).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastOperation = BinaryOperations.DIVIDE;
    }

    @FXML
    public void cePressed() {
        buffer = "0";
        setMainLabelText(buffer);
    }

    @FXML
    public void percentPressed() {
        result = model.percent(new BigDecimal(result), new BigDecimal(buffer), lastOperation).toString();
        buffer = "0";
        setMainLabelText(result);
    }

    @FXML
    public void cPressed() {
        result = "0";
        cePressed();
    }

    @FXML
    public void delPressed() {
        if (buffer.endsWith(".")) {
            isCommaPressed = false;
        }
        if (!buffer.equals("")) {
            buffer = buffer.substring(0, buffer.length() - 1);
        }
        if (buffer.equals("")) {
            buffer = "0";
        }
        setMainLabelText(buffer);
    }

    @FXML
    public void mcPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void mrPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void mMinusPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void mPlusPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void msPressed(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initialize(Stage stage) {
        this.stage = stage;
        menu.setVisible(false);
    }

    private void addToBuffer(String s) {
        if (mainLabel.getText().length() < 21) {
            if (buffer.equals("0")) {
                buffer = s;
            } else {
                buffer += s;
            }
            setMainLabelText(buffer);
        }
    }

    private void setMainLabelText(String text) {
        int indexOfComma;
        int lengthOfWholePart;
        if (text.contains(".")){
            indexOfComma = text.indexOf(".");
            lengthOfWholePart = text.length() - (text.length() - indexOfComma);
        } else {
            indexOfComma = text.length();
            lengthOfWholePart = text.length();
        }
        System.out.println(lengthOfWholePart);


        if(lengthOfWholePart == 16) {
            text = new StringBuilder(text).insert(indexOfComma - 3, " ")
                    .insert(indexOfComma - 6, " ")
                    .insert(indexOfComma - 9, " ")
                    .insert(indexOfComma - 12, " ")
                    .insert(indexOfComma - 15, " ").toString();
        } else if (lengthOfWholePart < 16 && lengthOfWholePart > 11){
            text = new StringBuilder(text).insert(indexOfComma - 3, " ")
                    .insert(indexOfComma - 6, " ")
                    .insert(indexOfComma - 9, " ")
                    .insert(indexOfComma - 12, " ").toString();
        } else if (lengthOfWholePart < 13 && lengthOfWholePart > 8){
            text = new StringBuilder(text).insert(indexOfComma - 3, " ")
                    .insert(indexOfComma - 6, " ")
                    .insert(indexOfComma - 9, " ").toString();
        } else if (lengthOfWholePart < 10 && lengthOfWholePart > 5){
            text = new StringBuilder(text).insert(indexOfComma - 3, " ")
                    .insert(indexOfComma - 6, " ").toString();
        } else if (lengthOfWholePart < 7 && lengthOfWholePart > 2){
            text = new StringBuilder(text).insert(indexOfComma - 3, " ").toString();
        }


            mainLabel.setText(text.replace(".", ","));


        if (mainLabel.getText().length() == 21) {
            mainLabel.setFont(new Font("Segoe UI Semibold", 28)); //28
        } else if(mainLabel.getText().length() >= 19){
            mainLabel.setFont(new Font("Segoe UI Semibold", 32)); //32
        } else if(mainLabel.getText().length() >= 18){
            mainLabel.setFont(new Font("Segoe UI Semibold", 33)); //33
        } else if(mainLabel.getText().length() >= 17){
            mainLabel.setFont(new Font("Segoe UI Semibold", 35)); //35
        } else if(mainLabel.getText().length() >= 15){
            mainLabel.setFont(new Font("Segoe UI Semibold", 39)); //39
        } else if(mainLabel.getText().length() >= 14){
            mainLabel.setFont(new Font("Segoe UI Semibold", 42)); //42
        } else {
            mainLabel.setFont(new Font("Segoe UI Semibold", 46)); //46
        }
    }


    public void optionOpenOrClose() {
        if (!isMenuVisible) {
            menu.setVisible(true);
            isMenuVisible = true;
        } else {
            menu.setVisible(false);
            isMenuVisible = false;
        }
    }

    public void clicked() {
        if (isMenuVisible) {
            menu.setVisible(false);
            isMenuVisible = false;
        }
    }
}
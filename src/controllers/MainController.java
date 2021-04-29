package controllers;

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
    private Button radical;
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
    void minimize(MouseEvent event) {
        stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        stage.close();
    }

    @FXML
    public void plusMinusPressed() {
    }

    @FXML
    public void digitButtonPressed(ActionEvent actionEvent) {
        String source = actionEvent.getSource().toString();
        String digitButton = source.substring(source.length() - 2, source.length() - 1);
        if (digitButton.equals("0")) {
            if (!(new BigDecimal(buffer.replace(",", ".")).equals(BigDecimal.ZERO)) || isCommaPressed) {
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
                addToBuffer("0,");
            } else {
                addToBuffer(",");
            }
            isCommaPressed = true;
        }
    }

    @FXML
    public void equalsPressed() throws DivisionByZeroException {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result.replace(",", ".")), new BigDecimal(buffer.replace(",", ".")), lastOperation).toString().replace(".", ",");
        }
        mainLabel.setText(buffer);
        lastOperation = null;
    }

    @FXML
    public void plusPressed() throws DivisionByZeroException {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result.replace(",", ".")), new BigDecimal(buffer.replace(",", ".")), lastOperation).toString().replace(".", ",");
        }
        result = buffer;
        buffer = "0";
        mainLabel.setText(result);
        lastOperation = BinaryOperations.PLUS;

    }

    @FXML
    public void minusPressed() throws DivisionByZeroException {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result.replace(",", ".")), new BigDecimal(buffer.replace(",", ".")), lastOperation).toString().replace(".", ",");
        }
        result = buffer;
        buffer = "0";
        mainLabel.setText(result);
        lastOperation = BinaryOperations.MINUS;
    }

    @FXML
    public void oneDividedXPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void multiplyPressed() throws DivisionByZeroException {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result.replace(",", ".")), new BigDecimal(buffer.replace(",", ".")), lastOperation).toString().replace(".", ",");
        }
        result = buffer;
        buffer = "0";
        mainLabel.setText(result);
        lastOperation = BinaryOperations.MULTIPLY;
    }

    @FXML
    public void squarePressed() {
    }

    @FXML
    public void radicalPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void dividePressed() throws DivisionByZeroException {
        if (lastOperation != null) {
            buffer = model.calculate(new BigDecimal(result.replace(",", ".")), new BigDecimal(buffer.replace(",", ".")), lastOperation).toString().replace(".", ",");
        }
        result = buffer;
        buffer = "0";
        mainLabel.setText(result);
        lastOperation = BinaryOperations.DIVIDE;
    }

    @FXML
    public void cePressed() {
        buffer = "0";
        mainLabel.setText(buffer);
    }

    @FXML
    public void percentPressed() {

    }

    @FXML
    public void cPressed() {
        result = "0";
        cePressed();
    }

    @FXML
    public void delPressed() {
        if (buffer.endsWith(",")) {
            isCommaPressed = false;
        }
        if (!buffer.equals("")) {
            buffer = buffer.substring(0, buffer.length() - 1);
        }
        if (buffer.equals("")) {
            buffer = "0";
        }
        mainLabel.setText(buffer);
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

    public void initialize(Stage stage){
        this.stage = stage;
        menu.setVisible(false);
    }

    private void addToBuffer(String s) {
        if (buffer.equals("0")) {
            buffer = s;
        } else {
            buffer += s;
        }
        mainLabel.setText(buffer);
    }

    public void optionOpenOrClose() {
        if (!isMenuVisible) {
            menu.setVisible(true);
            isMenuVisible = true;
        } else if (isMenuVisible){
            menu.setVisible(false);
            isMenuVisible = false;
        }
    }

    public void clicked() {
        if (isMenuVisible){
            menu.setVisible(false);
            isMenuVisible = false;
        }
    }
}
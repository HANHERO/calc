package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MainModel;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private String buffer = "0";
    private boolean isCommaPressed = false;
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
    MainModel model = new MainModel();
    double x, y;

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() + x);
        stage.setY(event.getScreenY() + y);
    }

    @FXML
    void pressed(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        x = stage.getX() - event.getScreenX();
        y = stage.getY() - event.getScreenY();
    }

    @FXML
    void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void plusMinusPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void zeroPressed(ActionEvent actionEvent) {
        if (!(new BigDecimal(buffer.replace(",", ".")).equals(BigDecimal.ZERO)) || isCommaPressed) {
            addToBuffer("0");
        }
    }

    @FXML
    public void onePressed(ActionEvent actionEvent) {
        addToBuffer("1");
    }

    @FXML
    public void twoPressed(ActionEvent actionEvent) {
        addToBuffer("2");
    }

    @FXML
    public void threePressed(ActionEvent actionEvent) {
        addToBuffer("3");
    }

    @FXML
    public void fourPressed(ActionEvent actionEvent) {
        addToBuffer("4");
    }

    @FXML
    public void fivePressed(ActionEvent actionEvent) {
        addToBuffer("5");
    }

    @FXML
    public void sixPressed(ActionEvent actionEvent) {
        addToBuffer("6");
    }

    @FXML
    public void sevenPressed(ActionEvent actionEvent) {
        addToBuffer("7");
    }

    @FXML
    public void eightPressed(ActionEvent actionEvent) {
        addToBuffer("8");
    }

    @FXML
    public void ninePressed(ActionEvent actionEvent) {
        addToBuffer("9");
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
    public void equalsPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void plusPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void minusPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void oneDividedXPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void multiplyPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void squarePressed(ActionEvent actionEvent) {
    }

    @FXML
    public void radicalPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void dividePressed(ActionEvent actionEvent) {
    }

    @FXML
    public void cePressed(ActionEvent actionEvent) {
    }

    @FXML
    public void percentPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void cPressed(ActionEvent actionEvent) {
    }

    @FXML
    public void delPressed(ActionEvent actionEvent) {
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

    private void addToBuffer(String s) {
        if (buffer.equals("0")) {
            buffer = s;
        } else {
            buffer += s;
        }

        mainLabel.setText(buffer);
    }
}

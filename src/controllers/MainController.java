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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private String buffer = "0";
    private BinaryOperations lastBinary;
    private UnaryOperations lastUnary;
    private boolean isCommaPressed = false;
    private boolean isMenuVisible = false;
    private DecimalFormat format = new DecimalFormat();
    private DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    private static final String SYMBOL_EXP = "e";
    private static final char FLOAT_POINT = ',';
    private static final int MAX_DIGITS_IN_NUMBER = 17;
    private static final char BIG_NUMBER_SEPARATOR = ' ';
    private static final String DEFAULT_PATTERN = "#,##0.###;-#,##0.###";

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
    public void commaPressed() {
        if (!isCommaPressed) {
            isCommaPressed = true;
            if (mainLabel.getText().equals("0")) {
                addToBuffer("0.");
            } else {
                addToBuffer(".");
            }
        }
    }

    @FXML
    public void equalsPressed() {
        if (lastBinary != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        }
        setMainLabelText(buffer);
        lastBinary = null;
    }

    @FXML
    public void plusPressed() {
        if (lastBinary != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastBinary = BinaryOperations.PLUS;

    }

    @FXML
    public void minusPressed() {
        if (lastBinary != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastBinary = BinaryOperations.MINUS;
    }

    @FXML
    public void oneDividedXPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.ONE_DIVIDED_X).toString();
        lastUnary = UnaryOperations.ONE_DIVIDED_X;
        setMainLabelText(buffer);
    }

    @FXML
    public void multiplyPressed() {
        if (lastBinary != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastBinary = BinaryOperations.MULTIPLY;
    }

    @FXML
    public void squarePressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.SQUARE).toString();
        lastUnary = UnaryOperations.SQUARE;
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
    }

    @FXML
    public void radicalPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.SQRT).toString();
        lastUnary = UnaryOperations.SQRT;
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
    }

    @FXML
    public void dividePressed() {
        if (lastBinary != null) {
            buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        }
        result = buffer;
        buffer = "0";
        setMainLabelText(result);
        lastBinary = BinaryOperations.DIVIDE;
    }

    @FXML
    public void cePressed() {
        buffer = "0";
        setMainLabelText(buffer);
    }

    @FXML
    public void percentPressed() {
        result = model.percent(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
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
    public void mcPressed() {
        setMemButtonsDisable(true);
        model.clearMemoryValue();
    }

    @FXML
    public void mrPressed() {
        buffer = model.getMemoryValue().toString();
        setMainLabelText(buffer);
    }

    @FXML
    public void mMinusPressed() {
        setMemButtonsDisable(false);
        model.memoryMinus(new BigDecimal(buffer));
        buffer = "0";
    }

    @FXML
    public void mPlusPressed() {
        setMemButtonsDisable(false);
        model.memoryPlus(new BigDecimal(buffer));
        buffer = "0";
    }

    @FXML
    public void msPressed() {
        setMemButtonsDisable(false);
        model.setMemoryValue(new BigDecimal(buffer));
        buffer = "0";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initialize(Stage stage) {
        this.stage = stage;
        menu.setVisible(false);
        setMemButtonsDisable(true);
    }

    private void setMemButtonsDisable(boolean isEnable){
        mc.setDisable(isEnable);
        mr.setDisable(isEnable);
        mOption.setDisable(isEnable);
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
        symbols.setDecimalSeparator(FLOAT_POINT);
        symbols.setGroupingSeparator(BIG_NUMBER_SEPARATOR);
        format.setGroupingSize(3);
        format.setGroupingUsed(true);
        BigDecimal val = new BigDecimal(text);
        String pattern = DEFAULT_PATTERN;
        String exponentialSymbolSign = SYMBOL_EXP;


        int minDigits = 0;
        int maxDigits = MAX_DIGITS_IN_NUMBER - 1;


        symbols.setExponentSeparator(exponentialSymbolSign);
        format.setDecimalFormatSymbols(symbols);
        format.applyPattern(pattern);

        format.setMinimumFractionDigits(minDigits);
        format.setMaximumFractionDigits(maxDigits);
        mainLabel.setText(format.format(val));


        if (mainLabel.getText().length() == 21) {
            mainLabel.setFont(new Font("Segoe UI Semibold", 28)); //28
        } else if (mainLabel.getText().length() >= 19) {
            mainLabel.setFont(new Font("Segoe UI Semibold", 32)); //32
        } else if (mainLabel.getText().length() >= 18) {
            mainLabel.setFont(new Font("Segoe UI Semibold", 33)); //33
        } else if (mainLabel.getText().length() >= 17) {
            mainLabel.setFont(new Font("Segoe UI Semibold", 35)); //35
        } else if (mainLabel.getText().length() >= 15) {
            mainLabel.setFont(new Font("Segoe UI Semibold", 39)); //39
        } else if (mainLabel.getText().length() >= 14) {
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
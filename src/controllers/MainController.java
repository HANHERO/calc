package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private int fontSize = 46;
    public Label historyLabel;
    private String buffer = "0";
    private BinaryOperations lastBinary;
    private UnaryOperations lastUnary;
    private boolean isEqualsPressed = false;
    private boolean isCommaPressed = false;
    private boolean isTypingNew = false;
    private boolean isSignHas = false;
    private final DecimalFormat format = new DecimalFormat();
    private final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    private static final String SYMBOL_EXP = "e";
    private static final char FLOAT_POINT = ',';
    private static final int MAX_DIGITS_IN_NUMBER = 16;
    private static final char BIG_NUMBER_SEPARATOR = ' ';
    private static final String DEFAULT_PATTERN = "#,##0.###;-#,##0.###";


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
        isCommaPressed = false;
        isTypingNew = true;
        isEqualsPressed = true;
    }

    @FXML
    public void plusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.PLUS;
        updateHistory();
    }

    @FXML
    public void minusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MINUS;
        updateHistory();
    }

    @FXML
    public void dividePressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.DIVIDE;
        updateHistory();
    }

    @FXML
    public void multiplyPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MULTIPLY;
        updateHistory();
    }

    @FXML
    public void oneDividedXPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.ONE_DIVIDED_X).toString();
        lastUnary = UnaryOperations.ONE_DIVIDED_X;
        setMainLabelText(buffer);
        isTypingNew = true;
    }

    @FXML
    public void squarePressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.SQUARE).toString();
        lastUnary = UnaryOperations.SQUARE;
        result = buffer;
        isTypingNew = true;
        setMainLabelText(result);
    }

    @FXML
    public void radicalPressed() {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.SQRT).toString();
        lastUnary = UnaryOperations.SQRT;
        result = buffer;
        isTypingNew = true;
        setMainLabelText(result);
    }


    private void sendToCalculate() {
        if (!isSignHas) {
            if (isEqualsPressed) {
                lastBinary = null;
            }
            if (lastBinary != null) {
                buffer = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
            }
            result = buffer;
            isTypingNew = true;
            isCommaPressed = false;
            setMainLabelText(buffer);
        }
        isSignHas = true;
    }

    @FXML
    public void cePressed() {
        buffer = "0";
        setMainLabelText(buffer);
    }

    @FXML
    public void percentPressed() {
        result = model.percent(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        isTypingNew = true;
        setMainLabelText(result);
    }

    @FXML
    public void cPressed() {
        result = "0";
        cePressed();
    }

    @FXML
    public void delPressed() {
        if (!isTypingNew) {
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
    }

    @FXML
    public void mcPressed() {
        setDisableMemButtons(true);
        model.clearMemoryValue();
    }

    @FXML
    public void mrPressed() {
        buffer = model.getMemoryValue().toString();
        setMainLabelText(buffer);
    }

    @FXML
    public void mMinusPressed() {
        setDisableMemButtons(false);
        model.memoryMinus(new BigDecimal(buffer));
        isTypingNew = true;
    }

    @FXML
    public void mPlusPressed() {
        setDisableMemButtons(false);
        model.memoryPlus(new BigDecimal(buffer));
        isTypingNew = true;
    }

    @FXML
    public void msPressed() {
        setDisableMemButtons(false);
        model.setMemoryValue(new BigDecimal(buffer));
        isTypingNew = true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initialize(Stage stage) {
        this.stage = stage;
        menu.setVisible(false);
        setDisableMemButtons(true);
        symbols.setDecimalSeparator(FLOAT_POINT);
        symbols.setGroupingSeparator(BIG_NUMBER_SEPARATOR);
        format.setGroupingSize(3);
        format.setGroupingUsed(true);
        this.stage.getScene().setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case NUMPAD0:
                case DIGIT0:
                    zero.fire();
                    break;
                case NUMPAD1:
                case DIGIT1:
                    one.fire();
                    break;
                case NUMPAD2:
                case DIGIT2:
                    two.fire();
                    break;
                case NUMPAD3:
                case DIGIT3:
                    three.fire();
                    break;
                case NUMPAD4:
                case DIGIT4:
                    four.fire();
                    break;
                case NUMPAD5:
                case DIGIT5:
                    five.fire();
                    break;
                case NUMPAD6:
                case DIGIT6:
                    six.fire();
                    break;
                case NUMPAD7:
                case DIGIT7:
                    seven.fire();
                    break;
                case NUMPAD8:
                case DIGIT8:
                    eight.fire();
                    break;
                case NUMPAD9:
                case DIGIT9:
                    nine.fire();
                    break;
                case MULTIPLY:
                    multiply.fire();
                    break;
                case ADD:
                    plus.fire();
                    break;
                case SUBTRACT:
                    minus.fire();
                    break;
                case DIVIDE:
                    divide.fire();
                    break;
                case DECIMAL:
                    comma.fire();
                    break;
                case BACK_SPACE:
                    del.fire();
                    break;
                case ENTER:
                    equals.fire();
                    break;
                case ESCAPE:
                    c.fire();
                    break;
                case DELETE:
                    ce.fire();
                    break;
            }
        });
    }

    private void setDisableAllOperations(boolean isDisable) {
        percent.setDisable(isDisable);
        oneDividedX.setDisable(isDisable);
        square.setDisable(isDisable);
        sqrt.setDisable(isDisable);
        divide.setDisable(isDisable);
        multiply.setDisable(isDisable);
        minus.setDisable(isDisable);
        plus.setDisable(isDisable);
        plusMinus.setDisable(isDisable);
        comma.setDisable(isDisable);
    }

    private void setDisableMemButtons(boolean isDisable) {
        mc.setDisable(isDisable);
        mr.setDisable(isDisable);
        mOption.setDisable(isDisable);
    }

    private void addToBuffer(String s) {
        if (isTypingNew) {
            buffer = "0";
            isTypingNew = false;
        }
        if (mainLabel.getText().length() < 21) {
            if (buffer.equals("0")) {
                buffer = s;
            } else {
                buffer += s;
            }
            isSignHas = false;
            setMainLabelText(buffer);
        }
    }

    private void setMainLabelText(String text) {
        if (text.contains(".")) {
            text = removeZeros(text);
        }
        BigDecimal val = new BigDecimal(text);
        String pattern = DEFAULT_PATTERN;

        int minDigits = 0;
        int maxDigits = MAX_DIGITS_IN_NUMBER - 1;

        if (countDigitsAfterDecimalPoint(text) > 15) {
            pattern = "0.###############E0;-0.###############E0";
        }

        symbols.setExponentSeparator(SYMBOL_EXP);
        format.setDecimalFormatSymbols(symbols);
        format.setRoundingMode(RoundingMode.CEILING);
        format.applyPattern(pattern);

        format.setMinimumFractionDigits(minDigits);
        format.setMaximumFractionDigits(maxDigits);
        mainLabel.setText(format.format(val));

        fontSize = resizeMainLabelFont(fontSize);

        mainLabel.setFont(new javafx.scene.text.Font("Segoe UI Semibold", fontSize));
    }

    private int resizeMainLabelFont(int fontSize) {
        int size = fontSize;
        int maxTextSizeInPx = 300;

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        FontMetrics fm = img.getGraphics().getFontMetrics(new Font("Segoe UI Semibold", Font.PLAIN, size));

        while (fm.stringWidth(mainLabel.getText()) < maxTextSizeInPx && size < 46) {
            fm = img.getGraphics().getFontMetrics(new Font("Segoe UI Semibold", Font.PLAIN, ++size));
        }

        while (fm.stringWidth(mainLabel.getText()) > maxTextSizeInPx) {
            fm = img.getGraphics().getFontMetrics(new Font("Segoe UI Semibold", Font.PLAIN, --size));
        }
        return size;
    }

    private void updateHistory() {
        String history = buffer + lastBinary.sign;
        historyLabel.setText(history);
    }

    private int countDigitsAfterDecimalPoint(String number) {
        int result = 0;
        if (number.contains(".")) {
            try {
                result = number.split("\\.")[1].length();
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
        return result;
    }

    private String removeZeros(String number) {
        while (number.charAt(number.length() - 1) == '0') {
            number = number.substring(0, number.length() - 1);
        }
        return number;
    }


    public void optionOpenOrClose() {
        menu.setVisible(!menu.isVisible());
    }

    public void clicked() {
        if (menu.isVisible()) {
            menu.setVisible(false);
        }
    }
}
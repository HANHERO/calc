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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private final ArrayList<Object> history = new ArrayList<>();
    private int fontSize = 46;
    public Label historyLabel;
    private String buffer = "0";
    private boolean isNewHistoryForNext = false;
    private BinaryOperations lastBinary;
    private UnaryOperations lastUnary;
    private boolean isEqualsPressed = false;
    private boolean isCommaPressed = false;
    private boolean isTypingNew = false;
    private boolean isSignHas = false;
    private final DecimalFormat format = new DecimalFormat();
    private final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    private String displayedInMainLabel = "0";
    private static final String SYMBOL_EXP = "e";
    private static final char FLOAT_POINT = ',';
    private static final int MAX_DIGITS_IN_NUMBER = 16;
    private static final char BIG_NUMBER_SEPARATOR = ' ';
    private static final String DEFAULT_PATTERN = "#,##0.###;-#,##0.###";
    private static final BigDecimal MAX_NUMBER = new BigDecimal("1E+10000");
    private static final BigDecimal MIN_NUMBER = new BigDecimal("1E-10000");
    private String unaryExpression = "";


    @FXML
    public Label mainLabel;
    @FXML
    public Button plusMinus;
    @FXML
    public Button zero;
    @FXML
    public Button comma;
    @FXML
    public Button equals;
    @FXML
    public Button one;
    @FXML
    public Button two;
    @FXML
    public Button three;
    @FXML
    public Button plus;
    @FXML
    public Button four;
    @FXML
    public Button seven;
    @FXML
    public Button eight;
    @FXML
    public Button minus;
    @FXML
    public Button six;
    @FXML
    public Button five;
    @FXML
    public Button oneDividedX;
    @FXML
    public Button multiply;
    @FXML
    public Button nine;
    @FXML
    public Button square;
    @FXML
    public Button sqrt;
    @FXML
    public Button divide;
    @FXML
    public Button ce;
    @FXML
    public Button percent;
    @FXML
    public Button c;
    @FXML
    public Button del;
    @FXML
    public Button mc;
    @FXML
    public Button mr;
    @FXML
    public Button mPlus;
    @FXML
    public Button mMinus;
    @FXML
    public Button ms;
    @FXML
    public Button mOption;
    @FXML
    public AnchorPane menu;

    private Stage stage;
    MainModel model = new MainModel();
    String result = "0";
    double x, y;

    @FXML
    public void dragged(MouseEvent event) {
        if (stage.getScene().getCursor() != Cursor.N_RESIZE) {
            stage.setX(event.getScreenX() + x);
            stage.setY(event.getScreenY() + y);
        }
    }

    @FXML
    public void pressed(MouseEvent event) {
        x = stage.getX() - event.getScreenX();
        y = stage.getY() - event.getScreenY();
    }

    @FXML
    public void minimize() {
        stage.setIconified(true);
    }

    @FXML
    public void close() {
        stage.close();
    }

    @FXML
    public void plusMinusPressed() throws ArithmeticException {
        buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.NEGATIVE).toString();
        setMainLabelText(buffer);
    }

    @FXML
    public void digitButtonPressed(ActionEvent actionEvent) {
        String source = actionEvent.getSource().toString();
        String digitButton = source.substring(source.length() - 2, source.length() - 1);
        if (isEqualsPressed) {
            cPressed();
        }
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
            if (isEqualsPressed) {
                cPressed();
                isEqualsPressed = false;
            }
            if (mainLabel.getText().equals("0")) {
                addToBuffer("0.");
            } else {
                addToBuffer(".");
            }
        }
    }

    @FXML
    public void plusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.PLUS;
        addToHistory("");
        showHistory();
    }

    @FXML
    public void minusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MINUS;
        addToHistory("");
        showHistory();
    }

    @FXML
    public void dividePressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.DIVIDE;
        addToHistory("");
        showHistory();
    }

    @FXML
    public void multiplyPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MULTIPLY;
        addToHistory("");
        showHistory();
    }

    private void sendToCalculate() {
        if (unaryExpression.equals("")) {
            addToHistory(buffer);
        }
        unaryExpression = "";
        isEqualsPressed = false;
        if (buffer.contains(".")) {
            buffer = removeZeros(buffer);
        }
        if (!isSignHas) {
            if (isEqualsPressed) {
                buffer = result;
                lastBinary = null;
            }
            if (lastBinary != null) {
                result = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
            } else {
                result = buffer;
            }
            if (isNewHistoryForNext) {
                clearHistory();
                addToHistory(result);
            }
            isTypingNew = true;
            isCommaPressed = false;
            lastUnary = null;
            setMainLabelText(result);
            if (lastUnary == null) {
                isNewHistoryForNext = true;
            }
        }
        isSignHas = true;
    }

    @FXML
    public void equalsPressed() {
        isCommaPressed = false;
        isTypingNew = true;
        isEqualsPressed = true;
        isNewHistoryForNext = true;
        if (unaryExpression.equals("")) {
            addToHistory(buffer);
        }
        showHistory();


        if (lastBinary != null) {
            result = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
        } else {
            result = buffer;
        }
        if (history.size() == 1) {
            history.set(0, result);
        } else if (history.size() == 3) {
            history.set(0, result);
            history.set(2, buffer);
        }
        setMainLabelText(result);
    }

    @FXML
    public void oneDividedXPressed() {
        if (isNewHistoryForNext) {
            clearHistory();
            unaryExpression = result;
            isNewHistoryForNext = false;
        } else if (unaryExpression.equals("")) {
            unaryExpression = buffer;
        }
        buffer = model.calculate(new BigDecimal(displayedInMainLabel), UnaryOperations.ONE_DIVIDED_X).toString();
        lastUnary = UnaryOperations.ONE_DIVIDED_X;
        createUnaryExpression();
        setMainLabelText(buffer);
        isTypingNew = true;
        showHistory();
    }


    @FXML
    public void squarePressed() {
        if (isNewHistoryForNext) {
            clearHistory();
            unaryExpression = result;
            isNewHistoryForNext = false;
        } else if (unaryExpression.equals("")) {
            unaryExpression = buffer;
        }

        buffer = model.calculate(new BigDecimal(displayedInMainLabel), UnaryOperations.SQUARE).toString();
        lastUnary = UnaryOperations.SQUARE;
        createUnaryExpression();
        isTypingNew = true;
        setMainLabelText(buffer);
        showHistory();
    }

    @FXML
    public void radicalPressed() {
        if (isNewHistoryForNext) {
            clearHistory();
            unaryExpression = result;
            isNewHistoryForNext = false;
        } else if (unaryExpression.equals("")) {
            unaryExpression = buffer;
        }
        buffer = model.calculate(new BigDecimal(displayedInMainLabel), UnaryOperations.SQRT).toString();
        lastUnary = UnaryOperations.SQRT;
        createUnaryExpression();
        isTypingNew = true;
        setMainLabelText(buffer);
        showHistory();
    }

    private void createUnaryExpression() {
        unaryExpression = lastUnary.sign + "( " + unaryExpression + " )";
        addToHistory(unaryExpression);

    }

    private void addToHistory(String expression) {
        int historySize = history.size();
        if (history.isEmpty()) {
            history.add(0, expression);
        } else if (historySize == 1 && !isSignHas) {
            history.set(0, expression);
        }
        if (historySize == 1 && isSignHas) {
            history.add(lastBinary);
        } else if (historySize == 2 && isSignHas) {
            history.set(1, lastBinary);
        }
        if (lastUnary != null) {
            if (historySize == 2) {
                history.add(2, expression);
            } else if (historySize == 3) {
                history.set(2, expression);
            }
        } else if (isEqualsPressed) {
            if (historySize == 2) {
                history.add(2, expression);
            }
        }
    }

    private void showHistory() {
        int historySize = history.size();
        if (historySize == 3 && isEqualsPressed) {
            historyLabel.setText(history.get(0) + ((BinaryOperations) history.get(1)).sign + history.get(2) + " = ");
        } else if (historySize == 3) {
            historyLabel.setText(history.get(0) + ((BinaryOperations) history.get(1)).sign + history.get(2));
        } else if (historySize == 2) {
            historyLabel.setText(history.get(0) + ((BinaryOperations) history.get(1)).sign);
        } else if (historySize == 1 && isEqualsPressed) {
            historyLabel.setText(history.get(0) + " = ");
        } else if (historySize == 1) {
            historyLabel.setText((String) history.get(0));
        }
    }

    private void clearHistory() {
        history.clear();
        unaryExpression = "";
        historyLabel.setText("");
    }

    @FXML
    public void cePressed() {
        setDisableAllOperations(false);
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
        unaryExpression = "";
        isSignHas = false;
        isCommaPressed = false;
        isEqualsPressed = false;
        lastBinary = null;
        lastUnary = null;
        clearHistory();
        cePressed();
    }

    @FXML
    public void delPressed() {
        if (!isTypingNew) {
            if (buffer.endsWith(".")) {
                isCommaPressed = false;
            }
            if (!buffer.equals("") && buffer.length() != 1) {
                buffer = buffer.substring(0, buffer.length() - 1);
            } else {
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
                case NUMPAD0, DIGIT0 -> zero.fire();
                case NUMPAD1, DIGIT1 -> one.fire();
                case NUMPAD2, DIGIT2 -> two.fire();
                case NUMPAD3, DIGIT3 -> three.fire();
                case NUMPAD4, DIGIT4 -> four.fire();
                case NUMPAD5, DIGIT5 -> five.fire();
                case NUMPAD6, DIGIT6 -> six.fire();
                case NUMPAD7, DIGIT7 -> seven.fire();
                case NUMPAD8, DIGIT8 -> eight.fire();
                case NUMPAD9, DIGIT9 -> nine.fire();
                case MULTIPLY -> multiply.fire();
                case ADD -> plus.fire();
                case SUBTRACT -> minus.fire();
                case DIVIDE -> divide.fire();
                case DECIMAL -> comma.fire();
                case BACK_SPACE -> del.fire();
                case ENTER -> equals.fire();
                case ESCAPE -> c.fire();
                case DELETE -> ce.fire();
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
        if (((countDigitsBeforeDecimalPoint(buffer) + countDigitsAfterDecimalPoint(buffer)) < 16) || s.equals(".")) {
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
        displayedInMainLabel = text;
        BigDecimal val = new BigDecimal(text);
        if (val.compareTo(MAX_NUMBER) > 0 || (val.compareTo(MIN_NUMBER) < 0 && val.compareTo(BigDecimal.ZERO) > 0)) {
            mainLabel.setFont(new javafx.scene.text.Font("Segoe UI Semibold", 43));
            mainLabel.setText("Переполнение");
            setDisableAllOperations(true);
            setDisableMemButtons(true);
            return;
        }

        String pattern = DEFAULT_PATTERN;

        int minDigits = 0;
        int maxDigits = MAX_DIGITS_IN_NUMBER - 1;
        if (countDigitsBeforeDecimalPoint(text) < 17) {
            pattern = DEFAULT_PATTERN;
        }
        if (countDigitsAfterDecimalPoint(text) > 15) {
            pattern = "0.###############E0;-0.###############E0";
        } else if (text.endsWith(".")) {
            pattern = "#,###.;-#,###.";
        } else if (text.contains(".") && text.endsWith("0")) {
            pattern = "#,##0.0000;-#,##0.0000";

        }
        if (lastUnary == UnaryOperations.SQRT) {
            pattern = "0.###############;-0.###############";
        }
        countDigitsBeforeDecimalPoint(val.toString());

        if (countDigitsBeforeDecimalPoint(text) > 16) {
            pattern = "0.E0;-0.E0";
        }
        symbols.setExponentSeparator(SYMBOL_EXP);
        if (val.compareTo(BigDecimal.ONE) > 0) {
            symbols.setExponentSeparator("e+");
        }


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

    private int countDigitsBeforeDecimalPoint(String number) {
        int result = 0;
        if (number.contains(".")) {
            try {
                result = number.split("\\.")[0].length();
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        } else {
            result = number.length();
        }
        return result;
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
        String noZero = number;
        while (noZero.endsWith("0") || noZero.endsWith(".")) {
            noZero = noZero.substring(0, noZero.length() - 1);
        }
        return noZero;
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
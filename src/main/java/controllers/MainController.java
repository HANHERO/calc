package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private final List<Object> history = new ArrayList<>();
    private final List<Button> textButtons = new ArrayList<>();
    public ScrollPane scrollPaneHistory;
    public Button fullScreenButton;
    public Label historyLabel;
    private String buffer = "0";
    private boolean isNewHistoryForNext = false;
    private BinaryOperations lastBinary;
    private UnaryOperations lastUnary;
    boolean isFirstTimeUnary = false;
    private boolean isPercentLast = false;
    private boolean isEqualsPressed = false;
    private boolean isCommaPressed = false;
    private boolean isTypingNew = true;
    private boolean isTyping = true;
    private boolean isSignHas = false;
    private String whatOnScreen = "0";
    private String unaryExpression = "";
    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9999999999999995E+9999");
    private static final BigDecimal NEAREST_TO_ZERO_POSITIVE_VALUE = new BigDecimal("1E-9999");
    private static final BigDecimal NEAREST_TO_ZERO_NEGATIVE_VALUE = new BigDecimal("-1E-9999");
    private static final BigDecimal MIN_VALUE = new BigDecimal("-9.9999999999999995E+9999");
    private static final String DIVISION_BY_ZERO = "Деление на ноль невозможно";
    private static final String NEGATIVE_SQRT = "Неверный ввод";
    private static final String OVERFLOW = "Переполнение";

    @FXML
    public Button historyLeftMover;
    @FXML
    public Button historyRightMover;
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
    public Button CE;
    @FXML
    public Button percent;
    @FXML
    public Button C;
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

    private void fillTextButtonsArray() {
        textButtons.add(one);
        textButtons.add(two);
        textButtons.add(three);
        textButtons.add(four);
        textButtons.add(five);
        textButtons.add(six);
        textButtons.add(seven);
        textButtons.add(eight);
        textButtons.add(nine);
        textButtons.add(comma);
        textButtons.add(zero);
        textButtons.add(C);
        textButtons.add(CE);
        textButtons.add(del);
        textButtons.add(oneDividedX);
        textButtons.add(square);
        textButtons.add(percent);
        textButtons.add(divide);
        textButtons.add(multiply);
        textButtons.add(minus);
        textButtons.add(plus);
        textButtons.add(equals);
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
    public void digitButtonPressed(ActionEvent actionEvent) {
        String source = actionEvent.getSource().toString();
        String digitButton = source.substring(source.length() - 2, source.length() - 1);
        isTyping = true;
        if (isEqualsPressed) {
            cPressed();
            isEqualsPressed = false;
        }
        if (digitButton.equals("0")) {
            if (!buffer.equals("0") || isCommaPressed) {
                addToBuffer(digitButton);
            } else {
                buffer = "0";
            }
        } else {
            addToBuffer(digitButton);
        }
    }

    @FXML
    public void commaPressed() {
        if (!isCommaPressed) {
            isCommaPressed = true;
            isTyping = true;
            if (isEqualsPressed) {
                cPressed();
                isEqualsPressed = false;
            }
            if (isTypingNew || buffer.equals("")) {
                addToBuffer("0.");
            } else if (!buffer.equals("0")) {
                addToBuffer(".");
            } else {
                addToBuffer("0.");
            }
        }
    }

    @FXML
    public void plusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.PLUS;
        addToHistory("");
        history.set(1, lastBinary);
        showHistory();
    }

    @FXML
    public void minusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MINUS;
        addToHistory("");
        history.set(1, lastBinary);
        showHistory();
    }

    @FXML
    public void dividePressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.DIVIDE;
        addToHistory("");
        history.set(1, lastBinary);
        showHistory();
    }

    @FXML
    public void multiplyPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MULTIPLY;
        addToHistory("");
        history.set(1, lastBinary);
        showHistory();
    }

    private void sendToCalculate() {
        if (isEqualsPressed) {
            lastBinary = null;
            isEqualsPressed = false;
            buffer = result;
        }
        if (buffer.contains(".")) {
            buffer = removeZeros(buffer);
        }
        if (!isSignHas) {
            if (isEqualsPressed) {
                buffer = result;
                lastBinary = null;
            }
            if (lastBinary != null && !isPercentLast) {
                try {
                    result = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
                    isTypingNew = true;
                    isTyping = false;
                    isCommaPressed = false;
                    setMainLabelText(result);
                } catch (DivisionByZeroException e) {
                    showExceptionMessage(DIVISION_BY_ZERO);
                }
            } else if (isPercentLast) {
                isPercentLast = false;
            } else {
                result = whatOnScreen;
                buffer = result;
                isTypingNew = true;
                isTyping = false;
                isCommaPressed = false;
                setMainLabelText(result);
            }

            if (unaryExpression.equals("") || history.size() > 2) {
                clearHistory();
                unaryExpression = "";
                lastUnary = null;
                addToHistory(formatterForHistory(result));
            } else {
                unaryExpression = "";
                lastUnary = null;
            }

        }
        isSignHas = true;
    }

    @FXML
    public void equalsPressed() {
        isEqualsPressed = true;
        isCommaPressed = false;
        isTypingNew = true;
        isTyping = false;
        isNewHistoryForNext = true;
        if (unaryExpression.equals("")) {
            addToHistory(formatterForHistory(buffer));
        }
        showHistory();

        if (history.size() == 3 && historyLabel.getText().contains("=") && !unaryExpression.equals("") && isFirstTimeUnary) {
            history.set(1, lastBinary);
            history.set(2, formatterForHistory(buffer));
            history.set(0, formatterForHistory(result));
            showHistory();
            isFirstTimeUnary = false;
            lastUnary = null;
            unaryExpression = "";
        }

        if (lastBinary != null && !isPercentLast) {
            try {
                result = model.calculate(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
                setMainLabelText(result);
            } catch (DivisionByZeroException e) {
                showExceptionMessage(DIVISION_BY_ZERO);
            }

        } else if (isPercentLast) {
            setMainLabelText(result);
            isPercentLast = false;
        } else {
            result = buffer;
            setMainLabelText(result);
        }
        if (history.size() == 1) {
            history.set(0, formatterForHistory(result));
        } else if (history.size() == 3 && unaryExpression.equals("")) {
            history.set(1, lastBinary);
            history.set(2, formatterForHistory(buffer));
            showHistory();
            history.set(0, formatterForHistory(result));
        } else {
            history.set(1, lastBinary);
            showHistory();
        }
        if (historyLabel.getText().contains("=")) {
            isFirstTimeUnary = true;
        }


    }

    @FXML
    public void plusMinusPressed() {
        try {
            buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.NEGATIVE).toString();
        } catch (DivisionByZeroException e) {
            showExceptionMessage(DIVISION_BY_ZERO);
        } catch (NegativeSqrtException e) {
            showExceptionMessage(NEGATIVE_SQRT);
        }
        if (isEqualsPressed || !unaryExpression.equals("")) {
            if (isNewHistoryForNext) {
                unaryExpression = formatterForHistory(whatOnScreen);
                isNewHistoryForNext = false;
            }
            if (unaryExpression.equals("")) {
                unaryExpression = formatterForHistory(buffer);
            }
            try {
                buffer = model.calculate(new BigDecimal(whatOnScreen), UnaryOperations.NEGATIVE).toString();
            } catch (DivisionByZeroException e) {
                showExceptionMessage(DIVISION_BY_ZERO);
            } catch (NegativeSqrtException e) {
                showExceptionMessage(NEGATIVE_SQRT);
            }
            lastUnary = UnaryOperations.NEGATIVE;
            createUnaryExpression();
            setMainLabelText(buffer);
            isTypingNew = true;
            isTyping = false;
            showHistory();
        }
        setMainLabelText(buffer);
    }

    private void sendToUnary() {
        if (isNewHistoryForNext) {
            unaryExpression = formatterForHistory(whatOnScreen);
            isNewHistoryForNext = false;
        }
        if (unaryExpression.equals("")) {
            unaryExpression = formatterForHistory(buffer);
        }
        if (isTyping) {
            unaryExpression = formatterForHistory(whatOnScreen);
        }
    }

    @FXML
    public void oneDividedXPressed() {
        isTypingNew = true;
        isTyping = false;
        sendToUnary();
        try {
            buffer = model.calculate(new BigDecimal(whatOnScreen), UnaryOperations.ONE_DIVIDED_X).toString();
            setMainLabelText(buffer);
        } catch (DivisionByZeroException e) {
            showExceptionMessage(DIVISION_BY_ZERO);
        } catch (NegativeSqrtException e) {
            showExceptionMessage(NEGATIVE_SQRT);
        }
        lastUnary = UnaryOperations.ONE_DIVIDED_X;
        createUnaryExpression();
        showHistory();
    }

    @FXML
    public void squarePressed() {
        isTypingNew = true;
        isTyping = false;
        sendToUnary();
        try {
            buffer = model.calculate(new BigDecimal(whatOnScreen), UnaryOperations.SQUARE).toString();
            setMainLabelText(buffer);
        } catch (DivisionByZeroException e) {
            showExceptionMessage(DIVISION_BY_ZERO);
        } catch (NegativeSqrtException e) {
            showExceptionMessage(NEGATIVE_SQRT);
        }
        lastUnary = UnaryOperations.SQUARE;
        createUnaryExpression();
        showHistory();
    }

    @FXML
    public void rootPressed() {
        isTypingNew = true;
        isTyping = false;
        sendToUnary();
        try {
            buffer = model.calculate(new BigDecimal(whatOnScreen), UnaryOperations.SQRT).toString();
            setMainLabelText(buffer);
        } catch (DivisionByZeroException e) {
            showExceptionMessage(DIVISION_BY_ZERO);
        } catch (NegativeSqrtException e) {
            showExceptionMessage(NEGATIVE_SQRT);
        }
        lastUnary = UnaryOperations.SQRT;
        createUnaryExpression();
        showHistory();
    }


    private void createUnaryExpression() {
        if (isEqualsPressed) {
            history.clear();
            isEqualsPressed = false;
            lastBinary = null;
        }
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
        } else if (historySize == 3 && lastUnary != null || isPercentLast) {
            historyLabel.setText(history.get(0).toString() + ((BinaryOperations) history.get(1)).sign + history.get(2).toString());
        } else if (historySize == 3) {
            historyLabel.setText(history.get(0).toString() + ((BinaryOperations) history.get(1)).sign);
        } else if (historySize == 2 && !isEqualsPressed) {
            historyLabel.setText(history.get(0) + ((BinaryOperations) history.get(1)).sign);
        } else if (historySize == 1 && isEqualsPressed) {
            historyLabel.setText(history.get(0) + " = ");
        } else if (historySize == 1) {
            historyLabel.setText((String) history.get(0));
        }
        if (historyLabel.getWidth() > stage.getWidth() - 40) {
            historyLeftMover.setVisible(true);
        }

    }

    private void clearHistory() {
        history.clear();
        unaryExpression = "";
        historyLabel.setText("");
        historyLeftMover.setVisible(false);
        historyRightMover.setVisible(false);
    }

    @FXML
    public void cePressed() {
        setDisableAllOperations(false);
        isCommaPressed = false;
        isPercentLast = false;
        isFirstTimeUnary = false;
        buffer = "0";
        isTyping = true;
        setMainLabelText(buffer);
    }

    @FXML
    public void percentPressed() {
        if (!isPercentLast) {
            if (lastBinary == null) {
                historyLabel.setText("0");
                setMainLabelText("0");
                isTypingNew = true;
                return;
            }
            try {
                isPercentLast = true;
                result = model.percent(new BigDecimal(result), new BigDecimal(buffer), lastBinary).toString();
                isTypingNew = true;
                isTyping = false;
                buffer = model.getPercentCoef().toString();
                history.add(formatterForHistory(buffer));
                showHistory();
                setMainLabelText(buffer);
            } catch (DivisionByZeroException e) {
                showExceptionMessage(DIVISION_BY_ZERO);
            }
        }
    }

    @FXML
    public void cPressed() {
        result = "0";
        unaryExpression = "";
        isSignHas = false;
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
            if (buffer.length() == 2 && buffer.contains("-")) {
                buffer = "0";
                isTyping = false;
            }
            if (!buffer.equals("") && buffer.length() != 1) {
                buffer = buffer.substring(0, buffer.length() - 1);
            } else {
                buffer = "0";
                isTyping = false;
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
        isTyping = false;
        setMainLabelText(buffer);
    }

    @FXML
    public void mMinusPressed() {
        setDisableMemButtons(false);
        try {
            model.memoryMinus(new BigDecimal(whatOnScreen));
        } catch (DivisionByZeroException e) {
            showExceptionMessage(DIVISION_BY_ZERO);
        }
        isTypingNew = true;
        isTyping = false;
    }

    @FXML
    public void mPlusPressed() {
        setDisableMemButtons(false);
        try {
            model.memoryPlus(new BigDecimal(whatOnScreen));
        } catch (DivisionByZeroException e) {
            showExceptionMessage(DIVISION_BY_ZERO);
        }
        isTypingNew = true;
        isTyping = false;
    }

    @FXML
    public void msPressed() {
        setDisableMemButtons(false);
        model.setMemoryValue(new BigDecimal(whatOnScreen));
        isTypingNew = true;
        isTyping = false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initialize(Stage stage) {
        this.stage = stage;
        menu.setVisible(false);
        setDisableMemButtons(true);
        fillTextButtonsArray();
        ResizeFont.init(stage, mainLabel);
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
                case ESCAPE -> C.fire();
                case DELETE -> CE.fire();
            }
        });
        ResizeWindow r = new ResizeWindow(stage, textButtons);
        Scene scene = stage.getScene();
        scene.setOnMouseMoved(r);
        scene.setOnMousePressed(r);
        scene.setOnMouseDragged(r);
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
        equals.setDisable(isDisable);
    }

    private void setDisableMemButtons(boolean isDisable) {
        mc.setDisable(isDisable);
        mr.setDisable(isDisable);
        mOption.setDisable(isDisable);
    }

    private void addToBuffer(String s) {
        int digitsAfterComma = 16;
        if (isTypingNew) {
            buffer = "0";
            isTypingNew = false;
        }

        if (buffer.contains(".")) {
            if (new BigDecimal(buffer.split("\\.")[0]).equals(BigDecimal.ZERO)) {
                digitsAfterComma = 17;
            }
        }
        if (((countDigitsBeforeDecimalPoint(buffer) + countDigitsAfterDecimalPoint(buffer)) < digitsAfterComma) || s.equals(".")) {
            if (buffer.equals("0")) {
                buffer = s;
            } else {
                buffer += s;
            }
            isSignHas = false;

            setMainLabelText(buffer);
        }
    }

    private String formatterForHistory(String text) {
        return OutputFormatter.format(text).replace(" ", "");
    }

    private void setMainLabelText(String text) {
        whatOnScreen = text;
        if (isTyping) {
            mainLabel.setText(InputFormatter.formatter(text));
        } else {
            try {
                checkOverflow(text);
                mainLabel.setText(OutputFormatter.format(text));
            } catch (OverflowException e) {
                showExceptionMessage(OVERFLOW);
            }
        }

        ResizeFont.resizeMainLabelFont();
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
        while ((noZero.endsWith("0") || noZero.endsWith(".")) && number.contains(".")) {
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

    public void moveHistoryLeft() {
        double present = scrollPaneHistory.getHvalue();
        double max = scrollPaneHistory.getHmax();
        double moveLeft = scrollPaneHistory.getHvalue() + 0.35;

        scrollPaneHistory.setHvalue(moveLeft);
        historyRightMover.setVisible(true);

        if (present == max) {
            historyLeftMover.setVisible(false);
        }
    }

    public void moveHistoryRight() {
        double moveRight = scrollPaneHistory.getHvalue() - 0.35;
        double present = scrollPaneHistory.getHvalue();

        scrollPaneHistory.setHvalue(moveRight);
        historyLeftMover.setVisible(true);

        if (present == 0) {
            historyRightMover.setVisible(false);
        }
    }

    public void fullScreen() {
        if (stage.isMaximized()) {
            stage.setMaximized(false);
            fullScreenButton.setStyle("-fx-background-image: url('buttons/fullScreen.png')");
            for (Button textButton : textButtons) {
                textButton.setStyle("-fx-font-size: 16px");
            }
            ResizeFont.resizeMainLabelFont();
        } else {
            stage.setMaximized(true);
            fullScreenButton.setStyle("-fx-background-image: url('buttons/notFullScreen.png')");
            ResizeFont.resizeMainLabelFont();
            for (Button textButton : textButtons) {
                textButton.setStyle("-fx-font-size: 24px");
            }
        }
    }

    private void showExceptionMessage(String message) {
        setDisableAllOperations(true);
        mainLabel.setText(message);
        ResizeFont.resizeMainLabelFont();
    }

    private void checkOverflow(String number) throws OverflowException {
        if (new BigDecimal(number).compareTo(MAX_VALUE) >= 0) {
            throw new OverflowException();
        } else if (new BigDecimal(number).compareTo(MIN_VALUE) <= 0) {
            throw new OverflowException();
        } else if (new BigDecimal(number).compareTo(NEAREST_TO_ZERO_POSITIVE_VALUE) < 0 &&
                new BigDecimal(number).compareTo(BigDecimal.ZERO) > 0) {
            throw new OverflowException();
        } else if (new BigDecimal(number).compareTo(NEAREST_TO_ZERO_NEGATIVE_VALUE) > 0 &&
                new BigDecimal(number).compareTo(BigDecimal.ZERO) < 0) {
            throw new OverflowException();
        }
    }
}
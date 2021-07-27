package controllers;

import javafx.animation.PauseTransition;
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
import javafx.util.Duration;
import model.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    private boolean isFirstTimeUnary = false;
    private boolean isPercentLast = false;
    private boolean isEqualsPressed = false;
    private boolean isCommaPressed = false;
    private boolean isTypingNew = true;
    private boolean isTyping = true;
    private boolean isSignHas = false;
    private boolean isNegatePressed = false;
    private boolean isMemoryUsed = false;
    private String whatOnScreen = "0";
    private String unaryExpression = "";
    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9999999999999995E+9999");
    private static final BigDecimal NEAREST_TO_ZERO_POSITIVE_VALUE = new BigDecimal("1E-9999");
    private static final BigDecimal NEAREST_TO_ZERO_NEGATIVE_VALUE = new BigDecimal("-1E-9999");
    private static final BigDecimal MIN_VALUE = new BigDecimal("-9.9999999999999995E+9999");
    private static final String OVERFLOW = "Переполнение";

    @FXML
    public Button historyLeftMover, historyRightMover, plusMinus, zero, comma, equals, one, two, three, plus, four,
            seven, eight, minus, six, five, oneDividedX, multiply, nine, square, sqrt, divide, CE, percent, C, del,
            mc, mr, mPlus, mMinus, ms, mOption;

    @FXML
    public Label mainLabel;
    @FXML
    public AnchorPane menu;

    private Stage stage;
    Calculator model = new Calculator();
    String result = "0";
    double x, y;

    @FXML
    public void dragged(MouseEvent event) {
        if (stage.getScene().getCursor() == Cursor.DEFAULT) {
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
        isMemoryUsed = false;
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
                    buffer = result;
                } catch (DivisionByZeroException | UnexpectedException e) {
                    showExceptionMessage(e.getMessage());
                }
            } else if (isPercentLast) {
                setMainLabelText(result);
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
            } catch (DivisionByZeroException | UnexpectedException e) {
                showExceptionMessage(e.getMessage());

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
        isNegatePressed = true;
        try {
            buffer = model.calculate(new BigDecimal(buffer), UnaryOperations.NEGATIVE).toString();
        } catch (DivisionByZeroException | NegativeSqrtException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        if (isEqualsPressed || !unaryExpression.equals("") || isMemoryUsed) {
            if (isNewHistoryForNext) {
                unaryExpression = formatterForHistory(whatOnScreen);
                isNewHistoryForNext = false;
            }
            if (unaryExpression.equals("")) {
                unaryExpression = formatterForHistory(whatOnScreen);
            }
            try {
                buffer = model.calculate(new BigDecimal(whatOnScreen), UnaryOperations.NEGATIVE).toString();
            } catch (DivisionByZeroException | NegativeSqrtException | UnexpectedException e) {
                showExceptionMessage(e.getMessage());
            }
            lastUnary = UnaryOperations.NEGATIVE;
            createUnaryExpression();
            setMainLabelText(buffer);
            isTypingNew = true;
            isTyping = false;
            isSignHas = false;
            showHistory();
        }
        setMainLabelText(buffer);
    }

    private void sendToUnary(UnaryOperations unary) {
        isTypingNew = true;
        isTyping = false;
        if (isEqualsPressed) {
            isSignHas = false;
        }
        if (isNewHistoryForNext) {
            unaryExpression = formatterForHistory(whatOnScreen);
            isNewHistoryForNext = false;
        }
        if (isTyping || (isSignHas && unaryExpression.equals(""))) {
            unaryExpression = formatterForHistory(whatOnScreen);
        } else if (unaryExpression.equals("")) {
            unaryExpression = formatterForHistory(buffer);
        }

        try {
            buffer = model.calculate(new BigDecimal(whatOnScreen), unary).toString();
            setMainLabelText(buffer);
        } catch (DivisionByZeroException | NegativeSqrtException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        lastUnary = unary;
        createUnaryExpression();
        showHistory();
    }

    @FXML
    public void oneDividedXPressed() {
        sendToUnary(UnaryOperations.ONE_DIVIDED_X);
    }

    @FXML
    public void squarePressed() {
        sendToUnary(UnaryOperations.SQUARE);
    }

    @FXML
    public void rootPressed() {
        sendToUnary(UnaryOperations.SQRT);
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
        historyLeftMover.setVisible(historyLabel.getWidth() > stage.getWidth() - (historyLeftMover.getWidth() * 2));
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
        isMemoryUsed = false;
        isNegatePressed = false;
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
            } catch (DivisionByZeroException | UnexpectedException e) {
                showExceptionMessage(e.getMessage());
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
        isMemoryUsed = true;
        setDisableMemButtons(true);
        model.clearMemoryValue();
    }

    @FXML
    public void mrPressed() {
        isMemoryUsed = true;
        buffer = model.getMemoryValue().toString();
        isTyping = false;
        setMainLabelText(buffer);
    }

    @FXML
    public void mMinusPressed() {
        setDisableMemButtons(false);
        isMemoryUsed = true;
        try {
            model.memoryMinus(new BigDecimal(whatOnScreen));
        } catch (DivisionByZeroException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        isTypingNew = true;
        isTyping = false;
    }

    @FXML
    public void mPlusPressed() {
        setDisableMemButtons(false);
        isMemoryUsed = true;
        try {
            model.memoryPlus(new BigDecimal(whatOnScreen));
        } catch (DivisionByZeroException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        isTypingNew = true;
        isTyping = false;
    }

    @FXML
    public void msPressed() {
        isMemoryUsed = true;
        setDisableMemButtons(false);
        model.setMemoryValue(new BigDecimal(whatOnScreen));
        isTypingNew = true;
        isTyping = false;
    }

    private void clickOnButton(Button button) {
        button.arm();
        button.fire();
        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
        pause.setOnFinished(e -> button.disarm());
        pause.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initialize(Stage stage) {
        this.stage = stage;
        menu.setVisible(false);
        setDisableMemButtons(true);
        fillTextButtonsArray();
        ResizeFont.init(stage, mainLabel, textButtons);
        this.stage.getScene().setOnKeyPressed(keyEvent -> {
            CalcButton button = CalcButton.searchButtonByEvent(keyEvent);
            if (Objects.nonNull(button)) {
                clickOnButton((Button) stage.getScene().lookup(button.getFXId()));
            }
        });
        ResizeWindow r = new ResizeWindow(stage);
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
        if (isTyping && !isNegatePressed) {
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
            fullScreenButton.setStyle("-fx-background-image: url('/buttons/fullScreen.png')");
            ResizeFont.resizeButtonFonts();
            ResizeFont.resizeMainLabelFont();
        } else {
            stage.setMaximized(true);
            fullScreenButton.setStyle("-fx-background-image: url('/buttons/notFullScreen.png')");
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
            throw new OverflowException(OVERFLOW);
        } else if (new BigDecimal(number).compareTo(MIN_VALUE) <= 0) {
            throw new OverflowException(OVERFLOW);
        } else if (new BigDecimal(number).compareTo(NEAREST_TO_ZERO_POSITIVE_VALUE) < 0 &&
                new BigDecimal(number).compareTo(BigDecimal.ZERO) > 0) {
            throw new OverflowException(OVERFLOW);
        } else if (new BigDecimal(number).compareTo(NEAREST_TO_ZERO_NEGATIVE_VALUE) > 0 &&
                new BigDecimal(number).compareTo(BigDecimal.ZERO) < 0) {
            throw new OverflowException(OVERFLOW);
        }
    }
}
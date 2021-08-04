package controllers;

import controllers.formatters.InputFormatter;
import controllers.formatters.OutputFormatter;
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

import static controllers.formatters.HistoryFormatter.formatHistory;
import static controllers.formatters.InputFormatter.*;


public class Controller implements Initializable {
    @FXML
    private final List<Button> textButtons = new ArrayList<>();
    private History history = new History();
    public ScrollPane scrollPaneHistory;
    public Button fullScreenButton;
    public Label historyLabel;
    private BigDecimal result = BigDecimal.ZERO;
    private BigDecimal buffer = BigDecimal.ZERO;
    private BigDecimal whatOnScreen = BigDecimal.ZERO;
    private BinaryOperations lastBinary;
    private boolean isPercentLast = false;
    private boolean isEqualsPressed = false;
    private boolean isCommaPressed = false;
    private boolean isTypingNew = false;
    private boolean isCanNegateToHistory = false;
    private boolean isTyping = true;
    private boolean isException = false;
    private boolean isSignHas = false;
    public static boolean isNegatePressed = false;
    private boolean isMemoryUsed = false;
    private static final String COMMA_SYMBOL = ",";
    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9999999999999995E+9999");
    private static final BigDecimal NEAREST_TO_ZERO_POSITIVE_VALUE = new BigDecimal("1E-9999");
    private static final BigDecimal NEAREST_TO_ZERO_NEGATIVE_VALUE = new BigDecimal("-1E-9999");
    private static final BigDecimal MIN_VALUE = new BigDecimal("-9.9999999999999995E+9999");
    private static final String OVERFLOW = "Переполнение";

    public Button historyLeftMover, historyRightMover, plusMinus, zero, comma, equals, one, two, three, plus, four,
            seven, eight, minus, six, five, oneDividedX, multiply, nine, square, sqrt, divide, CE, percent, C, del,
            mc, mr, mPlus, mMinus, ms, mOption;

    @FXML
    public Label mainLabel;
    @FXML
    public AnchorPane menu;

    private Stage stage;
    Calculator model = new Calculator();
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
        String digitButton = ((Button) actionEvent.getSource()).getText();
        isMemoryUsed = false;
        isTyping = true;
        if (isTypingNew && !isCommaPressed) {
            clearInput();
            buffer = BigDecimal.ZERO;
            isTypingNew = false;
        }
        if (isEqualsPressed || isException) {
            cPressed();
            isEqualsPressed = false;
            history.setEqual(false);
            history.cleanAll();
        }

        appendNumeric(digitButton);
        buffer = InputFormatter.getInput();
        isSignHas = false;
        setMainLabelText();
    }

    @FXML
    public void commaPressed() {
        isCommaPressed = true;
        isTyping = true;
        addPointToInput();
        setMainLabelText();
        if (isEqualsPressed) {
            cPressed();
            isEqualsPressed = false;
            history.setEqual(false);
        }
    }

    @FXML
    public void plusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.PLUS;
        history.setOperation(lastBinary);
        updateHistoryLabel();
    }

    @FXML
    public void minusPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MINUS;
        history.setOperation(lastBinary);
        updateHistoryLabel();
    }

    @FXML
    public void dividePressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.DIVIDE;
        history.setOperation(lastBinary);
        updateHistoryLabel();
    }

    @FXML
    public void multiplyPressed() {
        sendToCalculate();
        lastBinary = BinaryOperations.MULTIPLY;
        history.setOperation(lastBinary);
        updateHistoryLabel();
    }

    private void sendToCalculate() {
        if (isEqualsPressed) {
            lastBinary = null;
            isEqualsPressed = false;
            history.setEqual(false);
            buffer = result;
        }
        if (!isSignHas) {
            if (lastBinary != null && !isPercentLast) {
                try {
                    result = model.calculate(result, buffer, lastBinary);
                    isTypingNew = true;
                    isTyping = false;
                    isCommaPressed = false;
                    if (history.getFirstHistory().isEmpty()) {
                        history.setFirst(result);
                    }
                    history.setOperation(lastBinary);
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
                if (history.getFirstHistory().isEmpty()) {
                    history.setFirst(result);
                }
                setMainLabelText(result);
            }
        }
        updateHistoryLabel();
        clearInput();
        isSignHas = true;
    }

    @FXML
    public void equalsPressed() {
        isEqualsPressed = true;
        isCommaPressed = false;
        isTypingNew = true;
        isTyping = false;
        history.setEqual(true);

        if (lastBinary != null && !isPercentLast) {
            try {
                result = model.calculate(result, buffer, lastBinary);
                if (history.getSecondHistory().isEmpty()) {
                    history.setSecond(buffer);
                }
            } catch (DivisionByZeroException | UnexpectedException e) {
                showExceptionMessage(e.getMessage());
            }
        } else if (isPercentLast) {
            isPercentLast = false;
        } else {
            result = buffer;
            if(history.getFirstHistory().isEmpty()) {
                history.setFirst(result);
            }
        }
        setMainLabelText(result);
        updateHistoryLabel();
        history.clearFirstHistory();
        history.clearSecondHistory();
        history.setFirst(result);

    }

    @FXML
    public void plusMinusPressed() {
        sendToUnary(UnaryOperations.NEGATIVE);
    }

    private void sendToUnary(UnaryOperations unary) {
        if (unary != UnaryOperations.NEGATIVE) {
            isTypingNew = true;
            isTyping = false;
        }
        if (isEqualsPressed) {
            isSignHas = false;
            lastBinary = null;
            isEqualsPressed = false;
            history.cleanAll();
        }
        history.addHistory(lastBinary != null, unary, whatOnScreen);
        try {
            buffer = model.calculate(whatOnScreen, unary);
            setMainLabelText(buffer);
        } catch (DivisionByZeroException | NegativeSqrtException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        updateHistoryLabel();
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

    @FXML
    public void cePressed() {
        setDisableAllOperations(false);
        isException = false;
        isMemoryUsed = false;
        isNegatePressed = false;
        isCommaPressed = false;
        isPercentLast = false;
        isTyping = true;
        clearInput();
        setMainLabelText(InputFormatter.getInput());
    }

    @FXML
    public void percentPressed() {
        if (!isPercentLast) {
            if (lastBinary == null) {
                historyLabel.setText("0");
                setMainLabelText(BigDecimal.ZERO);
                isTypingNew = true;
                return;
            }
            try {
                isPercentLast = true;
                result = model.percent(result, buffer, lastBinary);
                buffer = model.getPercentCoef();
                history.addHistory(lastBinary != null, UnaryOperations.PERCENT, buffer);
                isTypingNew = true;
                isTyping = false;
                setMainLabelText(buffer);
                updateHistoryLabel();
            } catch (DivisionByZeroException | UnexpectedException e) {
                showExceptionMessage(e.getMessage());
            }
        }
    }

    @FXML
    public void cPressed() {
        result = BigDecimal.ZERO;
        isSignHas = false;
        isEqualsPressed = false;
        history.setEqual(false);
        history.cleanAll();
        lastBinary = null;
        isCanNegateToHistory = false;
        updateHistoryLabel();
        historyLeftMover.setVisible(false);
        historyRightMover.setVisible(false);
        cePressed();
    }

    @FXML
    public void delPressed() {
        if (!isTypingNew) {
            backspaceInput();
            isCommaPressed = isInputPointSet();
            buffer = getInput();
            isTyping = false;
            setMainLabelText();
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
        buffer = model.getMemoryValue();
        isTyping = false;
        setMainLabelText(buffer);
    }

    @FXML
    public void mMinusPressed() {
        setDisableMemButtons(false);
        isMemoryUsed = true;
        try {
            model.memoryMinus(whatOnScreen);
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
            model.memoryPlus(whatOnScreen);
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
        model.setMemoryValue(whatOnScreen);
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

    private void setMainLabelText(BigDecimal number) {
        whatOnScreen = parseInput(number.toString());
        try {
            checkOverflow(number);
            if(!isException) {
                mainLabel.setText(OutputFormatter.format(number, true));
            }
        } catch (OverflowException e) {
            showExceptionMessage(OVERFLOW);
        }
        ResizeFont.resizeMainLabelFont();
    }

    private void setMainLabelText() {
        mainLabel.setText(getStringForMainLabel());
        whatOnScreen = parseInput(mainLabel.getText());
        ResizeFont.resizeMainLabelFont();
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
        isException = true;
        mainLabel.setText(message);
        ResizeFont.resizeMainLabelFont();
    }

    private void checkOverflow(BigDecimal number) throws OverflowException {
        if (number.compareTo(MAX_VALUE) >= 0) {
            throw new OverflowException(OVERFLOW);
        } else if (number.compareTo(MIN_VALUE) <= 0) {
            throw new OverflowException(OVERFLOW);
        } else if (number.compareTo(NEAREST_TO_ZERO_POSITIVE_VALUE) < 0 &&
                number.compareTo(BigDecimal.ZERO) > 0) {
            throw new OverflowException(OVERFLOW);
        } else if (number.compareTo(NEAREST_TO_ZERO_NEGATIVE_VALUE) > 0 &&
                number.compareTo(BigDecimal.ZERO) < 0) throw new OverflowException(OVERFLOW);
    }

    private void updateHistoryLabel() {
        historyLabel.setText(formatHistory(history));
        historyLeftMover.setVisible(historyLabel.getWidth() > stage.getWidth() - (historyLeftMover.getWidth() * 2));
    }


    private BigDecimal parseInput(String number) {
        number = number.replace(",", ".");
        number = number.replace("+", "");
        number = number.replace(" ", "");
        return new BigDecimal(number);
    }
}
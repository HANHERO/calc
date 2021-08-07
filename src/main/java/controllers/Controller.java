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
import view.CalcButton;
import view.ResizeFont;
import view.ResizeWindow;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static controllers.formatters.HistoryFormatter.formatHistory;
import static controllers.formatters.InputFormatter.*;

/**
 * The {@code Controller} class
 * processes work of buttons of calculator.
 * <br/>
 * Connects View and Model.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class Controller implements Initializable {
    /** List of text buttons [0 - 9, comma, some operations, etc].*/
    private final List<Button> textButtons = new ArrayList<>();

    /**History of calculator*/
    private final History history = new History();

    /**
     * The Scroll pane history.
     */
    public ScrollPane scrollPaneHistory;

    /** Calculation result */
    private BigDecimal result = BigDecimal.ZERO;

    /** Temporary storage */
    private BigDecimal buffer = BigDecimal.ZERO;

    /**What is currently on the main label.*/
    private BigDecimal whatOnScreen = BigDecimal.ZERO;

    /** Last binary operation */
    private BinaryOperations lastBinary;

    /** True if the last operation was "percent" */
    private boolean isPercentLast = false;

    /** True if equals button was pressed. */
    private boolean isEqualsPressed = false;

    /** True if comma button was pressed. */
    private boolean isCommaPressed = false;

    /** True if input is editable. */
    private boolean isEditable = true;

    /** True if an exception was thrown. */
    private boolean isException = false;

    /** True if any binary operation button was pressed*/
    private boolean isBinaryHas = false;

    /** Max value. */
    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9999999999999995E+9999");

    /** Minimum positive value. */
    private static final BigDecimal MIN_POSITIVE_VALUE = new BigDecimal("1E-9999");

    /** Maximum negative value. */
    private static final BigDecimal MAX_NEGATIVE_VALUE = new BigDecimal("-1E-9999");

    /** Min value. */
    private static final BigDecimal MIN_VALUE = new BigDecimal("-9.9999999999999995E+9999");

    /** Message, which obtained when scale of result is bigger than 10000. */
    private static final String OVERFLOW = "Переполнение";

    /** Calculator buttons */
    public Button historyLeftMover, historyRightMover, plusMinus, zero, comma, equals, one, two, three, plus, four,
            seven, eight, minus, six, five, oneDividedX, multiply, nine, square, sqrt, divide, CE, percent, C, del,
            mc, mr, mPlus, mMinus, ms, mOption, fullScreenButton;

    /**
     * Calculator labels.
     */
    @FXML
    public Label mainLabel, historyLabel;
    /**
     * The left menu pane.
     */
    @FXML
    public AnchorPane menu;

    /** Stage of calculator*/
    private Stage stage;

    /** {@link Calculator} object which consist set of methods
     * of calculation methods*/
    private final Calculator model = new Calculator();

    /** Mouse movement values ​​for moving the window. */
    private double x, y;


    /**
     * Dragged listener.
     * @param event the event
     */
    @FXML
    public void dragged(MouseEvent event) {
        if (stage.getScene().getCursor() == Cursor.DEFAULT) {
            stage.setX(event.getScreenX() + x);
            stage.setY(event.getScreenY() + y);
        }
    }

    /**
     * Pressed listener.
     *
     * @param event the event
     */
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

    /**
     * Window minimization.
     */
    @FXML
    public void minimize() {
        stage.setIconified(true);
    }

    /**
     * Window close.
     */
    @FXML
    public void close() {
        stage.close();
    }

    /**
     * Click on digits buttons processing.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void digitButtonPressed(ActionEvent actionEvent) {
        String digitButton = ((Button) actionEvent.getSource()).getText();
        if (!isEditable && !isCommaPressed) {
            clearInput();
            buffer = BigDecimal.ZERO;
            isEditable = true;
        }
        if (isEqualsPressed || isException) {
            cPressed();
            isEqualsPressed = false;
            history.setEqual(false);
            history.cleanAll();
        }

        appendNumeric(digitButton);
        buffer = InputFormatter.getInput();
        isBinaryHas = false;
        setMainLabelText();
    }

    /**
     * Click on comma button processing.
     */
    @FXML
    public void commaPressed() {
        if (isEqualsPressed) {
            cPressed();
        }
        isCommaPressed = true;
        addPointToInput();
        setMainLabelText();
    }

    /**
     * Click on plus button processing.
     */
    @FXML
    public void plusPressed() {
        sendToBinary(BinaryOperations.PLUS);
    }

    /**
     * Click on minus button processing.
     */
    @FXML
    public void minusPressed() {
        sendToBinary(BinaryOperations.MINUS);
    }

    /**
     * Click on divide button processing.
     */
    @FXML
    public void dividePressed() {
        sendToBinary(BinaryOperations.DIVIDE);
    }

    /**
     * Click on multiply button processing.
     */
    @FXML
    public void multiplyPressed() {
        sendToBinary(BinaryOperations.MULTIPLY);
    }

    private void sendToBinary(BinaryOperations operation) {
        sendToCalculate();
        lastBinary = operation;
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
        if (!isBinaryHas) {
            if (lastBinary != null && !isPercentLast) {
                try {
                    result = model.calculate(result, buffer, lastBinary);
                    isEditable = false;
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
                isEditable = false;
                isCommaPressed = false;
                if (history.getFirstHistory().isEmpty()) {
                    history.setFirst(result);
                }
                setMainLabelText(result);
            }
        }
        updateHistoryLabel();
        clearInput();
        isBinaryHas = true;
    }

    /**
     * Click on equals button processing.
     */
    @FXML
    public void equalsPressed() {
        isEqualsPressed = true;
        isCommaPressed = false;
        isEditable = false;
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
            if (history.getFirstHistory().isEmpty()) {
                history.setFirst(result);
            }
        }
        setMainLabelText(result);
        updateHistoryLabel();
        history.clearFirstHistory();
        history.clearSecondHistory();
        history.setFirst(result);
    }

    private void sendToUnary(UnaryOperations unary) {
        if (unary != UnaryOperations.NEGATIVE) {
            isEditable = false;
        }
        if (isEqualsPressed) {
            isBinaryHas = false;
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

    /**
     * Click on negate button processing.
     */
    @FXML
    public void plusMinusPressed() {
        sendToUnary(UnaryOperations.NEGATIVE);
    }

    /**
     * Click on one divided x button processing.
     */
    @FXML
    public void oneDividedXPressed() {
        sendToUnary(UnaryOperations.ONE_DIVIDED_X);
    }

    /**
     * Click on square button processing.
     */
    @FXML
    public void squarePressed() {
        sendToUnary(UnaryOperations.SQUARE);
    }

    /**
     * Click on sqrt button processing.
     */
    @FXML
    public void rootPressed() {
        sendToUnary(UnaryOperations.SQRT);
    }

    /**
     * Click on percent button processing.
     */
    @FXML
    public void percentPressed() {
        if (!isPercentLast) {
            if (lastBinary == null) {
                historyLabel.setText("0");
                setMainLabelText(BigDecimal.ZERO);
                isEditable = false;
                return;
            }
            try {
                isPercentLast = true;
                result = model.percent(result, buffer, lastBinary);
                buffer = model.getPercentCoef();
                history.addHistory(lastBinary != null, UnaryOperations.PERCENT, buffer);
                isEditable = false;
                setMainLabelText(buffer);
                updateHistoryLabel();
            } catch (DivisionByZeroException | UnexpectedException e) {
                showExceptionMessage(e.getMessage());
            }
        }
    }

    /**
     * Click on clear button processing.
     */
    @FXML
    public void cPressed() {
        result = BigDecimal.ZERO;
        isBinaryHas = false;
        isEqualsPressed = false;
        history.setEqual(false);
        history.cleanAll();
        lastBinary = null;
        updateHistoryLabel();
        historyLeftMover.setVisible(false);
        historyRightMover.setVisible(false);
        cePressed();
    }

    /**
     * Click on clear entry button processing.
     */
    @FXML
    public void cePressed() {
        setDisableAllOperations(false);
        isException = false;
        isCommaPressed = false;
        isPercentLast = false;
        clearInput();
        setMainLabelText(InputFormatter.getInput());
    }

    /**
     * Click on backspace button processing.
     */
    @FXML
    public void backspacePressed() {
        if (isEditable) {
            backspaceInput();
            isCommaPressed = isInputPointSet();
            buffer = getInput();
            setMainLabelText();
        }
    }

    /**
     * Click on memory clear button processing.
     */
    @FXML
    public void mcPressed() {
        setDisableMemButtons(true);
        model.clearMemoryValue();
    }

    /**
     * Click on memory read button processing.
     */
    @FXML
    public void mrPressed() {
        buffer = model.getMemoryValue();
        setMainLabelText(buffer);
    }

    /**
     * Click on memory minus button processing.
     */
    @FXML
    public void mMinusPressed() {
        setDisableMemButtons(false);
        try {
            model.memoryMinus(whatOnScreen);
        } catch (DivisionByZeroException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        isEditable = false;
    }

    /**
     * Click on memory plus button processing.
     */
    @FXML
    public void mPlusPressed() {
        setDisableMemButtons(false);
        try {
            model.memoryPlus(whatOnScreen);
        } catch (DivisionByZeroException | UnexpectedException e) {
            showExceptionMessage(e.getMessage());
        }
        isEditable = false;
    }

    /**
     * Click on memory save button processing..
     */
    @FXML
    public void msPressed() {
        setDisableMemButtons(false);
        model.setMemoryValue(whatOnScreen);
        isEditable = false;
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

    /**
     * Controller initialization.
     *
     * @param stage the stage
     */
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
            if (!isException) {
                mainLabel.setText(OutputFormatter.format(number, true));
            }
        } catch (OverflowException e) {
            showExceptionMessage(OVERFLOW);
        }
        ResizeFont.resizeMainLabelFont();
    }

    private void setMainLabelText() {
        mainLabel.setText(getMainLabelText());
        whatOnScreen = parseInput(mainLabel.getText());
        ResizeFont.resizeMainLabelFont();
    }

    /**
     * Left menu open / close button.
     */
    public void optionOpenOrClose() {
        menu.setVisible(!menu.isVisible());
    }

    /**
     * Closing the left menu by clicking on the main part of the calculator.
     */
    public void clicked() {
        if (menu.isVisible()) {
            menu.setVisible(false);
        }
    }

    /**
     * Button to move history to the left.
     */
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

    /**
     * Button to move history to the right.
     */
    public void moveHistoryRight() {
        double moveRight = scrollPaneHistory.getHvalue() - 0.35;
        double present = scrollPaneHistory.getHvalue();

        scrollPaneHistory.setHvalue(moveRight);
        historyLeftMover.setVisible(true);

        if (present == 0) {
            historyRightMover.setVisible(false);
        }
    }

    /**
     * Button to open the calculator in full screen.
     */
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
        } else if (number.compareTo(MIN_POSITIVE_VALUE) < 0 &&
                number.compareTo(BigDecimal.ZERO) > 0) {
            throw new OverflowException(OVERFLOW);
        } else if (number.compareTo(MAX_NEGATIVE_VALUE) > 0 &&
                number.compareTo(BigDecimal.ZERO) < 0) {
            throw new OverflowException(OVERFLOW);
        }
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
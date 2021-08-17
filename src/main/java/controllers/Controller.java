package controllers;

import controllers.formatters.HistoryFormatter;
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
import java.util.*;

import static model.UnaryOperations.PERCENT;

/**
 * The {@code Controller} class
 * processes work of all buttons of calculator.
 * <br/>
 * Connects View and Model.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class Controller implements Initializable {
    /**
     * Input formatter of calculator
     */
    private final InputFormatter input = new InputFormatter();
    /**
     * History formatter of calculator
     */
    private final HistoryFormatter historyFormatter = new HistoryFormatter();
    /**
     * History of calculator
     */
    private final History history = new History();
    /**
     * The Scroll pane history.
     */
    public ScrollPane scrollPaneHistory;
    /**
     * Calculation result
     */
    private BigDecimal result = BigDecimal.ZERO;
    /**
     * Temporary storage
     */
    private BigDecimal buffer = BigDecimal.ZERO;
    /**
     * What is currently on the main label.
     */
    private BigDecimal whatOnScreen = BigDecimal.ZERO;
    /**
     * Last binary operation
     */
    private BinaryOperations lastBinary;
    /**
     * True if the last operation was "percent"
     */
    private boolean isPercentLast = false;
    /**
     * True if equals button was pressed.
     */
    private boolean isEqualsPressed = false;
    /**
     * True if comma button was pressed.
     */
    private boolean isCommaPressed = false;
    /**
     * True if input is editable.
     */
    private boolean isEditable = true;
    /**
     * True if an exception was thrown.
     */
    private boolean isException = false;
    /**
     * True if any binary operation button was pressed
     */
    private boolean isBinaryHas = false;
    /**
     * Max value.
     */
    private static final BigDecimal MAX_VALUE = new BigDecimal("9.9999999999999995E+9999");
    /**
     * Minimum positive value.
     */
    private static final BigDecimal MIN_POSITIVE_VALUE = new BigDecimal("1E-9999");
    /**
     * Maximum negative value.
     */
    private static final BigDecimal MAX_NEGATIVE_VALUE = new BigDecimal("-1E-9999");
    /**
     * Min value.
     */
    private static final BigDecimal MIN_VALUE = new BigDecimal("-9.9999999999999995E+9999");
    /**
     * Message, which obtained when scale of result is bigger than 10000.
     */
    private static final String OVERFLOW = "Переполнение";
    /**
     * An exception message if the user divides zero by zero.
     */
    private static final String RESULT_UNDEFINED = "Результат неопределен";
    /**
     * An exception message if the user divides any number by zero.
     */
    private static final String DIVISION_BY_ZERO = "Деление на ноль невозможно";
    /**
     * An exception message if the user takes the root of a negative number.
     */
    private static final String NEGATIVE_SQRT = "Неверный ввод";
    /**
     * Used for movement history label
     */
    private static final double HISTORY_MOVEMENT_FACTOR = 0.35;
    /**
     * Calculator buttons
     */
    public Button historyLeftMover, historyRightMover, plusMinus, zero, comma, equals, one, two, three, plus, four,
            seven, eight, minus, six, five, oneDividedX, multiply, nine, square, sqrt, divide, CE, percent, C, del,
            mc, mr, mPlus, mMinus, ms, mOption, fullScreenButton;
    /**
     * List of text buttons [0 - 9, comma, some operations, etc].
     */
    private final List<Button> textButtons = new ArrayList<>();
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
    /**
     * Stage of calculator
     */
    private Stage stage;
    /**
     * {@link Calculator} object which consist set of methods
     * of calculation methods
     */
    private final Calculator model = new Calculator();
    /**
     * {@link Memory} object which consist set of methods
     * of memory methods
     */
    private final Memory memory = new Memory();
    /**
     * Mouse movement values ​​for moving the window.
     */
    private double x, y;

    /**
     * Dragged listener.
     *
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

    private void fillButtonsArrays() {
        Collections.addAll(textButtons, one, two, three, four, five, six, seven,
                eight, nine, comma, zero, C, CE, del, oneDividedX, square, percent, divide, multiply, minus, plus, equals);
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
            input.clearInput();
            buffer = BigDecimal.ZERO;
            isEditable = true;
        }
        if (isEqualsPressed || isException) {
            cPressed();
            isEqualsPressed = false;
            history.setEqual(false);
            history.cleanAll();
        }
        input.appendNumeric(digitButton);
        buffer = input.getInput();
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
        input.addPointToInput();
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
                isEditable = false;
                isCommaPressed = false;
                isPercentLast = false;
                try {
                    result = model.calculate(result, buffer, lastBinary);
                    history.setOperation(lastBinary);
                } catch (DivisionByZeroException e) {
                    checkDivisionByZero();
                }
            } else {
                result = whatOnScreen;
            }
            if (history.getFirstHistory().isEmpty()) {
                history.setFirst(result);
            }
            buffer = result;
            setMainLabelText(result);
        }
        updateHistoryLabel();
        input.clearInput();
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
            } catch (DivisionByZeroException e) {
                checkDivisionByZero();
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
        } catch (DivisionByZeroException e) {
            showExceptionMessage(RESULT_UNDEFINED);
        } catch (NegativeSqrtException e) {
            showExceptionMessage(NEGATIVE_SQRT);
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
            isEditable = false;
            if (lastBinary == null) {
                historyLabel.setText("0");
                setMainLabelText(BigDecimal.ZERO);
            } else {
                try {
                    isPercentLast = true;
                    buffer = model.percent(result, buffer, lastBinary);
                    result = model.calculate(result, buffer, lastBinary);
                    history.addHistory(lastBinary != null, PERCENT, buffer);
                    setMainLabelText(buffer);
                    updateHistoryLabel();
                } catch (DivisionByZeroException e) {
                    checkDivisionByZero();
                }
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
        input.clearInput();
        setMainLabelText(input.getInput());
    }

    /**
     * Click on backspace button processing.
     */
    @FXML
    public void backspacePressed() {
        if (isEditable) {
            input.backspaceInput();
            isCommaPressed = input.isInputPointSet();
            buffer = input.getInput();
            setMainLabelText();
        }
    }

    /**
     * Click on memory clear button processing.
     */
    @FXML
    public void mcPressed() {
        setDisableMemButtons(true);
        memory.clearMemoryValue();
        history.cleanAll();
        updateHistoryLabel();
    }

    /**
     * Click on memory read button processing.
     */
    @FXML
    public void mrPressed() {
        buffer = memory.getMemoryValue();
        history.cleanAll();
        updateHistoryLabel();
        setMainLabelText(buffer);
    }

    /**
     * Click on memory minus button processing.
     */
    @FXML
    public void mMinusPressed() {
        setDisableMemButtons(false);
        try {
            memory.memoryMinus(whatOnScreen);
            history.cleanAll();
            updateHistoryLabel();
        } catch (DivisionByZeroException e) {
            checkDivisionByZero();
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
            memory.memoryPlus(whatOnScreen);
            history.cleanAll();
            updateHistoryLabel();
        } catch (DivisionByZeroException e) {
            checkDivisionByZero();
        }
        isEditable = false;
    }

    /**
     * Click on memory save button processing..
     */
    @FXML
    public void msPressed() {
        setDisableMemButtons(false);
        memory.setMemoryValue(whatOnScreen);
        history.cleanAll();
        updateHistoryLabel();
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
        fillButtonsArrays();
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
        List.of(percent, oneDividedX, square, sqrt, divide, multiply, minus, plus, plusMinus,
                comma, equals).forEach(b -> b.setDisable(isDisable));
    }

    private void checkDivisionByZero() {
        String message;
        if (result.equals(BigDecimal.ZERO)) {
            message = RESULT_UNDEFINED;
        } else {
            message = DIVISION_BY_ZERO;
        }
        showExceptionMessage(message);
    }

    private void setDisableMemButtons(boolean isDisable) {
        List.of(mc, mr, mOption).forEach(b -> b.setDisable(isDisable));
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
        mainLabel.setText(input.getMainLabelText());
        whatOnScreen = parseInput(mainLabel.getText());
        ResizeFont.resizeMainLabelFont();
    }

    /**
     * Left menu open / close button.
     */
    public void optionOpenOrCloseMenu() {
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
        double moveLeft = scrollPaneHistory.getHvalue() + HISTORY_MOVEMENT_FACTOR;

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
        double moveRight = scrollPaneHistory.getHvalue() - HISTORY_MOVEMENT_FACTOR;
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
        String style;
        if (stage.isMaximized()) {
            stage.setMaximized(false);
            style = "-fx-background-image: url('/buttons/fullScreen.png')";
            ResizeFont.resizeButtonFonts();
        } else {
            stage.setMaximized(true);
            style = "-fx-background-image: url('/buttons/notFullScreen.png')";
            textButtons.forEach(b -> b.setStyle("-fx-font-size: 24px"));
        }
        ResizeFont.resizeMainLabelFont();
        fullScreenButton.setStyle(style);
    }

    private void showExceptionMessage(String message) {
        setDisableAllOperations(true);
        isException = true;
        mainLabel.setText(message);
        ResizeFont.resizeMainLabelFont();
    }

    private void checkOverflow(BigDecimal number) throws OverflowException {
        if (number.compareTo(MAX_VALUE) >= 0 || number.compareTo(MIN_VALUE) <= 0 ||
                (number.compareTo(MIN_POSITIVE_VALUE) < 0 && number.compareTo(BigDecimal.ZERO) > 0) ||
                (number.compareTo(MAX_NEGATIVE_VALUE) > 0 && number.compareTo(BigDecimal.ZERO) < 0)) {
            throw new OverflowException(OVERFLOW);
        }
    }

    private void updateHistoryLabel() {
        historyLabel.setText(historyFormatter.formatHistory(history));
        historyLeftMover.setVisible(historyLabel.getWidth() > stage.getWidth() - (historyLeftMover.getWidth() * 2));
    }

    private BigDecimal parseInput(String number) {
        number = number.replace(",", ".");
        number = number.replace("+", "");
        number = number.replace(" ", "");
        return new BigDecimal(number);
    }
}
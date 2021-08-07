package view;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

import static javafx.scene.input.KeyCombination.CONTROL_DOWN;
import static javafx.scene.input.KeyCombination.SHIFT_DOWN;

/**
 * Enum of calculator buttons.
 * <br/>
 * Store id buttons from view.fxml,
 * and setup keycode combinations.
 * There are methods for working with {@code CalcButton} enum:
 *  - getFXId,
 *  - searchButtonByEvent.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public enum CalcButton {
    /**
     * Zero calc button.
     */
    ZERO("#zero"),
    /**
     * One calc button.
     */
    ONE("#one"),
    /**
     * Two calc button.
     */
    TWO("#two"),
    /**
     * Three calc button.
     */
    THREE("#three"),
    /**
     * Four calc button.
     */
    FOUR("#four"),
    /**
     * Five calc button.
     */
    FIVE("#five"),
    /**
     * Six calc button.
     */
    SIX("#six"),
    /**
     * Seven calc button.
     */
    SEVEN("#seven"),
    /**
     * Eight calc button.
     */
    EIGHT("#eight"),
    /**
     * Nine calc button.
     */
    NINE("#nine"),
    /**
     * Comma calc button.
     */
    COMMA("#comma"),
    /**
     * Plus minus calc button.
     */
    PLUS_MINUS("#plusMinus"),
    /**
     * Equals calc button.
     */
    EQUALS("#equals"),
    /**
     * Plus calc button.
     */
    PLUS("#plus"),
    /**
     * Minus calc button.
     */
    MINUS("#minus"),
    /**
     * Divide calc button.
     */
    DIVIDE("#divide"),
    /**
     * Multiply calc button.
     */
    MULTIPLY("#multiply"),
    /**
     * One divided x calc button.
     */
    ONE_DIVIDED_X("#oneDividedX"),
    /**
     * Sqr calc button.
     */
    SQR("#square"),
    /**
     * Sqrt calc button.
     */
    SQRT("#sqrt"),
    /**
     * Percent calc button.
     */
    PERCENT("#percent"),
    /**
     * C calc button.
     */
    C("#C"),
    /**
     * Ce calc button.
     */
    CE("#CE"),
    /**
     * Del calc button.
     */
    DEL("#del"),
    /**
     * Mc calc button.
     */
    MC("#mc"),
    /**
     * Mr calc button.
     */
    MR("#mr"),
    /**
     * M minus calc button.
     */
    M_MINUS("#mMinus"),
    /**
     * M plus calc button.
     */
    M_PLUS("#mPlus"),
    /**
     * Ms calc button.
     */
    MS("#ms");

    private final String fxId;
    private static final HashMap<KeyCodeCombination, CalcButton> keys = new HashMap<>();

    CalcButton(String fxId) {
        this.fxId = fxId;
    }

    static {
        keys.put(new KeyCodeCombination(KeyCode.DIGIT0), ZERO);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD0), ZERO);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT1), ONE);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD1), ONE);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT2), TWO);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD2), TWO);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT3), THREE);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD3), THREE);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT4), FOUR);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD4), FOUR);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT5), FIVE);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD5), FIVE);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT6), SIX);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD6), SIX);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT7), SEVEN);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD7), SEVEN);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT8), EIGHT);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD8), EIGHT);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT9), NINE);
        keys.put(new KeyCodeCombination(KeyCode.NUMPAD9), NINE);
        keys.put(new KeyCodeCombination(KeyCode.COMMA), COMMA);
        keys.put(new KeyCodeCombination(KeyCode.DECIMAL), COMMA);
        keys.put(new KeyCodeCombination(KeyCode.F9), PLUS_MINUS);
        keys.put(new KeyCodeCombination(KeyCode.EQUALS), EQUALS);
        keys.put(new KeyCodeCombination(KeyCode.ENTER), EQUALS);
        keys.put(new KeyCodeCombination(KeyCode.ADD), PLUS);
        keys.put(new KeyCodeCombination(KeyCode.SUBTRACT), MINUS);
        keys.put(new KeyCodeCombination(KeyCode.MINUS), MINUS);
        keys.put(new KeyCodeCombination(KeyCode.DIVIDE), DIVIDE);
        keys.put(new KeyCodeCombination(KeyCode.SLASH), DIVIDE);
        keys.put(new KeyCodeCombination(KeyCode.MULTIPLY), MULTIPLY);
        keys.put(new KeyCodeCombination(KeyCode.R), ONE_DIVIDED_X);
        keys.put(new KeyCodeCombination(KeyCode.Q), SQR);
        keys.put(new KeyCodeCombination(KeyCode.ESCAPE), C);
        keys.put(new KeyCodeCombination(KeyCode.DELETE), CE);
        keys.put(new KeyCodeCombination(KeyCode.BACK_SPACE), DEL);
        keys.put(new KeyCodeCombination(KeyCode.EQUALS, SHIFT_DOWN), PLUS);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT8, SHIFT_DOWN), MULTIPLY);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT2, SHIFT_DOWN), SQRT);
        keys.put(new KeyCodeCombination(KeyCode.DIGIT5, SHIFT_DOWN), PERCENT);
        keys.put(new KeyCodeCombination(KeyCode.L, CONTROL_DOWN), MC);
        keys.put(new KeyCodeCombination(KeyCode.R, CONTROL_DOWN), MR);
        keys.put(new KeyCodeCombination(KeyCode.Q, CONTROL_DOWN), M_MINUS);
        keys.put(new KeyCodeCombination(KeyCode.P, CONTROL_DOWN), M_PLUS);
        keys.put(new KeyCodeCombination(KeyCode.M, CONTROL_DOWN), MS);
    }

    /**
     * Return fx:id of given button
     */
    public String getFXId() {
        return fxId;
    }

    /**
     * Search button with given keycode combination
     *
     * @param event given keycode combination
     */
    public static CalcButton searchButtonByEvent(KeyEvent event) {
        CalcButton button = null;
        for (KeyCodeCombination code : keys.keySet()) {
            if (code.match(event)) {
                button =  keys.get(code);
            }
        }
        return button;
    }
}
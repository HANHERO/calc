package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;


/**
 * The {@code ResizeFont} class is for changing the font size of buttons and the font of the main label.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class ResizeFont {
    /** The stage on which the changes will be made. */
    private static Stage stage;
    /** The main label on which the changes will be made. */
    private static Label mainLabel;
    /** Buttons on which the changes will be made. */
    private static List<Button> buttons;

    private ResizeFont() {
    }

    /**
     * Class initialization.
     *
     * @param stage       the stage
     * @param label       the label
     * @param textButtons the text buttons
     */
    public static void init(Stage stage, Label label, List<Button> textButtons) {
        mainLabel = label;
        ResizeFont.stage = stage;
        buttons = textButtons;
    }

    /**
     * This method changes the font size of the buttons based on the height of the window.
     */
    public static void resizeButtonFonts(){
        double textButtonsFontSize;
        for (int i = 0; i < buttons.size(); i++) {
            if (i < 11) {
                textButtonsFontSize = (stage.getHeight() - 500) * 0.016 + 18;
            }else {
                textButtonsFontSize = (stage.getHeight() - 500) * 0.016 + 15;
            }
            buttons.get(i).setStyle("-fx-font-size: " + textButtonsFontSize + "px");
        }
    }

    /**
     * This method changes the font size
     * main label so that the text fits into it.
     */
    public static void resizeMainLabelFont() {
        String font = "Segoe UI Semibold";
        int maximizedTextMainLabelSize = 72;
        int normalTextMainLabelSize = 46;
        if (!stage.isMaximized()) {
            if (mainLabel.getFont().getSize() == maximizedTextMainLabelSize) {
                mainLabel.setFont(new javafx.scene.text.Font(font, normalTextMainLabelSize));
            }
            double size = mainLabel.getFont().getSize();
            double maxTextSizeInPx = mainLabel.getWidth() - 20;

            BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            FontMetrics fm = img.getGraphics().getFontMetrics(new Font(font, Font.PLAIN, (int) size));

            while (fm.stringWidth(mainLabel.getText()) < maxTextSizeInPx && size < normalTextMainLabelSize) {
                fm = img.getGraphics().getFontMetrics(new Font(font, Font.PLAIN, (int) ++size));
            }

            while (fm.stringWidth(mainLabel.getText()) > maxTextSizeInPx) {
                fm = img.getGraphics().getFontMetrics(new Font(font, Font.PLAIN, (int) --size));
            }
            mainLabel.setFont(new javafx.scene.text.Font(font, (int) size));
        } else {
            mainLabel.setFont(new javafx.scene.text.Font(font, maximizedTextMainLabelSize));
        }
    }
}
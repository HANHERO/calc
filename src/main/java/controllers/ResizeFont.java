package controllers;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ResizeFont {
    private static Stage stage;
    private static Label mainLabel;

    private ResizeFont() {
    }

    public static void init(Stage stage, Label label) {
        mainLabel = label;
        ResizeFont.stage = stage;
    }

    public static void resizeMainLabelFont() {
        if (!stage.isMaximized()) {
            if (mainLabel.getFont().getSize() == 72) {
                mainLabel.setFont(new javafx.scene.text.Font("Segoe UI Semibold", 46));
            }
            double size = mainLabel.getFont().getSize();
            double maxTextSizeInPx = mainLabel.getWidth() - 20;

            BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            FontMetrics fm = img.getGraphics().getFontMetrics(new Font("Segoe UI Semibold", Font.PLAIN, (int) size));

            while (fm.stringWidth(mainLabel.getText()) < maxTextSizeInPx && size < 46) {
                fm = img.getGraphics().getFontMetrics(new Font("Segoe UI Semibold", Font.PLAIN, (int) ++size));
            }

            while (fm.stringWidth(mainLabel.getText()) > maxTextSizeInPx) {
                fm = img.getGraphics().getFontMetrics(new Font("Segoe UI Semibold", Font.PLAIN, (int) --size));
            }
            mainLabel.setFont(new javafx.scene.text.Font("Segoe UI Semibold", (int) size));
        } else {
            mainLabel.setFont(new javafx.scene.text.Font("Segoe UI Semibold", 72));
        }
    }
}
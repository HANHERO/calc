package controllers;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class ResizeWindow implements EventHandler<MouseEvent> {
    private static final double BORDER = 10;
    private static final double MIN_WIDTH = 320;
    private static final double MIN_HEIGHT = 500;
    private double dx;
    private double dy;
    private boolean isMoveH;
    private boolean isMoveV;
    private boolean isResizeHorizontal;
    private boolean isResizeVertical;
    private final Scene scene;
    private final Stage stage;
    private final List<Button> textButtons;
    private Cursor cursor;

    public ResizeWindow(Stage stage, List<Button> textButtons) {
        this.stage = stage;
        this.scene = stage.getScene();
        this.textButtons = textButtons;
    }

    @Override
    public void handle(MouseEvent event) {

        EventType type = event.getEventType();

        if (type.equals(MouseEvent.MOUSE_MOVED)) {
            changeCursor(event);
        } else if (type.equals(MouseEvent.MOUSE_PRESSED)) {
            dx = stage.getWidth() - event.getX();
            dy = stage.getHeight() - event.getY();
        } else if (type.equals(MouseEvent.MOUSE_DRAGGED)) {
            if (isResizeHorizontal) {
                changeWidth(event);
            }
            if (isResizeVertical) {
                changeHeight(event);
            }
        }
    }

    private void changeHeight(MouseEvent event) {
        double deltaY = stage.getY() - event.getScreenY();
        double height = stage.getHeight();
        double eventY = event.getY();
        double newHeight = stage.getHeight();
        double newY = stage.getY();

        if (height <= MIN_HEIGHT) {
            if (isMoveV) {
                if (eventY < 0) {
                    newHeight = height + deltaY;
                    newY = event.getScreenY();
                }
            } else if (eventY + dy - height > 0) {
                newHeight = eventY + dy;
            }
        } else {
            if (isMoveV) {
                newHeight = height + deltaY;
                newY = event.getScreenY();
            } else {
                newHeight = eventY + dy;
            }
        }
        stage.setHeight(newHeight);
        stage.setY(newY);
        ResizeFont.resizeButtonFonts();
    }

    private void changeWidth(MouseEvent event) {
        double deltaX = stage.getX() - event.getScreenX();
        double width = stage.getWidth();
        double eventX = event.getX();
        double newWidth = stage.getWidth();
        double newX = stage.getX();

        if (width <= MIN_WIDTH) {
            if (isMoveH) {
                if (eventX < 0) {
                    newWidth = width + deltaX;

                    newX = event.getScreenX();
                }
            } else if (eventX + dx - width > 0) {
                newWidth = eventX + dx;
            }
        } else {
            if (isMoveH) {
                newWidth = deltaX + width;
                newX = event.getScreenX();
            } else {
                newWidth = eventX + dx;
            }
        }

        stage.setWidth(newWidth);
        stage.setX(newX);
        ResizeFont.resizeMainLabelFont();
    }

    private void changeCursor(MouseEvent event) {
        double eventX = event.getX();
        double eventY = event.getY();
        double width = scene.getWidth();
        double height = scene.getHeight();

        if (eventX < BORDER && eventY < BORDER) {
            cursor = Cursor.NW_RESIZE;
            isResizeHorizontal = true;
            isResizeVertical = true;
            isMoveH = true;
            isMoveV = true;
        } else if (eventX < BORDER && eventY > height - BORDER) {
            cursor = Cursor.SW_RESIZE;
            isResizeHorizontal = true;
            isResizeVertical = true;
            isMoveH = true;
            isMoveV = false;
        } else if (eventX > width - BORDER && eventY < BORDER) {
            cursor = Cursor.NE_RESIZE;
            isResizeHorizontal = true;
            isResizeVertical = true;
            isMoveH = false;
            isMoveV = true;
        } else if (eventX > width - BORDER && eventY > height - BORDER) {
            cursor = Cursor.SE_RESIZE;
            isResizeHorizontal = true;
            isResizeVertical = true;
            isMoveH = false;
            isMoveV = false;
        } else if (eventX < BORDER || eventX > width - BORDER) {
            cursor = Cursor.E_RESIZE;
            isResizeHorizontal = true;
            isResizeVertical = false;
            isMoveH = (eventX < BORDER);
            isMoveV = false;
        } else if (eventY < BORDER || eventY > height - BORDER) {
            cursor = Cursor.N_RESIZE;
            isResizeHorizontal = false;
            isResizeVertical = true;
            isMoveH = false;
            isMoveV = (eventY < BORDER);
        } else {
            cursor = Cursor.DEFAULT;
            isResizeHorizontal = false;
            isResizeVertical = false;
            isMoveH = false;
            isMoveV = false;
        }

        scene.setCursor(cursor);
    }
}
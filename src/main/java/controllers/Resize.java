package controllers;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Resize implements EventHandler<MouseEvent> {

    private static final double border = 10;
    private double lastWight;
    private double lastHeight;
    private double lastScreenX;
    private double lastScreenY;
    private double deltaX;
    private double deltaY;
    private double minPositionX;
    private double minPositionY;
    private boolean moveH;
    private boolean moveV;
    private boolean resizeH = false;
    private boolean resizeV = false;
    private Stage stage;
    private double stageMinWidth;
    private double stageMinHeight;
    private Scene scene;

    Resize(Stage stage) {
        this.stage = stage;
        stageMinWidth = stage.getMinWidth();
        stageMinHeight = stage.getMinHeight();
        scene = stage.getScene();

    }

    @Override
    public void handle(MouseEvent t) {
        if (MouseEvent.MOUSE_MOVED.equals(t.getEventType())) {
            double windowX = t.getX();
            double windowY = t.getY();
            double sceneWidth = scene.getWidth();
            double sceneHeight = scene.getHeight();

            if (windowX < border && windowY < border) {
                scene.setCursor(Cursor.NW_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = true;
                moveV = true;
            } else if (windowX < border && windowY > sceneHeight - border) {
                scene.setCursor(Cursor.SW_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = true;
                moveV = false;
            } else if (windowX > sceneWidth - border && windowY < border) {
                scene.setCursor(Cursor.NE_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = false;
                moveV = true;
            } else if (windowX > sceneWidth - border && windowY > sceneHeight - border) {
                scene.setCursor(Cursor.SE_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = false;
                moveV = false;
            } else if (windowX < border || windowX > sceneWidth - border) {
                scene.setCursor(Cursor.E_RESIZE);
                resizeH = true;
                resizeV = false;
                moveH = (windowX < border);
                moveV = false;
            } else if (windowY < border || windowY > sceneHeight - border) {
                scene.setCursor(Cursor.N_RESIZE);
                resizeH = false;
                resizeV = true;
                moveH = false;
                moveV = (windowY < border);
            } else {
                scene.setCursor(Cursor.DEFAULT);
                resizeH = false;
                resizeV = false;
                moveH = false;
                moveV = false;
            }
        } else if (MouseEvent.MOUSE_PRESSED.equals(t.getEventType())) {
            lastWight = stage.getWidth();
            lastHeight = stage.getHeight();

            lastScreenX = t.getScreenX();
            lastScreenY = t.getScreenY();

            minPositionX = stage.getX() + (lastWight - stageMinWidth);
            minPositionY = stage.getY() + (lastHeight - stageMinHeight);
        } else if (MouseEvent.MOUSE_DRAGGED.equals(t.getEventType())) {
            if (resizeH) {
                double newScreenX = t.getScreenX();
                if (moveH) {
                    deltaX = lastScreenX - newScreenX;
                    double newWight = lastWight + deltaX;

                    if (newWight < stageMinWidth) {
                        newWight = stageMinWidth;
                        newScreenX = minPositionX;
                    }

                    setWight(newWight);
                    stage.setX(newScreenX);
                } else {
                    deltaX = newScreenX - lastScreenX;
                    double wight = lastWight + deltaX;

                    if (newScreenX < lastScreenX) {
                        wight = stageMinWidth;
                    }

                    setWight(wight);
                }
            }
            if (resizeV) {
                double newScreenY = t.getScreenY();
                if (moveV) {
                    deltaY = lastScreenY - newScreenY;
                    double newHeight = lastHeight + deltaY;

                    if (newHeight < stageMinHeight) {
                        newHeight = stageMinHeight;
                        newScreenY = minPositionY;
                    }

                    setHeight(newHeight);
                    stage.setY(newScreenY);
                } else {
                    deltaY = newScreenY - lastScreenY;
                    double height = lastHeight + deltaY;

                    if (newScreenY < lastScreenY) {
                        height = stageMinHeight;
                    }

                    setHeight(height);
                }
            }
        } else if (MouseEvent.MOUSE_RELEASED.equals(t.getEventType())) {
            if (moveH || moveV) {
                stage.setX(lastScreenX);
                stage.setY(lastScreenY);
            }
        }
    }

    private void setWight(double wight) {
        stage.setWidth(wight);
    }

    private void setHeight(double height) {
        stage.setHeight(height);
    }
}

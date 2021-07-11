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
    private static final double BORDER = 5;
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
                    newHeight = deltaY + height;
                    newY = event.getScreenY();
                }
            } else if (eventY + dy - height > 0) {
                newHeight = eventY + dy;
            }
        } else {
            if (isMoveV) {
                newHeight = deltaY + height;
                newY = event.getScreenY();
            } else {
                newHeight = eventY + dy;
            }
        }
        stage.setHeight(newHeight);
        stage.setY(newY);
        double textButtonsFontSize = 18 + (stage.getHeight() - 500) * 0.016;
        for (Button textButton : textButtons) {
            textButton.setStyle("-fx-font-size: " + textButtonsFontSize + "px");
        }
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
                    newWidth = deltaX + width;
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
        Cursor cursor;
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
    /*private static final double border = 10;
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
    private final Stage stage;
    private final double stageMinWidth;
    private final double stageMinHeight;
    private final Scene scene;
    private final List<Button> textButtons;

    ResizeWindow(Stage stage, List<Button> textButtons) {
        this.stage = stage;
        stageMinWidth = stage.getMinWidth();
        stageMinHeight = stage.getMinHeight();
        scene = stage.getScene();
        this.textButtons = textButtons;

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
        ResizeFont.resizeMainLabelFont();
    }

    private void setHeight(double height) {
        stage.setHeight(height);
        double textButtonsFontSize = 18 + (stage.getHeight() - 500) * 0.016;
        for (Button textButton : textButtons) {
            textButton.setStyle("-fx-font-size: " + textButtonsFontSize + "px");
        }
    }
}*/
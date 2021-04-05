package controllers;

import model.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    MainModel model = new MainModel();
    double x, y;

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node ) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() + x);
        stage.setY(event.getScreenY() + y);
    }

    @FXML
    void pressed(MouseEvent event) {
        Stage stage = (Stage) ((Node ) event.getSource()).getScene().getWindow();
        x = stage.getX() - event.getScreenX();
        y = stage.getY() - event.getScreenY();
    }

    @FXML
    void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node ) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node ) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void plusMinusClicked() {
    }

    public void zeroClicked() {
        model.initB(0);
    }

    public void commaClicked() {
        model.commaClicked();
    }

    public void equalsClicked() {
    }

    public void oneClicked() {
        model.initB(1);
    }

    public void twoClicked() {
        model.initB(2);
    }

    public void threeClicked() {
        model.initB(3);
    }

    public void plusClicked() {
    }

    public void fourClicked() {
        model.initB(4);
    }

    public void sevenClicked() {
        model.initB(7);
    }

    public void eightClicked() {
        model.initB(8);
    }

    public void minusClicked() {
    }

    public void sixClicked() {
        model.initB(6);
    }

    public void fiveClicked() {
        model.initB(5);
    }

    public void oneDividedX() {
    }

    public void multiplyClicked() {
    }

    public void nineClicked() {
        model.initB(9);
    }

    public void squareClicked() {
        model.squareClicked();
    }

    public void rootClicked() {
        model.root();
    }

    public void divideClicked() {
    }

    public void ceClicked() {
        model.ceClicked();
    }

    public void percentClicked() {
    }

    public void cClicked() {
        model.cClicked();
    }

    public void delClicked() {
    }

    public void mcClicked() {
    }

    public void mrClicked() {
    }

    public void mPlusClicked() {
    }

    public void mMinusClicked() {
    }

    public void msClicked() {
    }

    public void mOptionClicked() {
    }

    public void optionClicked() {
    }

    public void historyClicked() {
    }
}

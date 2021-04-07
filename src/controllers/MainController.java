package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.MainModel;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    MainModel model = new MainModel();
    double x, y;

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() + x);
        stage.setY(event.getScreenY() + y);
    }

    @FXML
    void pressed(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        x = stage.getX() - event.getScreenX();
        y = stage.getY() - event.getScreenY();
    }

    @FXML
    void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void plusMinusClicked() {
    }

    @FXML
    public void zeroClicked() {
        model.initB(0);
    }

    @FXML
    public void commaClicked() {
        model.commaClicked();
    }

    @FXML
    public void equalsClicked() {
    }

    @FXML
    public void oneClicked() {
        model.initB(1);
    }

    @FXML
    public void twoClicked() {
        model.initB(2);
    }

    @FXML
    public void threeClicked() {
        model.initB(3);
    }

    @FXML
    public void plusClicked() {
    }

    @FXML
    public void fourClicked() {
        model.initB(4);
    }

    @FXML
    public void sevenClicked() {
        model.initB(7);
    }

    @FXML
    public void eightClicked() {
        model.initB(8);
    }

    @FXML
    public void minusClicked() {
    }

    @FXML
    public void sixClicked() {
        model.initB(6);
    }

    @FXML
    public void fiveClicked() {
        model.initB(5);
    }

    @FXML
    public void oneDividedX() {
    }

    @FXML
    public void multiplyClicked() {
    }

    @FXML
    public void nineClicked() {
        model.initB(9);
    }

    @FXML
    public void squareClicked() {
        model.squareClicked();
    }

    @FXML
    public void rootClicked() {
        model.root();
    }

    @FXML
    public void divideClicked() {
    }

    @FXML
    public void ceClicked() {
        model.ceClicked();
    }

    @FXML
    public void percentClicked() {
    }

    @FXML
    public void cClicked() {
        model.cClicked();
    }

    @FXML
    public void delClicked() {
    }

    @FXML
    public void mcClicked() {
    }

    @FXML
    public void mrClicked() {
    }

    @FXML
    public void mPlusClicked() {
    }

    @FXML
    public void mMinusClicked() {
    }

    @FXML
    public void msClicked() {
    }

    @FXML
    public void mOptionClicked() {
    }

    @FXML
    public void optionClicked(Event event) throws IOException {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void historyClicked() {
    }
}

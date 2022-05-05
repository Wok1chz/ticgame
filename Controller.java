package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button b1;
    @FXML
    Label p1s;
    @FXML
    Label p2s;
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;
    @FXML
    Label l4;
    @FXML
    Label l5;
    @FXML
    Label l6;
    @FXML
    Label l7;
    @FXML
    Label l8;
    @FXML
    Label l9;

    GameField gfield = new GameField();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gfield.reset(p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9);
        b1.setOnMouseClicked(event -> gfield.reset(p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));

        l1.setOnMouseEntered(event-> gfield.preTurnIn(l1,0));
        l1.setOnMouseExited(event-> gfield.preTurnOut(l1,0));

        l2.setOnMouseEntered(event-> gfield.preTurnIn(l2,1));
        l2.setOnMouseExited(event-> gfield.preTurnOut(l2,1));

        l3.setOnMouseEntered(event->gfield.preTurnIn(l3,2));
        l3.setOnMouseExited(event->gfield.preTurnOut(l3,2));

        l4.setOnMouseEntered(event->gfield.preTurnIn(l4,3));
        l4.setOnMouseExited(event->gfield.preTurnOut(l4,3));

        l5.setOnMouseEntered(event->gfield.preTurnIn(l5,4));
        l5.setOnMouseExited(event->gfield.preTurnOut(l5,4));

        l6.setOnMouseEntered(event->gfield.preTurnIn(l6,5));
        l6.setOnMouseExited(event->gfield.preTurnOut(l6,5));

        l7.setOnMouseEntered(event->gfield.preTurnIn(l7,6));
        l7.setOnMouseExited(event->gfield.preTurnOut(l7,6));

        l8.setOnMouseEntered(event->gfield.preTurnIn(l8,7));
        l8.setOnMouseExited(event->gfield.preTurnOut(l8,7));

        l9.setOnMouseEntered(event->gfield.preTurnIn(l9,8));
        l9.setOnMouseExited(event->gfield.preTurnOut(l9,8));

        l1.setOnMouseClicked(event -> gfield.logic(0,l1,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l2.setOnMouseClicked(event -> gfield.logic(1,l2,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l3.setOnMouseClicked(event -> gfield.logic(2,l3,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l4.setOnMouseClicked(event -> gfield.logic(3,l4,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l5.setOnMouseClicked(event -> gfield.logic(4,l5,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l6.setOnMouseClicked(event -> gfield.logic(5,l6,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l7.setOnMouseClicked(event -> gfield.logic(6,l7,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l8.setOnMouseClicked(event -> gfield.logic(7,l8,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
        l9.setOnMouseClicked(event -> gfield.logic(8,l9,p1s,p2s,l1,l2,l3,l4,l5,l6,l7,l8,l9));
    }
}

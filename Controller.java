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


    Elements map = new Elements(0);
    MusicPlayer musicPlayer = new MusicPlayer();
    Player p1=new Player(0,true);
    Player p2=new Player(0,false);

    void clear(){
        l1.setText("");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        l5.setText("");
        l6.setText("");
        l7.setText("");
        l8.setText("");
        l9.setText("");
    }

    void reset(Elements map, Player p1, Player p2, Label p1s, Label p2s){
        map.fill_map();
        clear();
        Player.p_default(p1,p2);
        p1.reset();
        p2.reset();
        p1s.setText(String.valueOf(Player.getScore(p1)));
        p2s.setText(String.valueOf(Player.getScore(p2)));
    }

    void set_x(Label label, javafx.scene.paint.Color color){
        label.setTextFill(color);
        label.setText("X");
    }

    void set_o(Label label,javafx.scene.paint.Color color){
        label.setTextFill(color);
        label.setText("O");
    }

    void pre_turn_in(Label l,Player p1, Player p2, Elements map, int i){
        if(p1.getTurn() && map.get_value(i)<1) {
            set_x(l,javafx.scene.paint.Color.web("#97a5b2"));
        }else if (p2.getTurn() && map.get_value(i)<1) {
            set_o(l,javafx.scene.paint.Color.web("#97a5b2"));
        }
    }

    void pre_turn_out(Label l, Elements map, int i){
        if(map.get_value(i)<1) {
            l.setText("");
        }
    }
    
    void logic(Player p1,Player p2, Elements map, int i,Label l, Label p1s, Label p2s, MusicPlayer musicPlayer){
        if(p1.getTurn() && map.get_value(i)<1) {
            map.set_x(i);
            set_x(l,javafx.scene.paint.Color.DODGERBLUE);
            musicPlayer.turn_music();
            if(map.check_win()) {
                p1.add_score();
                p1s.setText(String.valueOf(Player.getScore(p1)));
                map.fill_map();
                musicPlayer.win_music();
                clear();
                Player.p_default(p1,p2);
            }else if (map.check_full()) {
                map.fill_map();
                musicPlayer.draw_music();
                clear();
                Player.p_default(p1,p2
                );
            }else{
                Player.t_switch(p1,p2);
            }
        }else if (p2.getTurn() && map.get_value(i)<1) {
            map.set_o(i);
            set_o(l,javafx.scene.paint.Color.web("#ff215c"));
            musicPlayer.turn_music();
            if(map.check_win()){
                p2.add_score();
                p2s.setText(String.valueOf(Player.getScore(p2)));
                map.fill_map();
                musicPlayer.win_music();
                clear();
                Player.p_default(p1,p2
                );

            }else if (map.check_full()) {
                map.fill_map();
                musicPlayer.draw_music();
                clear();
                Player.p_default(p1,p2);
            }
            else {
                Player.t_switch(p1,p2);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reset(map,p1,p2,p1s,p2s);
        b1.setOnMouseClicked(event ->reset(map,p1,p2,p1s,p2s));

        l1.setOnMouseEntered(event->pre_turn_in(l1,p1,p2,map,0));
        l1.setOnMouseExited(event->pre_turn_out(l1,map,0));

        l2.setOnMouseEntered(event->pre_turn_in(l2,p1,p2,map,1));
        l2.setOnMouseExited(event->pre_turn_out(l2,map,1));

        l3.setOnMouseEntered(event->pre_turn_in(l3,p1,p2,map,2));
        l3.setOnMouseExited(event->pre_turn_out(l3,map,2));

        l4.setOnMouseEntered(event->pre_turn_in(l4,p1,p2,map,3));
        l4.setOnMouseExited(event->pre_turn_out(l4,map,3));

        l5.setOnMouseEntered(event->pre_turn_in(l5,p1,p2,map,4));
        l5.setOnMouseExited(event->pre_turn_out(l5,map,4));

        l6.setOnMouseEntered(event->pre_turn_in(l6,p1,p2,map,5));
        l6.setOnMouseExited(event->pre_turn_out(l6,map,5));

        l7.setOnMouseEntered(event->pre_turn_in(l7,p1,p2,map,6));
        l7.setOnMouseExited(event->pre_turn_out(l7,map,6));

        l8.setOnMouseEntered(event->pre_turn_in(l8,p1,p2,map,7));
        l8.setOnMouseExited(event->pre_turn_out(l8,map,7));

        l9.setOnMouseEntered(event->pre_turn_in(l9,p1,p2,map,8));
        l9.setOnMouseExited(event->pre_turn_out(l9,map,8));

        l1.setOnMouseClicked(event -> logic(p1,p2,map,0,l1,p1s,p2s,musicPlayer));
        l2.setOnMouseClicked(event -> logic(p1,p2,map,1,l2,p1s,p2s,musicPlayer));
        l3.setOnMouseClicked(event -> logic(p1,p2,map,2,l3,p1s,p2s,musicPlayer));
        l4.setOnMouseClicked(event -> logic(p1,p2,map,3,l4,p1s,p2s,musicPlayer));
        l5.setOnMouseClicked(event -> logic(p1,p2,map,4,l5,p1s,p2s,musicPlayer));
        l6.setOnMouseClicked(event -> logic(p1,p2,map,5,l6,p1s,p2s,musicPlayer));
        l7.setOnMouseClicked(event -> logic(p1,p2,map,6,l7,p1s,p2s,musicPlayer));
        l8.setOnMouseClicked(event -> logic(p1,p2,map,7,l8,p1s,p2s,musicPlayer));
        l9.setOnMouseClicked(event -> logic(p1,p2,map,8,l9,p1s,p2s,musicPlayer));
    }
}

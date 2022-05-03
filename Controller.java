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

    Elements[] map = new Elements[9];
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

    void reset(Elements[] map, Player p1, Player p2, Label p1s, Label p2s){
        Elements.fill_map(map);
        clear();
        Player.p_default(p1,p2);
        Player.reset(p1,p2);
        p1s.setText(String.valueOf(p1.score));
        p2s.setText(String.valueOf(p2.score));
    }

    void set_x(Label label, javafx.scene.paint.Color color){
        label.setTextFill(color);
        label.setText("X");
    }

    void set_o(Label label,javafx.scene.paint.Color color){
        label.setTextFill(color);
        label.setText("O");
    }

    void pre_turn_in(Label l,Player p1, Player p2, Elements [] map, int i){
        if(p1.turn && map[i].get_value()<1) {
            set_x(l,javafx.scene.paint.Color.web("#97a5b2"));
        }else if (p2.turn && map[i].get_value()<1) {
            set_o(l,javafx.scene.paint.Color.web("#97a5b2"));
        }
    }

    void pre_turn_out(Label l, Elements[] map, int i){
        if(map[i].get_value()<1) {
            l.setText("");
        }
    }
    
    void logic(Player p1,Player p2, Elements[] map, int i,Label l, Label p1s, Label p2s, MusicPlayer musicPlayer){
        if(p1.turn && map[i].get_value()<1) {
            Elements.set_x(map,i);
            set_x(l,javafx.scene.paint.Color.DODGERBLUE);
            musicPlayer.turn_music();
            if(Elements.check_win(map)) {
                Player.add_score(p1);
                p1s.setText(String.valueOf(p1.score));
                Elements.fill_map(map);
                musicPlayer.win_music();
                clear();
                Player.p_default(p1,p2);
            }else if (Elements.check_full(map)) {
                Elements.fill_map(map);
                musicPlayer.draw_music();
                clear();
                Player.p_default(p1,p2
                );
            }else{
                Player.t_switch(p1,p2);
            }
        }else if (p2.turn && map[i].get_value()<1) {
            Elements.set_o(map,i);
            set_o(l,javafx.scene.paint.Color.web("#ff215c"));
            musicPlayer.turn_music();
            if(Elements.check_win(map)){
                Player.add_score(p2);
                p2s.setText(String.valueOf(p2.score));
                Elements.fill_map(map);
                musicPlayer.win_music();
                clear();
                Player.p_default(p1,p2
                );

            }else if (Elements.check_full(map)) {
                Elements.fill_map(map);
                musicPlayer.draw_music();
                clear();
                Player.p_default(p1,p2
                );
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

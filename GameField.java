package sample;

import javafx.scene.control.Label;

public class GameField {
    private final Elements map = new Elements(0);
    private final MusicPlayer musicPlayer = new MusicPlayer();
    private final Player p1=new Player(0,true);
    private final Player p2=new Player(0,false);



    void clear(Label l1,Label l2,Label l3,Label l4,Label l5,Label l6,Label l7,Label l8,Label l9){
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


    void reset(Label p1s, Label p2s,
               Label l1,Label l2,Label l3,Label l4,Label l5,Label l6,Label l7,Label l8,Label l9){
        map.fillMap();
        clear(l1,l2,l3,l4,l5,l6,l7,l8,l9);
        pDefault();
        p1.reset();
        p2.reset();
        p1s.setText(String.valueOf(p1.getScore()));
        p2s.setText(String.valueOf(p2.getScore()));
    }
    void pDefault(){
        if(!p1.getTurn()) {
            p1.pTurnSwitch();
            p2.pTurnSwitch();
        }
    }
    void turnSwitch(){
        p1.pTurnSwitch();
        p2.pTurnSwitch();
    }
    void setX(Label label, javafx.scene.paint.Color color){
        label.setTextFill(color);
        label.setText("X");
    }

    void setO(Label label,javafx.scene.paint.Color color){
        label.setTextFill(color);
        label.setText("O");
    }

    void preTurnIn(Label l,int i){
        if(p1.getTurn() && map.getValue(i)<1) {
            setX(l,javafx.scene.paint.Color.web("#97a5b2"));
        }else if (p2.getTurn() && map.getValue(i)<1) {
            setO(l,javafx.scene.paint.Color.web("#97a5b2"));
        }
    }

    void preTurnOut(Label l, int i){
        if(map.getValue(i)<1) {
            l.setText("");
        }
    }
    void logic(int i,Label l, Label p1s, Label p2s,
               Label l1,Label l2,Label l3,Label l4,Label l5,Label l6,Label l7,Label l8,Label l9){
        if(p1.getTurn() && map.getValue(i)<1) {
            map.setX(i);
            setX(l,javafx.scene.paint.Color.DODGERBLUE);
            musicPlayer.turnMusic();
            if(map.checkWin()) {
                p1.add_score();
                p1s.setText(String.valueOf(p1.getScore()));
                map.fillMap();
                musicPlayer.winMusic();
                clear(l1,l2,l3,l4,l5,l6,l7,l8,l9);
                pDefault();
            }else if (map.checkFull()) {
                map.fillMap();
                musicPlayer.drawMusic();
                clear(l1,l2,l3,l4,l5,l6,l7,l8,l9);
                pDefault();
            }else{
                turnSwitch();
            }
        }else if (p2.getTurn() && map.getValue(i)<1) {
            map.setO(i);
            setO(l,javafx.scene.paint.Color.web("#ff215c"));
            musicPlayer.turnMusic();
            if(map.checkWin()){
                p2.add_score();
                p2s.setText(String.valueOf(p2.getScore()));
                map.fillMap();
                musicPlayer.winMusic();
                clear(l1,l2,l3,l4,l5,l6,l7,l8,l9);
                pDefault();

            }else if (map.checkFull()) {
                map.fillMap();
                musicPlayer.drawMusic();
                clear(l1,l2,l3,l4,l5,l6,l7,l8,l9);
                pDefault();
            }
            else {
                turnSwitch();
            }
        }
    }
}

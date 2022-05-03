package sample;

public class Player {
    int score;
    boolean turn;

    Player (int score, boolean turn){
        this.score = score;
        this.turn = turn;
    }
    static void reset(Player p1, Player p2){
        p1.score = 0;
        p2.score = 0;
    }
    static void add_score(Player player){
        player.score++;
    }
    static void p_default(Player p1, Player p2){
        p1.turn = true;
        p2.turn = false;
    }

    static void t_switch(Player player1, Player player2){
        if(player1.turn){
            player1.turn = false;
            player2.turn = true;
        } else if (player2.turn){
            player1.turn = true;
            player2.turn = false;
        }
    }

}

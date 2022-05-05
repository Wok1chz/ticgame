package sample;

public class Player {
    private int score;
    private boolean turn;


    Player (int score, boolean turn){
        this.score = score;
        this.turn = turn;
    }

     public void reset(){
        score = 0;
    }

    public static int getScore(Player player){
        return player.score;
    }

    public boolean getTurn(){
        return turn;
    }

    public void add_score(){
        score++;
    }

    static void p_default(Player p1, Player p2){
        p1.turn = true;
        p2.turn = false;
    }

    public static void t_switch(Player player1, Player player2){
        if(player1.turn){
            player1.turn = false;
            player2.turn = true;
        } else if (player2.turn){
            player1.turn = true;
            player2.turn = false;
        }
    }

}

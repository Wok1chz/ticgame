package sample;

public class Player {
    private int score;
    private boolean turn;

    public Player(int score, boolean turn) {
        this.score = score;
        this.turn = turn;
    }

     public void reset() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public boolean getTurn() {
        return turn;
    }

    public void add_score() {
        score++;
    }

    public void pTurnSwitch() {
        turn=!turn;
    }

}

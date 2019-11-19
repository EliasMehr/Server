package object;

import java.io.Serializable;

public class ScoreReport implements Serializable {
    static final long serialVersionUID = 42L;


    private String player;
    private int score;
    private int roundNumber;

    public ScoreReport(){}

    public ScoreReport(String player, int score, int roundNumber) {
        this.player = player;
        this.score = score;
        this.roundNumber = roundNumber;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    @Override
    public String toString() {
        return this.player + " Runda: " + this.roundNumber + " Poäng: " + this.score;
    }
}

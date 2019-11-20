package object;

import java.io.Serializable;

public class ScoreReport implements Serializable {
    static final long serialVersionUID = 42L;


    private String player;
    private int score;
    private int roundNumber;

    public ScoreReport() {}

    public ScoreReport(String player, int score, int roundNumber) {
        this.player = player;
        this.score = score;
        this.roundNumber = roundNumber;
    }

    @Override
    public String toString() {
        return this.player + " Runda: " + this.roundNumber + " Poäng: " + this.score;
    }
}

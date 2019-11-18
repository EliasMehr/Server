package object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int score;
    private Player opponent;
    private ObjectOutputStream playerOutput;
    private ObjectInputStream playerInput;

    private int[] player1TotalScore = new int[4];
    private int[] player2TotalScore = new int[4];

    public Player(String name, int score, Socket player) {
        this.score = score;
        this.name = name;

        try {
            this.playerInput = new ObjectInputStream(player.getInputStream());
            this.playerOutput = new ObjectOutputStream(player.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println(e.getMessage());
        }
    }

    public void setPlayer1TotalScore(int[] player1TotalScore) {
        this.player1TotalScore = player1TotalScore;
    }

    public void setPlayer2TotalScore(int[] player2TotalScore) {
        this.player2TotalScore = player2TotalScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void setPlayerOutput(ObjectOutputStream playerOutput) {
        this.playerOutput = playerOutput;
    }

    public void setPlayerInput(ObjectInputStream playerInput) {
        this.playerInput = playerInput;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Player getOpponent() {
        return opponent;
    }

    public int[] getPlayer1TotalScore() {
        return player1TotalScore;
    }

    public int[] getPlayer2TotalScore() {
        return player2TotalScore;
    }

    public ObjectOutputStream getPlayerOutput() {
        return playerOutput;
    }

    public ObjectInputStream getPlayerInput() {
        return playerInput;
    }
}


// TODO
// Möjligtvis lägga till en metod för att skicka en fråga, men till vem?
// Möjligtvis en metod för att skicka poäng för varje runda mellan spelare
// Möjligtvis en metod för att skicka totala poängen för hela gamet
// Möjligtvis en metod för att välja kategori innan spelet börjar
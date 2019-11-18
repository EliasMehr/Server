package game;

import db.Database;
import object.Player;

import java.net.Socket;

public class Game implements Runnable {

    private Player firstPlayer;
    private Player secondPlayer;
    private Database database;
    private int questionForEachRound;
    private int rounds;

    public Game(Socket firstPlayer, Socket secondPlayer){
        this.firstPlayer = new Player("Player 1:", 0, firstPlayer);
        this.secondPlayer = new Player("Player 2: ", 0, secondPlayer);
        this.firstPlayer.setOpponent(this.secondPlayer);
        this.secondPlayer.setOpponent(this.firstPlayer);
    }


    @Override
    public void run() {

    }
}


// poäng per runda för varje spelare
// spara poäng för varje runda därefter summera ihop alla poäng vid slutet av rundan
// Använda arrayer för att hålla reda på rond poängen.
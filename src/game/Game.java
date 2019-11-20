package game;

import db.Database;
import object.Player;
import object.Question;
import object.ScoreReport;
import services.Category;
import settings.Settings;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game implements Runnable {

    // Game properties after completed Matchmaking
    private Database database = new Database();
    private Settings settings = new Settings();

    private Player firstPlayer;
    private Player secondPlayer;

    private int roundCount = 1;
    private int questionsForEachRound;
    private int totalGameRounds;

    // Initiating Matchmaking between 2 players & reading total rounds and total set of question
    public Game(Socket firstPlayer, Socket secondPlayer) {
        this.firstPlayer = new Player("Player 1:", 0, firstPlayer);
        this.secondPlayer = new Player("Player 2: ", 0, secondPlayer);
        this.firstPlayer.setOpponent(this.secondPlayer);
        this.secondPlayer.setOpponent(this.firstPlayer);
        this.questionsForEachRound = settings.getNumberOfQuestions();
        this.totalGameRounds = settings.getNumberOfRounds();
    }


    @Override
    public void run() {
        try {
            // initiating playGame() method
            playGame();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void playGame() throws IOException, ClassNotFoundException {
        List<Player> listOfPlayers = new LinkedList<>();

        listOfPlayers.add(firstPlayer);
        listOfPlayers.add(secondPlayer);

        List<Category> categories = database.initiateCategories();

        for (int i = 0; i < totalGameRounds; i++) {
            listOfPlayers.get(1).sendMessage("Waiting for opponent to select a category");
            listOfPlayers.get(0).sendCategories(categories);
            Category selectedCategory = listOfPlayers.get(0).recieveCategoryFromUser();

            playRound(selectedCategory, listOfPlayers);
            Collections.reverse(listOfPlayers);
            roundCount++;
        }
    }

    private void playRound(Category category, List<Player> playerList) throws IOException, ClassNotFoundException {

        List<Question> qList = database.getallQuestionsFromCategory(category);
        Collections.shuffle(qList);

        playerList.get(1).sendMessage("Waiting for opponent to play the round...");

        for (int i = 0; i < questionsForEachRound; i++) {
            playerList.get(0).sendQuestion(qList.get(i));


            Object inputFromPlayer;

            inputFromPlayer = playerList.get(0).getInput();
            if (inputFromPlayer.equals(qList.get(i).getCorrectAlternative())) {
                playerList.get(0).addPointToScore();
            }
        }

        // ----> Händelsen upprepar sig för motståndaren, reversed

        playerList.get(0).sendMessage("Waiting for opponent to play the round...");

        for (int i = 0; i < questionsForEachRound; i++) {
            playerList.get(1).sendQuestion(qList.get(i));
            String inputFromPlayer = (String) playerList.get(1).getInput();

            if (inputFromPlayer.equals(qList.get(i).getCorrectAlternative())) {
                playerList.get(1).addPointToScore();
            }
        }


        Database.scoreReports.add(new ScoreReport(playerList.get(0).getName(), playerList.get(0).getScore(), roundCount));
        Database.scoreReports.add(new ScoreReport(playerList.get(1).getName(), playerList.get(1).getScore(), roundCount));

        Database.endOfGameReport();

        // Nollställer varje spelares poäng för rundan efter avslutad runda

        playerList.get(0).setScore(0);
        playerList.get(1).setScore(0);

    }
}

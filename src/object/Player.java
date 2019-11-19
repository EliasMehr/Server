package object;

import services.Category;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Player {

    private String name;
    private int score;
    private Player opponent;
    private ObjectOutputStream playerOutput;
    private ObjectInputStream playerInput;

    public Player(String name, int score, Socket socket) {
        this.score = score;
        this.name = name;

        try {
            this.playerOutput = new ObjectOutputStream(socket.getOutputStream());
            this.playerInput = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPointToScore() {
        this.score++;
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


    public void sendMessage(String message) {
        try {
            playerOutput.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendCategories(Object categories) {
        try {
            playerOutput.writeObject(categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendQuestion(Question question) {
        try {
            playerOutput.writeObject(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObjectOutputStream getPlayerOutput() {
        return playerOutput;
    }

    public ObjectInputStream getPlayerInput() {
        return playerInput;
    }

    public Object getInput() throws IOException, ClassNotFoundException {
      return playerInput.readObject();
    }

    public Category[] getTypeOfCategory() {
        opponent.sendMessage("Opponent selecting category");
        Category[] categories = Category.values();
        try {
            playerOutput.writeObject(categories);
            categories = (Category[]) playerInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categories;
    }
}


// TODO
// Möjligtvis lägga till en metod för att skicka en fråga, men till vem?
// Möjligtvis en metod för att skicka poäng för varje runda mellan spelare
// Möjligtvis en metod för att skicka totala poängen för hela gamet
// Möjligtvis en metod för att välja kategori innan spelet börjar
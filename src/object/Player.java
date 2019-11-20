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

    public void addPointToScore() {
        this.score++;
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

    public Category recieveCategoryFromUser(){
        Category selectedCategory = null;
        try {
           selectedCategory = (Category) playerInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return selectedCategory;
    }

    public void sendQuestion(Question question) {
        try {
            playerOutput.writeObject(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getInput() throws IOException, ClassNotFoundException {
      return playerInput.readObject();
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }



}
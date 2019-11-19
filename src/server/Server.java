package server;

import game.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int serverPort = 5989;

    public Server() {
        System.out.println("Game server running....");
        try (ServerSocket acceptConnectionRequest = new ServerSocket(serverPort)) {

            while (true) {
                Socket playerRequest1 = acceptConnectionRequest.accept();
                System.out.println("First player connected");
                Socket playerRequest2 = acceptConnectionRequest.accept();
                System.out.println("Second player connected");
                Thread initiateGame = new Thread(new Game(playerRequest1, playerRequest2));
                initiateGame.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

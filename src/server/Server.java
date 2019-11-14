package server;

import game.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int serverPort = 5989;

    public Server() {
        try (ServerSocket acceptConnectionRequest = new ServerSocket(serverPort)) {

            while (true) {
                Socket playerRequest1 = acceptConnectionRequest.accept();
                Socket playerRequest2 = acceptConnectionRequest.accept();

               Thread initiateGame = new Thread(new Game(playerRequest1, playerRequest2));
               initiateGame.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

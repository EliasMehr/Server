package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private int numberOfRounds;
    private int numberOfQuestions;

    public Settings(){
        Properties gameSettings = new Properties();
        try {
            gameSettings.load(new FileInputStream("src/settings/gameconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.numberOfRounds = Integer.parseInt(gameSettings.getProperty("rounds"));
        this.numberOfQuestions = Integer.parseInt(gameSettings.getProperty("questions"));
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }


}

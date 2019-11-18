package db;

import object.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
    private List<Question> listOfQuestions;

    public Database(){
        listOfQuestions = initiateQuestionList();
    }

    public List<Question> initiateQuestionList() {
        List<Question> newGameList = new ArrayList<>();
        
        newGameList.add(new Question("Historia", "Vem var Adolf Hitler?", "Diktator", "President", "Poet", "Krigsherre"));
        newGameList.add(new Question("Historia", "När föddes Astrid lindgren?", "1920", "1944", "1950", "1910"));

        return newGameList;
    }

}

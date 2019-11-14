package object;

import java.io.Serializable;

public class Question implements Serializable {
    static final long serialUID = 42L;

    private String category;
    private String question;
    private String alternative1;
    private String alternative2;
    private String alternative3;
    private String correctAlternative;

    public Question(String category, String question, String alternative1, String alternative2, String alternative3, String correctAlternative) {
        this.category = category;
        this.question = question;
        this.alternative1 = alternative1;
        this.alternative2 = alternative2;
        this.alternative3 = alternative3;
        this.correctAlternative = correctAlternative;
    }

    public String getQuestion() {
        return question;
    }

    public String getAlternative1() {
        return alternative1;
    }

    public String getAlternative2() {
        return alternative2;
    }

    public String getAlternative3() {
        return alternative3;
    }

    public String getCorrectAlternative() {
        return correctAlternative;
    }

    public String getCategory() {
        return category;
    }
}

package db;

import object.Question;
import object.ScoreReport;

import java.util.ArrayList;
import java.util.List;

public class Database {

    List<Question> qList;
    public static List<ScoreReport> scoreReports = new ArrayList<>();

    public Database(){
        qList = initiateQuestionList();
    }

    public List<Question> initiateQuestionList(){
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Historia", "När startade andra världskriget?", "1945", "1920", "1942", "1939"));
        questionList.add(new Question("Historia", "När införde Sverige högertrafik?", "1920", "1965", "1945", "1967"));
        questionList.add(new Question("Historia", "Vilket år sköts Olof Palme?", "1976", "1980", "1989", "1986"));
        questionList.add(new Question("Historia", "Sveriges första kvinnliga partiledare var?", "Maria Leissner", "Mona Sahlin", "Maud Olofsson", "Karin Söder"));
        questionList.add(new Question("Historia", "Vilket efternamn hade Greta Garbo när hon föddes?", "Svensson", "Garbi", "Olofsson", "Gustafsson"));
        questionList.add(new Question("Historia", "Vem var kung innan Karl XII?", "Gustav III", "Fredrik I", "Gustav Vasa", "Karl XI"));

        questionList.add(new Question("Mat", "Vad är entrecote för typ av kött?", "Fågel", "Fläsk", "Lamm", "Nöt"));
        questionList.add(new Question("Mat", "Huvudingrediens i tofu?", "Majs", "Mjöl", "Banan", "Soja"));
        questionList.add(new Question("Mat", "Bearnesesås tillagas alltid med?", "Timjan", "Oregano", "Persilja", "Dragon"));
        questionList.add(new Question("Mat", "Flygande jakob innehåller bland annat?", "Purjolök & ananas", "Mango & majs", "Tonfisk", "Kyckling & banan"));

        questionList.add(new Question("Musik", "Avicii var en vadå?", "Sångare", "Statist", "Maskot", "Producent"));
        questionList.add(new Question("Musik", "Hur många tangenter har ett piano?", "24", "33", "48", "88" ));
        questionList.add(new Question("Musik", "Vem kallades för king of pop?", "Whitney Houston", "Barry White", "Kendal Jenner", "Michael Jackson"));
        questionList.add(new Question("Musik", "Vilket land kommer Icona pop ifrån?", "Ryssland", "Belgien", "Norge", "Sverige"));

        questionList.add(new Question("Spel", "Vad är World of Warcarft för typ av spel?", "RPG", "FPS", "3D", "MMORPG"));
        questionList.add(new Question("Spel", "Vem är en svensk legend inom Counter-Strike 1.6?", "WazP", "Potti", "Get_RiGHT", "HeaToN"));
        questionList.add(new Question("Spel", "Världsspelet LOL står för?", "Laughing out loud", "Lean ocean Lanister", "League of lust", "League of Legends"));
        questionList.add(new Question("Spel", "Vad är fördelen med mekaniskt tangetbord?", "Skönare ljud", "RGB-Belysning", "Det är en bluff", "Snabbare respons"));

        return questionList;
    }

        // Test metod för att se att objekten av frågor existerar enligt kategorier
    public void viewQuestions(String kategori){
        qList.forEach(question -> {
            if (kategori.equalsIgnoreCase(question.getCategory()))
            System.out.println(question.getQuestion());
        });
    }

    public static void endOfGameReport(){
        scoreReports.forEach( scoreReport -> {
                System.out.println(scoreReport);
        });
    }

    public List<Question> getallQuestionsFromCategory(String category){
        List<Question> allQuestionsForCategory = new ArrayList<>();

        qList.forEach(question -> {
            if (category.equalsIgnoreCase(question.getCategory())){
                allQuestionsForCategory.add(question);
            }
        });
        return allQuestionsForCategory;
    }

    public List<ScoreReport> getScoreReports() {
        return scoreReports;
    }

    public void setScoreReports(List<ScoreReport> scoreReports) {
        this.scoreReports = scoreReports;
    }
}

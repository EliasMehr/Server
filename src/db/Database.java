package db;

import object.Question;
import object.ScoreReport;
import services.Category;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Question> qList;
    public static List<ScoreReport> scoreReports = new ArrayList<>();

    public Database() {
        qList = initiateQuestionList();
    }

    public List<Question> initiateQuestionList() {
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question(Category.HISTORIA, "När startade andra världskriget?", "1945", "1920", "1942", "1939"));
        questionList.add(new Question(Category.HISTORIA, "När införde Sverige högertrafik?", "1920", "1965", "1945", "1967"));
        questionList.add(new Question(Category.HISTORIA, "Vilket år sköts Olof Palme?", "1976", "1980", "1989", "1986"));
        questionList.add(new Question(Category.HISTORIA, "Sveriges första kvinnliga partiledare var?", "Maria Leissner", "Mona Sahlin", "Maud Olofsson", "Karin Söder"));
        questionList.add(new Question(Category.HISTORIA, "Vilket efternamn hade Greta Garbo när hon föddes?", "Svensson", "Garbi", "Olofsson", "Gustafsson"));
        questionList.add(new Question(Category.HISTORIA, "Vem var kung innan Karl XII?", "Gustav III", "Fredrik I", "Gustav Vasa", "Karl XI"));

        questionList.add(new Question(Category.MAT, "Vad är entrecote för typ av kött?", "Fågel", "Fläsk", "Lamm", "Nöt"));
        questionList.add(new Question(Category.MAT, "Huvudingrediens i tofu?", "Majs", "Mjöl", "Banan", "Soja"));
        questionList.add(new Question(Category.MAT, "Bearnesesås tillagas alltid med?", "Timjan", "Oregano", "Persilja", "Dragon"));
        questionList.add(new Question(Category.MAT, "Flygande jakob innehåller bland annat?", "Purjolök & ananas", "Mango & majs", "Tonfisk", "Kyckling & banan"));

        questionList.add(new Question(Category.MUSIK, "Avicii var en vadå?", "Sångare", "Statist", "Maskot", "Producent"));
        questionList.add(new Question(Category.MUSIK, "Hur många tangenter har ett piano?", "24", "33", "48", "88"));
        questionList.add(new Question(Category.MUSIK, "Vem kallades för king of pop?", "Whitney Houston", "Barry White", "Kendal Jenner", "Michael Jackson"));
        questionList.add(new Question(Category.MUSIK, "Vilket land kommer Icona pop ifrån?", "Ryssland", "Belgien", "Norge", "Sverige"));

        questionList.add(new Question(Category.SPEL, "Vad är World of Warcarft för typ av spel?", "RPG", "FPS", "3D", "MMORPG"));
        questionList.add(new Question(Category.SPEL, "Vem är en svensk legend inom Counter-Strike 1.6?", "WazP", "Potti", "Get_RiGHT", "HeaToN"));
        questionList.add(new Question(Category.SPEL, "Världsspelet LOL står för?", "Laughing out loud", "Lean ocean Lanister", "League of lust", "League of Legends"));
        questionList.add(new Question(Category.SPEL, "Vad är fördelen med mekaniskt tangetbord?", "Skönare ljud", "RGB-Belysning", "Det är en bluff", "Snabbare respons"));

        return questionList;
    }

    // Test metod för att se att objekten av frågor existerar enligt kategorier

    public void viewQuestions(Category category) {
        qList.forEach(question -> {
            if (category.equals(question.getCategory()))
                System.out.println(question.getQuestion());
        });
    }

    public static void endOfGameReport() {
        scoreReports.forEach(scoreReport -> {
            System.out.println(scoreReport);
        });
    }

    public List<Question> getallQuestionsFromCategory(Category category) {
        List<Question> allQuestionsForCategory = new ArrayList<>();

        qList.forEach(question -> {
            if (category.equals(question.getCategory())) {
                allQuestionsForCategory.add(question);
            }
        });
        return allQuestionsForCategory;
    }

    public List<Category> initiateCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(Category.HISTORIA);
        categories.add(Category.MAT);
        categories.add(Category.MUSIK);
        categories.add(Category.POLITIK);
        categories.add(Category.SPEL);
        categories.add(Category.VETENSKAP);

        return categories;
    }

}

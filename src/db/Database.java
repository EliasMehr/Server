package db;

import object.Question;
import services.Category;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {

    private List<Question> questionList;

    Database() {
        questionList = initiateLilst();
    }

    public List<Question> initiateLilst() {

        List<Question> makeList = new ArrayList<>();
        makeList.add(new Question("Historia", "Vilket år startade andra världskriget?", "1920", "1940", "1944", "1939"));
        makeList.add(new Question("Historia", "När fick svenska kvinnor rösta för första gången?", "1918", "1917", "1817", "1718"));
        makeList.add(new Question("Historia", "När gick vi över till högertrafik i Sverige?", "1901", "1957", "1980", "1967"));
        makeList.add(new Question("Historia", "Vem är Christer Fuglesang?", "Musiker", "Skådespelare", "Fiskare", "Astronaut"));
        makeList.add(new Question("Historia", "USA:s senaste president va?", "George W Bush", "Trump", "Abraham Lincoln", "Barack Obama"));

        makeList.add(new Question("Musik", "Skaparen av hitlåten Levels ?", "Icona pop", "Kygo", "Matuma", "Avicii"));







        return makeList;
    }

    public List<Question> getListByCategory(String cat){
        return questionList.stream().filter(q -> q.getCategory()
                .equals(Category.valueOf(cat))).collect(Collectors.toList());
    }


}

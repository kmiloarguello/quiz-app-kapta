package biz.kapta.quizappkapta;

/**
 * Created by Camilo Arguello R on 2017-11-17.
 */

public class Questions {

    public String mQuestions[] = {
            "Cuanto es 2 + 1?",
            "Cuanto es 2 + 2?",
            "Cuanto es 2 + 3?"
    };

    private String mChoices[][] = {
            {"1","2","4","3"},
            {"2","3","4","5"},
            {"4","5","6","7"}
    };

    private String mCorrectAnswers[] = {
            "3","4","5"
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice(int a){
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }


}

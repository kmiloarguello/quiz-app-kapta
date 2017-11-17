package biz.kapta.quizappkapta;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.preference.DialogPreference;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RadioGroup answers;
    RadioButton answer1,answer2, answer3, answer4,answer;
    Button sendAnswers;

    TextView score, question;

    private Questions mQuestions = new Questions();

    private  String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        answers = (RadioGroup) findViewById(R.id.answers);
        answer1 = (RadioButton) findViewById(R.id.answer1);
        answer2 = (RadioButton) findViewById(R.id.answer2);
        answer3 = (RadioButton) findViewById(R.id.answer3);
        answer4 = (RadioButton) findViewById(R.id.answer4);
        sendAnswers = (Button) findViewById(R.id.sendAnswers);

        score.setText("Puntaje : "+ mScore);
        updateQuestion(r.nextInt(mQuestionsLength));

        // ----------------------------------------------------------------------------
        // BUTTON
        sendAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer1.isChecked() || answer2.isChecked() || answer3.isChecked() || answer4.isChecked()){
                    int selected = answers.getCheckedRadioButtonId();
                    answer = (RadioButton) findViewById(selected);

                    if(answer.getText() == mAnswer) {
                        Toast.makeText(MainActivity.this, "Correcto!!. La Rta " + answer.getText() + " es correcta." , Toast.LENGTH_SHORT).show();
                        mScore++;
                        score.setText("Score: "+ mScore);
                        updateQuestion(r.nextInt(mQuestionsLength));
                    }else{
                        //Toast.makeText(MainActivity.this, "Incorrecto!!." , Toast.LENGTH_SHORT).show();
                        gameOver();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "No has seleccionado una respuesta. " , Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void updateQuestion(int num){

        Toast.makeText(this, "Siguiente Pregunta ", Toast.LENGTH_SHORT).show();

        question.setText(mQuestions.getQuestion(num));

        answer1.setText(mQuestions.getChoice(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        answer1.setChecked(false);
        answer2.setChecked(false);
        answer3.setChecked(false);
        answer4.setChecked(false);

        mAnswer = mQuestions.getCorrectAnswer(num);
    }
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Incorrecto!! ¿Quieres volver a intentarlo?")
                .setCancelable(false)
                .setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        }
                )
                .setNegativeButton("No, Salir",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}

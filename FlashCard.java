package com.example.pocketwit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class FlashCard extends AppCompatActivity {

    private TextView optionA, optionB, optionC, optionD;
    private TextView questionNum, question, score;
    private TextView selectAns, correctAns;
    int currentIndex;
    int Tscore = 0;
    int qn = 1;
    ProgressBar progressBar;

    int CurrentQuestion, CurrentOptionA, CurrentOptionB, CurrentOptionC, CurrentOptionD;


    private Answer[] QuizBank = new Answer[]{
            new Answer(R.string.Question_1, R.string.Option_1A, R.string.Option_1B, R.string.Option_1C, R.string.Option_1D, R.string.Answer_1),

            new Answer(R.string.Question_2, R.string.Option_2A, R.string.Option_2B, R.string.Option_2C, R.string.Option_2D, R.string.Answer_2),
            new Answer(R.string.Question_3, R.string.Option_3A, R.string.Option_3B, R.string.Option_3C, R.string.Option_3D, R.string.Answer_3),
            new Answer(R.string.Question_4, R.string.Option_4A, R.string.Option_4B, R.string.Option_4C, R.string.Option_4D, R.string.Answer_4),
            new Answer(R.string.Question_5, R.string.Option_5A, R.string.Option_5B, R.string.Option_5C, R.string.Option_5D, R.string.Answer_5),
            new Answer(R.string.Question_6, R.string.Option_6A, R.string.Option_6B, R.string.Option_6C, R.string.Option_6D, R.string.Answer_6),
            new Answer(R.string.Question_7, R.string.Option_7A, R.string.Option_7B, R.string.Option_7C, R.string.Option_7D, R.string.Answer_7),
            new Answer(R.string.Question_8, R.string.Option_8A, R.string.Option_8B, R.string.Option_8C, R.string.Option_8D, R.string.Answer_8),
            new Answer(R.string.Question_9, R.string.Option_9A, R.string.Option_9B, R.string.Option_9C, R.string.Option_9D, R.string.Answer_9),
            new Answer(R.string.Question_10, R.string.Option_10A, R.string.Option_10B, R.string.Option_10C, R.string.Option_10D, R.string.Answer_10),
            new Answer(R.string.Question_11, R.string.Option_11A, R.string.Option_11B, R.string.Option_11C, R.string.Option_11D, R.string.Answer_11),
            new Answer(R.string.Question_12, R.string.Option_12A, R.string.Option_12B, R.string.Option_12C, R.string.Option_12D, R.string.Answer_12),
            new Answer(R.string.Question_13, R.string.Option_13A, R.string.Option_13B, R.string.Option_13C, R.string.Option_13D, R.string.Answer_13),
            new Answer(R.string.Question_14, R.string.Option_14A, R.string.Option_14B, R.string.Option_14C, R.string.Option_14D, R.string.Answer_14),
            new Answer(R.string.Question_15, R.string.Option_15A, R.string.Option_15B, R.string.Option_15C, R.string.Option_15D, R.string.Answer_15)


    };


    final int PROGRESS_BAR = (int) Math.ceil(100 / QuizBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        optionA = findViewById(R.id.OptionA);
        optionB = findViewById(R.id.OptionB);
        optionC = findViewById(R.id.OptionC);
        optionD = findViewById(R.id.OptionD);

        question = findViewById(R.id.Question);
        score = findViewById(R.id.Score);
        questionNum = findViewById(R.id.QuestionNumber);

        selectAns = findViewById(R.id.ChoosenAnswer);
        correctAns = findViewById(R.id.CorrectAnswer);
        progressBar = findViewById(R.id.ProgressBar);


        CurrentQuestion = QuizBank[currentIndex].getQuestion();
        question.setText(CurrentQuestion);

        CurrentOptionA = QuizBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);

        CurrentOptionB = QuizBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);

        CurrentOptionC = QuizBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);

        CurrentOptionD = QuizBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);


        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(CurrentOptionA);
                UpdateQuestion();

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(CurrentOptionB);
                UpdateQuestion();

            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(CurrentOptionC);
                UpdateQuestion();

            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(CurrentOptionD);
                UpdateQuestion();

            }
        });


    }

    private void CheckAnswer(int UserSelection) {
        int CorrectAnswer = QuizBank[currentIndex].getAnswer();

        selectAns.setText(UserSelection);
        correctAns.setText(CorrectAnswer);

        String m = selectAns.getText().toString().trim();
        String n = correctAns.getText().toString().trim();

        if (m.equals(n)) {
            Toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT).show();
            Tscore = Tscore + 1;
        } else {
            Toast.makeText(getApplicationContext(), "WRONG", Toast.LENGTH_SHORT).show();
        }

    }


    @SuppressLint("SetTextI18n")
    private void UpdateQuestion() {

        qn = qn + 1;

        if (qn <= QuizBank.length) {
            questionNum.setText("Question" + qn + "/" + QuizBank.length);
        }

        currentIndex = (currentIndex + 1) % QuizBank.length;

        CurrentQuestion = QuizBank[currentIndex].getQuestion();
        question.setText(CurrentQuestion);

        CurrentOptionA = QuizBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);

        CurrentOptionB = QuizBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);

        CurrentOptionC = QuizBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);

        CurrentOptionD = QuizBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);


        score.setText("Score" + Tscore + "/" + QuizBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);

        if(currentIndex == 0)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("End of Quiz");
            alert.setCancelable(false);
            if(Tscore == QuizBank.length)
            {
                alert.setMessage("Excellent!\n" + "You Scored " + Tscore + "/"+ QuizBank.length);
            }

            else if(Tscore > ((QuizBank.length)/2) && Tscore < QuizBank.length)
            {
                alert.setMessage("Great!\n" + "You Scored " + Tscore + "/"+ QuizBank.length);
            }

            else
            {
                alert.setMessage("Work Harder!\n" + "You Scored " + Tscore + "/"+ QuizBank.length);
            }




            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("Retake Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Tscore = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("Score" + Tscore + "/" + QuizBank.length);
                    questionNum.setText("Question" + qn + "/" + QuizBank.length);
                }
            });
            alert.show();
        }




    }
}
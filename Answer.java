package com.example.pocketwit;

public class Answer {
    private int OptionA, OptionB, OptionC, OptionD, Question, Answer;

    public Answer(int question, int a, int b, int c, int d, int answ)
    {
        Question = question;
        OptionA = a;
        OptionB = b;
        OptionC = c;
        OptionD = d;
        Answer = answ;

    }

    public int getOptionA() {
        return OptionA;
    }

    public int getOptionB() {
        return OptionB;
    }

    public int getOptionC() {
        return OptionC;
    }

    public int getOptionD() {
        return OptionD;
    }

    public int getQuestion() {
        return Question;
    }

    public int getAnswer() {
        return Answer;
    }
}


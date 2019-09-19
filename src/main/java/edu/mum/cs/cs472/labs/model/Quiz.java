package edu.mum.cs.cs472.labs.model;

import java.util.Arrays;

public class Quiz {
    private  String[] questions = {"3,1,4,15","1,1,2,3,5","1,4,9,16,25","2,3,5,7,11","1,2,4,8,16"};
    private  int[] answers = {9,8,36,13,32};
    private  int[] solutions = new int[5];
    private  int questionNo = 1;

    public void setAnswer(int answeredQuestion , int solution){
        if(answeredQuestion <= maxQuestionNos()) {
            if (solutions[answeredQuestion-1] == 0) {
                questionNo++;
            }
            solutions[answeredQuestion - 1] = solution;

        }

    }
    public int getScore(){
        int score = 0;
        for(int i = 0; i<answers.length;i++){
            if(answers[i] ==solutions[i] ){
                score++;
            }
        }
        return score;
    }

    public int currentQuestion(){
        return questionNo;
    }
    public int nextQuestion(){
        int newquestion = questionNo+1;
        return newquestion;
    }
    public String getQuestion(int questionNo){
        return questions[questionNo-1];
    }
    public int maxQuestionNos(){
        return questions.length;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "questions=" + Arrays.toString(questions) +
                ", answers=" + Arrays.toString(answers) +
                ", solutions=" + Arrays.toString(solutions) +
                ", questionNo=" + questionNo +
                '}';
    }
}

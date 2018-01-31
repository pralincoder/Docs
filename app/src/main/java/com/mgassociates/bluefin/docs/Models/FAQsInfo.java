package com.mgassociates.bluefin.docs.Models;

import java.util.ArrayList;

/**
 * Created by Rasil10 on 2017-12-13.
 */

public class FAQsInfo {
    int id;
    ArrayList<String> questions;
    ArrayList<String> answers;

    public FAQsInfo() {
    }

    public FAQsInfo(int id, ArrayList<String> questions, ArrayList<String> answers) {
        this.id = id;
        this.questions = questions;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}

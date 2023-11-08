package ru.musailov.symbols.models;

import java.nio.file.LinkOption;
import java.util.Map;
import java.util.SortedMap;

public class Answer {

    private String answer;

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

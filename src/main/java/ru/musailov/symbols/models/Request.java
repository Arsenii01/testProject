package ru.musailov.symbols.models;

public class Request {
    private String string;

    public Request(String string) {
        this.string = string;
    }

    public Request() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

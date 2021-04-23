package com.cestadefrutas.mega.model;

public class Answer {

    private String key;
    private int value;
    private int secondValue;

    public Answer() {
    }

    public Answer(String key, int value, int secondValue) {
        this.key = key;
        this.value = value;
        this.secondValue = secondValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }
}

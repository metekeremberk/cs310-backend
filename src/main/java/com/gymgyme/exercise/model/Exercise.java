package com.gymgyme.exercise.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="all-exercises")
public class Exercise {
    private String title;
    private String[] primary;
    private String[] secondary;
    private String[] howTo;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String[] getPrimary() {
        return primary;
    }
    public void setPrimary(String[] primary) {
        this.primary = primary;
    }
    public String[] getSecondary() {
        return secondary;
    }
    public void setSecondary(String[] secondary) {
        this.secondary = secondary;
    }
    public String[] getHowTo() {
        return howTo;
    }
    public void setHowTo(String[] howTo) {
        this.howTo = howTo;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "Title: '" + title + "',\n" +
                "Primary: '" + Arrays.toString(primary) + "',\n" +
                "Secondary: '" + Arrays.toString(secondary) + "',\n" +
                "How To: '" + Arrays.toString(howTo) + "'\n}";
    }
}
package mx.edu.utez.dogclassifier.modules.dog;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Dog {
    private String breed;
    private double height;
    private double weight;
    private double coatLength;
    private int color;
    private int activityLevel;
    private int friendliness;
    private int intelligence;


    public Dog() {
    }

    public Dog(double height, double weight, double coatLength, int color, int activityLevel, int friendliness, int intelligence, String breed) {
        this.height = height;
        this.weight = weight;
        this.coatLength = coatLength;
        this.color = color;
        this.activityLevel = activityLevel;
        this.friendliness = friendliness;
        this.intelligence = intelligence;
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCoatLength() {
        return coatLength;
    }

    public void setCoatLength(double coatLength) {
        this.coatLength = coatLength;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(int friendliness) {
        this.friendliness = friendliness;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @JsonIgnore
    public double[] getFeatures() {
        return new double[]{height, weight, coatLength, color, activityLevel, friendliness, intelligence};
    }



}



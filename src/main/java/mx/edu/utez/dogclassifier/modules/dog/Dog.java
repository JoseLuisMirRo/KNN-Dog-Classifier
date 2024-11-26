package mx.edu.utez.dogclassifier.modules.dogBreed;

public class Dog {
    private double height;
    private double weight;
    private double coatLength;
    private int color;
    private int activityLevel;
    private int friendliness;
    private int intelligence;
    private String breed;

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

    public double[] getFeatures() {
        return new double[]{height, weight, coatLength, color, activityLevel, friendliness, intelligence};
    }

    public String getBreed() {
        return breed;
    }
}



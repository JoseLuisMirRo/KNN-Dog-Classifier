package mx.edu.utez.dogclassifier.modules.dog.DTO;

public class DogDTO {
    private double height;
    private double weight;
    private double coatLength;
    private int color;
    private int activityLevel;
    private int friendliness;
    private int intelligence;

    public DogDTO() {
    }

    public DogDTO(double height, double weight, double coatLength, int color, int activityLevel, int friendliness, int intelligence) {
        this.height = height;
        this.weight = weight;
        this.coatLength = coatLength;
        this.color = color;
        this.activityLevel = activityLevel;
        this.friendliness = friendliness;
        this.intelligence = intelligence;
    }

    public double[] getFeatures() {
        return new double[]{height, weight, coatLength, color, activityLevel, friendliness, intelligence};
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
}

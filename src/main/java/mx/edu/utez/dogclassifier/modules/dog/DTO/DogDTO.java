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
}

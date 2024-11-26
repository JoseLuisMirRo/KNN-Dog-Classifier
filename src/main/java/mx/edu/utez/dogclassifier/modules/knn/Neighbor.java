package mx.edu.utez.dogclassifier.modules.knn;

public class Neighbor {
    private final double distance;
    private final String breed;

    public Neighbor(double distance, String breed) {
        this.distance = distance;
        this.breed = breed;
    }

    public double getDistance() {
        return distance;
    }

    public String getBreed() {
        return breed;
    }
}

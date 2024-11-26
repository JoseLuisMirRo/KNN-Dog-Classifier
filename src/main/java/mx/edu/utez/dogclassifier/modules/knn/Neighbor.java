package mx.edu.utez.dogclassifier.modules.knn;

import mx.edu.utez.dogclassifier.modules.dog.Dog;

public class Neighbor {
    private final double distance;
    private final Dog dog;

    public Neighbor(double distance, Dog dog) {
        this.distance = distance;
        this.dog = dog;
    }

    public double getDistance() {
        return distance;
    }

    public Dog getDog() {
        return dog;
    }

    @Override
    public String toString() {
        return "Neighbor{distance=" + distance + ", breed='" + dog + "'}";
    }
}

package mx.edu.utez.dogclassifier.modules.knn;

import mx.edu.utez.dogclassifier.modules.dog.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KNNService {

    /**
     * Predice la categoría más cercana utilizando el algoritmo KNN.
     *
     * @param dataset Conjunto de datos (lista de perros).
     * @param newFeatures Características del nuevo perro.
     * @param k Número de vecinos a considerar.
     * @return La raza predicha
     */

    public String predict(List<Dog> dataset, double[] newFeatures, int k) {
        //Lista para almacenar las distncias y sus respectivas razas
        List<Neighbor> neighbors = new ArrayList<>();

        //Calcular la distancia euclidiana entre el nuevo perro y los perros del dataset
        for (Dog dog : dataset ) {
            double distance = calculateDistance(dog, newFeatures);
            neighbors.add(new Neighbor(distance, dog.getBreed()));
        }

        Sorter.bubbleSort(neighbors); //Ordenar la lista de vecinos por distancia

        //Seleccionar las k razas más cercanas
        List<String> topKBreeds = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topKBreeds.add(neighbors.get(i).getBreed());
        }

        //Contar cual es la raza mas frecuente en los k vecinos
        return findMostFrequentBreed(topKBreeds);
    }

    private double calculateDistance(Dog dog, double[] features) {
        double[] dogFeatures = dog.getFeatures();
        double sum = 0;
        for (int i = 0; i < features.length; i++) {
            sum += Math.pow(dogFeatures[i] - features[i], 2);
        }
        return Math.sqrt(sum);
    }

    private String findMostFrequentBreed(List<String> breeds) {
        int maxCount = 0;
        String mostFrequentBreed = null;

        for (String breed : breeds) {
            int count = 0;
            for (String b : breeds) {
                if (b.equals(breed)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequentBreed = breed;
            }
        }
        return mostFrequentBreed;
    }
}

package mx.edu.utez.dogclassifier.modules.knn;

import java.util.List;

public class Sorter {
    /**
     * Ordena una lista de vecinos usando Bubble Sort
     * @param neighbors Lista de vecinos
     */

    public static void bubbleSort(ArrayList<Neighbor> neighbors) {
        int n = neighbors.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (neighbors.get(j).getDistance() > neighbors.get(j + 1).getDistance()) {
                    Neighbor temp = neighbors.get(j);
                    neighbors.set(j, neighbors.get(j + 1));
                    neighbors.set(j + 1, temp);
                }
            }
        }
    }
}

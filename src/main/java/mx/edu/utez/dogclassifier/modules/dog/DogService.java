package mx.edu.utez.dogclassifier.modules.dog;

import mx.edu.utez.dogclassifier.modules.dataset.DatasetService;
import mx.edu.utez.dogclassifier.modules.knn.KNNService;
import mx.edu.utez.dogclassifier.modules.utils.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    private DatasetService datasetService;

    @Autowired
    private KNNService knnService;
    /**
     * Clasifica la raza de un perro usando el algoritmo KNN
     * @param features Características del perro
     * @param k Número de vecinos más cercanos a considerar
     * @return La raza predicha
     */
    public Dog classifyDog(double[] features, int k) {
        List<Dog> dataset = datasetService.getDataset();

        if(dataset.isEmpty()){
            throw new IllegalStateException("El dataset está vacío");
        }
        return knnService.predict(dataset, features, k);
    }
}


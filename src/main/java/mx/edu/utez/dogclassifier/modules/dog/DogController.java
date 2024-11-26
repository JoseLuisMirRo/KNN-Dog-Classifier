package mx.edu.utez.dogclassifier.modules.dog;

import mx.edu.utez.dogclassifier.modules.dog.DTO.DogDTO;
import mx.edu.utez.dogclassifier.modules.utils.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dogs")
public class DogController {
    @Autowired
    private DogService dogService;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    @PostMapping("/classify")
    public ResponseEntity<?> classifyDog(@RequestBody DogDTO dog){
        try{
            double[] features = dog.getFeatures();
            String predictedBreed = dogService.classifyDog(features, 10); //K vecinos más cercanos = 3
            return customResponseEntity.getOkResponse("Raza clasificada correctamente", predictedBreed);
        } catch (Exception e){
            return customResponseEntity.get400Response();
        }
    }

}

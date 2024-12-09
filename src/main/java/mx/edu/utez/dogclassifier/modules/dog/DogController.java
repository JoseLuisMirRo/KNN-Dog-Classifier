package mx.edu.utez.dogclassifier.modules.dog;

import mx.edu.utez.dogclassifier.modules.dog.DTO.DogDTO;
import mx.edu.utez.dogclassifier.modules.utils.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Locale;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    @PostMapping("/classify")
    public ResponseEntity<?> classifyDog(@RequestBody DogDTO dog) {
        try {
            double[] features = dog.getFeatures();
            System.out.println("ATRIBUTOS: " + Arrays.toString(features));
            Dog predictedBreed = dogService.classifyDog(features, 6); // K vecinos más cercanos = 6

            // Capitalizar el nombre de la raza
            String formattedBreed = capitalizeBreedName(predictedBreed.getBreed());
            predictedBreed.setBreed(formattedBreed);

            // Consultar la API de Dog CEO para obtener la imagen
            String breedPath = formatBreedForApi(predictedBreed.getBreed());
            String imageUrl = fetchDogImage(breedPath);
            predictedBreed.setImageURL(imageUrl);

            return customResponseEntity.getOkResponse("Raza clasificada correctamente", predictedBreed);
        } catch (Exception e) {
            return customResponseEntity.get400Response();
        }
    }

    private String capitalizeBreedName(String breed) {
        String[] words = breed.toLowerCase(Locale.ROOT).split(" ");
        StringBuilder capitalizedBreed = new StringBuilder();
        for (String word : words) {
            capitalizedBreed.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return capitalizedBreed.toString().trim();
    }

    private String formatBreedForApi(String breed) {
        String[] parts = breed.toLowerCase(Locale.ROOT).split(" ");
        if (parts.length > 1) {
            return parts[1] + "/" + parts[0]; // Sub-breed/Raza principal
        }
        return parts[0]; // Solo la raza principal
    }

    private String fetchDogImage(String breedPath) {
        String apiUrl = "https://dog.ceo/api/breed/" + breedPath + "/images/random";
        RestTemplate restTemplate = new RestTemplate();
        try {
            DogCeoResponse response = restTemplate.getForObject(apiUrl, DogCeoResponse.class);
            return response != null ? response.getMessage() : null;
        } catch (Exception e) {
            System.err.println("Error al consultar la API de Dog CEO: " + e.getMessage());
            return null;
        }
    }

    // Clase para manejar la respuesta de Dog CEO
    static class DogCeoResponse {
        private String message;
        private String status;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

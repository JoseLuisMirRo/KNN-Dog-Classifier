package mx.edu.utez.dogclassifier.modules.dataset;

import mx.edu.utez.dogclassifier.modules.dog.Dog;
import mx.edu.utez.dogclassifier.modules.utils.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/dataset")
public class DatasetController {

    @Autowired
    private DatasetService datasetService;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadDataset(@RequestParam("file")MultipartFile file){
        try{
            datasetService.loadDataset(file);
            return customResponseEntity.get201Response("Dataset cargado correctamente");
        }catch (IOException e){
            return customResponseEntity.get400Response();
        }
    }

    @GetMapping()
    public ResponseEntity<?> getDataset(){
        List<Dog> dataset = datasetService.getDataset();
        if(dataset.isEmpty()) {
            return customResponseEntity.get404Response();
        }
        return customResponseEntity.getOkResponse("Operación exitosa", dataset);
    }







}

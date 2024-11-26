package mx.edu.utez.dogclassifier.modules.dogBreed;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatasetService {
    private final List<DogBreed> dataset = new ArrayList<>();

    public void loadDataset(MultipartFile file) throws IOException {
        dataset.clear(); //Limpiar el datase previo

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for(Row row : sheet) {
            if(row.getRowNum() == 0) continue; //Saltar el encabezado

            String name = row.getCell(0).getStringCellValue();
            double height = row.getCell(1).getNumericCellValue();
            double weight = row.getCell(2).getNumericCellValue();
            int energy = (int) row.getCell(3).getNumericCellValue();
            int friendliness = (int) row.getCell(4).getNumericCellValue();
            int intelligence = (int) row.getCell(5).getNumericCellValue();

            dataset.add(new DogBreed(name, height, weight, energy, friendliness, intelligence));
        }

        public List
    }
}

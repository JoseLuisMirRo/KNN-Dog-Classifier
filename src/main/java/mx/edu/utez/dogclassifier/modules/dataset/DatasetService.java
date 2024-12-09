package mx.edu.utez.dogclassifier.modules.dataset;

import mx.edu.utez.dogclassifier.modules.dog.Dog;
import mx.edu.utez.dogclassifier.modules.knn.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class DatasetService {
    private final ArrayList<Dog> dataset = new ArrayList<>();

    public void loadDataset(MultipartFile file) throws IOException {
        dataset.clear(); //Limpiar el datase previo

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; //Saltar el encabezado

            double height = row.getCell(0).getNumericCellValue();
            double weight = row.getCell(1).getNumericCellValue();
            double coatLength = row.getCell(2).getNumericCellValue();
            int color = (int) row.getCell(3).getNumericCellValue();
            int activityLevel = (int) row.getCell(4).getNumericCellValue();
            int friendliness = (int) row.getCell(5).getNumericCellValue();
            int intelligence = (int) row.getCell(6).getNumericCellValue();
            String breed = row.getCell(7).getStringCellValue();

            dataset.add(new Dog(height, weight, coatLength, color, activityLevel, friendliness, intelligence, breed));
        }
        workbook.close();
    }

    public ArrayList<Dog> getDataset() {
        return dataset;
    }
}

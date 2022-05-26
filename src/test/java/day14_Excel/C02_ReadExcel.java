package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //10. WorkbookFactory.create(fileInputStream)

       String actualData= workbook
               .getSheet("Sayfa1")  //11. Sheet objesi olusturun
               .getRow(3)           //12. Row objesi olusturun
               .getCell(3)          //12. Cell objesi olusturun
               .toString();           //data tipini stringe cevırelım.
    }
}

package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        //10. WorkbookFactory.create(fileInputStream)
        //11. Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(2);
        //12. Row objesi olusturun row.getCell(index)
        Cell cell=row.getCell(2);
        System.out.println(cell);

        //3.indekstekı satırın 3. ındekstekı datanın Cezayir oldugunu test edın
        Assert.assertEquals("Arnavutluk",cell.toString());

        //cell in daya tipi Cell oldugu için toString methodu ıle strınge cevırıyoruz.
    }
}

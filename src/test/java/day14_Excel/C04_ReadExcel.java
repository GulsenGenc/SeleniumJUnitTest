package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcel() throws IOException {


        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //ingilizce başkentler sütununu yazdıralım
        int sonSatır = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatır);
        String satırdakiData = " ";

        for (int i = 0; i <= sonSatır; i++) {
            satırdakiData = C03_readExcel.banaDataGetir(i, 1);
            System.out.println(satırdakiData);
        }

    }
}

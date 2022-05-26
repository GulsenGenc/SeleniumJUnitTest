package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //sayfa2 ye gidip kullanılan satır sayısının 21 oldugunu test edin
        int sonSatırIndeksı=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();

        int expectedSatırSayısı=21;
        Assert.assertEquals(expectedSatırSayısı,sonSatırIndeksı+1);

        int kullanılanSatırSayısı=workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();//kullanılan satır sayısını bıze verır
        int expectedKullanılanSatırSayısı=9;
        Assert.assertEquals(expectedKullanılanSatırSayısı,kullanılanSatırSayısı);


    }
}

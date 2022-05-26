package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_readExcel {
    @Test
    public void readExcelTesti() throws IOException {
        //input olarak verılen satır no,sutun no değerlerini parametre olarak alıp o cell dekı
        //datayı string olarak bana dönduren bır method oluşturun

        int satırNo = 4;
        int sutunNo = 4;
        //dönen stringin Cezayir oldugunu test edin
        String expectedData = "Cezayir";

        String actualData = banaDataGetir(satırNo - 1, sutunNo - 1);//çünkü excel indeks ile çalışır
        Assert.assertEquals(expectedData,actualData);

    }

    public static String banaDataGetir(int satırIndex, int sutunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satırIndex)
                .getCell(sutunIndex)
                .toString();
        return istenenData;
    }
}

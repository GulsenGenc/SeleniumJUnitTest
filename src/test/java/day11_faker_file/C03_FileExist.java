package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\Admin\IdeaProjects\com.Batch59JUnit
        //bana içinde oldugun projenın dosya yolunu(path) verir
        System.out.println(System.getProperty("user.home"));
        //C:\Users\Admin bılgısayarımın bana özel kısmını verdi.

        //masaustumuzdekı text dosyasının varlıgını test edelım
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

         /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String farkliKisim= System.getProperty("user.home");
        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";
        // mac icin   "/Desktop/text"
        String masaustuDosyaYolu=farkliKisim+ortakKisim ;

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
    }
}

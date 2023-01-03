package Day13excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_writeExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu= "src/test/java/Day12_WebTables/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //5.sütun olarak Nüfus başlığı ile sütun oluşturalım
        workbook.getSheet("Sayfa1").getRow(0).createCell(5).setCellValue("Nufus");
        //3.satırdaki nufus bilgisini 1500000 yapın
        workbook.getSheet("Sayfa1").getRow(2).createCell(5).setCellValue("1500000");
        //7.satırdaki nufus bilgisini3000000 yapın
        workbook.getSheet("Sayfa1").getRow(6).createCell(5).setCellValue("300000");
        //yaptığımız değişiklikler kopya wookbook üzerinde bu değişiklikleri excel dosyasına kaydetmek için
        //FileoutputStream kullanırız
        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(0);
        Cell cell5=row.getCell(5);
        workbook.getSheet("Sayfa1").getRow(0).removeCell(cell5);//herhangi bir cell'i silmek için kullanabiliriz.

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();


    }
}

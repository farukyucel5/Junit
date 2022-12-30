package Day10FileinputOutput;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C01_fileinputStream {
    @Test
    public void test01() throws FileNotFoundException {
        String filePath="C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\Vocabulary.txt";
        FileInputStream fileInputStream=new FileInputStream(filePath);

        System.out.println(System.getProperty("user.dir"));
        //şuanda çalışan dosyanın yolunu verir(C01_fileinputStream)

        System.out.println(System.getProperty("user.home"));
        //kullanıcının temel path'ini verir(C:\Users\Lenovo)

        String dynamicFile=System.getProperty("user.home")+ "\\OneDrive\\Masaüstü\\Vocabulary.txt";
        System.out.println(dynamicFile);



    }
}

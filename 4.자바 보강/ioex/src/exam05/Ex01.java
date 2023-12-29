package exam05;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws IOException,InterruptedException {
        //File file = new File("D:/test1.txt");
        //file.createNewFile();
        File dir = new File("D:/folder");
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(dir,"test1.txt");
        //file.createNewFile();
        File file2 = File.createTempFile("tmp_",".log",new File("D:/"));
        Thread.sleep(3000);
        file2.deleteOnExit();
    }
}

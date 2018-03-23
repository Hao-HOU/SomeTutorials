package a.wikidata;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by houhao on 2017/11/9.
 */
public class IOUtil {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new FileInputStream("E:\\Temp\\wikidata\\all-timeout.txt"));
        int fileCount = 0;
        while (in.hasNextLine()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                if (in.hasNextLine()) {
                    sb.append(in.nextLine()).append("\n");
                }
            }
            FileWriter fw = new FileWriter("E:\\Temp\\wikidata\\data\\file_" + fileCount + ".txt");
            fileCount++;
            fw.write(sb.toString());
            fw.close();
        }
        in.close();
        System.out.println("分割完成！");
    }
}

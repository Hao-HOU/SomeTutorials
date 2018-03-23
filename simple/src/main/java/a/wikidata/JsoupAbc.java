package a.wikidata;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author houhao
 */
public class JsoupAbc {
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int j = 90; j <= 102; j++) {
            System.out.println("读取URL文件file_" + j + ".txt");
            Scanner in = new Scanner(new FileInputStream("E:\\Temp\\wikidata\\data\\file_" + j + ".txt"));
            Map<String, String> res = new HashMap<>();

            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] m = line.split("\t");
                res.put(m[0], m[1]);
            }
            in.close();
            System.out.println("开始爬取...");
            long start = System.currentTimeMillis();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000L,
                    TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

            int i = 1;
            for (String key : res.keySet()) {
                System.out.println(i++);
                FetchTitleLabelThread fetchTitleLabelThread = new FetchTitleLabelThread(key, res.get(key));
                executor.submit(fetchTitleLabelThread);
            }
            executor.shutdown();
            System.out.println("此次抓取结束！");
            System.out.println("历时：" + (System.currentTimeMillis() - start) / 1000 + "s");
            System.out.println(new Date());
        }
    }
}

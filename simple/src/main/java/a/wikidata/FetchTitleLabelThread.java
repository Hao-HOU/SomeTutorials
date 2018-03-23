package a.wikidata;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author houhao
 */
public class FetchTitleLabelThread extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchTitleLabelThread.class);
    String urlPrefix = "http://www.wikidata.org/entity";

    private String id;
    private String url;

    public FetchTitleLabelThread(String id, String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public void run() {
        try {
            FileWriter fw = new FileWriter("E:\\Temp\\wikidata\\result\\" + Thread.currentThread().getName() + ".txt", true);
            FileWriter timeoutFw = new FileWriter("E:\\Temp\\wikidata\\timeout\\" + Thread.currentThread().getName() + ".txt", true);
            Document doc = null;
            try {
                doc = Jsoup.connect(urlPrefix + url).get();
            } catch (IOException e) {
                timeoutFw.write(id + "\t" + url + "\n");
                System.out.println("超时url已写入文件");
            } finally {
                timeoutFw.close();
            }

            Elements titles = doc.select(".wikibase-title-label");
            for (Element title : titles) {
                JSONObject res = new JSONObject();
                res.put("id", id);
                res.put("title", title.text());
                fw.write(res.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            LOGGER.info("创建写出文件异常！");
        }
    }
}

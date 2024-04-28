package lr10.task3;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

public class Task3 {
    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        String filePath = "src/lr10/task3/task3.txt";
        int maxRetries = 2;

        Response response = null;
        try {
            for (int i = 1; i <= maxRetries; i++) {
                response = Jsoup.connect(url).ignoreHttpErrors(true).execute();
                if (response.statusCode() < 399) {
                    break;
                } else {
                    System.out.println("Произошла ошибка при загрузке страницы.");
                    System.out.println("Status code = " + response.statusCode());
                    System.out.println("Status msg  = " + response.statusMessage());

                    if (i == maxRetries) {
                        System.out.println("Не удалось загрузить страницу. Выход");
                        System.exit(1);
                    } else {
                        System.out.println("Попытка переподключения " + i);
                    }
                }
            }

            Document doc = response.parse();
            Elements links = doc.select("a[href]");
            PrintWriter pr = new PrintWriter(filePath);
            for (Element link : links) {
                pr.println(link.attr("abs:href"));
            }
            pr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
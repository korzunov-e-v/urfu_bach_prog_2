package lr10.task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Task2 {
    public static void main(String[] args) {
        String filePath = "src/lr10/task2/task2.json";

        searchBook(filePath, "Булгаков");
        addBook(filePath, "1984", "Джордж Оруэлл", 1949);
        removeBook(filePath, "1984");

    }

    public static void removeBook(String filePath, String bookTitle) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray books = (JSONArray) jsonObject.get("books");

            var iterator = books.iterator();
            while (iterator.hasNext()) {
                JSONObject book = (JSONObject) iterator.next();
                if (bookTitle.equals(book.get("title"))) {
                    iterator.remove();
                    System.out.println("Удалена книга");
                    System.out.println("Название книги: " + book.get("title"));
                    System.out.println("Автор: " + book.get("author"));
                    System.out.println("Год издания: " + book.get("year"));
                }}

            FileWriter file = new FileWriter(filePath);
            file.write(jsonObject.toJSONString());
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBook(String filePath, String title, String author, int year) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray books = (JSONArray) jsonObject.get("books");

            JSONObject book = new JSONObject();
            book.put("title", title);
            book.put("author", author);
            book.put("year", year);

            books.add(book);

            FileWriter file = new FileWriter(filePath);
            file.write(jsonObject.toJSONString());
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchBook(String filePath, String query) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                String title = book.get("title").toString();
                String author = book.get("author").toString();
                String year = book.get("year").toString();

                if (title.contains(query) | author.contains(query) | year.contains(query)) {
                    System.out.println("Найдена книга");
                    System.out.println("Название книги: " + title);
                    System.out.println("Автор: " + author);
                    System.out.println("Год издания: " + year);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

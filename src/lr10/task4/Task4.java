package lr10.task4;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        // Открываем файл Excel для чтения
        String filePath = "src/lr10/task4/task4.xlsx";
        File file = new File(filePath);

        // Создаем экземпляр книги Excel из файла
        try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            // Получаем лист из книги по его имени
            XSSFSheet sheet = workbook.getSheet("Товары");

            // Перебираем строки и ячейки листа
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Выводим значение ячейки на экран
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        } catch (InvalidFormatException e) {
            System.out.println("Файл повреждён или имеет неизвестный формат");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
            e.printStackTrace();
        } finally {
            System.exit(1);
        }
    }
}

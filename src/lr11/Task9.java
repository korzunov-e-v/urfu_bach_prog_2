package lr11;

import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        String reference = "Мороз и солнце; день чудесный! " +
                "Еще ты дремлешь, друг прелестный — " +
                "Пора, красавица, проснись: " +
                "Открой сомкнуты негой взоры " +
                "Навстречу северной Авроры, " +
                "Звездою севера явись! " +
                "Вечор, ты помнишь, вьюга злилась, " +
                "На мутном небе мгла носилась; " +
                "Луна, как бледное пятно, " +
                "Сквозь тучи мрачные желтела, " +
                "И ты печальная сидела — " +
                "А нынче… погляди в окно: " +
                "Под голубыми небесами " +
                "Великолепными коврами, " +
                "Блестя на солнце, снег лежит; " +
                "Прозрачный лес один чернеет, " +
                "И ель сквозь иней зеленеет, " +
                "И речка подо льдом блестит.";

        List<String> strings = List.of(reference.split(" "));
        System.out.println("Список строк : " + strings);

        List<String> result = getOnlyAlphabetical(strings);

        System.out.println("Результат : " + result);
    }

    public static List<String> getOnlyAlphabetical(List<String> list) {
        return list.stream()
                .filter(s -> s.chars().allMatch(c -> Character.isLetter(c)))
                .collect(Collectors.toList());
    }
}

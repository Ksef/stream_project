package classwork_p2;

import java.util.ArrayList;
import java.util.List;

//- создать ArrayList со словами на 15-20 элементов.
//        -- отсортировать его по алфавиту в восходящем порядке.
//        -- отсортировать его по алфавиту  в нисходящем порядке.
//        -- отфильтровать слова длиной менее 4х символов
public class Main {
    public static void main(String[] args) {

        List<Array> words = new ArrayList<>();

        words.add(new Array("book"));
        words.add(new Array("laptop"));
        words.add(new Array("phone"));
        words.add(new Array("display"));
        words.add(new Array("linux"));
        words.add(new Array("ubuntu"));
        words.add(new Array("percent"));
        words.add(new Array("telegram"));
        words.add(new Array("chrome"));
        words.add(new Array("idea"));
        words.add(new Array("wifi"));
        words.add(new Array("languige"));
        words.add(new Array("bluetooth"));
        words.add(new Array("settings"));
        words.add(new Array("vasgen"));
        words.add(new Array("home"));

        words.stream()
                .sorted((o1, o2) -> o1.getWords().compareTo(o2.getWords()))
                .forEach(array -> System.out.println(array));
        System.out.println("=============");
        words.stream()
                .sorted((o1, o2) -> o2.getWords().compareTo(o1.getWords()))
                .forEach(array -> System.out.println(array));
        System.out.println("=======");
        words.stream()
                .filter(array -> array.getWords().length() <= 4 )
                .forEach(array -> System.out.println(array));

    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person(1, "Vasa", LocalDate.of(1993, 1, 30)));
        people.add(new Person(2, "Ivan", LocalDate.of(1997, 7, 3)));
        people.add(new Person(3, "Anna", LocalDate.of(1992, 3, 12)));
        people.add(new Person(4, "Olena", LocalDate.of(1999, 4, 17)));

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

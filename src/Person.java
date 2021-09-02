import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private LocalDate BirthDate;

    public Person(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        BirthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(BirthDate, person.BirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, BirthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }
}

package classwork;

import java.util.ArrayList;
import java.util.List;

//Створити енум Стать.
//        Створити клас Юзер з плоями : ід, ім'я , вік, Стать.
//        Ствроити 10 об'єктів Юзера з відповідними ід (1-10)
//        Свторити  arrayList , та покласти цих юзерів в arayList.
//        - Проітерувати колекцію юзерів, вивевши тільки юзерів з парним значенням ід
//        - Проітерувати колекцію юзерів, вивевши тільки юзерів з ім'ям , довжина якого більше ніж 5 символів
//        - Проітерувати колекцію юзерів, вивевши тільки юзерів жінок
public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, 35, "vasgen", Gender.MAN));
        users.add(new User(2, 45, "vasgen1", Gender.MAN));
        users.add(new User(3, 65, "vasgen2", Gender.MAN));
        users.add(new User(4, 55, "vasgen3", Gender.MAN));
        users.add(new User(5, 75, "vasgen4", Gender.MAN));
        users.add(new User(6, 25, "vika", Gender.WOMAN));
        users.add(new User(7, 15, "vika1", Gender.WOMAN));
        users.add(new User(8, 5, "vika2", Gender.WOMAN));
        users.add(new User(9, 34, "vika3", Gender.WOMAN));
        users.add(new User(10, 39, "vika4", Gender.WOMAN));

        users.stream()
                .filter(user -> user.getId() % 2 == 0 )
                .forEach(user -> System.out.println(user));

        System.out.println("============");

        users.stream()
                .filter(user -> user.getName().length() > 5)
                        .forEach(user -> System.out.println(user));

        System.out.println("============");

        users.stream()
                .filter(user -> user.getGender()==Gender.WOMAN)
                .forEach(user -> System.out.println(user));

        System.out.println("============");
    }


}

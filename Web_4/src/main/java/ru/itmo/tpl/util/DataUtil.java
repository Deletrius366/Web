package ru.itmo.tpl.util;

import ru.itmo.tpl.model.Colors;
import ru.itmo.tpl.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataUtil {
    private static final List<User> USERS = Arrays.asList(
            new User(1, "MikeMirayanov", "Mikhail Mirzayanov", Colors.RED),
            new User(2, "tourist", "Genady Korotkevich", Colors.GREEN),
            new User(3, "emusk", "Elon Musk", Colors.BLUE),
            new User(5, "pashka", "Pavel Mavrin", Colors.RED),
            new User(7, "geranazavr555", "Georgiy Nazarov", Colors.GREEN),
            new User(11, "cannon147", "Erofey Bashunov", Colors.BLUE)
    );

    private static List<User> getUsers() {
        return USERS;
    }

    public static void putData(Map<String, Object> data) {
        data.put("users", getUsers());

        for (User user : getUsers()) {
            if (Long.toString(user.getId()).equals(data.get("logged_user_id"))) {
                data.put("user", user);
            }
        }
    }
}

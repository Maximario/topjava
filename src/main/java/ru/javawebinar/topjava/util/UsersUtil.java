package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {

    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static final List<User> USERS = Arrays.asList(
            new User(null, "Administrator", "admin@topjava.com", "12345678", Role.ADMIN),
            new User(null, "User", "user@topjava.com", "12345678", Role.USER)
    );

}

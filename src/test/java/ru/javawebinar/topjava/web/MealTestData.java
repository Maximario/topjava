package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.*;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;


public class MealTestData {

    public static final int NOT_FOUND_ID = 10;
    public static final int MEAL1_ID = START_SEQ + 2;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int USER_ID = START_SEQ;

    public static final Meal USER_MEAL1 = new Meal(MEAL1_ID, of(2020, 6, 25, 10, 0), "Завтрак", 1000);
    public static final Meal USER_MEAL2 = new Meal(MEAL1_ID + 1, of(2020, 6, 25, 14, 0), "Обед", 2000);
    public static final Meal USER_MEAL3 = new Meal(MEAL1_ID + 2, of(2020, 6, 25, 20, 0), "Ужин", 2000);
    public static final Meal USER_MEAL4 = new Meal(MEAL1_ID + 3, of(2020, 6, 26, 00, 0), "Поздний ужин", 1000);
    public static final Meal ADMIN_MEAL1 = new Meal(MEAL1_ID + 4, of(2020, 6, 26, 00, 0), "Завтрак Админ", 500);
    public static final Meal ADMIN_MEAL2 = new Meal(MEAL1_ID + 5, of(2020, 6, 26, 9, 0), "Завтрак Админ", 500);
    public static final Meal ADMIN_MEAL3 = new Meal(MEAL1_ID + 6, of(2020, 6, 26, 15, 0), "Обед Админ", 500);
    public static final Meal ADMIN_MEAL4 = new Meal(MEAL1_ID + 7, of(2020, 6, 26, 20, 0), "Ужин Админ", 400);


    public static final List<Meal> MEALS = Arrays.asList(USER_MEAL4, USER_MEAL3, USER_MEAL2, USER_MEAL1);

    public static Meal getNew() {
        return new Meal(null, of(2020, Month.JUNE, 26, 18, 0), "Созданный ужин", 300);
    }

    public static Meal getUpdated() {
        return new Meal(MEAL1_ID, USER_MEAL1.getDateTime(), "Обновленный завтрак", 200);
    }

}

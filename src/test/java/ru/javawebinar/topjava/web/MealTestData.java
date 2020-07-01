package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.inmemory.InMemoryMealRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;

import static ru.javawebinar.topjava.web.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.web.UserTestData.USER_ID;


public class MealTestData {

    public static final MealRepository MEALS = new InMemoryMealRepository();

    static {
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 25, 10, 0), "Завтрак", 1000), USER_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 25, 14, 0), "Обед", 2000), USER_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 25, 20, 0), "Ужин", 2000), USER_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 26, 0, 0), "Поздний ужин", 1000), USER_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 26, 0, 0), "Завтрак админ", 500), ADMIN_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 26, 9, 0), "Завтрак админ", 500), ADMIN_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 26, 15, 0), "Обед админ", 500), ADMIN_ID);
        MEALS.save(new Meal(LocalDateTime.of(2020, Month.JUNE, 26, 20, 0), "Ужин админ", 400), ADMIN_ID);
    }


}

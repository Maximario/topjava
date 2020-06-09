package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryMealRepository implements MealRepository {

    AtomicInteger mealCounter = new AtomicInteger(0);
    Map<Integer, Meal> mealDB = new ConcurrentHashMap<>();

    @Override
    public void create(Meal meal) {
        synchronized (meal) {
            meal.setId(mealCounter.addAndGet(1));
            mealDB.put(meal.getId(), meal);
        }
    }

    @Override
    public Meal get(int id) {
        return mealDB.get(id);
    }

    @Override
    public void update(Meal meal) {
        synchronized (meal) {
            mealDB.put(meal.getId(), meal);
        }
    }

    @Override
    public void delete(int id) {
        mealDB.remove(id);
    }
}

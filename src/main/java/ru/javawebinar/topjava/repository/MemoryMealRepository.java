package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryMealRepository implements MealRepository {

    private AtomicInteger counter = new AtomicInteger(0);
    private Map<Integer, Meal> mealDB = new ConcurrentHashMap<>();

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) meal.setId(counter.incrementAndGet());
        return mealDB.put(meal.getId(), meal);
    }

    @Override
    public Meal get(int id) {
        return mealDB.get(id);
    }


    @Override
    public void remove(int id) {
        mealDB.remove(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return mealDB.values();
    }
}

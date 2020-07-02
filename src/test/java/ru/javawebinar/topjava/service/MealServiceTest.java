package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.web.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))

public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() throws Exception {
        Meal actual = service.get(MEAL1_ID, USER_ID);
        assertThat(actual).isEqualTo(USER_MEAL1);
    }

    @Test
    public void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND_ID, USER_ID));
    }

    @Test
    public void getNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID, ADMIN_ID));
    }

    @Test
    public void delete() throws Exception {
        service.delete(MEAL1_ID, USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID, USER_ID));
    }

    @Test
    public void deleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND_ID, USER_ID));
    }
    @Test
    public void deleteNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(MEAL1_ID, ADMIN_ID));
    }

    @Test
    public void getBetweenInclusive() throws Exception {
        assertThat(service.getBetweenInclusive(
                LocalDate.of(2020, Month.JUNE, 25),
                LocalDate.of(2020, Month.JUNE, 25),
                USER_ID))
        .isEqualTo(Arrays.asList(USER_MEAL3, USER_MEAL2, USER_MEAL1));
    }

    @Test
    public void getBetweenWithNullDates() throws Exception {
        assertThat(service.getBetweenInclusive(null, null, USER_ID)).isEqualTo(MEALS);
    }

    @Test
    public void getAll() throws Exception {
        assertThat(service.getAll(USER_ID)).isEqualTo(MEALS);
    }

    @Test
    public void update() throws Exception {
        Meal updated = getUpdated();
        service.update(updated, USER_ID);
        assertThat(service.get(MEAL1_ID, USER_ID)).isEqualTo(getUpdated());
    }

    @Test
    public void updateNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () -> service.update(USER_MEAL1, ADMIN_ID));
    }

    @Test
    public void create() throws Exception {
        Meal created = service.create(getNew(), USER_ID);
        int newId = created.getId();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        assertThat(created).isEqualTo(newMeal);
        assertThat(service.get(newId, USER_ID)).isEqualTo(newMeal);
    }

}
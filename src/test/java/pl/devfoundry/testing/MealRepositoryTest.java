package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();
    @Test
    void shouldBeAbleToAddMealToRepository() {

        //give

        Meal meal = new Meal(10,  "Pizza");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {

        //given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        //when
        mealRepository.delete(meal);

        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }
}

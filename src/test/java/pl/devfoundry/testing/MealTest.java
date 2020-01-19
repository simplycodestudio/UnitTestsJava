package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(28, discountedPrice);
        //hamcrest
        assertThat(discountedPrice, equalTo(28));
        //assertj

    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {

        // given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);
        //hamcrest
        assertThat(meal1, sameInstance(meal2));
        //assertj

    }

    @Test
    void referencesToTheDifferentObjectShouldNotBeEqual() {

        // given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        //then
        assertNotSame(meal1, meal2);
        //hamcrest
        assertThat(meal1, not(sameInstance(meal2)));
        //assertj

    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {
        //given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pizza");

        //then
        assertEquals(meal1, meal2, "Checkin if two meals are equal");
        //assertj

    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {

        //given
        Meal meal = new Meal(8, "Soup");

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(4));
    }
}
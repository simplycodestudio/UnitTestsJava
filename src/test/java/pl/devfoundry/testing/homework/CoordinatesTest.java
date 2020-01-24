package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void setCoordinatesLessThan0AndRetrieveIllegalArgumentException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1,-2));
    }

    @Test
    void setCoordinatesAbove100AndRetrieveIllegalArgumentException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(110, 100));
    }


//    @Test
//    void copyShouldReturnNewObject() {
//        //given
//        Coordinates coordinates = new Coordinates(10,10);
//
//        //when
//        Coordinates copy = coordinates.copy(coordinates, 5,6);
//
//        //then
//        assertThat(copy, not(sameInstance(coordinates)));
//        assertThat(copy, equalTo(coordinates));
//    }

    @Test
    void copyShoulReturnAddedCords() {
        //given
        Coordinates coordinates = new Coordinates(15,25);

        //when
        Coordinates copy  = Coordinates.copy(coordinates, 4,8);

        //then
        assertThat(copy.getX(), equalTo(19));
        assertThat(copy.getY(), equalTo(33));
    }
}
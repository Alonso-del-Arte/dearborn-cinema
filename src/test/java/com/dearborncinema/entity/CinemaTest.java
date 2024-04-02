package com.dearborncinema.entity;

import static com.dearborncinema.entity.MovieTest.RANDOM;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    @Test
    void testGetTotalCapacity() {
        System.out.println("getTotalCapacity");
        Cinema cinema = new Cinema();
        int numberOfScreens = RANDOM.nextInt(16) + 4;
        int expected = 0;
        for (int i = 0; i < numberOfScreens; i++) {
            Screen screen = new Screen();
            int numberOfSeats = RANDOM.nextInt(128) + 2;
            screen.setCapacity(numberOfSeats);
            cinema.add(screen);
            expected += numberOfSeats;
        }
        int actual = cinema.getTotalCapacity();
        String msg = "Cinema with " + numberOfScreens
                + " expected to have a total capacity of " + expected
                + " seats";
        assertEquals(expected, actual, msg);
    }

}

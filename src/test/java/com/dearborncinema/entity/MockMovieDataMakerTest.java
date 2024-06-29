package com.dearborncinema.entity;

import static com.dearborncinema.entity.MovieTest.RANDOM;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MockMovieDataMakerTest {

    @Test
    void testLastFriday() {
        LocalDate expected = LocalDate.now();
        do {
            expected = expected.minusDays(1);
        } while (expected.getDayOfWeek() != DayOfWeek.FRIDAY);
        LocalDate actual = MockMovieDataMaker.LAST_FRIDAY;
        assertEquals(expected, actual);
    }

    @Test
    void testMakeUpTitle() {
        System.out.println("makeUpTitle");
        int capacity = RANDOM.nextInt(32) + 8;
        Set<String> titles = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            titles.add(MockMovieDataMaker.makeUpTitle());
        }
        int expected = 3 * capacity / 5;
        int actual = titles.size();
        String msg = "After calling makeUpTitle() " + capacity
                + " times, should've gotten at least " + expected
                + " distinct titles";
        assert expected <= actual : msg;
    }

    @Test
    void testChooseRating() {
        MPAARating[] ratings = MPAARating.values();
        Set<MPAARating> expected = new HashSet<>(Set.of(MPAARating.G,
                MPAARating.PG, MPAARating.PG13, MPAARating.R, MPAARating.NC17));
        int size = expected.size();
        Set<MPAARating> actual = new HashSet<>(size);
        int totalNumberOfCalls = 16 * size;
        for (int i = 0; i < totalNumberOfCalls; i++) {
            actual.add(MockMovieDataMaker.chooseRating());
        }
        assertEquals(expected, actual);
    }

}

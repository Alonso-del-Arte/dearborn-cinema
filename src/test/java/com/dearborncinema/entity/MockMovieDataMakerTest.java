package com.dearborncinema.entity;

import static com.dearborncinema.entity.MovieTest.RANDOM;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        System.out.println("chooseRating");
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

    // TODO: Write tests for makeUpRatingReason

    // TODO: Rewrite this test to use org.testframe.api.Asserters.assertInRange()
    @Test
    void testChooseDuration() {
        System.out.println("chooseDuration");
        int minimumMinutes = 77;
        int maximumMinutes = 150;
        Duration minimum = Duration.of(minimumMinutes, ChronoUnit.MINUTES);
        Duration maximum = Duration.of(maximumMinutes, ChronoUnit.MINUTES);
        int range = maximumMinutes - minimumMinutes;
        Set<Duration> set = new HashSet<>(range);
        int numberOfCalls = 16 * range;
        String msgPart = " should be at least " + minimum.toString() + " and at most " + maximum.toString();
        for (int i = 0; i < numberOfCalls; i++) {
            Duration duration = MockMovieDataMaker.chooseDuration();
            String msg = duration.toString() + msgPart;
            assert duration.compareTo(minimum) > 0 : msg;
            assert duration.compareTo(maximum) < 0 : msg;
            set.add(duration);
        }
        int expected = 3 * range / 5;
        int actual = set.size();
        String msg = "After " + numberOfCalls + ", expected at least "
                + expected + " distinct, got " + actual;
        assert actual >= expected : msg;
    }

}

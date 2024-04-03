package com.dearborncinema.entity;

import static com.dearborncinema.entity.MovieTest.RANDOM;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MockMovieDataMakerTest {

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

}

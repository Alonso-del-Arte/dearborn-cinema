package com.dearborncinema.entity;

import static com.dearborncinema.entity.MovieTest.RANDOM;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

public class MockMovieDataMaker {

    private static final String[] FRANCHISE_NAMES = {"Avengers",
            "Back to the Present", "Cosmic Trek", "Cosmic Wars", "Dinosaurs",
            "Elastic Man", "Fast Vehicles", "Girl Wizard", "Sherlock Holmes",
            "Ionic Man", "Jokester", "Kern", "Lion Tamer", "Medal of Valor",
            "Notung", "Outerborough", "Phantom Trapper", "Qualls of Destiny",
            "Rural Detective", "Safe House", "Transforming Robots",
            "Under the Moon", "Vowel Thief", "Wild North", "Xenon Morphemes",
            "Young Sherlock Holmes", "Zoographer of Destiny"};

    private static final int NUMBER_OF_FRANCHISES = FRANCHISE_NAMES.length;;

    private static final String[] ROMAN_NUMERALS = {"I", "II", "III", "IV", "V",
            "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
            "XVI", "XVII", "XVIII", "XIX", "XX"};

    private static final int NUMBER_OF_NUMERALS = ROMAN_NUMERALS.length;

    private static final String[] GENERAL_NOUNS = {"Attack", "Battle",
            "Convocation", "Defenestration", "Destruction", "Exodus", "Fall",
            "Games", "Hindrance", "Illumination", "Journey", "Jog", "Karate",
            "Loss", "March", "Narrative", "Opportunity", "Peroration",
            "Questioning", "Return", "Revenge", "Revolt", "Rise", "Ruminations",
            "Sojourn", "Temptation", "Unification", "Voyage", "Waters",
            "Xylopyrography", "Youth", "Zenith"};

    private static final int NUMBER_OF_GENERAL_NOUNS = GENERAL_NOUNS.length;

    private static final String[] CHARACTER_NOUNS = {"Algernon", "the Beasts",
            "the Clones", "the Dogs of War", "the Empire", "Frankenstein",
            "Goldilocks", "Sherlock Holmes", "Hoth", "Indigo", "the Jedi",
            "Don Juan", "Kilimanjaro", "the Penguins", "the Roses",
            "the Serifs", "the Sith", "the Town Crier", "Underwood", "Voyager",
            "Walker", "Xanadu", "Yonkers", "Zorro"};

    private static final int NUMBERS_OF_CHARACTER_NOUNS
            = CHARACTER_NOUNS.length;

    static final LocalDate LAST_FRIDAY;

    // TODO: Maybe refactor to use DayOfWeek ordinal
    static {
        LocalDate curr = LocalDate.now().minusDays(1);
        while (curr.getDayOfWeek() != DayOfWeek.FRIDAY) {
            curr = curr.minusDays(1);
        }
        LAST_FRIDAY = LocalDate.now();// curr;
    }

    public static String makeUpTitle() {
        String franchise
                = FRANCHISE_NAMES[RANDOM.nextInt(NUMBER_OF_FRANCHISES)];
        String romanNumeral
                = ROMAN_NUMERALS[RANDOM.nextInt(NUMBER_OF_NUMERALS)];
        String generalNoun
                = GENERAL_NOUNS[RANDOM.nextInt(NUMBER_OF_GENERAL_NOUNS)];
        String characterNoun
                = CHARACTER_NOUNS[RANDOM.nextInt(NUMBERS_OF_CHARACTER_NOUNS)];
        return franchise + " " + romanNumeral + ": The " + generalNoun + " of "
                + characterNoun;
    }

    // TODO: Write tests for this
    public static MPAARating chooseRating() {
        return MPAARating.UNRATED;
    }

    // TODO: Write tests for this
    public static String makeUpRatingReason() {
        return "SORRY, NOT IMPLEMENTED YET";
    }

    // TODO: Write tests for this
    public static Duration chooseDuration() {
        return Duration.ZERO;
    }

    // TODO: Write tests for this
    public static LocalDate choosePremiereDate() {
        return LocalDate.now();
    }

}

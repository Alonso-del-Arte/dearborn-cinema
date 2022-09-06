package com.dearborncinema.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a screen at a multiplex movie theater. For example, a multiplex
 * with twelve screens can show twelve different movies at the same time.
 * @author Alonso del Arte
 */
public class Screen {

    private String marqueeID;

    private Set<Screening> screenings;

    private int capacity;

    public String getMarqueeID() {
        return this.marqueeID;
    }

    public void setMarqueeID(String label) {
        this.marqueeID = label;
    }

    // TODO: Write tests for this
    public boolean add(Screening showtime) {
        return true;
    }

    // TODO: Write tests for this
    public Set<Screening> getScreenings() {
        return new HashSet<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int numberOfSeats) {
        if (numberOfSeats < 0) {
            String excMsg = "Capacity must be positive, not " + numberOfSeats;
            throw new IllegalArgumentException(excMsg);
        }
        this.capacity = numberOfSeats;
    }

}

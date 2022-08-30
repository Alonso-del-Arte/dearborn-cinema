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

    public String getMarqueeID() {
        return this.marqueeID;
    }

    public void setMarqueeID(String label) {
        this.marqueeID = label;
    }

    // TODO: Write tests for this
    public boolean add(Screening showtime) {
        return false;
    }

    // TODO: Write tests for this
    public Set<Screening> getScreenings() {
        return new HashSet<>();
    }

}

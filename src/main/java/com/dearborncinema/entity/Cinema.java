package com.dearborncinema.entity;

import java.util.HashSet;
import java.util.Set;

public class Cinema {

    private String name;

    private Set<Screen> screens = new HashSet<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Write tests for this
    public boolean add(Screen screen) {
        this.screens.add(screen);
        return false;
    }

    // TODO: Write tests for this
    public boolean remove(Screen screen) {
        return false;
    }

    // TODO: Write tests for this
    public Set<Screen> getScreens() {
        return new HashSet<>();
    }

    public int getTotalCapacity() {
        int total = 0;
        for (Screen screen : this.screens) {
            total += screen.getCapacity();
        }
        return total;
    }

}

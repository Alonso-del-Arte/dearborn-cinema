package com.dearborncinema.entity;

import java.util.HashSet;
import java.util.Set;

public class Cinema {

    private String name;

    private Set<Screen> screens;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Write tests for this
    public boolean add(Screen screen) {
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

}

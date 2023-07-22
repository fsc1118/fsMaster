package com.fs.model;

/**
 * 
 * List of location of the chunk stored in workers
 * 
 */
public class RedundantLocation {
    private final Location[] locations;

    public RedundantLocation(final Location[] locations) {
        this.locations = locations;
    }

    public Location[] getLocations() {
        return this.locations;
    }
}

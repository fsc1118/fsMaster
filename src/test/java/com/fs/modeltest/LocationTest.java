package com.fs.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fs.model.Address;
import com.fs.model.Location;

public class LocationTest {

    private Location location;
    private static final int PORT = 8080;
    private static final Address ADDRESS = new Address("localhost", PORT);
    private static final int BLOCK_INDEX = 100;
    private static final int OFFSET = 200;

    @Before
    public void setUp() {
        location = new Location(ADDRESS, BLOCK_INDEX, OFFSET);
    }

    @Test
    public void getWorkerAddress() {
        assertEquals(ADDRESS.getAddress(), location.getWorkerAddress().getAddress());
        assertEquals(ADDRESS.getPort(), location.getWorkerAddress().getPort());
    }

    @Test
    public void getBlockIndex() {
        assertEquals(BLOCK_INDEX, location.getBlockIndex());
    }

    @Test
    public void getOffset() {
        assertEquals(OFFSET, location.getOffset());
    }
}

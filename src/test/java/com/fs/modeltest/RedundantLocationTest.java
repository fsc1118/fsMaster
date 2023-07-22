package com.fs.modeltest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.fs.model.Address;
import com.fs.model.Location;
import com.fs.model.RedundantLocation;

public class RedundantLocationTest {

    private RedundantLocation redundantLocation;
    private Location[] locations;
    private static final int REDUNDANCY_FACTOR = 2;
    private static final int PORT1 = 8080;
    private static final int PORT2 = 8081;
    private static final String ADDRESS1 = "abc.com";
    private static final String ADDRESS2 = "def.com";
    private static final int BLOCK_INDEX1 = 100;
    private static final int BLOCK_INDEX2 = 101;
    private static final int OFFSET1 = 200;
    private static final int OFFSET2 = 201;

    @Before
    public void setUp() {
        locations = new Location[REDUNDANCY_FACTOR];
        locations[0] = new Location(new Address(ADDRESS1, PORT1), BLOCK_INDEX1, OFFSET1);
        locations[1] = new Location(new Address(ADDRESS2, PORT2), BLOCK_INDEX2, OFFSET2);
        redundantLocation = new RedundantLocation(locations);
    }

    @Test
    public void getLocations() {
        assertEquals(REDUNDANCY_FACTOR, redundantLocation.getLocations().length);
        assertEquals(ADDRESS1, redundantLocation.getLocations()[0].getWorkerAddress().getAddress());
        assertEquals(PORT1, redundantLocation.getLocations()[0].getWorkerAddress().getPort());
        assertEquals(BLOCK_INDEX1, redundantLocation.getLocations()[0].getBlockIndex());
        assertEquals(OFFSET1, redundantLocation.getLocations()[0].getOffset());
        assertEquals(ADDRESS2, redundantLocation.getLocations()[1].getWorkerAddress().getAddress());
        assertEquals(PORT2, redundantLocation.getLocations()[1].getWorkerAddress().getPort());
        assertEquals(BLOCK_INDEX2, redundantLocation.getLocations()[1].getBlockIndex());
        assertEquals(OFFSET2, redundantLocation.getLocations()[1].getOffset());
    }
}

package com.fs.modeltest;

import com.fs.model.Address;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

    private static final String ADDRESS = "localhost";
    private static final int PORT = 8080;
    private Address address;

    @Before
    public void setUp() {
        address = new Address(ADDRESS, PORT);
    }

    @Test
    public void getAddress() {
        assertEquals(ADDRESS, address.getAddress());
    }

    @Test
    public void getPort() {
        assertEquals(PORT, address.getPort());
    }
}

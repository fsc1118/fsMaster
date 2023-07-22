package com.fs.model;

/**
 * Address of a worker. Could be IP address or hostname.
 */
public class Address {
    private final String address;
    private final int port;

    public Address(final String address, final int port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }
}

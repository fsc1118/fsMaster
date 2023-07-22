package com.fs.filesystem;

public class Filesystem {

    private static Filesystem instance = null;

    public byte[] read() {
        return null;
        // TODO: implement
    }

    public void write(final String filename, final byte[] data) {

    }

    private Filesystem() {
        instance = this;
    }

    public static Filesystem getInstance() {
        if (instance == null) {
            instance = new Filesystem();
        }
        return instance;
    }
}

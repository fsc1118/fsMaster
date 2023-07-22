package com.fs.model;

/**
 * 
 * Abstraction of a chunk of raw file data.
 * 
 */
public final class Chunk {
    private final int size;

    public Chunk(final byte[] data) {
        this.size = data.length;
    }

    public int getSize() {
        return this.size;
    }
}

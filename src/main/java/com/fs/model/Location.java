package com.fs.model;

/**
 * 
 * Location of the chunk stored in worker
 */
public final class Location {
    private final Address workerAddress;
    private final int blockIndex;
    private final int offset;

    public Location(final Address workerAddress, final int blockIndex, final int offset) {
        this.workerAddress = workerAddress;
        this.blockIndex = blockIndex;
        this.offset = offset;
    }

    public Address getWorkerAddress() {
        return this.workerAddress;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public int getOffset() {
        return this.offset;
    }
}

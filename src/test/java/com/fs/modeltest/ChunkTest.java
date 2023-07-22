package com.fs.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fs.model.Chunk;

public class ChunkTest {

    private static final int size = 100;
    private Chunk chunk;

    @Before
    public void setUp() {
        chunk = new Chunk(new byte[size]);
    }

    @Test
    public void getSize() {
        assertEquals(size, chunk.getSize());
    }
}

package com.fs.filesystemtest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.fs.filesystem.Filesystem;

public class FilesystemTest {
    @Test
    public void read() {
        assertTrue(true);
    }

    @Test
    public void write() {
        assertTrue(true);
    }

    @Test
    public void getInstance() {
        final Filesystem filesystem1 = Filesystem.getInstance();
        final Filesystem filesystem2 = Filesystem.getInstance();
        assertTrue(filesystem1 == filesystem2);
    }
}

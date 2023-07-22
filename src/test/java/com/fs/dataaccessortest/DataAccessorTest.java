package com.fs.dataaccessortest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fs.dataaccessor.DataAccessor;

public class DataAccessorTest {
    @Test
    public void getInstance() {
        final DataAccessor dataAccessor1 = DataAccessor.getInstance();
        final DataAccessor dataAccessor2 = DataAccessor.getInstance();
        assertTrue(dataAccessor1 == dataAccessor2);
    }
}

package com.fs.dataaccessor;

public class DataAccessor {

    private static DataAccessor instance = null;

    private DataAccessor() {
        instance = this;
    }

    public static DataAccessor getInstance() {
        if (instance == null) {
            instance = new DataAccessor();
        }
        return instance;
    }
}

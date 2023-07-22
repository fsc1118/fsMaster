package com.fs.appconfigtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.mockito.Mockito;

import com.fs.appconfig.AppConfig;
import com.fs.exception.InvalidConfigEntryException;
import com.fs.exception.MissingConfigFileException;

public class AppConfigTest {
    @Test
    public void getAndSetConfig() {
        final String TEST_KEY = "testKey";
        final String TEST_VALUE = "testValue";
        new AppConfig(); // for initializing AppConfig
        AppConfig.setConfig(TEST_KEY, TEST_VALUE);
        final String testValue = AppConfig.getConfig(TEST_KEY);
        assertEquals(TEST_VALUE, testValue);
    }

    @Test(expected = NumberFormatException.class)
    public void getConfigInInteger() {
        final String TEST_KEY_VALID = "testKeyValid";
        final String TEST_VALUE_VALID = "100";
        final String Test_KEY_INVALID = "testKeyInvalid";
        final String Test_VALUE_INVALID = "abc";
        AppConfig.setConfig(TEST_KEY_VALID, TEST_VALUE_VALID);
        AppConfig.setConfig(Test_KEY_INVALID, Test_VALUE_INVALID);
        final int testValue = AppConfig.getConfigInInteger(TEST_KEY_VALID);
        assertEquals(Integer.parseInt(TEST_VALUE_VALID), testValue);
        AppConfig.getConfigInInteger(Test_KEY_INVALID);
    }

    @Test(expected = MissingConfigFileException.class)
    public void initalizeWithInvalidConfigFilePath()
            throws MissingConfigFileException, IOException, InvalidConfigEntryException {
        // final String TEST_CONFIG_FILE_PATH_VALID = "src/test/resources/config.json";
        final String TEST_CONFIG_FILE_PATH_INVALID = "/invalid";
        // AppConfig.initalize(TEST_CONFIG_FILE_PATH_VALID);
        AppConfig.initalize(TEST_CONFIG_FILE_PATH_INVALID);
    }

    @Test(expected = IOException.class)
    public void initalizeWithInvalidConfigEntry()
            throws MissingConfigFileException, IOException, InvalidConfigEntryException {
        final File file = new File("src/test/java/com/fs/appconfigtest/test.Invalid.json");
        final String absolutePath = file.getAbsolutePath();
        AppConfig.initalize(absolutePath);
    }

    @Test(expected = IOException.class)
    public void initalizeWithNonJsonConfigFile()
            throws MissingConfigFileException, IOException, InvalidConfigEntryException {
        final File file = new File("src/test/java/com/fs/appconfigtest/test.xml");
        final String absolutePath = file.getAbsolutePath();
        AppConfig.initalize(absolutePath);
    }

    @Test
    public void initalizeWithValidJsonConfigFile()
            throws MissingConfigFileException, IOException, InvalidConfigEntryException {
        final File file = new File("src/test/java/com/fs/appconfigtest/test.Valid.json");
        final String absolutePath = file.getAbsolutePath();
        AppConfig.initalize(absolutePath);
        assertEquals(1, AppConfig.getConfigInInteger("redundancy_factor"));
        assertEquals(8080, AppConfig.getConfigInInteger("port"));
    }
}

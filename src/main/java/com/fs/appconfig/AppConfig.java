package com.fs.appconfig;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fs.exception.InvalidConfigEntryException;
import com.fs.exception.MissingConfigFileException;

public class AppConfig {

    private static class Config {
        @JsonProperty("redundancyFactor")
        int redundancy_factor;
        @JsonProperty("port")
        int port;
        @JsonProperty("chunkSize")
        int chunkSize;
        @JsonProperty("workerHealthcheckInterval")
        int workerHealthcheckInterval;
        @JsonProperty("failedHealthcheckCountBeforeRemovingWorker")
        int failedHealthcheckCountBeforeRemovingWorker;
        @JsonProperty("persistantStoragePath")
        String persistantStoragePath;
        @JsonProperty("logPath")
        String logPath;
    }

    public static int getConfigInInteger(final String configKey) throws NumberFormatException {
        return Integer.parseInt(System.getProperty(configKey));
    }

    public static String getConfig(final String configKey) {
        return System.getProperty(configKey);
    }

    public static void setConfig(final String configKey, final String configValue) {
        System.setProperty(configKey, configValue);
    }

    public static void initalize(final String configFilePath)
            throws MissingConfigFileException, InvalidConfigEntryException, IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final File jsonFile = new File(configFilePath);
        if (!jsonFile.exists()) {
            throw new MissingConfigFileException("Config file " + configFilePath + " does not exist");
        }
        if (jsonFile.isDirectory()) {
            throw new MissingConfigFileException("Config file " + configFilePath + " is a directory");
        }
        final Config config = objectMapper.readValue(jsonFile, Config.class);
        // Use reflection to set all the config values declared as public in Config
        for (final java.lang.reflect.Field field : config.getClass().getDeclaredFields()) {
            final String configKey = field.getName();
            Object configValue = null;
            try {
                configValue = field.get(config);
                if (configValue == null) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new InvalidConfigEntryException("Config value for " + configKey + " is invalid or missing");
            }

            if (!attemptToSetConfig(configKey, configValue)) {
                throw new InvalidConfigEntryException("Config value for " + configKey + " is invalid");
            }
        }
    }

    private static boolean attemptToSetConfig(final String configKey, final Object configValue) {
        // Try to convert configValueType in String, Integer, Boolean, Double
        boolean isValueSet = false;
        for (Class<?> configValueType : new Class<?>[] { String.class, Integer.class, Boolean.class,
                Double.class }) {
            try {
                final Object configValueConverted = configValueType.cast(configValue);
                setConfig(configKey, configValueConverted.toString());
                isValueSet = true;
                break;
            } catch (ClassCastException e) {
            }
        }
        return isValueSet;
    }
}

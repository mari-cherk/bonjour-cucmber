package common;

public class ProjectConfig {
    public static final String REMOTE_BASE_URL = System.getProperty("remote.baseUrl", "http://localhost:4444/wd/hub");
    public static final String DEVICE_OS = System.getProperty("device.os", "Android");
    public static final int TIMEOUT = 5;

    private ProjectConfig() {
        throw new AssertionError("Suppress default constructor");
    }
}

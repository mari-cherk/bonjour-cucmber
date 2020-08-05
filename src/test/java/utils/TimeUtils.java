package utils;

public class TimeUtils {

    private TimeUtils() {
        throw new UnsupportedOperationException("Suppress default constructor");
    }

    public static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(String.format("Exception %s", e.getMessage()));
        }
    }
}

package patterns.singleton;

public final class SingletonOne {
    private static SingletonOne instance;
    public String value;

    private SingletonOne(String value) {
        // Этот код эмулирует медленную инициализацию.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonOne getInstance(String value) {
        if (instance == null) {
            instance = new SingletonOne(value);
        }
        return instance;
    }
}
package patterns.abstract_factory;

import patterns.abstract_factory.app.Application;
import patterns.abstract_factory.factories.GUIFactory;
import patterns.abstract_factory.factories.MacOsFactory;
import patterns.abstract_factory.factories.WindowsFactory;

/**
 * Демо-класс. Здесь всё сводится воедино.
 */
public class Main {
    /**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
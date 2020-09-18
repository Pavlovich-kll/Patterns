package patterns.factory_method.buttons;

/**
 * Общий интерфейс для всех продуктов.
 */
public interface Button {
    void render();
    void onClick();
}
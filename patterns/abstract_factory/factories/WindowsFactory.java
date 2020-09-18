package patterns.abstract_factory.factories;

import patterns.abstract_factory.buttons.Button;
import patterns.abstract_factory.buttons.MacOsButton;
import patterns.abstract_factory.buttons.WindowsButton;
import patterns.abstract_factory.checkboxes.Checkbox;
import patterns.abstract_factory.checkboxes.MacOSCheckbox;
import patterns.abstract_factory.checkboxes.WindowsCheckbox;

/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
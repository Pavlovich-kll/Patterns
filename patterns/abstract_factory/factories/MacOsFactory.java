package patterns.abstract_factory.factories;

import patterns.abstract_factory.buttons.Button;
import patterns.abstract_factory.buttons.MacOsButton;
import patterns.abstract_factory.checkboxes.Checkbox;
import patterns.abstract_factory.checkboxes.MacOSCheckbox;

/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
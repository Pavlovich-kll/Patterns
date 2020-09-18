package patterns.factory_method.factory;


import patterns.factory_method.buttons.Button;
import patterns.factory_method.buttons.WindowsButton;

/**
 * Диалог на элементах операционной системы.
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
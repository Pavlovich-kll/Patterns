package patterns.composite;

import patterns.composite.editor.ImageEditor;
import patterns.composite.shapes.Circle;
import patterns.composite.shapes.CompoundShape;
import patterns.composite.shapes.Dot;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                )
        );
    }
}
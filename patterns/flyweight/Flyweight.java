package patterns.flyweight;

import java.util.ArrayList;
import java.util.HashMap;

public class Flyweight {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        ArrayList<Shape> arrayList = new ArrayList<>();
        arrayList.add(shapeFactory.getShape("line"));
        arrayList.add(shapeFactory.getShape("square"));
        arrayList.add(shapeFactory.getShape("line"));
        arrayList.add(shapeFactory.getShape("circle"));

        int count = 0;
        for (Shape shape : arrayList) {
            shape.draw(count + 1, count + 2);
            count++;
        }
    }
}

interface Shape{
    void draw(int x,int y);
}

class LineShape implements Shape{

    @Override
    public void draw(int x, int y) {
        System.out.println("Линия с координатами " + x + " " + y);
    }
}

class CircleShape implements Shape{
    private int radius = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("Кргуг с координатами " + x + " " + y + ", и радиусом " + radius );
    }
}

class SquareShape implements Shape{
    private int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("Квадрат с координатами " + x + " " + y + ", и сторонами " + a );

    }
}

class ShapeFactory{
    private static final HashMap <String,Shape> shapes = new HashMap();

    public Shape getShape(String shapeName){
        Shape shape = shapes.get(shapeName);
        if (shape == null){
            switch (shapeName){
                case "line":
                    shape = new LineShape();
                    break;
                case "circle":
                    shape = new CircleShape();
                    break;
                case "square":
                    shape = new SquareShape();
                    break;
            }
            shapes.put(shapeName,shape);
        }
        return shape;
    }
}
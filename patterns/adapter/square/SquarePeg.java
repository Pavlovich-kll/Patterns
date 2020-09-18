package patterns.adapter.square;

/**
 * КвадратныеКолышки несовместимы с КруглымиОтверстиями.
 * Нужно как-то интегрировать их в систему.
 */
public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2); //возводит арг1 в степень арг2
        return result;
    }
}

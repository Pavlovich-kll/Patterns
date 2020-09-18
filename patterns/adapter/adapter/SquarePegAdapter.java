package patterns.adapter.adapter;

import patterns.adapter.round.RoundPeg;
import patterns.adapter.square.SquarePeg;

/**
 * Структурный паттерн для совместной работы классов с разными интерфейсами.
 * Адаптер выступает прослойкой между двумя объектами, превращая вызовы одного в вызовы понятные другому.
 */
/**
 * Адаптер получает конвертируемый объект в конструкторе или через параметры своих методов.
 * Методы Адаптера обычно совместимы с интерфейсом одного объекта.
 * Они делегируют вызовы вложенному объекту, превратив перед этим параметры вызова в формат, поддерживаемый вложенным объектом.
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2)); //превращение: формула радиуса квадрата через диагональ.
        return result;
    }
}
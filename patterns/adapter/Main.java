package patterns.adapter;

import patterns.adapter.adapter.SquarePegAdapter;
import patterns.adapter.round.RoundHole;
import patterns.adapter.round.RoundPeg;
import patterns.adapter.square.SquarePeg;

public class Main {
    public static void main(String[] args) {
        //круглое к круглому.
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) {
            System.out.println("Round peg fits round hole.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Не скомпилируется.

        // Применяем адаптер.
        SquarePegAdapter smallPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largePegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallPegAdapter)) {
            System.out.println("Square peg fits round hole.");
        }
        if (!hole.fits(largePegAdapter)) {
            System.out.println("Square peg doesn't fit into round hole.");
        }
    }
}
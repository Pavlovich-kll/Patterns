package patterns.iterator;

public class Iterator {
    public static void main(String[] args) {
        Container container = new SpecialContainer();
        IteratorInterface iterator = container.getIterator();
        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }
    }
}

interface IteratorInterface {
    boolean hasNext();

    Object next();
}

interface Container {
    IteratorInterface getIterator();
}

class SpecialContainer implements Container {
    String[] arr = {"A", "B", "C"};

    public IteratorInterface getIterator() {
        return new SpecialIterator();
    }

    private class SpecialIterator implements IteratorInterface {
        private int index;

        @Override
        public boolean hasNext() {
            return index < arr.length;
        }

        @Override
        public Object next() {
            return arr[index++];
        }
    }
}
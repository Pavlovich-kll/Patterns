package patterns.tamplate_method;

public class TemplatePattern {
    public static void main(String[] args) {
        new A().print();
        new B().print();
    }
}

abstract class Temple {
    protected void print() {
        System.out.print("Шаблонная часть '1', ");
        custom();
        System.out.print(", Шаблонная часть '2'");
        System.out.println();
    }

    public abstract void custom();
}

class A extends Temple {
    @Override
    public void custom() {
        System.out.print("Class A");
    }
}

class B extends Temple {
    @Override
    public void custom() {
        System.out.print("Class B");
    }
}
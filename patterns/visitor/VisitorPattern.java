package patterns.visitor;

public class VisitorPattern {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor visitor = new HooliganVisitor();
        body.accept(visitor);
        engine.accept(visitor);
        visitor = new EngineVisitor();
        body.accept(visitor);
        engine.accept(visitor);
    }
}

interface Visitor {
    void visit(EngineElement engineElement);

    void visit(BodyElement bodyElement);
}

interface Element {
    void accept(Visitor visitor);
}

class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Сделал какую-то шляпу с движком");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Пнул по капоту");
    }
}

class EngineVisitor implements Visitor {

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Починил капот");
    }
}
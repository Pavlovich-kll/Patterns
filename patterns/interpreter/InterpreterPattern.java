package patterns.interpreter;

public class InterpreterPattern {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.evaluate("1+2+3").interpret());
    }
}

interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class PlusExpression implements Expression {
    private Expression left;
    private Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class MinusExpression implements Expression {
    private Expression left;
    private Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class Context {
    public Expression evaluate(String s) {
        int pos = s.length() - 1;
        while (pos > 0) {
            if (Character.isDigit(s.charAt(pos))) {
                pos--;
            } else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(Integer.valueOf(s.substring(pos + 1), s.length()));
                char operator = s.charAt(pos);
                switch (operator) {
                    case '+':
                        return new PlusExpression(left, right);
                    case '-':
                        return new MinusExpression(left, right);
                }

            }
        }
        int res = Integer.parseInt(s);
        return new NumberExpression(res);
    }
}
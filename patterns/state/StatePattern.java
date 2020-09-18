package patterns.state;

public class StatePattern {
    public static void main(String[] args) {
        Human human = new Human();
        for (int i = 0; i < 4; i++) {
            human.doSomeThing();
        }
    }
}

class Human {
    private Activity activity = new Relax();

    public void doSomeThing() {
        activity.doIt(this);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}


interface Activity {
    void doIt(Human human);
}

class Relax implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Ничего не далаю пока");
        human.setActivity(new WatchTV());
    }
}

class WatchTV implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Смотрю телек");
        human.setActivity(new Running());
    }
}

class Running implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Бегаю");
        human.setActivity(new PlyingHockey());
    }
}

class PlyingHockey implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Играю в хоккей");
    }
}
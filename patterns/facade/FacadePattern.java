package patterns.facade;

class FacedPattern {
    public static void main(String[] args) {
        WatchFactory watchFactory = new DigitalWatchFactory();
        Watch watch = watchFactory.createWatch();
        watch.showTime();
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("Время на электронных часах");
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("Время на римских часах ");
    }
}

interface WatchFactory {
    Watch createWatch();
}

class DigitalWatchFactory implements WatchFactory {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchFactory implements WatchFactory {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
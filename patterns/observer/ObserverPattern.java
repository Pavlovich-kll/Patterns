package patterns.observer;

import java.util.ArrayList;

public class ObserverPattern {
    public static void main(String[] args) {
        Observed meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());

        meteoStation.setChanges(30, 130);
        meteoStation.setChanges(45, 140);
    }
}

interface Observed {
    void addObserver(Observer observer);

    void notifyObservers();

    void setChanges(int temp, int press);
}

interface Observer {
    void showChanges(int temp, int press);
}

class MeteoStation implements Observed {
    private int temp;
    private int press;
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.showChanges(temp, press);
        }
    }

    @Override
    public void setChanges(int temp, int press) {
        this.temp = temp;
        this.press = press;
        notifyObservers();
    }
}

class ConsoleObserver implements Observer {

    @Override
    public void showChanges(int temp, int press) {
        System.out.printf("Изменение температуры '%d' и давления '%d'", temp, press);
        System.out.println();
    }
}
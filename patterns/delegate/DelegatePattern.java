package patterns.delegate;

/**
 * Экземпляры вспомогательных классов передаются в CarController
 * и вызов на выполнение действия осуществляется на экземпляре
 * класса CarController
 */
class DelegatePattern {
    private static final String RIDER = "Tom";

    public static void main(String[] args) {
        CarController bmw = new CarController(new BMWCar());
        CarController mercedes = new CarController(new MercedesCar());
        CarController volvo = new CarController(new VolvoCar());

        bmw.ride(RIDER);
        mercedes.ride(RIDER);
        volvo.ride(RIDER);
    }
}

interface Car {
    public void ride(String name);
}

/**
 * Класс CarController реализует интерфейс Car, но сам действие не выполняет,
 * а делегирует это вспомогательному классу,
 * экземпляр которого хранит в своем поле car.
 */
class CarController implements Car {

    private final Car car;

    public CarController(Car car) {
        this.car = car;
    }

    @Override
    public void ride(String name) {
        car.ride(name);
    }
}

/**
 * Есть вспомогательные классы которые непосредственно
 * выполняют действие - BMWCar, MercedesCar, VolvoCar - они также реализуют
 * интерфейс Car, но в самом приложении вызываются опосредованно
 * через экземпляр класса CarController, который делегирует им выполнение работы:
 */

class BMWCar implements Car {
    @Override
    public void ride(String name) {
        System.out.println(name + " rides in BMW");
    }
}

class MercedesCar implements Car {
    @Override
    public void ride(String name) {
        System.out.println(name + " rides in Mercedes");
    }
}

class VolvoCar implements Car {
    @Override
    public void ride(String name) {
        System.out.println(name + " rides in Volvo");
    }
}
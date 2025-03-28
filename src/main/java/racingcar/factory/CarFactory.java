package racingcar.factory;

import racingcar.entity.Car;

public class CarFactory {
    public static Car createCar(String name){
        return new Car(name.trim());
    }
}

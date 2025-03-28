package racingcar.factory;

import racingcar.entity.Car;
import racingcar.entity.Cars;

import java.util.List;

public class CarsFactory {
    public static Cars createCars(List<String> carNameList){
        Cars cars = new Cars();
        for(String carName : carNameList){
            Car car = CarFactory.createCar(carName);
            cars.addCars(car);
        }
        return cars;
    }
}

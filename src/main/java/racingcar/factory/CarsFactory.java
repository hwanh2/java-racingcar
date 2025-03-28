package racingcar.factory;

import racingcar.entity.Car;
import racingcar.entity.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    public static Cars createCars(List<String> carNameList){
        // Car 객체 리스트를 생성
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = CarFactory.createCar(carName);
            cars.add(car);
        }
        // Cars 객체 생성 시, List<Car>를 주입하여 생성
        return new Cars(cars);
    }
}

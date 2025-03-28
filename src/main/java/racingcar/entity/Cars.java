package racingcar.entity;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars(){
        return cars;
    }

    public void addCars(Car car){
        cars.add(car);
    }
}

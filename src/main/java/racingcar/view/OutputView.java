package racingcar.view;

import racingcar.entity.Car;
import racingcar.entity.Cars;

public class OutputView {
    public static void printHead() {
        System.out.println("실행 결과");
    }

    public static void printScore(Cars cars) {
        for(Car car : cars.getCars()){
            System.out.println(car.getName()+" : ");
            printPosition(car);
            System.out.println();
        }
    }

    public static void printPosition(Car car){
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
    }

}

package racingcar.view;

import racingcar.entity.Car;
import racingcar.entity.Cars;

import java.util.List;

public class OutputView {
    public static void printHead() {
        System.out.println("\n실행 결과");
    }

    public static void printScore(Cars cars) {
        for(Car car : cars.getCars()){
            System.out.print(car.getName()+" : ");
            printPosition(car);
        }
        System.out.println();
    }

    public static void printPosition(Car car){
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners){
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winners.size(); i++){
            System.out.print(winners.get(i));
            if(i<winners.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

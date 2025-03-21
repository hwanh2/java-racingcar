package racingcar.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStartTest {

    @Test
    void 자동차생성_테스트(){
        ArrayList<Car> array = new ArrayList<>();
        array.add(new Car("test1",0));
        array.add(new Car("test2",0));

        assertEquals(2,array.size());
        assertEquals("test1",array.get(0).getName());
        assertEquals("test2",array.get(1).getName());
    }

    @Test
    void 자동차이동_테스트() {
        Car car = new Car("test", 0);
        car.move(1);
        assertEquals(1, car.getDistance());
    }

    @Test
    public void 우승자찾기_테스트() {
        GameStart gameStart = new GameStart();

        // 테스트용 자동차 생성
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1", 3));
        cars.add(new Car("Car2", 3));
        cars.add(new Car("Car3", 3));

        gameStart.setCars(cars);

        // 우승자를 찾고 결과 비교
        List<String> winners = gameStart.findWinner();

        assertEquals(3, winners.size()); // 모든 자동차가 동점이므로 우승자는 3명이어야 함
    }
}

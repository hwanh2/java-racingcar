package racingcar.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;

public class GameStartTest {
    private GameStart gameStart;

    @BeforeEach
    void setUp() {
        gameStart = new GameStart();
    }

    @Test
    void createCar(){
        ArrayList<Car> array = new ArrayList<>();
        array.add(new Car("test1",0));
        array.add(new Car("test2",0));

        Assertions.assertEquals(2,array.size());
        Assertions.assertEquals("test1",array.get(0).getName());
        Assertions.assertEquals("test2",array.get(1).getName());
    }

    @Test
    void move() {
        Car car = new Car("test", 0);
        car.move(1);
        Assertions.assertEquals(1, car.getDistance());
    }

}

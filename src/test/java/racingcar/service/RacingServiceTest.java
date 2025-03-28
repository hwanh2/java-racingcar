package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.entity.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingServiceTest {
    private RacingService racingService;
    private Cars cars;

    @BeforeEach
    void init(){
        racingService = new RacingService();
        cars = new Cars();
        cars.addCars(new Car("test1"));
        cars.addCars(new Car("test2"));
        cars.addCars(new Car("test3"));
    }

    @Test
    @DisplayName("게임 시작 전 자동차들의 위치는 0입니다.")
    void 게임시작_전(){
        assertThat(cars.getCars()).allMatch(car -> car.getPosition() == 0);
    }

    @Test
    @DisplayName("자동차가 잘 이동했나 확인합니다. 우승자도 확인합니다.")
    void 자동차_이동_우승자_확인(){
        cars.getCars().get(0).move(1);
        cars.getCars().get(1).move(2);
        cars.getCars().get(2).move(3);

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(2);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(3);

        List<String> winners = racingService.getWinner(cars);

        assertThat(winners.get(0)).isEqualTo("test3");
    }

    @Test
    @DisplayName("공동 우승를 확인합니다.")
    void 공동_우승자_확인(){
        cars.getCars().get(0).move(1);
        cars.getCars().get(1).move(3);
        cars.getCars().get(2).move(3);

        List<String> winners = racingService.getWinner(cars);
        assertThat(winners).containsExactlyInAnyOrder("test2", "test3");
    }

}

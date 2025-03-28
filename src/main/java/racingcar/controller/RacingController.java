package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Cars;
import racingcar.factory.CarsFactory;
import racingcar.service.RacingService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void run(){
        List<String> carNames = Parser.parseCarName(getCarNamesByInput());
        Cars cars = CarsFactory.createCars(carNames);

        int trailInput = Parser.parseTrail(getTrailByInput());

        OutputView.printHead();

        // 입력받은 횟수만큼 게임 실행
        for(int i=0; i<trailInput; i++){
            racingService.doGame(cars);
            OutputView.printScore(cars);
        }

        List<String> winners = racingService.getWinner(cars);
        OutputView.printWinners(winners);
    }

    private String getCarNamesByInput(){
        InputView.requestCarNames();
        return Console.readLine();
    }

    private String getTrailByInput(){
        InputView.requestNumberOfTrail();
        return Console.readLine();
    }
}

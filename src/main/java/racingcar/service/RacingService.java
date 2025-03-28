package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.Car;
import racingcar.entity.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    // 한 턴을 실행하는 함수
    public void doGame(Cars cars){
        for(Car car : cars.getCars()){ // 모든 자동차 리스트 순회
            if(isMove()){
                car.move(1); // 4 이상일 시 car객체 한칸 이동함.
            }
        }
    }

    // 랜덤값이 4 이상이면 true를 반환하는 함수
    private boolean isMove(){
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    // 가장 멀리 간 차를 구하는 함수
    public List<String> getWinner(Cars cars){
        int maxPosition = getMaxPosition(cars); // 가장 멀리 간 위치를 구함.
        List<String> winners = new ArrayList<>();

        for(Car car : cars.getCars()){
            if(car.getPosition()==maxPosition){ // 멀리 간 위치가 같으면 리스트에 추가
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition(Cars cars){
        int max = Integer.MIN_VALUE;

        for(Car car : cars.getCars()){
            if(car.getPosition()>max){
                max = car.getPosition();
            }
        }
        return max;
    }

}

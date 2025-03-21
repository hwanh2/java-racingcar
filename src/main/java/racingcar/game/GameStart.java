package racingcar.game;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameStart {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Car> cars;

    public void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCar();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            start();
        }

    }

    public void createCar(){
        String input = sc.next();
        StringTokenizer st = new StringTokenizer(input,",");
        cars = new ArrayList<>();

        while(st.hasMoreTokens()){
            cars.add(new Car(st.nextToken(),0)); // 플레이어 생성
        }
    }

    public void start(){
        for(int i=0; i<cars.size(); i++){
            if(is_move()){
                cars.get(i).move(1);
            }
        }
    }

    public boolean is_move(){
        int random = (int)(Math.random() * 10);
        if(random>=4){
            return true;
        }
        return false;
    }
}

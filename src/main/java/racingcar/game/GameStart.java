package racingcar.game;

import racingcar.domain.Car;

import java.util.*;

public class GameStart {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Car> cars;

    public void setCars(ArrayList<Car> cars) { // 테스트를 위한 메서드
        this.cars = cars;
    }

    public void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCar();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = sc.nextInt();

        System.out.println("실행결과\n");

        for(int i=0; i<n; i++){
            start();
            print();
        }

        System.out.print("최종 우승자 : ");

        //우승자 받아오기
        List<String> winners = findWinner();
        // 우승자 출력
        for(int i=0; i<winners.size(); i++){
            System.out.print(winners.get(i));

            if(i!=winners.size()-1){ // , 처리
                System.out.print(", ");
            }
        }
        System.out.println();
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

    public void print(){
        for(int i=0; i<cars.size(); i++){
            System.out.println(cars.get(i).getName()+" : "+cars.get(i).getDistance());
        }
        System.out.println();
    }

    public List<String> findWinner(){
        ArrayList<String> winners = new ArrayList<>();

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getDistance() - o1.getDistance(); // 거리. 순으로 내림차순 정렬한다.
            }
        });

        int max = cars.get(0).getDistance(); // 첫 번쨰 인덱스가 max값

        // 동점자 찾는 로직
        for(Car car : cars){
            if(car.getDistance()==max){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

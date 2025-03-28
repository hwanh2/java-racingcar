package racingcar.entity;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int distance){
        this.position+=distance; // 확장성을 위해 파라미터로 받음
    }

    public int getPosition(){
        return position;
    }

}

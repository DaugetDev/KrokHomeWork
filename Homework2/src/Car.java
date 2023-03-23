/**
 * Класс для моделирования точки выезда.
 */
public class Car {
    private final String number;

    public Car(String number){
        this.number = number;
    }

    /**
     * Возвращает номер машины.
     * @return номер машины.
     */
    public String getNumber(){
        return number;
    }

    @Override
    public String toString(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number.equals(car.number);
    }
}

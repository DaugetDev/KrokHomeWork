package Homework2;

/**
 * Класс для моделирования точки выезда.
 */
public class ExitPoint{
    private final int number;
    private final String description;
    private int countCars;
    Car[] cars;

    public ExitPoint(int number, String description){
        this.number = number;
        this.description = description;
        this.cars = new Car[10];
    }
    /**
     * Метод, который добавляет машину в массив машин, расширяя этот массив, если необходимо.
     * @param car машина, которая добавится.
     */
    private void addExitCar(Car car){
        countCars++;
        if(countCars > cars.length){
            Car[] newCars = new Car[cars.length * 2];
            System.arraycopy(cars, 0 , newCars, 0, cars.length);
            newCars[cars.length] = car;
            cars = newCars;
        }
        else {
            cars[countCars - 1] = car;
        }
    }
    /**
     * Добавляет машину в массив машин, которые проехали через данный выезд.
     * @param car Машина, которая проехала через выезд.
     */
    public void rememberCar(Car car){
        addExitCar(car);
    }
    /**
     * Возвращает количество проехавших через выезд машин.
     * @return кол-во машин.
     */
    public int getCountCars(){
        return countCars;
    }

    /**
     * Возвращает описание выезда.
     * @return описание выезда.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает номер выезда.
     * @return номер выезда.
     */
    public int getNumber(){
        return  number;
    }
}

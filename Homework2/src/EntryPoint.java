/**
 * Класс для моделирования точки въезда.
 */

public class EntryPoint{
    private final int number;
    private final String description;
    private int countCars;
    Car[] cars;

    public EntryPoint(int number, String description){
        this.number = number;
        this.description = description;
        this.cars = new Car[10];
    }
    /**
     * Метод, который добавляет машину в массив машин, расширяя этот массив, если необходимо.
     * @param car машина, которая добавится.
     */
    private void addEntryCar(Car car){
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
     * Возвращает количество проехавших через въезд машин.
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
     * Добавляет машину в массив машин, которые проехали через данный въезд.
     * @param car Машина, которая проехала через въезд.
     */
    public void rememberCar(Car car){
        addEntryCar(car);
    }

    /**
     * Возвращает номер въезда.
     * @return номер въезда.
     */
    public int getNumber(){
        return  number;
    }
}

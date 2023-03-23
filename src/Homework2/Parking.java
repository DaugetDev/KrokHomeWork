package Homework2;

import java.time.LocalDateTime;

/**
 * Класс для моделирования парковки.
 */


public class Parking {
    private final int numbersParkingSpace;
    private int numbersFreeParkingSpace;
    private EntryAttempt[] attempts;
    private int numberAttempts = 0;
    private final EntryPoint[] entryPoints;
    private final ExitPoint[] exitPoints;
    private Car[] parkedCars;

    public Parking(int numbersParkingSpace, EntryPoint[] entryPoints, ExitPoint[] exitPoints){
        this.numbersParkingSpace = numbersParkingSpace;
        this.numbersFreeParkingSpace = numbersParkingSpace;
        this.entryPoints = entryPoints;
        this.exitPoints = exitPoints;
        this.attempts = new EntryAttempt[10];
        this.parkedCars = new Car[numbersParkingSpace + 1];
    }

    /**
     * Метод для проверки возможности въезда на парковку.
     * @return true, если есть свободные места иначе false.
     */
    private boolean canEnter(){
        return numbersFreeParkingSpace > 0;
    }
    /**
     * Метод, который выводит в консоль информацию о возможности въезда на парковку.
     */
    public void infoCanEnter(){
        if(numbersFreeParkingSpace > 0){
            System.out.println("Можно въехать");
        }
        else {
            System.out.println("Нельзя въехать");
        }
    }

    /**
     * Возвращает кол-во свободных мест.
     * @return количество свободных мест.
     */
    public int getNumbersFreeParkingSpace(){
        return numbersFreeParkingSpace;
    }

    /**
     * Метод, который удаляет объект машину из массива машин.
     * @param car машина, которая удалится.
     */
    private void deleteCar(Car car){
        Car[] newParkedCars = new Car[parkedCars.length];
        int index = 0;
        for (int i = 0; i < numbersParkingSpace - numbersFreeParkingSpace; i++) {
            if (!parkedCars[i].equals(car)){
                newParkedCars[index] = parkedCars[i];
                index++;
            }
        }
        parkedCars = newParkedCars;
        numbersFreeParkingSpace++;
    }

    /**
     * Метод выводящий в консоль список машин прошедших через данный въезд.
     * @param point въезд через который проходили машины.
     */
    public void printListCarsInEntryPoint(EntryPoint point){
        for (EntryPoint tempPoint: entryPoints) {
            if (tempPoint.getNumber() == point.getNumber()){
                for (int i = 0; i < tempPoint.getCountCars(); i++) {
                    System.out.println(tempPoint.cars[i]);
                }
            }
        }
    }
    /**
     * Метод выводящий в консоль список машин прошедших через данный выезд.
     * @param point выезд через который проходили машины.
     */
    public void printListCarsInExitPoint(ExitPoint point){
        for (ExitPoint tempPoint: exitPoints) {
            if (tempPoint.getNumber() == point.getNumber()){
                for (int i = 0; i < tempPoint.getCountCars(); i++) {
                    System.out.println(tempPoint.cars[i]);
                }
            }
        }
    }

    /**
     * Метод выводящий в консоль список попыток заехать.
     */
    public void printListAttemptsToEnter(){
        for (int i = 0; i < numberAttempts; i++) {
            System.out.println(attempts[i]);
        }
    }
    /**
     * Метод, который добавляет попытку въезда в массив попыток въезда, расширяя этот массив, если необходимо.
     * @param attempt попытка въезда.
     */
    private void addAttempt(EntryAttempt attempt){
        numberAttempts++;
        if (numberAttempts > attempts.length){
            EntryAttempt[] newAttempts = new EntryAttempt[attempts.length * 2];
            System.arraycopy(attempts, 0 , newAttempts, 0, attempts.length);
            newAttempts[attempts.length] = attempt;
            attempts = newAttempts;
        }
        else {
            attempts[numberAttempts-1] = attempt;
        }
    }

    /**
     * Метод, который добавляет машину на парковку.
     * @param car машина, которая будет добавлена на парковку
     * @param numberEntry номер въезда.
     */
    public void enter(Car car, int numberEntry){
        boolean existsPoint = false;
        for (EntryPoint point : entryPoints) {
            if(point.getNumber() == numberEntry){
                existsPoint = true;
                break;
            }
        }
        if (!existsPoint){
            System.out.println("Такого входа нет");
            return;
        }
        if(!canEnter()){
            addAttempt(new EntryAttempt(car.getNumber(), LocalDateTime.now()));
        }
        else{
            for (EntryPoint point : entryPoints) {
                if (point.getNumber() == numberEntry){
                    parkedCars[numbersParkingSpace - numbersFreeParkingSpace] = car;
                    point.rememberCar(car);
                    numbersFreeParkingSpace--;
                }
            }
        }
    }

    /**
     * Метод, который убирает машину с парковки.
     * @param car машина, которая будет убрана с парковки.
     * @param exitPoint номер выезда.
     */
    public void exit(Car car, int exitPoint){
        boolean existsPoint = false;
        boolean existsCar = false;
        for (int i = 0; i < numbersParkingSpace - numbersFreeParkingSpace; i++) {
            for (ExitPoint point : exitPoints) {
                if (parkedCars[i].equals(car) && point.getNumber() == exitPoint){
                    deleteCar(car);
                    point.rememberCar(car);
                    return;
                }
                if (parkedCars[i].equals(car)) {
                    existsCar = true;
                }
                if (point.getNumber() == exitPoint){
                    existsPoint = true;
                }
            }
        }
        if (!existsCar){
            System.out.println("Машина не найдена");
        }
        if (!existsPoint) {
            System.out.println("Выезд не найден");
        }
    }
}

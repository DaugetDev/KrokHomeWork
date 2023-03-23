import java.time.LocalDateTime;

/**
 * Класс для сохранения попытки въезда.
 */
public class EntryAttempt {
    private final String carNumber;
    private final LocalDateTime time;

    public EntryAttempt(String carNumber, LocalDateTime time){
        this.carNumber = carNumber;
        this.time = time;
    }

    /**
     * Возвращает номер машины.
     * @return номер машины.
     */
    public String getCarNumber(){
        return carNumber;
    }

    /**
     * Возвращает время попытки въезда.
     * @return время попытки въезда.
     */
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString(){
        return "Машина с номером " + carNumber + " попыталась въехать в " + time;
    }
}
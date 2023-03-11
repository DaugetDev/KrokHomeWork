package Homework1;

import java.util.Map;
import java.util.Scanner;

public class Main {

    // Карта для сопоставления размера числа с префиксами значений
    static Map<Integer, String> units = Map.of(0, "Б", 1, "Кб", 2, "Мб", 3, "Гб", 4, "Тб", 5, "Пб", 6, "Эб", 7, "Зб", 8, "Йб");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        convert(Double.parseDouble(input.nextLine()));
    }
    // Метод для перевода значений
    public static void convert(double value){
        int prefixIndex = 0;
        while (value >= 1024){
            value /= 1024;
            prefixIndex++;
        }
        System.out.println(String.format("%.1f", value).replace(',', '.') + ' ' + units.get(prefixIndex));
    }
}
package Homework2;

public class Main {
    public static void main(String[] args) {
        EntryPoint[] entryPoints = new EntryPoint[2];
        entryPoints[0] = new EntryPoint(2, "Основной въезд");
        entryPoints[1] = new EntryPoint(4, "Запасной въезд");
        ExitPoint[] exitPoints = new ExitPoint[1];
        exitPoints[0] = new ExitPoint(1, "Единственный выход");
        Parking myParking = new Parking(2, entryPoints, exitPoints);
        myParking.enter(new Car("x777xx"), 2);
        myParking.enter(new Car("a123ea"), 1);
        myParking.enter(new Car("x123ae"), 4);
        myParking.enter(new Car("r123as"), 2);
        myParking.exit(new Car("x123ae"), 1);
        myParking.exit(new Car("x123a"), 1);
        myParking.exit(new Car("x777xx"), 2);
        myParking.printListCarsInEntryPoint(entryPoints[0]);
        myParking.printListCarsInExitPoint(exitPoints[0]);
        myParking.printListAttemptsToEnter();
    }
}

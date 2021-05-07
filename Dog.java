package dz6;

public class Dog extends Animal {

    private static int totalDogs = 0;

    public Dog(String name, String color, int speed) {
        super(name, color, speed);
        this.totalDogs += 1;
    }

    public static int getTotalDogs() {
        return totalDogs;
    }
}

package dz6;

public class Cat extends Animal {

    private static int totalCats = 0;

    public Cat(String name, String color, int speed) {
        super(name, color, speed);
        this.totalCats += 1;
    }

    @Override
    public void swim(int legth) {
        System.out.println(name + " не умеет плавать");
    }

    public static int getTotalCats() {
        return totalCats;
    }
}

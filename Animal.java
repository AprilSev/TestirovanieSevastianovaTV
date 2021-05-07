package dz6;

public class Animal {

    protected String name;
    protected String color;
    protected int speed;
    protected static int totalAnimals = 0;

    public Animal (String name, String color, int speed) {
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.totalAnimals += 1;
    }

    public void run(int length) {
        System.out.println(name + " run: " + length + " metres");
    }

    public void swim(int length) {
        System.out.println(name + " swim: " + length + " metres");
    }


}

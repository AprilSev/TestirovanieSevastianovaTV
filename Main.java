package JCDZ3;

public class Main {
    public static void main(String [] args) {
        Apple app1 = new Apple();
        Orange orange1 = new Orange();
        Box<Apple> boxWithApple = new Box<Apple>(app1, 10);
        System.out.println(boxWithApple.getWeight());
        Box<Orange> boxWithOrange = new Box<Orange>(orange1, 15);
        System.out.println(boxWithOrange.getWeight());
        System.out.println(boxWithApple.compare(boxWithOrange));
    }
}

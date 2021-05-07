package dz6;

import java.util.Random;

public class Entrada {

    private static Random random = new Random();

    public static void main(String[] args) {

        Cat cat1 = new Cat("Василий", "red", 30);
        Cat cat2 = new Cat("Дымка", "grey", 30);
        Cat cat3 = new Cat("Арсений", "black", 50);
        Cat cat4 = new Cat("Рыжуля", "orange", 35);

        Dog dog1 = new Dog("Бакс", "black", 50);
        Dog dog2 = new Dog("Шарик", "brown", 30);
        Dog dog3 = new Dog("Обжора", "white", 56);
        Dog dog4 = new Dog("Дикси", "orange", 12);
        Dog dog5 = new Dog("Милка", "white", 100);

        System.out.println("Total cats: " + Cat.getTotalCats()); //Подсчёт кошек
        System.out.println("Total dogs: " + Dog.getTotalDogs()); //Подсчёт собак
        System.out.println("Total animals: " + Animal.totalAnimals); //Подсчёт животных

        cat1.run(random.nextInt(200));
        cat1.swim(random.nextInt());
        dog4.run(random.nextInt(500));
        dog4.swim(random.nextInt(10));
    }
}

package JCDZ1;

public class Main {

    public static void main (String[] args) {

        Cat cat = new Cat(20,23);
        Human human = new Human(5,15);
        Robot robot = new Robot(10,40);
        Treadmill[] treadmills = {new Treadmill(12), new Treadmill(22), new Treadmill(32), new Treadmill(5)};

        for (Treadmill treadmill : treadmills) {
            treadmill.getRun(cat);
            treadmill.getRun(human);
            treadmill.getRun(robot);
        }

        System.out.println("***************************");

        Wall[] walls = {new Wall(15), new Wall(10), new Wall(5), new Wall(12)};

        for (Wall wall : walls) {
            wall.getJump(cat);
            wall.getJump(human);
            wall.getJump(robot);
        }

    }
}

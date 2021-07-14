package JCDZ1;

public class Cat implements CanRun, CanJump  {

    int jumpHeight;
    int runningDistance;

    public Cat(int jumpHeight, int runningDistance) {
        this.jumpHeight = jumpHeight;
        this.runningDistance = runningDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getRunningDistance() {
        return runningDistance;
    }

    public void setRunningDistance(int runningDistance) {
        this.runningDistance = runningDistance;
    }



    @Override
    public void jump(Wall wall) {
        if (jumpHeight >= wall.getHeight()) {
            System.out.println("I'm a cat, I'm jumping: " + wall.getHeight());
        } else {
            System.out.println("Cat can't jumping: " + wall.getHeight());
        }
    }

    @Override
    public void run(Treadmill treadmill) {
        if (this.runningDistance >= treadmill.getLength()) {
            System.out.println("I'm a cat, I'm running: " + treadmill.getLength());
        } else {
            System.out.println("Cat can't running: " + treadmill.getLength());
        }
    }
}


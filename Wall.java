package JCDZ1;

public class Wall {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void getJump (CanJump jumper) {
        jumper.jump(this);
    }

}

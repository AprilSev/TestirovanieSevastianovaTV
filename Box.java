package JCDZ3;

public class Box<T extends Fruit> {
    private T obj;
    private int fruitCount;

    public Box(T obj, int fruitCount) {
        this.obj = obj;
        this.fruitCount = fruitCount;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }

    float getWeight() {
        float boxWeight = fruitCount * obj.getWeight();
        return boxWeight;
    }

    public boolean compare(Box<?> yourBox) {
        return this.getWeight() == yourBox.getWeight();
    }

    public void addFruitInBox(int numberOfFruits) {
        fruitCount += numberOfFruits;
    }
}

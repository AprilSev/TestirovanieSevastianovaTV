package JCDZ3;

import java.util.Arrays;

public class ChangePlaces <T extends Number>{
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public ChangePlaces(T... array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ChangePlaces{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    static void changePlacesInTheArray(Object[] array, int position1, int position2) {
        Object a = array[position1];
        array[position1] = array[position2];
        array[position2] = a;
    }

    public static void main(String[] args) {
        ChangePlaces<Integer> testArray = new ChangePlaces<>(6, 9, 20, 5, 8, 13, 1, 25);

    }
}



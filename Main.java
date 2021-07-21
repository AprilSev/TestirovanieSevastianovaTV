package JCDZ2;

public class Main {
    public static void main(String[] args) {
        String[][] arrayPositive = {
                {"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}
        };
        String[][] arrayNegativeSize = {
                {"1", "2", "3"}, {"5", "6", "7", "8"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}
        };
        String[][] arrayNegativeData = {
                {"1", "2", "3", "4"}, {"5", "6kk", "7", "8"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}
        };
        try {
            System.out.println(acceptArray(arrayNegativeData));
        } catch (MyArraySizeException e) {
            System.out.println("Длинна вашего массива не коректна");
        } catch (MyArrayDataException e) {
            System.out.println("Не корректные данные");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }


    public static int acceptArray(String[][] yourArray) throws MyArraySizeException, MyArrayDataException {
        int total = 0;
        if (yourArray.length != 4) {
            throw new MyArraySizeException("Длинна вашего массива не коректна");
        }
        for (int i = 0; i < yourArray.length; i++) {
            if (yourArray[i].length != 4) {
                throw new MyArraySizeException("Длинна вашего массива не коректна");
            }
            for (int j = 0; j < yourArray[i].length; j++) {
                try {
                    total += Integer.parseInt(yourArray[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return total;
    }
    }


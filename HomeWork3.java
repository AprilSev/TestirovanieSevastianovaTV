package dz3;


public class HomeWork3 {


    public static void main (String[] args) {

        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arrayZadanie1 = {1,1,0,0,1,0,1,1,0,0};
        for (int i = 0; i  < arrayZadanie1.length; i++) {
            if (arrayZadanie1[i] == 0) {
                arrayZadanie1[i] = 1;
            } else arrayZadanie1[i] = 0;
        }
        for (int i = 0; i < arrayZadanie1.length; i++) {
            System.out.print (i + "=" + arrayZadanie1[i] + " | ");
        }
        System.out.println("");

        //Задать пустой целочисленный массив длиной 100.
        //С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

        int[] arrayZadanie2 = new int[100];
        for (int i = 0; i < arrayZadanie2.length; i++) {
            arrayZadanie2[i] = i + 1;
        }
        for (int i = 0; i < arrayZadanie2.length; i++) {
            System.out.print (i + "=" + arrayZadanie2[i] + " | ");
        }
        System.out.println("");

        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        //и числа меньшие 6 умножить на 2;

        int[] arrayZadanie3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i  < arrayZadanie3.length; i++) {
            if (arrayZadanie3[i] < 6) arrayZadanie3[i] = arrayZadanie3[i] * 2;
        }

        for (int i = 0; i  < arrayZadanie3.length; i++) {
            System.out.print(i + "=" + arrayZadanie3[i] + " | ");
        }
        System.out.println("");

        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        //и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        //(можно только одну из диагоналей, если обе сложно).
        //Определить элементы одной из диагоналей можно по следующему принципу:
        //индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

        int[][] arrayZadanie4 = new int[5][5];
        cross(arrayZadanie4);
        printArray(arrayZadanie4);
        System.out.println("");


        // Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
        //типа int длиной len, каждая ячейка которого равна initialValue;

        int[] arrayZadanie5 = evenArray(20,6);
        printArray1(arrayZadanie5);
        System.out.println("");


        //Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

        int arrayZadanie6[] = {20, 5, 99, 10, 3, 150, 35, 145, 199};

        int min = arrayZadanie6[0];
        int max = arrayZadanie6[0];

        for (int i = 0; i < arrayZadanie6.length; i++) {
            if (arrayZadanie6[i] < min) {
                min = arrayZadanie6[i];
            }
            if (arrayZadanie6[i] > max) {
                max = arrayZadanie6[i];
            }
        }

        System.out.println("min=" + min);
        System.out.println("max=" + max);

        System.out.println("");



    }

    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    //и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    //(можно только одну из диагоналей, если обе сложно).
    //Определить элементы одной из диагоналей можно по следующему принципу:
    //индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

    public static void cross (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    public static void printArray (int[][] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            for (int j = 0; j < inArray.length; j++) {
                System.out.print(inArray[i][j] + " ");
            }
        }
    }

    // Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    //типа int длиной len, каждая ячейка которого равна initialValue;

    public static int[] evenArray (int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void printArray1 (int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            System.out.print(inArray[i] + " ");
        }
    }



}

package dz2;

public class HomeWork2 {

    public static void main (String [] args) {

        System.out.println (summa(5,6));
        posOrNeg (-1);
        System.out.println(zadanie3(5));
        zadanie4 ("Hello",0);
        System.out.println("***************");
        System.out.println(zadanie5(2020));
    }

    public static String summa (int a, int b) {
        if (a + b > 10 && a + b <= 20) {
            return "True";
        } else {
            return "False";
        }
    }

    public static void posOrNeg (int a) {
        if (a >= 0) {
            System.out.println ("Positive");
        } else {
            System.out.println ("Negative");
        }
    }

    public static String zadanie3 (int a) {
        if (a < 0) {
            return "True";
        } else {
            return "false";
        }
    }

    public static void zadanie4 (String w, int a) {
        while (a < 10) {
            a++;
            System.out.print(w + " ");
        }
    }

    public static String zadanie5 (int a) {
        if (a % 4 == 0 || a % 400 == 0 || a % 100 != 0) {
            return "true";
        } else {
            return "false";
        }
    }
}

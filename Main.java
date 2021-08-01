package JKDZ5;


public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData();
        appData.load("data.csv");
        appData.save("data2.csv");

    }
}
